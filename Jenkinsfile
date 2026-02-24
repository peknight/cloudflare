pipeline {
    agent any
    stages {
        stage('Init') {
            steps {
                sh 'curl "https://git.peknight.com/peknight/build/raw/branch/master/project/build.properties" > project/build.properties'
            }
        }
        stage('Clean') {
            steps {
                sh 'sbt clean'
            }
        }
        stage('Compile') {
            steps {
                sh 'sbt -J-Xmx2G compile'
            }
        }
        stage('Publish Local') {
            steps {
                sh 'sbt publishLocal'
            }
        }
        stage('Publish') {
            steps {
                sh 'sbt publish'
            }
        }
    }
}
