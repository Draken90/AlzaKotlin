package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import kotlin.random.Random.Default.nextInt
import org.openqa.selenium.WebElement
import org.jsoup.Jsoup




class ProductSelectPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }
    private var PoradiProduktu = (nextInt(18) + 1)
    var cisloGeneratoru = 1
    var typFiltru = "#alzadoporucuje"
    var allMatchingElements = 1
    private val leftMenuOption: ElementDef = ElementDef(ComponentType.ANY, "MenuOption", By.xpath("(//li[contains(@class,\"leftMenuItem\")])[${PoradiProduktu}]/a[contains(@class,\"catLink\")]"))
    private val choiceOptionUni: ElementDef = ElementDef(ComponentType.ANY, "Výběr z nabídky", By.xpath("//a[@class = 'catalogLocalTitlePage-alz-4']"))
    private val choiceOption: ElementDef = ElementDef(ComponentType.ANY, "Výběr z nabídky", By.xpath("(//a[@class = 'catalogLocalTitlePage-alz-4'])[${PoradiProduktu}]"))
    private val filter: ElementDef = ElementDef(ComponentType.ANY, "Řadit podle", By.xpath("//a[@href = '${typFiltru}']"))
    private val toBasketUni: ElementDef = ElementDef(ComponentType.ANY, "Do Košíku", By.xpath("//div[contains(@class,\"inStockAvailability\")]"))
    private val toBasket: ElementDef = ElementDef(ComponentType.ANY, "Do Košíku", By.xpath("(//div[contains(@class,\"inStockAvailability\")])[${PoradiProduktu}]//a[@class=\"btnk1\"]"))


    fun clickOnMenu() = {
        PoradiProduktu = (nextInt(18) + 1)
        elements().performClick(leftMenuOption)
    }

    fun clickOnOption() = {
     var allMatchingElements: List<WebElement> =  elements().findElements(choiceOptionUni)
     var numberOfElements = allMatchingElements.size
        cisloGeneratoru = (numberOfElements -1)
        PoradiProduktu = (nextInt(cisloGeneratoru)+1)
        elements().performClick(choiceOption)
    }

    fun clickFilter() = {
        PoradiProduktu = (nextInt(5) + 1)
      when (PoradiProduktu){
          1 -> typFiltru = "#alzadoporucuje"
          2 -> typFiltru = "#nejprodavanejsi"
          3 -> typFiltru = "#podleslevy"
          4 -> typFiltru = "#cenaasc"
          5 -> typFiltru = "#cenadesc"
          6 -> typFiltru = "#nejlepehodnocene"
      }

        elements().performClick(filter)
    }

    fun clickAddToBasket() = {
        var allMatchingElements: List<WebElement> =  elements().findElements(toBasketUni)
        var numberOfElements = allMatchingElements.size
        cisloGeneratoru = (numberOfElements -1)
        PoradiProduktu = (nextInt(cisloGeneratoru)+1)
        elements().performClick(toBasket)
    }



}