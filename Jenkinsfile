pipeline {
    agent any
    environment {
        //be sure to replace "willbla" with your own Docker Hub username
        DOCKER_IMAGE_NAME = "abbi1680/author-book-details"
    }
    stages {

    stage('SCM checkout') {
             steps {
                cleanWs()
                git credentialsId: 'GitHub', url: "https://github.com/seshredy/author-book-details.git"
             }
          }

        stage('Build Jar and run Unit Tests') {
            steps {
                echo 'Running build automation'
                sh './mvnw clean install package'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME)
                    app.inside {
                        sh 'echo Docker image is built'
                    }
                }
            }
        }
        stage('Push Docker Image to docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_login') {
                        app.push("${env.BUILD_NUMBER}")
                    }
                }
            }
        }


      stage('k8s deploy')
      {
      steps {

                      kubernetesDeploy(
                          kubeconfigId: 'kubeconfig',
                          configs: 'author-book-details-service.yaml',
                          enableConfigSubstitution: true
                      )
                      kubernetesDeploy(
                          kubeconfigId: 'kubeconfig',
                          configs: 'author-book-details-deployment.yaml',
                          enableConfigSubstitution: true
                      )
                  }
      }

    }
}