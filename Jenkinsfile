node {
  withMaven {
    checkout scm

    stage('Unit Tests') {
      sh 'mvn clean test'
    }

    stage('SonarQube analysis') {
      withSonarQubeEnv('My SonarQube Server') {
        sh 'mvn sonar:sonar'
      }
    }
  }
}

// No need to occupy a node
stage("Quality Gate"){
  sleep(time: 10 ,unit:"SECONDS")
  timeout(time: 10, unit: 'MINUTES') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}
