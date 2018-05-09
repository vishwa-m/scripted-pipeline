node ("master"){
    stage('Build'){
        echo 'First Stage'
        checkout scm
    }
    GIT_BRANCH = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
    
    
    echo "Branch name: " "${GIT_BRANCH}";
    //echo "${env.GIT_BRANCH}";
    
    if(env.BRANCH_NAME == "prac-script1"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
}
