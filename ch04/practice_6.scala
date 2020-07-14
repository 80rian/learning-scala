// 6. 한 쌍의 2차원 점 사이의 거리를 계산하는 함수를 작성하고 그 값을 점으로 반환하라.
// 힌트: 튜플을 사용하는 것이 좋다.

// def distanceCalc(x1: Int, y1: Int)(x2: Int, y2: Int): Double = {
//     math.pow(math.pow(x2 - x1, 2) + math.pow(y2 - y1, 2), 0.5)
// }

def distanceCalc(src: (Int, Int), dest: (Int, Int)): (Int, Int) = (dest._1 - src._1, dest._2 - src._2)

println(distanceCalc((3, 3), (7, 4)))