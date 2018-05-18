#!groovy

node{
    def maven=tool 'M3.5'
    stage('Checkout'){
            //git credentialsID: 'vishwa-git', url: 'https://github.com/vishwa-m/scripted-pipeline.git', branch: 'prac-script1'
                    
            /**********  OR **********/    
        
            checkout scm
    }
    
    stage('Maven'){
        sh "/opt/apache-maven-3.5.0/mvn -version"
        sh '${maven}/bin'
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
        if (fileExists('sample.txt')) {
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
        //text = readFile 'sample.txt'
        /******* OR ******/
        dir('.') {// code in this block gets executed in the context of the current dir. Other ex: dir('MyFolder')
            text=readFile 'sample.txt'
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
            /* We can run different parallel tasks on different nodes also. */
            build 'temp1'
        
        }, 'task2':{            
            build 'temp2'
        }
    }
    
    stage('timeout-stage'){
        /*
        When we use timeout block then, the code in this block needs to be executed with in specified time 
        otherwise the build will fail
        */
        timeout(time:30, unit:'SECONDS'){
            echo 'Hello'
            sleep time:25, unit: 'SECONDS' // If the sleep time is more than 30 secs then the build will fail as the time out is 30secs.
        }
    }
    
    stage('withEnv-stage'){
        withEnv(["PATH+MAVEN=${tool 'M3.5'}/bin"]) {
            sh "mvn --version"
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
