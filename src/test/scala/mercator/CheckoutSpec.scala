package mercator

import munit.FunSuite

class CheckoutSpec extends FunSuite {
  test("calculateTotal for [Apple, Apple, Orange, Apple]") {
    val cart = List(Apple, Apple, Orange, Apple)
    assertEquals(Checkout.calculateTotal(cart), BigDecimal("2.05"))
  }
}
