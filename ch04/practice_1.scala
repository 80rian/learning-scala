// 1. 반지름이 주어졌을 때 원의 면적을 구하는 함수를 작성하라.

import scala.math.{Pi}
val radius = 5

def areaCalc(r: Double): Double = {
    Pi * r * r
}

val result = areaCalc(radius)
println(result)