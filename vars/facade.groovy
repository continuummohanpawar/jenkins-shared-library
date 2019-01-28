def execute()
{
    p = new buildProject();
    p.testCall()
}

@NonCPS
def readConfig{
    def slurper = new JsonSlurper()
}

