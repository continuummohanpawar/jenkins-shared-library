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
    src.Log.log("Reading YAML file")
    def _config = readYaml text: config
    println(_config.name)
    Log.log("ERROR", "Reading YAML file - done")
}

