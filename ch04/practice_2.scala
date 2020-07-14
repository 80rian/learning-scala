// 2. 연습문제 1에서 작성한 함수를 반지름을 String으로 취하는 다른 형태의 함수로 바꿔보자. 빈 String으로 호출되면 어떤 일이 발생하는가?

import scala.math.{Pi}
val radius = "5"

def areaCalc(r: String): Double = {
    r.isEmpty match {
        case true => 0
        case false => Pi * r.toDouble * r.toDouble
    }
}

val result = areaCalc(radius)
println(result)