stage 'build'
node {
    def mvnHome
    def appPort
    stage('Preparation') { 
      git 'https://github.com/qintianjie/sample-jenkins.git'         
      mvnHome = tool 'M3'
      appPort = 8088
    }
    stage('Build') {
      if (isUnix()) {
          sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package -Dmaven.test.skip"
          // sh "mvn -Dmaven.test.failure.ignore clean package -Dmaven.test.skip"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
      // 备份当前的工作区的内容
      stash excludes: 'target/', includes: '**', name: 'source'
    }
}
stage 'test'
parallel 'integration': { 
     node {
          unstash 'source'
            //   withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
            //       sh "mvn clean verify"
            //   }
            sh "echo 'test - integration'"
            sh "sleep 2"
     }
}, 'quality': {
     node {
          unstash 'source'
        //   withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
        //       sh "mvn sonar:sonar"
        //   }
            sh "echo 'test - quality'"
            sh "sleep 2"
     }
}
stage 'approve'
//    input message: 'Do you want to deploy?'
    sh "echo 'approve'"
// timeout(time: 7, unit: 'DAYS') {
//      input message: 'Do you want to deploy?', submitter: 'ops'
// }
stage name:'deploy', concurrency: 1
node {
     unstash 'source'
    //  withEnv(["PATH+MAVEN=${tool 'm3'}/bin"]) {
    //       sh "mvn cargo:deploy"
    //  }
    sh "echo 'deploy'"
    sh "sleep 2"
}
