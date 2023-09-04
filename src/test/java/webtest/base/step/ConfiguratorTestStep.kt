package webtest.base.step

import webtest.page.app.ConfiguratorPage

class ConfiguratorTestStep: AbstractTestStep() {

    fun setFilter(filterNumber: Int){
        ConfiguratorPage().selectFilter(filterNumber)
    }

    fun startConfigurator(){
        ConfiguratorPage().clickOnBuildYourPC()
        ConfiguratorPage().clickOnProcessor()
    }




    fun fillConfiguratorFirstHalf(){

        repeat(8){
            ConfiguratorPage().clickOnAddToConfigurator()
            Thread.sleep(5000)
            ConfiguratorPage().clickOnFilter()
            Thread.sleep(5000)

        }
    }

    fun fillConfiguratorRest(){
        ConfiguratorPage().clickOnPCCompleteSet()
        ConfiguratorPage().clickOnPCMontage()
        ConfiguratorPage().clickOnPCMonitor()
        ConfiguratorPage().clickOnKeyboard()
        ConfiguratorPage().clickOnMouse()
        ConfiguratorPage().clickOnOperationSystem()
        ConfiguratorPage().clickOnPCSetToKart()

    }

}