pipeline {
  agent any
  environment {
          branch = 'develop'
          url = 'https://github.com/rafaelsouza-develop/android_challenge'
      }
      stages {

              stage('Checkout git') {
                  steps {
                      git branch: branch, credentialsId: '4a0786ea-791d-42b5-b6e7-80d2736c2590', url: url
                  }
              }
        
             stage('Build') {
                  steps {
                        sh "./gradlew clean build  --refresh-dependencies assembleDebug"
                  }
              }
             
              stage('Test') {
                  steps {
                     sh "./gradlew test --stacktrace"
                  }
              }

              stage('Lint') {
                   steps {
                     sh "./gradlew lint"
                   }
              }

             

              stage('Publish') {
                  parallel {
                      stage('Firebase Distribution') {
                          steps {
                            sh "./gradlew appDistributionUploadRelease"
                          }
                      }
                  }
              }
      }
}
