package christmas

import christmas.model.Badge
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BadgeTest {
    private val badge: Badge = Badge()

    @Test
    fun `배지 부여 테스트`() {
        val noneBadge = badge.assignBadge(0)
        val starBadge = badge.assignBadge(5000)
        val treeBadge = badge.assignBadge(10000)
        val santaBadge = badge.assignBadge(200000)

        Assertions.assertTrue(noneBadge == "없음")
        Assertions.assertTrue(starBadge == "별")
        Assertions.assertTrue(treeBadge == "트리")
        Assertions.assertTrue(santaBadge == "산타")
    }
}