node ("master"){
    
    stage('Build'){
        System.out.println("First Stage");
    }
    
    stage('Checkout Code'){
        checkout scm
        echo "My branch is: ${env.BRANCH_NAME}"// This works only for Multibranch pipeline
    }
    
    /*
    if(env.BRANCH_NAME == "prac-script1"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
    */
    
    sayHello()
}

def sayHello () {
    echo "Hello!!"
}
