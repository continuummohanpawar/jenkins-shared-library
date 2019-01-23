#!/usr/bin/groovy
package vars

class facade
{
    def execute()
    {
        node(master) {
            stage('Build a Maven project') {
                git 'https://github.com/jenkinsci/kubernetes-plugin.git'                    
            }
        }
    }
}



