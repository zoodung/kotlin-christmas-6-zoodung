package christmas.model

data class Customer(
    private val visitDate: Int,
    private val orderMenu: List<OrderItems>
) {
    fun getVisitDate(): Int = visitDate

    fun getOrderMenu(): List<OrderItems> = orderMenu
}