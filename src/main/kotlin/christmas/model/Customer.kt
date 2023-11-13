package christmas.model

data class Customer2(
    private val visitDate: Int,
    val orderMenu: List<OrderItems>
)