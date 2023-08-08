package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import kotlin.random.Random.Default.nextInt
import org.openqa.selenium.WebElement


class ProductSelectPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }
    private var poradiProduktu = (nextInt(18) + 1)
    private var cisloGeneratoru = 1
    private var typFiltru = "#cenaasc"
    private var leftMenuOption: ElementDef = ElementDef(ComponentType.BUTTON, "MenuOption", By.xpath("//li[contains(@class,\"leftMenuItem\")][${poradiProduktu}]/a[contains(@class,\"catLink\")]"))
    private var choiceOptionUni: ElementDef = ElementDef(ComponentType.BUTTON, "Výběr z nabídky", By.xpath("//a[@class = 'catalogLocalTitlePage-alz-4']"))
    private var onStore: ElementDef = ElementDef(ComponentType.ANY, "Na Skladě", By.xpath("//span[(text()=\"Skladem kdekoliv\")]/preceding-sibling::span/input[@type=\"radio\" and @ value= \"1\"]"))
    private var toBasketUni: ElementDef = ElementDef(ComponentType.ANY, "Do Košíku", By.xpath("//div[contains(@class,\"inStockAvailability\")]"))

    fun clickOnMenu() {
        poradiProduktu = (nextInt(19) + 1)
        elements().performClick(leftMenuOption)

    }

    fun clickOnOption() {
        var allMatchingElements: List<WebElement> = elements().findElements(choiceOptionUni)
        var numberOfElements = allMatchingElements.size
        while ( numberOfElements != 0){

            elements().waitUntilPageIsLoaded()

            cisloGeneratoru = (numberOfElements - 1)
            poradiProduktu = (nextInt(cisloGeneratoru)+1)
            var choiceOption: ElementDef = ElementDef(ComponentType.BUTTON, "Výběr z nabídky", By.xpath("(//a[@class = 'catalogLocalTitlePage-alz-4'])[${poradiProduktu}]"))
            elements().performClick(choiceOption)

            elements().waitUntilPageIsLoaded()

            allMatchingElements = elements().findElements(choiceOptionUni)
            numberOfElements = allMatchingElements.size
        }
    }
    fun clickOnStore() {
        elements().performClick(onStore)
    }
    fun clickFilter() {
        poradiProduktu = (nextInt(5) + 1)
        when (poradiProduktu){
            1 -> typFiltru = "#alzadoporucuje"
            2 -> typFiltru = "#nejprodavanejsi"
            3 -> typFiltru = "#podleslevy"
            4 -> typFiltru = "#cenaasc"
            5 -> typFiltru = "#cenadesc"
            6 -> typFiltru = "#nejlepehodnocene"
        }
        var filter: ElementDef = ElementDef(ComponentType.BUTTON, "Řadit podle", By.xpath("//a[@href = '${typFiltru}']"))
        elements().performClick(filter)
    }


    fun clickAddToBasket() {
        val allMatchingElements: List<WebElement> =  elements().findElements(toBasketUni)
        val numberOfElements = allMatchingElements.size
        cisloGeneratoru = (numberOfElements -1)
        poradiProduktu = (nextInt(cisloGeneratoru)+1)
        val toBasket: ElementDef = ElementDef(ComponentType.ANY, "Do Košíku", By.xpath("(//div[contains(@class,\"inStockAvailability\")])[${poradiProduktu}]//a[@class=\"btnk1\"]"))

        elements().performClick(toBasket)
    }


}