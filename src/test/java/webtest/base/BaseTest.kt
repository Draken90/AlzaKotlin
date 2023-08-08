package webtest.base

import org.testng.annotations.Test

class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        acceptCookies()
        selectMenu()
        selectOption()
        selectFilter()
        addToBasket()

    }
}