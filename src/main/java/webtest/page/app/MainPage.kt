package webtest.page.app

import org.openqa.selenium.By
//import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
//import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage


class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val cookies: ElementDef = ElementDef(ComponentType.ANY, "Přijmout", By.xpath("//a[contains(text(),'Rozumím')]"))

    fun eatCookies()= elements().performClick(cookies)

    private val alzaSearch: ElementDef = ElementDef(ComponentType.ANY, "Co hledáte?", By.xpath("//div[@data-testid='searchInput']"))
    private val alzaSearchButton: ElementDef = ElementDef(ComponentType.BUTTON, "Hledat", By.xpath("//div[@data-testid='button-search']"))
    private val addToCart: ElementDef = ElementDef(ComponentType.ANY, "Do košíku", By.xpath("(//a[contains(text(),'Do Košíku')])[1]"))

    fun clickOnAddToCartButton() = elements().performClick(addToCart)

    fun fillSearch(input: String){
        elements().setValue(alzaSearch, input)
    }

    fun clickOnSearchButton() = elements().performClick(alzaSearchButton)

}