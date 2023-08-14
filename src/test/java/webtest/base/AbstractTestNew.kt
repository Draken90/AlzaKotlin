package webtest.base

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestResult
import org.testng.annotations.*
import webtest.base.step.CatalogPageTestStep
import webtest.base.step.LeftMenuPageTestStep
import webtest.base.step.RandomizerTestStep
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
    val ResultsPage = ResultsPage()

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

    fun goThroughCatalog(){
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

    fun getProductPrice(prodNum: Number): Int {
        val ResultsPage = ResultsPage()
        return ResultsPage.getPriceOfProduct(prodNum)
    }


    fun decideProduct(): Int {

        Thread.sleep(5000)
        closeAdd()
        ResultsPage.clickOnOption()
        Thread.sleep(2000)
        ResultsPage.clickOnStore()
        Thread.sleep(2000)
        ResultsPage.checkOnlyNew()
        Thread.sleep(2000)
        ResultsPage.clickFilter()
        Thread.sleep(5000)
        return ResultsPage.decideProduct()
    }

    fun isVirtual(): Boolean {
        val ResultsPage = ResultsPage()
        return ResultsPage.checkVirtual()
    }


        fun buyProduct(prodOrder:Number): ResultsPage{
            val ResultsPage = ResultsPage()
            Thread.sleep(5000)
            ResultsPage.clickAddtoBasket(prodOrder)

        return ResultsPage()
    }

    fun returnToMainPage(): ResultsPage{
        val ResultsPage = ResultsPage()
        ResultsPage.returnToMainPage()
        return ResultsPage()
    }

    fun closeAdd(): ResultsPage {
            catalogPageTestStep.getRidOfAdvert()
        return ResultsPage()
    }

    fun printResults() = println("Cílová cena byla $budget, Celková cena nákupu činí $currentPrice a zbylo $leftover KČ")



}