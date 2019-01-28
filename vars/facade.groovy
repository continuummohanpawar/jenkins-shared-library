import groovy.json.JsonSlurper

def execute()
{
    p = new buildProject();
    p.testCall()
}


def readConfig()
{
    def slurper = new JsonSlurper()
}

