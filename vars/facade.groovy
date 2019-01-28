import groovy.json.JsonSlurper

def execute()
{
    p = new buildProject();
    p.testCall()
}


def readJsonConfig()
{
    def slurper = new JsonSlurper()
}

def readYamlConfig(String config)
{
    def config = readYaml text: config
}

