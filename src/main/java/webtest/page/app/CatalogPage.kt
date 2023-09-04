package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CatalogPage: AbstractTechnicalPage(){
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val choiceKomponenty: ElementDef = ElementDef(ComponentType.BUTTON, "Komponenty", By.xpath("//a[@href='https://www.alza.cz/komponenty/18852654.htm']"))
    fun countClickableObjects():Int{

        val catalogObject: ElementDef = ElementDef(ComponentType.BUTTON,"Catalog Button", By.className("catalogLocalTitlePage-alz-4"))
        val allMatchingElements: List<WebElement> = elements().findElements(catalogObject)
        val numberOfElements = allMatchingElements.size
        val generatorNumber = (numberOfElements-1)
        return generatorNumber
    }

    fun clickOnComponentsButton()=elements().performClick(choiceKomponenty)



    fun clickOnCatalogOption(productNumber: Int) {
        val choiceOption = ElementDef(ComponentType.BUTTON, "Výběr z nabídky", By.xpath("(//a[@class = 'catalogLocalTitlePage-alz-4'])[${productNumber}]"))
        elements().performClick(choiceOption)
    }

    fun seekForAdvert(): Boolean {

        val popup: ElementDef = ElementDef(ComponentType.ANY, "Zavřít reklamu", By.xpath("//div[@class = 'popup']"))
        waitUntilPageIsLoaded()
        val allMatchingElements: List<WebElement> = elements().findElements(popup)
        val numberOfElements = allMatchingElements.size
        return numberOfElements==1
    }

    fun closeAdvert(){
        val closeAdd: ElementDef = ElementDef(ComponentType.ANY, "Zavřít reklamu", By.xpath("(//div[@class = 'close'])[2]"))
        elements().performClick(closeAdd)
    }
}