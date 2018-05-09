node ("master"){
    
    stage('Build'){
        echo 'First Stage'
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
    
    def branchName = getCurrentBranch()
    echo 'My branch Name is' + branchName

    def getCurrentBranch () {
    return sh (
        script: 'git rev-parse --abbrev-ref HEAD',
        returnStdout: true
    ).trim()
}
}
