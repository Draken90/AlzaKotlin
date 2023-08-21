package webtest.base.step

import webtest.page.app.ShoppingCartPage

class ShoppingCartPageTestStep: AbstractTestStep() {

    val shoppingCartPage = ShoppingCartPage()

fun verifySameProductsArePresent(): Boolean{
    return shoppingCartPage.verifyProductsAreRight()
}


}