#!/usr/bin/groovy

def call(body) {
    // evaluate the body block, and collect configuration into the object    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    //body()
    
    def label = "mongo-${UUID.randomUUID().toString()}"
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
  - name: mongo
    image: mongo
"""
){ 
    body() 
    node(label){
        stage('Test Phase'){
            container('maven') {
                sh 'echo Hello World'
            }
        }        
    }
    }
}