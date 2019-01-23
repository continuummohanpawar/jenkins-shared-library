#!/usr/bin/groovy
package vars

import src.buildProject

def execute()
{
    p = new buildProject();
    p.testCall()
}



