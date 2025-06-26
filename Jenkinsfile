pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Test') {
            steps {
//                sh 'mvn test'
                sh 'echo Inside Test stage'
            }
//            post {
//                always {
//                    junit 'target/surefire-reports/*.xml'
//                }
//            }
        }
        stage('Deliver') {
            steps {
//                sh './jenkins/scripts/deliver.sh'
                sh 'echo Inside Deliver stage'
            }
        }
    }
}