package webtest.base.step

import webtest.page.app.ResultsPage

class ResultsPageTestStep: AbstractTestStep() {

    val resultsPage = ResultsPage()
    fun countItemsForRandomize(): Int {

        return resultsPage.countAddableObjects()
    }



    fun clickOnAddToBasket(genNum: Int){
        resultsPage.clickAddtoBasket(genNum)
    }

    fun isVirtual(){
        resultsPage.checkVirtual()
    }

    fun clickOnOnStore(){
        resultsPage.clickOnStore()
    }

    fun clickOnOnlyNew(){
        resultsPage.checkOnlyNew()
    }

    fun selectFilter(){
        resultsPage.clickFilter()
    }

    fun returnToMainPage(){

        resultsPage.returnToMainPage()
    }


}