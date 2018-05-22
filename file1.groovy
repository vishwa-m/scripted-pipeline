#!groovy

def firstTest(){
      //echo "firstTest invoked"
  //println("firstTest invoked");
}

return [
    firstTest: this.&firstTest,
]
