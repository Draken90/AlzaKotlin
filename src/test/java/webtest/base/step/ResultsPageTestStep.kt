package webtest.base.step

import webtest.page.app.ResultsPage

class ResultsPageTestStep: AbstractTestStep() {

    val resultsPage = ResultsPage()
    fun countItemsForRandomize(): Int {

        return resultsPage.countAddableObjects()
    }

    fun selectAddToCart(sel: Int){
        resultsPage.selectAddProductButton(sel)
    }


    fun clickOnAddToCart(){
        resultsPage.clickOnAddToCart()
    }

    fun clickOnAddVirtualToCart(){
        resultsPage.clickOnAddVirtualToCart()
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

    fun addFirstRandomAnyProductToCart(addProd: Int){

        selectAddToCart(addProd)

        if (!isVirtual()){
            clickOnAddToCart()
        }else{
            clickOnAddToCart()
            clickOnAddVirtualToCart()
        }
    }

    fun addAnyRandomProductToCart(addProd: Int){

        selectAddToCart(addProd)
        clickOnAddToCart()

    }

    fun anyVirtualProducts(): Boolean {
        val virtual = resultsPage.areThereAnyVirtualProductsOnPage()
        return virtual
    }

    fun clickOnGoToCartButton(){
        resultsPage.clickOnGoToCartButton()
    }

}