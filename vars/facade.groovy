import groovy.json.JsonSlurper

def execute()
{
    p = new buildProject()
    p.testCall()
}

def readJsonConfig()
{
    def slurper = new JsonSlurper()
}

def readYamlConfig(String config)
{   
    l = new logger()
    l.log("Reading YAML file")
    def _config = readYaml text: config
    println(_config.name)
    l.log("Reading YAML file - done", "ERROR")
    def lo = new org.my.jenkins.Loggy()
    lo.log("Reading YAML file LOGGY - done", "ERROR")
}

