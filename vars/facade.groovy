#!/usr/bin/groovy

import src.buildProject

package vars

def execute()
{
    new buildProject().testCall()
}

