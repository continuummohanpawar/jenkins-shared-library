package jenkins.vars

import jenkins.src

def execute()
{
    new buildProject().testCall()
}

