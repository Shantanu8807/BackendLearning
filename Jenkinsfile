pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Shantanu8807/BackendLearning.git'
            }
        }

        stage('Build Order Service') {
            steps {
                dir('order-service') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Email Service') {
            steps {
                dir('email-service') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Compose Up') {
            steps {
              sh '''
              docker compose up -d --build
                 '''
            }
        }
    }
}
