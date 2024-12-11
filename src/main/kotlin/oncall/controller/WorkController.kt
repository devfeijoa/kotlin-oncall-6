package oncall.controller

import oncall.view.InputView
import oncall.view.OutputView
import oncall.model.CalenderBuilder
import oncall.model.WorkScheduler

import java.util.*;

class WorkController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun start() {
        outputView.inputMonthDayMessage()
        val dateInfo = getValidMonthDay()

        outputView.inputWeekdayMessage()
        val weekdayNames = getValidNames()

        outputView.inputWeekendMessage()
        val weekendNames = getValidNames()

        val calendarBuilder  = CalenderBuilder(dateInfo)
        val calender = calendarBuilder.make()

        val workScheduler  = WorkScheduler(calender, LinkedList(weekdayNames), LinkedList(weekendNames))
        val result = workScheduler.get()

        outputView.printWorkSchedule(calender.map { it.first }, result )

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