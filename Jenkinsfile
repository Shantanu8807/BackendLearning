pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Build Order Service') {
            steps {
                dir('order-service') {
                    sh 'mvn clean package -DskipTests'
                    sh 'docker build -t order-service .'
                }
            }
        }

        stage('Build Email Service') {
            steps {
                dir('email-service') {
                    sh 'mvn clean package -DskipTests'
                    sh 'docker build -t email-service .'
                }
            }
        }

        stage('Start All Containers') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up -d'
            }
        }
    }
}
