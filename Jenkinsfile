node ("master"){
    stage('Build'){
        echo 'First Stage'
        checkout scm
    }
    
    if(env.BRANCH_NAME == "prac-script1"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
}
