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
    node{
        kubernetes.pod('buildpod')
            //.withServiceAccount(<service account>)
            //.withSecret(<mount path>, <secret name>)
            //.withEnvar(<gloabal key1>, <value1>)
            .withNewContainer().withName('maven').withImage('maven')
                            .and()
            .withNewContainer().withName('maven').withImage('maven').inside {
                sh 'I am inside a container'
        }
    }
}