package org.ak.scala.cookbook.ch10

import org.ak.scala.cookbook.ch10.util.MeasureSize
import org.ak.scala.cookbook.ch10.util.gen.ImmutableCollections
import org.scalameter.api._

import scala.language.reflectiveCalls

/**
  * @author antonk
  * @since 7/21/17 - 7:57 PM
  */
object CollectionPerformanceResearch
  extends Bench.OfflineReport
    with ImmutableCollections
    with MeasureSize {

  performance of "collections" in {
    performance of "list" in {
      measureSizeFor(lists)
    }

    performance of "range" in {
      measureSizeFor(ranges)
    }

    performance of "vector" in {
      measureSizeFor(vectors)
    }

    performance of "queue" in {
      measureSizeFor(queues)
    }

    performance of "string" in {
      measureSizeFor(strings)
    }
  }

  override def sizes = Gen.exponential("size")(
    1,
    10000,
    10
  )
}
