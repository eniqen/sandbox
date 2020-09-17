package com.github.eniqen.algo

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
object AviraTest extends App {
//  SELECT p.name FROM (
//    SELECT x1.caller as pn, x1.duration FROM calls as x1
//  UNION ALL
//    SELECT x2.callee as pn, x2.duration FROM calls as x2
//  ) as s INNER JOIN phones as p ON s.pn = p.phone_number
//  GROUP BY p.name
//  HAVING SUM(s.duration) >= 10
//  ORDER BY p.name
}
