package mercator

sealed trait Item {
  def price: BigDecimal
}

case object Apple extends Item {
  val price: BigDecimal = BigDecimal("0.60")
}

case object Orange extends Item {
  val price: BigDecimal = BigDecimal("0.25")
}
