package webtest.base.step
import webtest.page.app.MainPage


class MainPageStep: AbstractTestStep(){

    fun findProduct(){
        val mainPage = MainPage()
        mainPage.clickOnSearchButton()
        mainPage.clickOnAddToCartButton()
    }
}