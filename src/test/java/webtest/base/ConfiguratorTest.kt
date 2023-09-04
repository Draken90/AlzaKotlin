package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CatalogPageTestStep
import webtest.base.step.ConfiguratorTestStep
import webtest.base.step.LeftMenuPageTestStep

class ConfiguratorTest: AbstractTestNew() {



    @Test
    fun TestPcConfig(){
        acceptCookies()
        LeftMenuPageTestStep().clickOnComputersOption()
        closeAdd()
        CatalogPageTestStep().chooseComponents()
        ConfiguratorTestStep().setFilter(5)
        ConfiguratorTestStep().startConfigurator()
        ConfiguratorTestStep().fillConfiguratorFirstHalf()
        ConfiguratorTestStep().fillConfiguratorRest()


    }
}