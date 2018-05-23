#!groovy

node{
    def maven=tool 'M3.5'
    stage('Checkout'){
            //git credentialsID: 'vishwa-git', url: 'https://github.com/vishwa-m/scripted-pipeline.git', branch: 'prac-script1'
                    
            /**********  OR **********/    
        
            checkout scm
    }
    
    stage('Maven'){
        sh "/opt/apache-maven-3.5.0/bin/mvn -version"
        /**** OR ****/
        sh "${maven}/bin/mvn -version"
    }
    
    stage('sleep'){
        sleep time:5, unit:'SECONDS'
    }
    
    stage('echo'){
        echo 'Hi VNath'
    }
    
    stage('dir'){
        dir('Notes'){// code in the dir block gets executed in the context of this directory
            pwd // This prints the Notes pwd
        }
        pwd // This prints the job's directory
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
        timeout(time:5, unit:'SECONDS'){
            echo 'Hello'
            sleep time:4, unit: 'SECONDS' // If the sleep time is more than timeout time then build will fail
        }
    }
    
    stage('stash-stage'){
        stash includes: 'sample.txt', name: 'stash1' // 'stash1' will be generated under "JENKINS_HOME/jobs/<name of jenikins job>/builds/<build number>/stashes" folder
        sleep time:2, unit:'SECONDS'
        unstash 'stash1' // 'stash1' will be deleted
    }
    
    stage('archival-stage'){
        sh "mkdir -p output"
        dir('output'){
            // Write an useful file, which is needed to be archived.
            writeFile file: 'usefulfile.txt', text:'This file is going to be archived'
            
            // Write an useless file, which is not needed to be archived.
            writeFile file: 'uselessfile.md', text:'This file is not to be archived'
        }
        
        // Archive output/usefulfile.txt
        // archiveArtifacts willn't do compression. It copies the mentioned files/artifacts to jobs/<jenkins job>/builds/<build num>/archive folder.
        archiveArtifacts artifacts: 'output/*.txt', excludes: 'output/*.md'        
    }
    
    stage('maven-version-stage'){
        
        /*** To use the below function, install pipeline-utility-steps Jenkins plugin ***/
        def pom = readMavenPom file: 'pom.xml'
        //echo "${pom}"
        echo "${pom.version}"
        echo "${pom.artifactId}"
        echo "${pom.groupId}"
    }
    
    /*stage('clean'){
        sh "pwd"
        deleteDir()// It deletes the working directory of the current job
    }*/

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
