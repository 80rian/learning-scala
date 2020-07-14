// 4. 1000분의 1초 값을 취하여 그 값을 일, 시간, 분, 초로 나타내는 문자열로 반환하는 함수를 작성하라. 입력값으로 최적의 타입은 무엇인가?

def timeTransformer(ms: Long): String = {
    val s = ms / 1000
    val days = s / 86400
    val hours = (s % 86400 ) / 3600
    val minutes = (s % 3600) / 60
    val seconds = s % 60

    s"$days days, $hours hours, $minutes minutes, $seconds seconds"
}

println(timeTransformer(15275437615L))