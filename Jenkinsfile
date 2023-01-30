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
                        bat "./gradlew clean build  --refresh-dependencies assembleDebug -g C:/gradle-cache"
                  }
              }
             
              stage('Test') {
                  steps {
                     bat "./gradlew test --stacktrace -g C:/gradle-cache"
                  }
              }

              stage('Lint') {
                   steps {
                     bat "./gradlew lint -g C:/gradle-cache"
                   }
              }

             

              stage('Publish') {
                  parallel {
                      stage('Firebase Distribution') {
                          steps {
                            bat "./gradlew appDistributionUploadRelease -g C:/gradle-cache"
                          }
                      }
                  }
              }
      }
}
