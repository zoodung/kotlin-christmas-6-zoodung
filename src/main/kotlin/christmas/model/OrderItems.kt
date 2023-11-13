package christmas.model

data class OrderItems(
    private val menuName: String,
    private val quantity: Int
){
    fun getMenuName(): String = menuName

    fun getQuantity(): Int = quantity

}
