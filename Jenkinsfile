pipeline {
    agent any

    tools {
        jdk 'JDK-20.0.10'
        maven 'Maven-3.9.14'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/prabhasaini/TestPipelineDemo', branch: 'main'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {

                junit '*target/surefire-reports.xml'

        }
    }
}
