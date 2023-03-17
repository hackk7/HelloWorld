pipeline {

	agent any

	stages {
		stage('Check JavaCode From Gitlab') {
			steps {
				echo '拉取原始碼'
			}
		}

		stage('編譯成 Jar 檔') {
			steps {
					echo '測試編譯與打包'
			}
		}

        stage('打包成 Image') {
			steps {
					echo '打包 Image'
			}
		}
	}
}