//被抽離的參數
def git_auth = "github"
def git_address = "https://github.com/hackk7/HelloWorld.git"

pipeline {

	agent any

	stages {
		stage('Check Java Code From Gitlab') {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: "master"]], extensions: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]])

			}
		}
	}
}