#!/usr/bin/groovy

def call(body) {
    // evaluate the body block, and collect configuration into the object    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()   
    
    /* Working Code with Pod
    kubernetes.pod('buildpod').withImage('maven')
        .inside {
            sh "echo 'Image: ${config.image}'"
            sh "echo 'Image: ${config.message}'"
        }        
    */
    /*  */
    stage 'build stage'
    kubernetes.pod('buildpod').withServiceAccount('default').withNewContainer().withName('t2').withImage('nginx').inside {
        sh 'some shell commands that are going to be run inside name2'
    }
}