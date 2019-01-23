#!/usr/bin/groovy
package vars

def execute()
{
    node{
        stage('Build a Maven project') {
            git 'https://github.com/jenkinsci/kubernetes-plugin.git'                    
        }
    }
}



