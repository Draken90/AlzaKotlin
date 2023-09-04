package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage


class ConfiguratorPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val procesor: ElementDef =
        ElementDef(ComponentType.BUTTON, "Procesor", By.xpath("//a[contains(@title,'Procesor')]"))
    var filterType = "#cenadesc"
    var filter = ElementDef(ComponentType.ANY, "Řadit podle", By.xpath("//a[@href = '${filterType}']"))
    private val buildYourPC: ElementDef = ElementDef(
        ComponentType.BUTTON,
        "Sestavit vlastní PC",
        By.xpath("//button[contains(text(),'Sestavit vlastní PC')]")
    )
    private val pcCompleteSet: ElementDef =
        ElementDef(ComponentType.BUTTON, "Zobrazit sestavu", By.xpath("//button[contains(text(),'Zobrazit sestavu')]"))
    private val pcSetMontage: ElementDef = ElementDef(
        ComponentType.INPUT,
        "Montáž PC komponent",
        By.xpath("//input[contains(@class,'PrivateSwitchBase-input pc-configurator-1m9pwf3')]")
    )
    private val monitor: ElementDef =
        ElementDef(ComponentType.BUTTON, "Monitor", By.xpath("//span[contains(text(),'Monitor')]"))
    private val keyboard: ElementDef =
        ElementDef(ComponentType.BUTTON, "Klávesnice", By.xpath("//span[contains(text(),'Klávesnice')]"))
    private val mouse: ElementDef = ElementDef(ComponentType.BUTTON, "Myš", By.xpath("//span[contains(text(),'Myš')]"))
    private val operationSystem: ElementDef =
        ElementDef(ComponentType.BUTTON, "Operační Systém", By.xpath("//span[contains(text(),'Operační systém')]"))
    private val pcSetToKart: ElementDef =
        ElementDef(ComponentType.BUTTON, "Přesunout do košíku", By.xpath("//button[@type='submit']"))
    private val addToConfigurator: ElementDef = ElementDef(
        ComponentType.BUTTON,
        "Přidat",
        By.xpath("(//span[text()='Přidat'])[1]")
    )


    fun selectFilter(filterNumber: Int) {

        var filterType = ""
        when (filterNumber) {
            1 -> filterType = "#alzadoporucuje"
            2 -> filterType = "#nejprodavanejsi"
            3 -> filterType = "#podleslevy"
            4 -> filterType = "#cenaasc"
            5 -> filterType = "#cenadesc"
            6 -> filterType = "#nejlepehodnocene"
        }

        filter = ElementDef(ComponentType.ANY, "Řadit podle", By.xpath("//a[@href = '${filterType}']"))

    }

    fun clickOnFilter() {
        elements().performClick(filter)
    }

    fun clickOnProcessor() {
        elements().performClick(procesor)
    }

    fun clickOnAddToConfigurator() = elements().performClick(addToConfigurator)

    fun clickOnBuildYourPC() = elements().performClick(buildYourPC)

    fun clickOnPCCompleteSet() {
        elements().performClick(pcCompleteSet)
    }

    fun clickOnPCMontage() {
        elements().performClick(pcSetMontage)
    }

    fun clickOnPCMonitor() {
        elements().performClick(monitor)
        clickOnFilter()
        Thread.sleep(5000)
        ResultsPage().clickOnStore()
        Thread.sleep(5000)
        elements().performClick(addToConfigurator)

    }

    fun clickOnKeyboard() {
        elements().performClick(keyboard)
        clickOnFilter()
        Thread.sleep(5000)
        ResultsPage().clickOnStore()
        Thread.sleep(5000)
        elements().performClick(addToConfigurator)

    }

    fun clickOnMouse() {
        elements().performClick(mouse)
        clickOnFilter()
        Thread.sleep(5000)
        ResultsPage().clickOnStore()
        Thread.sleep(5000)
        elements().performClick(addToConfigurator)

    }

    fun clickOnOperationSystem() {
        elements().performClick(operationSystem)
        clickOnFilter()
        Thread.sleep(5000)
        ResultsPage().clickOnStore()
        Thread.sleep(5000)
        elements().performClick(addToConfigurator)

    }


    fun clickOnPCSetToKart() {
        elements().performClick(pcSetToKart)
    }
}




