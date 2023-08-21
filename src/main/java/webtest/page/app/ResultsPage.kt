package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import kotlin.random.Random.Default.nextInt
import org.openqa.selenium.WebElement


class ResultsPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(alzaHome).isDisplayed

    private var electronicProduct: ElementDef = ElementDef(ComponentType.ANY, "Virtual product", By.xpath("//div[contains(@class,'inStockAvailability virtual')]"))
    private var onStore: ElementDef = ElementDef(ComponentType.ANY, "Na Skladě", By.xpath("//div[@data-testid='alza-and-partner-branches']"))
    private var addToCartUni: ElementDef = ElementDef(ComponentType.BUTTON, "Do Košíku", By.xpath("//div[contains(@class,'inStockAvailability')]//a[@class='btnk1'and contains(@href,'boxOrder')]"))
    var toCart = ElementDef(ComponentType.ANY,"Do Košíku",By.xpath("(//div[contains(@class,'inStockAvailability')])[1]//a[@class='btnk1'and contains(@href,'boxOrder')]"))
    private val alzaHome: ElementDef = ElementDef(ComponentType.ANY, "Alza Homepage", By.xpath("//a[contains(@title,'Přejít na hlavní stránku')]"))
    private val onlyNewProduct: ElementDef = ElementDef(ComponentType.ANY, "Jen nové", By.id("hlCommodityStatusNew"))
    var browsingItem = ElementDef(ComponentType.ANY,"",By.xpath("//div[contains(@class,'inStockAvailability')]"))
    var listOfProducts: MutableList<String> = mutableListOf()

    public var virtualToCart: ElementDef = ElementDef(ComponentType.ANY, "Digitální obsah do Košíku", By.xpath("//a[@data-testid='hlAddToCart']"))
    public var buttonGoToCart: ElementDef = ElementDef(ComponentType.BUTTON, "Přejít do košíku", By.xpath("//a[@href='https://www.alza.cz/Order1.htm']"))

    fun checkVirtual(): Boolean {

    val element = elements().findElement(toCart)
        val virtualCheck = element.getAttribute("class")
        var virtual = virtualCheck.contains("virtual")
        return virtual



    }

    fun getProductId(ProdNum: Int): MutableList<String>{
        val allMatchingElements: List<WebElement> = elements().findElements(browsingItem)
        val productID = allMatchingElements[ProdNum].getAttribute("data-code")
        listOfProducts.add(productID)
        return listOfProducts


    }

    fun clickOnGoToCartButton(){
        elements().performClick(buttonGoToCart)
    }

    fun areThereAnyVirtualProductsOnPage(): Boolean{

        val allMatchingElements: List<WebElement> = elements().findElements(electronicProduct)
        val numberOfElements = allMatchingElements.size
        return numberOfElements>0

    }

   
    fun clickOnStore() {
        
            elements().performClick(onStore)
    }

    fun checkOnlyNew() {
            elements().performClick(onlyNewProduct)
    }
    fun clickRandomFilter() {
        val filterNumber = (nextInt(5) + 1)
        var filterType = ""
        when (filterNumber){
            1 -> filterType = "#alzadoporucuje"
            2 -> filterType = "#nejprodavanejsi"
            3 -> filterType = "#podleslevy"
            4 -> filterType = "#cenaasc"
            5 -> filterType = "#cenadesc"
            6 -> filterType = "#nejlepehodnocene"
        }

        val filter = ElementDef(ComponentType.ANY, "Řadit podle", By.xpath("//a[@href = '${filterType}']"))
        elements().performClick(filter)

    }

    fun countAddableObjects():Int{
        val allMatchingElements: List<WebElement> = elements().findElements(addToCartUni)
        val numberOfElements = allMatchingElements.size
        val generatorNumber = (numberOfElements - 1)
        return generatorNumber
    }


    fun clickOnAddVirtualToCart() {

        elements().performClick(virtualToCart)
    }

    fun clickOnAddToCart() {

        elements().performClick(toCart)
    }
    
    fun selectAddProductButton(productOrder: Number){
        toCart = ElementDef(ComponentType.ANY,"Do Košíku",By.xpath("(//div[contains(@class,'inStockAvailability')])[${productOrder}]//a[@class='btnk1'and contains(@href,'boxOrder')]"))
    }

    fun returnToMainPage()= elements().performClick(alzaHome)




}