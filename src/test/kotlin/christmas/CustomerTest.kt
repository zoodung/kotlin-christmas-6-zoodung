package christmas

import christmas.utils.Validate.validateVisitDate
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CustomerTest {
    @ValueSource(strings = ["", "Tomorrow", "12.11", " 25", "25 ", "-1", "0", "32"])
    @ParameterizedTest
    fun `예상 방문 날짜 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            validateVisitDate(input)
        }
    }
}