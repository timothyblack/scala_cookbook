package org.ak.scala.cookbook.ch06

import java.io.{File, FileOutputStream, PrintWriter}

import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

/**
 * @author antonk
 * @since  8/21/14 - 12:32 PM
 */
class ObjectsTest
  extends FunSuite
          with Matchers {

  val tmpFile = File.createTempFile("ScalaCookbook", "ObjectsTest")
  val outFile = new PrintWriter(new FileOutputStream(tmpFile))

  tmpFile.deleteOnExit()

  // ////////////////////////////////////////////

  object Main extends App {
    outFile.println(args.map(_.toInt).sum)
    outFile.close()
  }

  // ////////////////////////////////////////////

  test("launching an application with an object") {
    Main.main(Array("1", "2", "3", "4", "5"))


    val lines = Source.fromFile(tmpFile).getLines().toList
    lines shouldEqual List("15")
  }
}
