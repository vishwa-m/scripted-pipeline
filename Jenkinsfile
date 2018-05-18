#!groovy

node{
    /*stage('Checkout'){
            //git credentialsID: 'vishwa-git', url: 'https://github.com/vishwa-m/MavenPrac_HelloWorld_Donot_Delete.git', branch: 'master'
    }*/
    
    stage('Maven'){
            sh "/opt/apache-maven-3.5.0/bin/mvn -version"
    }
    
    stage('sleep'){
        sleep time:5, unit:'SECONDS'
    }
    
    stage('echo'){
        echo 'Hi VNath'
        
    }
    
    stage('dir'){
        dir('Notes'){// code in the dir block gets executed in the context of this directory
            sh "pwd" // This prints the Notes pwd
        }
        sh "pwd" // This prints the job's directory
    }
    
    stage('fileExists'){
        if (fileExists('Notes/Readme.txt')) {
            echo 'Yes'
        } else {
            echo 'No'
        }
    }
    
    stage('OS Checking'){
        if (isUnix()) {
            echo "It is Linux or Mac OS X"
            } else {
                echo "It is Windows"
                }
    }
    
    stage('pwd'){
        pwd  //prints pwd
    }
        
    /*
    stage(''){
        
    }
    */
    
    stage('write-file'){
        // creates a file and writes content to it
        writeFile file: '../delete.txt', text: 'Hello..'
    }
    
    stage('readfile'){
        def text = ''
        //text = readFile 'Notes/Readme.txt'
        /******* OR ******/
        dir('Notes') {
            text=readFile 'Readme.txt'
        }
        echo text
    }
    
    stage('build-other-job'){
        build 'temp1'// temp1 is the name of other jenkins job in the same a/c
    }
    
    /*stage('input-prompt'){
        input 'User provide your input..' // For prompting an input from the user
        false
    }*/
    
    stage('parallel-jobs'){
    parallel 'task1':{
            build 'temp1'
        }, 'task2':{
            build 'temp2'
        }
    }
    
    stage('clean'){
        sh "pwd"
        deleteDir()// It deletes the working directory of the current job
    }

    /*stage('error'){
        error 'Error'// simillar to throw new Exception(), but this step will avoid printing a stack trace.
    }*/
    
    /*stage('retry'){
        try{
            build 'error-job'
        }
        catch(error){
            retry(2) {
                input 'retry the error-job?'
                build 'error-job'
            }
        }
    }*/
}
