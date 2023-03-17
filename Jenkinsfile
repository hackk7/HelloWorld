//被抽離的參數
def git_auth = "github"
def git_address = "https://github.com/hackk7/HelloWorld.git"
def harbor_auth = "2324f2cc-0e08-4cc0-9440-001b77dd1bf1"

pipeline {

	agent any

	stages {
		stage('Check Java Code From Gitlab') {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: "master"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]])

			}
		}


	stage('jib Image 製作與推送') {
                 steps {
    				script{
    					withCredentials([usernamePassword(credentialsId: "${harbor_auth}", passwordVariable: 'harborPasswd', usernameVariable: 'haborUser')]) {
    							sh '''
    							mvn compile jib:build \
    							-DsendCredentialsOverHttp=true \
    							-Djib.to.auth.username=${haborUser} \
    							-Djib.to.auth.password=${harborPasswd}
    							'''
    							}
    						}
    					}
    				}

	}
}