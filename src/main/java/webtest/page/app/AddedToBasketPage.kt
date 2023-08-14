package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class AddedToBasketPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val alzaHome: ElementDef = ElementDef(ComponentType.ANY, "Alza Homepage", By.xpath("//a[contains(@title,'Přejít na hlavní stránku')]"))

    fun returnToMainPage()= elements().performClick(alzaHome)
}