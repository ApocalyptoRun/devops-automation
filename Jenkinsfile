pipeline{
    agent any
    
	environment {
		DOCKERHUB_CREDENTIALS=credentials('my_dockerhub_token')
	}
	
    tools{
        maven 'myMaven'
    }
    
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ApocalyptoRun/devops-automation.git']])
                bat 'mvn clean install'
            }
        }
        
        stage('Build Docker image'){
            steps{
                script{
                    bat 'docker build -t dieng940/devops-integration .'
                }
            }
        }
        
        stage('Push image to Docker Hub'){
            steps{
                script{
                    withDockerRegistry(url:'https://registry.hub.docker.com', credentialsId: 'my_dockerhub_token') {
                         bat 'echo %DOCKERHUB_PAT% | docker login -u dieng940 -p dckr_pat_EWBJldil3i7qLwoqTh33SG77pso'
                         bat 'docker push dieng940/devops-integration'
                    }
                }
            }
        }

        stage('Deploy App'){
            steps{
                script{
                    bat 'docker run -p 8082:8080 dieng940/devops-integration'
                }
            }
        }
    }
}