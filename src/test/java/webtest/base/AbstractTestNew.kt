package webtest.base

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestResult
import org.testng.annotations.*
import webtest.base.step.CatalogPageTestStep
import webtest.base.step.LeftMenuPageTestStep
import webtest.base.step.RandomizerTestStep
import webtest.base.step.ResultsPageTestStep
import webtest.base.step.ShoppingCartPageTestStep
import webtest.page.app.MainPage
import webtest.page.app.ResultsPage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

abstract class AbstractTestNew {

    val mainPage = MainPage()
    val leftMenuTestStep = LeftMenuPageTestStep()
    val randomizer = RandomizerTestStep()
    val catalogPageTestStep = CatalogPageTestStep()
    val resultsPageTestStep = ResultsPageTestStep()
    val shoppingCartPageTestStep = ShoppingCartPageTestStep()

    var productPrice = 0
    var leftover = 1000
    var budget = 1000
    var currentPrice = 1
    @BeforeMethod
    fun initializeDriver() = DriverSettings.initializeDriver()


    @AfterMethod
    fun closeDriver(result: ITestResult) {
        if (result.status == ITestResult.FAILURE) {
            val scrFile = (DriverSettings.getDriver() as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            try {
                FileUtils.copyFile(
                    scrFile, File(
                        "..\\ScreenShots\\" + result.name + "-"
                                + SimpleDateFormat("ddMMHHmm").format(Date()) + ".jpg"
                    )
                )
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        DriverSettings.getDriver().close()
        DriverSettings.getDriver().quit()
    }


    /**
     * Zmínit se jak to lze napsat jinak za pouziti core selenia Webdriver, rozdil mezi fce run/let/also ...
     */

    fun sInput(): MainPage {
        val searchInput = MainPage()
        searchInput.fillSearch(PropertiesData.getProductName())
        searchInput.clickOnSearchButton()

        return MainPage()
    }

    fun calculateLeftover(): Int {
        leftover = budget - currentPrice
        return leftover
    }

    fun generateBudget(): Int{

        budget = Random.nextInt(100000)
        println("Budget je $budget")
        return budget

    }

    fun calculateCurrentPrice(): Int{
        currentPrice += productPrice
        return currentPrice
    }

    fun goRandomlyThroughCatalog(){
        while ((catalogPageTestStep.countOptionsForRandomize())>-1){
            catalogPageTestStep.clickOnCatalogOption(randomizer.randomizeSelection(catalogPageTestStep.countOptionsForRandomize()))
        }

    }

    fun clickRandomLeftMenuItem(){
        leftMenuTestStep.clickOnLeftMenuOption(randomizer.randomizeSelection(leftMenuTestStep.countItemsForRandomize()))

    }

    fun acceptCookies(): MainPage {


        mainPage.eatCookies()

        return MainPage()
    }

    fun selectOnStore() = resultsPageTestStep.clickOnOnStore()

    fun selectOnlyNew() = resultsPageTestStep.clickOnOnlyNew()

    fun selectRandomFilter() = resultsPageTestStep.selectFilter()

    fun buyRandomNonVirtualProduct() {
        resultsPageTestStep.addRandomNonVirtualProductToCart(randomizer.randomizeSelection(resultsPageTestStep.countItemsForRandomize()))
    }

    fun buyRandomAnyProduct(){
        resultsPageTestStep.addAnyRandomProductToCart(randomizer.randomizeSelection(resultsPageTestStep.countItemsForRandomize()))
    }








    fun filterNewAndOnStore(){
        val virtualObjects = resultsPageTestStep.anyVirtualProducts()
        if (!virtualObjects){
            selectOnStore()
            selectOnlyNew()
        }
    }




    fun closeAdd(): ResultsPage {
            catalogPageTestStep.getRidOfAdvert()
        return ResultsPage()
    }

    fun returnToMainPage(): MainPage{
        resultsPageTestStep.returnToMainPage()
        return MainPage()
    }
    
    fun goToShoppingCart(){
        resultsPageTestStep.clickOnGoToCartButton()
    }


    fun verifySameProductsPresent(){
        val result = shoppingCartPageTestStep.verifySameProductsArePresent()
        println("Výsledek verifikace je $result")
    }

    fun printResults() = println("Cílová cena byla $budget, Celková cena nákupu činí $currentPrice a zbylo $leftover KČ")



}