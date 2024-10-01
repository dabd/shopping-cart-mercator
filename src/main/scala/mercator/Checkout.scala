package mercator

object Checkout {

  def calculateTotal(items: List[Item]): BigDecimal =
    items.map(_.price).sum

  def calculateTotalWithOffers(items: List[Item]): BigDecimal = {
    val itemCounts = items.groupBy(identity).map { case (k, v) => k -> v.size }
    val appleCount = itemCounts.getOrElse(Apple, 0)
    val orangeCount = itemCounts.getOrElse(Orange, 0)
    val appleTotal = (appleCount / 2 + appleCount % 2) * Apple.price
    val orangeTotal = ((orangeCount / 3) * 2 + orangeCount % 3) * Orange.price
    appleTotal + orangeTotal
  }
}
