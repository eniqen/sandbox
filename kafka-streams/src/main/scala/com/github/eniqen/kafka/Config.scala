package com.github.eniqen.kafka

/**
 * @author Mikhail Nemenko { @literal <nemenkoma@gmail.com>}
 */
object Config {
  val BootstrapServers = "localhost:9092"
  val AppId            = "word-count-app"
  val BankAppId        = "bank-transactions-app"
  val OffsEarliest     = "earliest"


  abstract class Topic(val name: String)

  object Topic {
    case object BankBalanceIn extends Topic("bank-balance-input")
    case object BankBalanceOut extends Topic("bank-balance-out")
    case object WordCountIn extends Topic("word-count-input")
    case object WordCountOut extends Topic("word-count-output")
    case object FavouriteColorIn extends Topic("favourite-color-in")
    case object FavouriteColorOut extends Topic("favourite-color-out")
    case object FavouriteColorUsersColors extends Topic("user-keys-and-color")
  }
}

