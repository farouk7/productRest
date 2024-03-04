pipeline {
    agent any
    tools{

        maven 'maven_3_6_0'
    }

    stages{
        stage('build maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/farouk7/productRest']])
                bat 'mvn clean install'
            }


        }
        stage ('build docker image'){
            steps{
                script{
                  bat 'docker build -t FKAB/product-rest .'
                }
            }
        }
    }
}