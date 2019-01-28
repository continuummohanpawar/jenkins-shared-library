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

def readYamlConfig()
{
    def config = readYaml file: 'pipelineConfig.yaml'    
}

