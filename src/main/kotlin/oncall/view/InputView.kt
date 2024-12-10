package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.util.Validator
import oncall.util.Validator.validateDay
import oncall.util.Validator.validateIsDigit
import oncall.util.Validator.validateLength
import oncall.util.Validator.validateNumberRange

class InputView {

    fun readMonthAndDay(): Pair<Int, String> {
        print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")

        try {
            val (month, day) = Console.readLine().split(SPLITTER)
            validateIsDigit(month)
            validateNumberRange(month.toInt())
            validateDay(day)
            validateLength(day)
            return Pair(month.toInt(), day)

        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(INVALID_INPUT)
        }


    }
    companion object {
        const val SPLITTER = ","
    }
}