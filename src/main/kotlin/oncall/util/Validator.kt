package oncall.util

object Validator {

    //빈 값이 들어왔을 경우(Month & Day 둘 다) => 전체 입력 값
    fun validateNotEmpty(input: String) {
        require(input.isNotBlank()) {"[ERROR] 입력값이 비어 있습니다."}
    }

    // Month와 Day가 ","제외 size가 2가 맞는지
    fun validateSize(input: String) {
        val parts = input.split(",")
        require(parts.size == 2) {"[ERROR] 입력값은 ','로 구분된 월과 요일 두 개여야 합니다."}
    }

    //각 값이 비어 있지 않은지 확인
    fun validateEachPartNotEmpty(parts: List<String>) {
        require(parts[0].isNotBlank()) {"[ERROR] 월의 값이 비어 있습니다."}
        require(parts[1].isNotBlank()) {"[ERROR] 요일의 값이 비어 있습니다."}
    }


    //Pair 중 String으로 받는 것 (요일)
    fun validateLength(input: String) {
        //요일을 한 글자로 받지 않는 경우
        require(input.length == 1) {"[ERROR] 요일은 한 글자로 입력해 주세요."}
    }

    //Pair 중 String으로 받는 것 (요일)
    fun validateDay(input: String) {
        require(listOf("월","화","수","목","금","토","일").contains(input)) {
            "[ERROR] 적절한 요일을 입력해 주세요."
        }
    }

    // Month 관련 입력값을 int로 변환하는걸 시도해서 숫자인지 아닌지 확인
    fun validateIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 월은 숫자로 입력해 주세요.")
        }
    }

    //month가 1~12 사이 값인지 확인
    fun validateNumberRange(input: Int) {
        require(input in 1..12)
    }

}