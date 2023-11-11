package christmas.model

import christmas.utils.Constant.BADGE_SANTA
import christmas.utils.Constant.BADGE_STAR
import christmas.utils.Constant.BADGE_TREE
import christmas.utils.Constant.SANTA_MIN
import christmas.utils.Constant.STAR_MAX
import christmas.utils.Constant.STAR_MIN
import christmas.utils.Constant.TREE_MAX
import christmas.utils.Constant.TREE_MIN

class Badge {
    fun assignBadge(benefitAmount: Int): String {
        when {
            benefitAmount in STAR_MIN..STAR_MAX -> return BADGE_STAR
            benefitAmount in TREE_MIN..TREE_MAX -> return BADGE_TREE
            benefitAmount >= SANTA_MIN -> return BADGE_SANTA
        }

        return "없음"
    }
}