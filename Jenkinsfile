pipeline {
  agent any
  stages {
    stage('error') {
      steps {
        withGradle() {
          build 'clean'
        }

      }
    }

  }
}