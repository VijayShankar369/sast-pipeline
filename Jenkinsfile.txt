pipeline {
    agent any
    stages {
        stage('Semgrep Scan') {
            agent { docker { image 'returntocorp/semgrep' } }
            steps {
                sh 'semgrep scan --config p/security-audit --config ./semgrep/custom-rules demo-app/'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'echo "SonarQube analysis placeholder"'
                }
            }
        }
    }
}