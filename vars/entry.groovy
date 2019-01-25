#!/usr/bin/groovy

def call(Map config) {
    // evaluate the body block, and collect configuration into the object
    println(body)
    //def config = [:]
    //body.resolveStrategy = Closure.DELEGATE_FIRST
    //body.delegate = config
    //body()

    kubernetes.pod('buildpod')
    .withNewContainer()
        .withName('maven-container')
        .withImage('maven')
    .withPrivileged(true)            
    .inside {     
        sh "echo 'Image: ${config.image}'"
        sh "echo 'Image: ${config.message}'"
    }
}

return this