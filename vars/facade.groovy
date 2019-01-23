#!/usr/bin/groovy
package vars

class facade
{
    def execute()
    {
        pipeline {
            agent {
                kubernetes {
                label 'mypod'
                yaml """
apiVersion: v1
kind: Pod
spec:
containers:
- name: maven
    image: maven:3.3.9-jdk-8-alpine
    command: ['cat']
    tty: true
"""
                }
            }
            stages {
                stage('Run maven - 01') {
                    steps {
                        container('maven') {
                        sh 'mvn -version'
                        }
                    }
                }
                
                stage('Run maven - 02') {
                    steps {
                        container('maven') {
                        sh 'mvn -version'
                        }
                    }
                }
                
                stage('Run maven - 03') {
                    steps {
                        container('maven') {
                        sh 'mvn -version'
                        }
                    }
                }    
            }
        }
    }    
}



