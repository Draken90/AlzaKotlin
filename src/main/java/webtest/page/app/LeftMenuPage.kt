package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage


class LeftMenuPage: AbstractTechnicalPage() {

    private val optionComputersLeftMenuButton : ElementDef = ElementDef(ComponentType.BUTTON, "Počítače",By.xpath("//a[@href='/pocitace-a-notebooky']"))

    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    fun countClickableObjects():Int{

        val leftMenuObject: ElementDef = ElementDef(ComponentType.MAIN_MENU_ITEM,"Main Menu Item",By.className("leftMenuItem"))
        val allMatchingElements: List<WebElement> = elements().findElements(leftMenuObject)
        val numberOfElements = allMatchingElements.size
        val generatorNumber = (numberOfElements-1)
        return generatorNumber
    }



    fun clickOnLeftMenuOption(productNumber: Int) {
        val leftMenuOption: ElementDef = ElementDef(ComponentType.BUTTON, "MenuOption", By.xpath("//li[contains(@class,'leftMenuItem')][${productNumber}]/a[contains(@class,'catLink')]"))
        elements().performClick(leftMenuOption)
    }

    fun clickOnOptionComputersLeftMenuButton()=elements().performClick(optionComputersLeftMenuButton)
}