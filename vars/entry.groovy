#!/usr/bin/groovy

def call(body) {
    // evaluate the body block, and collect configuration into the object    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()   
    //kubernetes.pod('buildpod')
    //.withNewContainer()
    //    .withName('maven-container')
    //    .withImage('maven')
    //.withPrivileged(true)            
    //.inside {  
    //node{   
        //sh "echo 'Image: ${config.image}'"
        //sh "echo 'Image: ${config.message}'"
        kubernetes.pod('buildpod')
        .withNewContainer()
            .withName('mavencontainer')
            .withImage('maven')
        .withPrivileged(true)            
        .inside { 
            sh "echo 'Image: ${config.image}'"
            sh "echo 'Image: ${config.message}'"
        }        
    //}
    //}
}