import groovy.json.JsonSlurper
import org.my-org.jenkins.Loggy

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
    l = new Logger()
    l.log("Reading YAML file")
    def _config = readYaml text: config
    println(_config.name)
    l.log("Reading YAML file - done", "ERROR")
    def lo = new Loggy()
    lo.log("Reading YAML file LOGGY - done", "ERROR")
}

