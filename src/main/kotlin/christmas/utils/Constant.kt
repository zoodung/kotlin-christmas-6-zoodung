package christmas.utils

object Constant {
    /* Model */
    const val FIRST_DAY_DISCOUNT_AMOUNT = 1_000
    const val DAILY_DISCOUNT_AMOUNT = 100
    const val ONE_DAY_DECREASE = 1
    const val WEEK_DISCOUNT_AMOUNT = 2_023
    const val CHRISTMAS_DAY_DISCOUNT_AMOUNT = 1_000
    const val CHAMPAGNE_CONDITION_AMOUNT = 120_000
    const val CHRISTMAS_DAY = 25
    const val DISCOUNT_THRESHOLD = 10_000
    const val EMPTY = 0
    const val BADGE_STAR = "별"
    const val BADGE_TREE = "트리"
    const val BADGE_SANTA = "산타"
    const val NONE = "없음"
    const val STAR_MIN = 5_000
    const val STAR_MAX = 9_999
    const val TREE_MIN = 10_000
    const val TREE_MAX = 19_999
    const val SANTA_MIN = 20_000
    const val FIRST_INDEX = 0
    const val SECOND_INDEX = 1

    /* Validate */
    const val ORDER_ITEMS_SIZE = 2
    const val VISIT_DATE_MIN = 1
    const val VISIT_DATE_MAX = 31
    const val QUANTITY_MINIMUM = 1
    const val QUANTITY_MAXIMUM = 20
    const val HYPHEN = "-"
    const val COMMA = ","
    const val NUMERIC_REGEX = "^\\d+$"
    private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
    const val ERROR_MESSAGE_INPUT_VISIT_DATE = ERROR_MESSAGE_PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요."
    const val ERROR_MESSAGE_INPUT_MENU = ERROR_MESSAGE_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."

    /* InputView */
    const val VISIT_DATE_ANNOUNCE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    const val MENU_ANNOUNCE_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"

    /* OutPutView */
    private const val PRINT_ENTER = "\n"
    const val START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
    const val PREVIEW_ANNOUNCE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
    const val ORDER_MENU_TITLE_MESSAGE = "$PRINT_ENTER<주문 메뉴>"
    const val ITEMS_RESULT = "%s %d개"
    const val TOTAL_ORDER_SUM_TITLE_MESSAGE = "$PRINT_ENTER<할인 전 총주문 금액>"
    const val TOTAL_AMOUNT_RESULT = "%,d원"
    const val PRESENT_MENU_TITLE_MESSAGE = "$PRINT_ENTER<증정 메뉴>"
    const val PRESENT_AMOUNT = 1
    const val BENEFIT_DETAILS_TITLE_MESSAGE = "$PRINT_ENTER<혜택 내역>"
    const val FREEBIE_EVENT_NAME = "증정 이벤트"
    const val BENEFIT_RESULT = "%s: -%,d원"
    const val BENEFIT_AMOUNT_TITLE_MESSAGE = "$PRINT_ENTER<총혜택 금액>"
    const val PAYMENT_AMOUNT_TITLE_MESSAGE = "$PRINT_ENTER<할인 후 예상 결제 금액>"
    const val BADGE_TITLE_MESSAGE = "$PRINT_ENTER<12월 이벤트 배지>"
}