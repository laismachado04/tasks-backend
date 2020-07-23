pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage ('Build Backend') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }
    }
}