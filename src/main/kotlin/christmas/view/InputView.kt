package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Constant.VISIT_DATE_ANNOUNCE_MESSAGE

class InputView {
    fun requestInputVisitDate(): String {
        println(VISIT_DATE_ANNOUNCE_MESSAGE)
        return Console.readLine()
    }
}