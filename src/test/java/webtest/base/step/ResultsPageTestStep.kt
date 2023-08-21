package webtest.base.step

import webtest.page.app.ResultsPage

class ResultsPageTestStep: AbstractTestStep() {

    val resultsPage = ResultsPage()
    fun countItemsForRandomize(): Int {

        return resultsPage.countAddableObjects()
    }

    fun selectAddToBasket(sel: Int){
        resultsPage.selectAddProductButton(sel)
    }



    fun clickOnAddToBasket(){
        resultsPage.clickOnAddToBasket()
    }

    fun isVirtual(): Boolean{
       return resultsPage.checkVirtual()
    }

    fun clickOnOnStore(){
        resultsPage.clickOnStore()
    }

    fun clickOnOnlyNew(){
        resultsPage.checkOnlyNew()
    }

    fun selectFilter(){
        resultsPage.clickRandomFilter()
    }

    fun returnToMainPage(){

        resultsPage.returnToMainPage()
    }

    fun addRandomNonVirtualProductToCart(addProd: Int){

        selectAddToBasket(addProd)

        if (!isVirtual()){
            
            clickOnAddToBasket()

        }
    }

    fun anyVirtualProducts(): Boolean {
        return resultsPage.areThereAnyVirtualProductsOnPage()
    }




}