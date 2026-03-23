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
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Test Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}