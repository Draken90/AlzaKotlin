package webtest.base

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestResult
import org.testng.annotations.*
import webtest.page.app.LoginPage
import webtest.page.app.MainPage
import webtest.page.app.ProductSelectPage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

abstract class AbstractTestNew {

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


    fun acceptCookies(): MainPage {

        val mainPage = MainPage()
        mainPage.eatCookies()

        return MainPage()
    }

    fun selectMenu(): ProductSelectPage {
        val productSelectPage = ProductSelectPage()
        productSelectPage.clickOnMenu()
            return ProductSelectPage()

    }

    fun selectOption(): ProductSelectPage {

        val productSelectPage = ProductSelectPage()
        productSelectPage.clickOnOption()
        return ProductSelectPage()

    }

    fun selectFilter(): ProductSelectPage{

        val productSelectPage = ProductSelectPage()
        productSelectPage.clickFilter()
        return ProductSelectPage()

    }

    fun addToBasket(): ProductSelectPage{

        val productSelectPage = ProductSelectPage()
        productSelectPage.clickAddToBasket()
        return ProductSelectPage()

    }

}