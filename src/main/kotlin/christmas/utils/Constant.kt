package christmas.utils

object Constant {
    /* DecemberEvent */
    const val FIRST_DAY_DISCOUNT_AMOUNT = 1_000
    const val DAILY_DISCOUNT_AMOUNT = 100
    const val ONE_DAY_DECREASE = 1
    const val WEEK_DISCOUNT_AMOUNT = 2_023
    const val CHRISTMAS_DAY_DISCOUNT_AMOUNT = 1_000
    const val CHAMPAGNE_CONDITION_AMOUNT = 120_000

    /* Badge */
    const val BADGE_STAR = "별"
    const val BADGE_TREE = "트리"
    const val BADGE_SANTA = "산타"
    const val NONE_BADGE = "없음"
    const val STAR_MIN = 5_000
    const val STAR_MAX = 9_999
    const val TREE_MIN = 10_000
    const val TREE_MAX = 19_999
    const val SANTA_MIN = 20_000

    /* Validate */
    const val VISIT_DATE_MIN = 1
    const val VISIT_DATE_MAX = 31
    const val NUMERIC_REGEX = "^\\d+$"
    private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
    const val ERROR_MESSAGE_INPUT_VISIT_DATE = ERROR_MESSAGE_PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요."

    /* InputView */
    const val VISIT_DATE_ANNOUNCE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"

    /* OutPutView */
    const val START_PLANNER_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
}