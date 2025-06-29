pipeline {
    agent any
    environment {
        REPO_NAME = "${env.GIT_URL.tokenize('/.')[-2]}"
        FULLSCAN = "${env.BRANCH_NAME ==~ /^(main|master|develop|stage|release)$/ ? 'true' : 'false'}"
        PRSCAN = "${env.CHANGE_TARGET ==~ /^(main|master|develop|stage|release)$/ ? 'true' : 'false'}"
        GITHUB_TOKEN = credentials('github-pat')
        DETECT_PROJECT_NAME = "${env.REPO_NAME}"
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Black Duck') {
            echo 'REPO_NAME is ' $REPO_NAME
            when {
                anyOf {
                    environment name: 'FULLSCAN', value: 'true'
                    environment name: 'PRSCAN', value: 'true'
                }
            }
            steps {
                sh 'echo inside Black Duck Stage'
//                security_scan product: 'blackducksca',
//                    blackducksca_scan_failure_severities: 'BLOCKER',
//                    blackducksca_prComment_enabled: true,
//                    blackducksca_reports_sarif_create: true,
//                    mark_build_status: 'UNSTABLE',
//                    github_token: "$GITHUB_TOKEN",
//                    include_diagnostics: false
            }
        }
        stage('Test') {
            steps {
//                sh 'mvn test'
                sh 'echo Inside Test stage'
            }
//            post {
//                always {
//                    junit 'target/surefire-reports/*.xml'
//                }
//            }
        }
        stage('Deliver') {
            steps {
//                sh './jenkins/scripts/deliver.sh'
                sh 'echo Inside Deliver stage'
            }
        }
    }
//    post {
//        always {
//            archiveArtifacts allowEmptyArchive: true, artifacts: '.bridge/bridge.log'
//            //zip archive: true, dir: '.bridge', zipFile: 'bridge-logs.zip'
//            cleanWs()
//        }
//    }
}
