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
              docker compose -f docker-compose.yml up --build -d
                 '''
            }
        }
    }
}
