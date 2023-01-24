pipeline {
  agent {
          docker {
              image 'androidsdk/android-30'
          }
      }
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

              stage('Lint') {
                  steps {
                      sh "./gradlew lint"
                  }
              }

              stage('Test') {
                  steps {
                      sh "./gradlew test --stacktrace"
                  }
              }



              stage('Build') {
                  steps {
                      sh "./gradlew clean assembleRelease"
                  }
              }

              stage('Publish') {
                  parallel {
                      stage('Firebase Distribution') {
                          steps {
                              sh "./gradlew appDistributionUploadRelease"
                          }
                      }

                      stage('Google Play...') {
                          steps {
                              sh "echo 'Test...'"
                          }
                      }
                  }
              }
          }
}