package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageStep


class BaseTest : AbstractTestNew() {
    val test2Step = MainPageStep()

    /*@Test
    fun exampleTest() {
        currentPrice = 0
        budget = generateBudget()
        leftover = calculateLeftover()
        acceptCookies()
/*        while(productPrice < leftover){
            val productNumber = decideProduct()
            val virtualProduct = isVirtual()
            if (!virtualProduct) {
                productPrice = getProductPrice(productNumber)
                leftover = calculateLeftover()
                if (productPrice < leftover) {
                    buyProduct(productNumber)
                    currentPrice = calculateCurrentPrice()
                }
            }

            returnToMainPage()

        }*/
        printResults()

    }*/

    @Test
    fun test2(){


        acceptCookies()
        clickRandomLeftMenuItem()
        closeAdd()
        goRandomlyThroughCatalog()
        selectRandomFilter()
        buyRandomNonVirtualProduct()
        returnToMainPage()
        clickRandomLeftMenuItem()
        closeAdd()
        goRandomlyThroughCatalog()
        selectRandomFilter()
        buyRandomNonVirtualProduct()
        returnToMainPage()




    }
//Test2 manuál
    @Test
    fun test3(){
        test2Step.findProduct()
        sInput()
    }
}