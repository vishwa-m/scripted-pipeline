node ("master"){
    stage('Build'){
        println 'First Stage'
        checkout scm
    }
    
    if(env.BRANCH_NAME == "master"){
        echo "Branch name is master"
    }
    else{
        echo "Different branch"
    }
}