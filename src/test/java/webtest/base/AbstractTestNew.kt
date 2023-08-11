package webtest.base

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestResult
import org.testng.annotations.*
import webtest.page.app.MainPage
import webtest.page.app.ProductSelectPage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

abstract class AbstractTestNew {


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
    fun acceptCookies(): MainPage {

        val mainPage = MainPage()
        mainPage.eatCookies()

        return MainPage()
    }

    fun getProductPrice(prodNum: Number): Int {
        val productSelectPage = ProductSelectPage()
        return productSelectPage.getPriceOfProduct(prodNum)
    }


    fun decideProduct(): Int {
        val productSelectPage = ProductSelectPage()
        productSelectPage.clickOnMenu()
        Thread.sleep(5000)
        closeAdd()
        productSelectPage.clickOnOption()
        Thread.sleep(2000)
        productSelectPage.clickOnStore()
        Thread.sleep(2000)
        productSelectPage.checkOnlyNew()
        Thread.sleep(2000)
        productSelectPage.clickFilter()
        Thread.sleep(5000)
        return productSelectPage.decideProduct()
    }

    fun isVirtual(): Boolean {
        val productSelectPage = ProductSelectPage()
        return productSelectPage.checkVirtual()
    }


        fun buyProduct(prodOrder:Number): ProductSelectPage{
            val productSelectPage = ProductSelectPage()
            Thread.sleep(5000)
            productSelectPage.clickAddtoBasket(prodOrder)

        return ProductSelectPage()
    }

    fun returnToMainPage(): ProductSelectPage{
        val productSelectPage = ProductSelectPage()
        productSelectPage.returnToMainPage()
        return ProductSelectPage()
    }

    private fun closeAdd(): ProductSelectPage {
        val productSelectPage = ProductSelectPage()
        productSelectPage.closeAdvert()
        return ProductSelectPage()
    }

    fun printResults() = println("Cílová cena byla $budget, Celková cena nákupu činí $currentPrice a zbylo $leftover KČ")



}