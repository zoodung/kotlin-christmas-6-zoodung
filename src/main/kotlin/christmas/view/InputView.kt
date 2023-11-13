package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Constant.MENU_ANNOUNCE_MESSAGE
import christmas.utils.Constant.VISIT_DATE_ANNOUNCE_MESSAGE

class InputView {
    fun readVisitDate(): String {
        println(VISIT_DATE_ANNOUNCE_MESSAGE)
        return Console.readLine()
    }

    fun readOrderMenu(): String {
        println(MENU_ANNOUNCE_MESSAGE)
        return Console.readLine()
    }
}