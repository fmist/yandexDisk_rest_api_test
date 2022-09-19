pipeline {
agent any

stages {
    stage('test') {
    steps {
         sh './gradlew cucumber'
        }
    }
}
post {
    always {
        allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
    }
}
}