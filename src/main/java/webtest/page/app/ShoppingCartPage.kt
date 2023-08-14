package webtest.page.app

import org.openqa.selenium.By
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }
    fun getPriceOfProduct(productOrder: Number): Int {

        val element = driver.findElement(By.xpath("(//div[contains(@class,\"inStockAvailability\")])[${productOrder}]//span[@class = 'price-box__price']"))
        var productPrice = element.text.replace(Regex("[^0-9]"), "").toInt()
        return productPrice

    }

}