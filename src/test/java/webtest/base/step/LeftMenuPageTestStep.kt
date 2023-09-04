package webtest.base.step

import webtest.page.app.LeftMenuPage

class LeftMenuPageTestStep: AbstractTestStep() {

    private val leftMenuPage = LeftMenuPage()
    fun countItemsForRandomize(): Int {

        return leftMenuPage.countClickableObjects()
    }



    fun clickOnLeftMenuOption(genNum: Int){
        leftMenuPage.clickOnLeftMenuOption(genNum)
    }

    fun clickOnComputersOption() = leftMenuPage.clickOnOptionComputersLeftMenuButton()





}