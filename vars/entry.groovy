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
    kubernetes.pod('buildpod')
        .withNewContainer().withName('mymaven1').withImage('maven').inside {
            sh 'I am inside a container'
        }.and()
        .withNewContainer().withName('mymaven2').withImage('maven').inside {
            sh 'I am inside a container'
        }
}