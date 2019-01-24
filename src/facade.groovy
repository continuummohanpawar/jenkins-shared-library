#!/usr/bin/groovy
//package vars

//import vars.buildProject

def execute()
{
    p = new buildProject();
    println("Hi I am inside a facade")
    p.testCall()
}

return this



