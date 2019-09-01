#!/usr/bin/groovy

def call(body) {
    // evaluate the body block, and collect configuration into the object    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    
    //def slaveTemplate = libraryResource 'org/continuum/shared-lib/goTemplate.yaml'
    def label = "go-${UUID.randomUUID().toString()}"
    podTemplate(label: label, yaml: """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: some-label-value
spec:
  containers:
  - name: maven
    image: maven:3.3.9-jdk-8-alpine
    command: ['cat']
    tty: true
"""
)   {
        body() 
        node(label){
            def stageName = "deploy-${config.env}"
            stage(stageName)
            {
                switch(config.env) 
                {
                    case 'int':
                        sh 'echo deploying it on int'
                    break
                    case 'qa':
                        sh 'echo deploying it on qa'
                    break
                    case 'stage':
                        sh 'echo deploying it on stage'
                    break
                    case 'prod':
                        sh 'echo deploying it on prod'
                    break
                    default:
                        sh 'echo unable to find ${config.env}'
                    break
                }
            }

            email{
                to = "abc@continuum.net"
                from = "xyz@continuum.net"
            }
        }       
    }
}