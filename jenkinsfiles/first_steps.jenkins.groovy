#!groovy
// Check ub1 properties
properties([disableConcurrentBuilds()])

pipeline {
    agent { 
        label 'Built-In Node'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("First step") {
            steps {
                sh 'ssh root@54.93.177.235 \'hostname\''
            }
        }
        stage("Second step") {
            steps {
                sh 'ssh root@54.93.177.235 \'uptime\''
            }
        }
    }
}