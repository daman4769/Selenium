pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Test') {
            steps {
                echo 'TEST start'
            }
        }
        stage('UAT') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Hello World'
            }
        }
    }
    post
       {
           always
           {
               emailext body: 'Please check the resion of falior', subject: 'Pipeline status', to: 'daman4769@gmail.com'
           }
       }
}
