#!/bin/groovy

package src

def call(String projectType)
{       
    switch(projectType) {
        case "go":
            println("I am building GO project")           
        break
        default:
            println("Unable to judge project type")
        break
    }
}


def testCall()
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