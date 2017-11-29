package chap4

import cats.Eval

object EvalApp extends App {

  val now = Eval.now({
    println("is it now??")
    math.random()
  })
  println(now)
  println(now)

  val later = Eval.later({
    println("is it now?? or later?")
    math.random()
  })

  println(later)
  println("later has not been evaluated")
  println(later.value)
  println(later.value)
  println("now it has")

  val always = Eval.always({
    println("Now or later? How about later and later?")
    math.random()
  })

  println(always)
  println("you'll have to do better than that")
  println(always.value)
  println(always.value)

  println("omg it is a monad")

  val answer: Eval[Int] = for {
    a <- Eval.now({println("Calculating 40. NOW!"); 40})
    b <- Eval.later({println("Calculating 2. Later..."); 2})
  } yield a + b

  println(answer)
  println("Not yet...")
  println(answer.value)
}