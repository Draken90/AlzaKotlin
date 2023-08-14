package webtest.base.step

import kotlin.random.Random



class RandomizerTestStep: AbstractTestStep() {

   fun randomizeSelection(generatorNumber:Int):Int {
       val selection = (Random.nextInt(generatorNumber)+1)
       return selection
   }
}