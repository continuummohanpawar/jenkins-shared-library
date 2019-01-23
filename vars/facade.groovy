#!/usr/bin/groovy
package vars

import src.buildProject

def execute()
{
    new buildProject().testCall()
}

