#!/usr/bin/groovy
package vars

import src

class Facade
{
    def execute()
    {
        new BuildProject().testCall()
    }
}



