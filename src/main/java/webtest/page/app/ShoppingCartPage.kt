package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(alzaHome).isDisplayed
    private val alzaHome: ElementDef = ElementDef(ComponentType.ANY, "Alza Homepage", By.xpath("//a[contains(@title,'Přejít na hlavní stránku')]"))


    var listOfShoppingCartProductsId: MutableList<String> = mutableListOf()
    var tableRows = ElementDef(ComponentType.ANY,"",By.xpath("//tr"))
    fun getPriceOfProduct(productOrder: Number): Int {

        val element = driver.findElement(By.xpath("(//div[contains(@class,\"inStockAvailability\")])[${productOrder}]//span[@class = 'price-box__price']"))
        var productPrice = element.text.replace(Regex("[^0-9]"), "").toInt()
        return productPrice

    }

    fun verifyProductsAreRight():Boolean{
        var resultsPage = ResultsPage()

        val listOfShoppingCartProducts: List<WebElement> = elements().findElements(tableRows)
        for (element in listOfShoppingCartProducts) {
            val productID = element.getAttribute("data-code")
            if (productID!=null) {
                listOfShoppingCartProductsId.add(productID)
            }
        }

        var addedSet = resultsPage.listOfProducts.toSet()
        var cartSet = listOfShoppingCartProductsId.toSet()

        return addedSet==cartSet




    }

}