package oncall.util

object Validator {

    //Pair 중 String으로 받는 것 (요일)
    fun validateLength(input: String) {
        //요일을 한 글자로 받지 않는 경우
        require(input.length == 1) {INVALID_INPUT}
    }

    //Pair 중 String으로 받는 것 (요일)
    fun validateDay(input: String) {
        require(listOf("월","화","수","목","금","토","일").contains(input)) {
            INVALID_INPUT
        }
    }

    // Month 관련 입력값을 int로 변환하는걸 시도해서 숫자인지 아닌지 확인
    fun validateIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT)
        }
    }

    //month가 1~12 사이 값인지 확인
    fun validateNumberRange(input: Int) {
        require(input in 1..12) {INVALID_INPUT}
    }

    // 닉네임 최소 1자 최대 5자인지 리스트 모든 요소 확인
    fun validateElementLength(input: List<String>) {
        require(input.all { it.length in 1..5 }) {INVALID_INPUT}
    }

    // 최소 근무자 수, 최대 근무자 수 확인
    fun validateSize(input: List<String>) {
        require(input.size in 5..35) {INVALID_INPUT}
    }

    // 닉네임 중복 여부 확인
    fun validateNotDuplicate(input: List<String>) {
        require(input.distinct().size == input.size) {INVALID_INPUT}
    }

    const val INVALID_INPUT = "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."

}


//    //빈 값이 들어왔을 경우(Month & Day 둘 다) => 전체 입력 값
//    fun validateNotEmpty(input: String) {
//        require(input.isNotBlank()) {"[ERROR] 입력값이 비어 있습니다."}
//    }
//
//    // Month와 Day가 ","제외 size가 2가 맞는지
//    fun validateSize(input: String) {
//        val parts = input.split(",")
//        require(parts.size == 2) {"[ERROR] 입력값은 ','로 구분된 월과 요일 두 개여야 합니다."}
//    }
//
//    //각 값이 비어 있지 않은지 확인
//    fun validateEachPartNotEmpty(parts: List<String>) {
//        require(parts[0].isNotBlank()) {"[ERROR] 월의 값이 비어 있습니다."}
//        require(parts[1].isNotBlank()) {"[ERROR] 요일의 값이 비어 있습니다."}
//    }