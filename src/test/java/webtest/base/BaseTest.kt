package webtest.base

import org.testng.annotations.Test

class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        acceptCookies()
        selectMenu()
        Thread.sleep(2000)
        selectOption()
        onStore()
        selectFilter()
        Thread.sleep(2000)
        addToBasket()
        Thread.sleep(10000)
    }
}