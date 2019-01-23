#!/usr/bin/groovy
package vars

import src.buildProject

class Facade
{
    def execute()
    {
        new buildProject().testCall()
    }
}



