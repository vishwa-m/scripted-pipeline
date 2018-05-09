node ("master"){
    stage('Build'){
        echo 'First Stage'
        checkout scm
    }
    
    echo "Branch name: " "${env.BRANCH_NAME}";
    //echo "${env.GIT_BRANCH}";
    
    if(env.BRANCH_NAME == "prac-script1"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
}
