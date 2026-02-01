pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    environment {
        DOCKER_BUILDKIT = '0'
    }

    stages {

        stage('Checkout Code') {
            steps {
                // Clean workspace first
                deleteDir()
                
                // Checkout Git repo
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[url: 'https://github.com/Shantanu8807/BackendLearning.git']]
                ])
            }
        }

        stage('Build Order Service') {
            steps {
                dir('order-service') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Email Service') {
            steps {
                dir('email-service') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Compose Up') {
            steps {
                // Use full Windows path to docker-compose.ymlC:\Users\user\Desktop\backend-learning
                bat 'docker compose -f "C:\\Users\\user\\Desktop\\backend-learning\\docker-compose.yml" up --build -d'
            }
        }
    }
}
