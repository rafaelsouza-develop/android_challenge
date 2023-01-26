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

              stage('Lint') {
                   steps {
                   if (isUnix()) --> sh "./gradlew lint"
                      else --> bat "./gradlew lint"
                          }
                   }

              stage('Test') {
                  steps {
                  if (isUnix()) --> sh "./gradlew test --stacktrace"
                       else --> bat "./gradlew test --stacktrace"

                  }
              }

              stage('Build') {
                  steps {
                  if (isUnix()) --> sh "./gradlew clean assembleRelease"
                                         else --> bat "./gradlew clean assembleRelease"

                  }
              }

              stage('Publish') {
                  parallel {
                      stage('Firebase Distribution') {
                          steps {
                          if (isUnix()) --> sh "./gradlew appDistributionUploadRelease"
                              else --> bat "./gradlew appDistributionUploadRelease"

                          }
                      }
                  }
              }
          }
}