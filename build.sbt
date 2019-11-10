name := "sandbox"
version := "0.1"
organization in ThisBuild := "com.github.eniqen"
scalaVersion in ThisBuild := "2.12.9"

lazy val root = (project in file("."))
  .settings(settings)
  .disablePlugins(AssemblyPlugin)
  .aggregate(
    common,
    kafkaStreams
  )

lazy val common = project
  .settings(
    name := "common",
    settings,
    libraryDependencies ++= commonDependencies
  )
  .disablePlugins(AssemblyPlugin)

lazy val kafkaStreams = (project in file("kafka-streams"))
  .settings(
    name := "kafka-streams",
    settings,
    assemblySettings,
    libraryDependencies ++= (commonDependencies ++ circeDependency)
  )
  .dependsOn(
    common % "compile -> compile; test -> test"
  )

lazy val dependencies =
  new {
    val scalaLoggingV = "3.7.2"
    val slf4jV        = "1.7.25"
    val scalatestV    = "3.0.4"
    val scalacheckV   = "1.13.5"
    val kafkaStreamsV = "2.3.1"

    val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"       % scalaLoggingV
    val scalatest    = "org.scalatest"              %% "scalatest"           % scalatestV
    val scalacheck   = "org.scalacheck"             %% "scalacheck"          % scalacheckV
    val kafkaStreams = "org.apache.kafka"           %% "kafka-streams-scala" % kafkaStreamsV
    val slf4j        = "org.slf4j"                  % "jcl-over-slf4j"       % slf4jV
  }

val circeVersion = "0.11.1"

lazy val circeDependency = Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

lazy val commonDependencies = Seq(
  dependencies.scalaLogging,
  dependencies.slf4j,
  dependencies.kafkaStreams,
  dependencies.scalatest  % "test",
  dependencies.scalacheck % "test"
)

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-deprecation",
  "-encoding",
  "utf8"
)

lazy val settings =
commonSettings ++
wartremoverSettings ++
scalafmtSettings

lazy val wartremoverSettings = Seq(
  wartremoverWarnings in (Compile, compile) ++= Warts.allBut(Wart.Throw)
)

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true,
    scalafmtVersion := "1.2.0"
  )

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  resolvers ++= Seq(
    "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)

lazy val assemblySettings = Seq(
  assemblyJarName in assembly := name.value + ".jar",
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "application.conf"            => MergeStrategy.concat
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  }
)
