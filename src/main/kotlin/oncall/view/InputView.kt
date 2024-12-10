package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.util.Validator

class InputView {

    fun readMonthAndDay(): Pair<Int, String> {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
        val input = Console.readLine()

        try {
            // 입력값이 비어 있는지 확인
            Validator.validateNotEmpty(input)
            // 쉼표로 구분된 월과 요일인지 확인
            Validator.validateSize(input)
            // 쉼표를 기준으로 분리
            val (month, day) = input.split(",")


            return Pair(month.toInt(), day)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.")
            readMonthAndDay()
        }
    }
}