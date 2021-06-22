pipeline {
    agent any

    environment {
        ARTIFACTORY_ID = 'Jfrog-Artifactory-Server'
        ARTIFACTORY_URL = credentials('Jfrog-Artifactory-URL')
        ARTIFACTORY_CREDENTIALS = credentials('artifactory-credentials')
    }

    stages {
        stage ('Clone') {
            steps {
                git branch: 'main', url: "https://github.com/MatheusSantana95/finalTheme1.git"
            }
        }
        
        stage ('Test') {
            steps{
                sh './gradle wrapper'
                sh './gradlew test'
            }
        }
        
        stage ('Build') {
            steps{
                sh './gradlew build'
            }
        }

        stage ('Artifactory Deploy') {
            steps {
                rtServer (
                    id: env.ARTIFACTORY_ID,
                    url: env.ARTIFACTORY_URL,
                    username: env.ARTIFACTORY_CREDENTIALS_USR,
                    password: env.ARTIFACTORY_CREDENTIALS_PSW
                )
                rtUpload (
                    serverId: env.ARTIFACTORY_ID,
                    spec: '''{
                        "files": [
                            {
                                "pattern": "build/libs/*.jar",
                                "target": "libs-gradle-dev-local/finalThemeApp/"
                            } 
                        ]
                    }'''
                )
            }
        }
    }
}