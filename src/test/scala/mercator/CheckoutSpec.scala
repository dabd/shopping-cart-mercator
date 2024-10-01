package mercator

import munit.FunSuite

class CheckoutSpec extends FunSuite {
  test("calculateTotal for [Apple, Apple, Orange, Apple]") {
    val cart = List(Apple, Apple, Orange, Apple)
    assertEquals(Checkout.calculateTotal(cart), BigDecimal("2.05"))
  }

  test("calculateTotalWithOffers [Apple, Apple]") {
    val cart = List(Apple, Apple)
    assertEquals(Checkout.calculateTotalWithOffers(cart), BigDecimal("0.60"))
  }

  test("calculateTotalWithOffers [Orange, Orange, Orange]") {
    val cart = List(Orange, Orange, Orange)
    assertEquals(Checkout.calculateTotalWithOffers(cart), BigDecimal("0.50"))
  }

  test("calculateTotalWithOffers [Apple, Apple, Apple, Orange, Orange, Orange, Orange]") {
    val cart = List(Apple, Apple, Apple, Orange, Orange, Orange, Orange)
    assertEquals(Checkout.calculateTotalWithOffers(cart),
      BigDecimal("0.60") + // 2-for-1 apple
      BigDecimal("0.60") + //1 apple
        BigDecimal("0.50") + // 3-for-2 oranges
        BigDecimal("0.25") // 1 orange
    )
  }
}
