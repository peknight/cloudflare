pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh 'sbt clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'sbt -J-Xmx2G test'
            }
        }
        stage('Publish Local') {
            steps {
                sh """
                    sbt publishLocal
                """
            }
        }
        stage('Publish') {
            steps {
                sh """
                    sbt publish
                """
            }
        }
    }
}