package oncall.controller

import oncall.view.InputView
import oncall.view.OutputView

class WorkController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun start() {
        outputView.inputMonthDayMessage()
        val dateInfo = getValidMonthDay()

        outputView.inputWeekdayMessage()
        val weekdayWorker = getValidNames()

        outputView.inputWeekendMessage()
        val weekendWorker = getValidNames()


    }

    private fun getValidMonthDay(): Pair<Int, String> {
        return try {
            inputView.readMonthAndDay()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidMonthDay()
        }
    }

    private fun getValidNames(): List<String> {
        return try {
            inputView.readNames()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getValidNames()
        }
    }
}