node ("master"){
    stage('Build'){
        echo 'First Stage'
        checkout scm
    }
    
    echo "Branch name: " BRANCH_NAME
    
    if(env.BRANCH_NAME == "prac-script1"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
}
