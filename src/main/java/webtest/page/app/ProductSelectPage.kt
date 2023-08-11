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
    private var productNumber = (nextInt(18) + 1)
    private var generatorNumber = 1
    private var productPrice = 1
    private var electronicProduct: ElementDef = ElementDef(ComponentType.ANY, "Virtual product", By.xpath("//div[contains(@class,'inStockAvailability virtual')]"))
    private var leftMenuOption: ElementDef = ElementDef(ComponentType.BUTTON, "MenuOption", By.xpath("//li[contains(@class,'leftMenuItem')][${productNumber}]/a[contains(@class,'catLink')]"))
    private var choiceOptionUni: ElementDef = ElementDef(ComponentType.BUTTON, "Výběr z nabídky", By.xpath("//a[@class = 'catalogLocalTitlePage-alz-4']"))
    private var onStore: ElementDef = ElementDef(ComponentType.ANY, "Na Skladě", By.xpath("//div[@data-testid='alza-and-partner-branches']"))
    private var toBasketUni: ElementDef = ElementDef(ComponentType.BUTTON, "Do Košíku", By.xpath("//div[contains(@class,'inStockAvailability')]//a[@class='btnk1'and contains(@href,'boxOrder')]"))
    private val alzaHome: ElementDef = ElementDef(ComponentType.ANY, "Alza Homepage", By.xpath("//a[contains(@title,'Přejít na hlavní stránku')]"))
    private val closeAdd: ElementDef = ElementDef(ComponentType.ANY, "Zavřít reklamu", By.xpath("(//div[@class = 'close'])[2]"))
    private val popup: ElementDef = ElementDef(ComponentType.ANY, "Zavřít reklamu", By.xpath("//div[@class = 'popup']"))
    private val onlyNewProduct: ElementDef = ElementDef(ComponentType.ANY, "Jen nové", By.id("hlCommodityStatusNew"))
    fun clickOnMenu() {
        productNumber = (nextInt(19) + 1)
        elements().performClick(leftMenuOption)

    }

    fun checkVirtual(): Boolean {

        val allMatchingElements: List<WebElement> = elements().findElements(electronicProduct)
        val numberOfElements = allMatchingElements.size
        return numberOfElements!=0



    }

    fun clickOnOption() {
        var allMatchingElements: List<WebElement> = elements().findElements(choiceOptionUni)
        var numberOfElements = allMatchingElements.size
        while ( numberOfElements != 0){

            elements().waitUntilPageIsLoaded()

            generatorNumber = (numberOfElements - 1)
            productNumber = (nextInt(generatorNumber)+1)
            val choiceOption = ElementDef(ComponentType.BUTTON, "Výběr z nabídky", By.xpath("(//a[@class = 'catalogLocalTitlePage-alz-4'])[${productNumber}]"))
            elements().performClick(choiceOption)

            elements().waitUntilPageIsLoaded()

            allMatchingElements = elements().findElements(choiceOptionUni)
            numberOfElements = allMatchingElements.size
        }
    }
    fun clickOnStore() {

        val allMatchingElements: List<WebElement> = elements().findElements(onStore)
        val numberOfElements = allMatchingElements.size
        if (numberOfElements==1) {
            elements().performClick(onStore)
        }
    }

    fun checkOnlyNew() {
        val allMatchingElements: List<WebElement> = elements().findElements(onlyNewProduct)
        val numberOfElements = allMatchingElements.size
        if (numberOfElements==1) {
            elements().performClick(onlyNewProduct)
        }
    }
    fun clickFilter() {
        productNumber = (nextInt(5) + 1)
        var filterType = ""
        when (productNumber){
            1 -> filterType = "#alzadoporucuje"
            2 -> filterType = "#nejprodavanejsi"
            3 -> filterType = "#podleslevy"
            4 -> filterType = "#cenaasc"
            5 -> filterType = "#cenadesc"
            6 -> filterType = "#nejlepehodnocene"
        }

        val filter = ElementDef(ComponentType.ANY, "Řadit podle", By.xpath("//a[@href = '${filterType}']"))
        val allMatchingElements: List<WebElement> = elements().findElements(filter)
        val numberOfElements = allMatchingElements.size
        if (numberOfElements==1) {
            elements().performClick(filter)
        }

    }

    fun decideProduct(): Int {
        val allMatchingElements: List<WebElement> = elements().findElements(toBasketUni)
        val numberOfElements = allMatchingElements.size
        generatorNumber = (numberOfElements - 1)
        println(generatorNumber)
        productNumber = (nextInt(generatorNumber) + 1)
        return productNumber

    }


    fun getPriceOfProduct(productOrder: Number): Int {

        val element = driver.findElement(By.xpath("(//div[contains(@class,\"inStockAvailability\")])[${productOrder}]//span[@class = 'price-box__price']"))
        productPrice = element.text.replace(Regex("[^0-9]"), "").toInt()
        return productPrice

    }


    fun clickAddtoBasket(productOrder: Number) {

        val toBasket = ElementDef(ComponentType.ANY,"Do Košíku",By.xpath("(//div[contains(@class,'inStockAvailability')])[${productOrder}]//a[@class='btnk1'and contains(@href,'boxOrder')]"))
        elements().performClick(toBasket)
    }

    fun returnToMainPage()= elements().performClick(alzaHome)
    fun closeAdvert() {
        val allMatchingElements: List<WebElement> = elements().findElements(popup)
        val numberOfElements = allMatchingElements.size
        if (numberOfElements==1) {
            elements().performClick(closeAdd)
        }
    }



}