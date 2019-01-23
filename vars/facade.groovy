#!/usr/bin/groovy
package vars

class facade
{
    def execute()
    {
        new buildProject().testCall()
    }
}



