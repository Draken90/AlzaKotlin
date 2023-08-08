package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val cookies: ElementDef = ElementDef(ComponentType.ANY, "Přijmout", By.xpath("//a[contains(text(),'Rozumím')]"))

fun eatCookies()= elements().performClick(cookies)

}