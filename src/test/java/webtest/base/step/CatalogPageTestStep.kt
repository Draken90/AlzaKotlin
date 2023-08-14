package webtest.base.step
import webtest.page.app.CatalogPage

class CatalogPageTestStep: AbstractTestStep() {

    val catalogPage = CatalogPage()

    fun countOptionsForRandomize():Int{
        return catalogPage.countClickableObjects()
    }

    fun clickOnCatalogOption(genNum: Int){
        catalogPage.clickOnCatalogOption(genNum)
    }

    fun getRidOfAdvert(){
        if (catalogPage.seekForAdvert()){
            catalogPage.closeAdvert()
        }
    }

}