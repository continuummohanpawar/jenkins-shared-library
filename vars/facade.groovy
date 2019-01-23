#!/usr/bin/groovy
package vars

import src.buildProject

class facade
{
    def execute()
    {
        new buildProject().testCall()
    }
}



