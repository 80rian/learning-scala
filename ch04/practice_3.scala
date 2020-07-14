// 3. for이나 while 루프를 사용하지 않고 5부터 50까지 5씩 증가하는 값을 출력하는 재귀 함수를 작성하라. 이 함수를 꼬리-재귀가 가능하도록 만들 수 있는가?

@annotation.tailrec
def incrementer(x: Int): Unit = {
    if (x <= 50) {
        println(x)
        incrementer(x + 5)
    }
}

incrementer(5)