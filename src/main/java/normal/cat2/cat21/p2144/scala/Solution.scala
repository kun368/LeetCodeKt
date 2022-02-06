package normal.cat2.cat21.p2144.scala

object Solution {
  def minimumCost(cost: Array[Int]): Int = {
    cost.sorted.reverse.zipWithIndex.filter(_._2 % 3 != 2).map(_._1).sum
  }

  def main(args: Array[String]): Unit = {
    println(Solution.minimumCost(Array(1, 2, 3)))
    println(Solution.minimumCost(Array(6, 5, 7, 9, 2, 2)))
    println(Solution.minimumCost(Array(5, 5)))
  }
}
