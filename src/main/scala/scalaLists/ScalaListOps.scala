package scalaListsSuite

/**
 * Created by cganoo on 6/23/14.
 */
object ScalaListOps extends App {

  def customLast[T](xs: List[T]): T = xs match {
    case Nil => throw new Error("last of empty list is undefined")
    case y :: Nil => y
    case y :: ys => customLast(ys)
  }

  def customInit[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new Error("init of empty list is undefined")
    case List(y) => Nil
    case y :: ys => y :: customInit(ys)
  }

  def customConcat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case z :: zs => z :: customConcat(zs, ys)
  }

  def customReverse[T](xs: List[T]): List[T] = xs match {
    case Nil => xs
    case y :: ys => customReverse(ys) ++ List(y)
  }

  def customRemoveAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

  /**
   * Flattens the specified list by flattening any contained nested lists
   * Type erasure will cause abstract type to be unchecked in the type pattern used by the method
   * Hence using Any
   * @param xs the list to be flattened
   * @tparam Any
   * @return the flattened list devoid of any nested lists
   */
  def customFlatten[Any](xs: List[Any]): List[Any] = xs match {
    case Nil => xs
    case (y: List[Any]) :: ys => customFlatten(y) ::: customFlatten(ys)
    case _ => xs.head :: customFlatten(xs.tail)
  }
}
