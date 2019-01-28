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
    def l = new Logger()
    l.log("Reading YAML file")
    def _config = readYaml text: config
    println(_config.name)
    l.log("ERROR", "Reading YAML file - done")
}

