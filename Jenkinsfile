pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                credentialsId: 'github-pat',
                url: 'https://github.com/Azururu/ShoppingCart.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean verify'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'

            recordCoverage(
                tools: [[parser: 'JACOCO', pattern: '**/target/site/jacoco/jacoco.xml']]
            )
        }
    }
}