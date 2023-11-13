package christmas.model

data class Customer(
    private val visitDate: Int,
    private val orderMenu: List<OrderItems>
) {
    fun requestApplyDecemberEvent() {
        EventHelper(visitDate, orderMenu).applyDecemberEvent()
    }
}