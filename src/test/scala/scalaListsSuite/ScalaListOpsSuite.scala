package scalaListsSuite

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * Created by cganoo on 5/31/14.
 */
@RunWith(classOf[JUnitRunner])
class ScalaListOpsSuite extends FunSuite {
  import scalaListsSuite.ScalaListOps._

  trait TestLists {
    val t1 = List(1, -7, 9, List(9, 34, 9))
    val t2 = List()
    val t3 = List(List(1, 2), List(3, 4, 5), List(6))
    val t4 = List('a', 'b', 'c')
    val t5 = List(List(9, 34, 9), 9, -7, 1)
  }

  test("Fetch last and initial part of the list correctly") {
    new TestLists {
      assert(customLast(t1) === List(9, 34, 9))
      intercept[Error] {
        customLast(t2)
      }
      assert(customLast(t3) === List(6))
      assert(customLast(t4) === 'c')
      assert(customInit(t1) === List(1, -7, 9))
      assert(customInit(t3) === List(List(1, 2), List(3, 4, 5)))
      intercept[Error] {
        customInit(t2)
      }
    }
  }

  test("Concatenation of 2 lists") {
    new TestLists {
      assert(customConcat(t1, t2) === t1)
      assert(customConcat(t2, t2) === Nil)
      assert(customConcat(t3, t4) === List(List(1, 2), List(3, 4, 5), List(6), 'a', 'b', 'c'))
    }
  }

  test("Reversal of a list") {
    new TestLists {
      assert(customReverse(t1) === t5)
      assert(customReverse(t2) === Nil)
    }
  }

  test("Removal of an element at a specified position in a list") {
    new TestLists {
      assert(customRemoveAt(3, t1) === List(1, -7, 9))
      assert(customRemoveAt(-1, t1) === t1)
      assert(customRemoveAt(10, t1) === t1)
      assert(customRemoveAt(0, t2) === Nil)
      assert(customRemoveAt(100, t2) === Nil)
      assert(customRemoveAt(1, t5) === List(List(9, 34, 9), -7, 1))
    }
  }

  test("Flattening of a list") {
    new TestLists {
      assert(customFlatten(t1) === List(1, -7, 9, 9, 34, 9))
      assert(customFlatten(t2) === Nil)
      assert(customFlatten(List(List(List(), List()))) === Nil)
      assert(customFlatten(t3) === List(1, 2, 3, 4, 5,6))
    }
  }

}
