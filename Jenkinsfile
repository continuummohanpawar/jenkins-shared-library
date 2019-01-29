
@Library("shared_lib") _

//def slurper = new JsonSlurper()

def f = new facade()
f.readJsonConfig()

def config = """

name: "Visharad"
lname: "Dhavle"

"""
def data = readYaml(file: "${WORKSPACE}/pipelineConfig.yaml")
println(data.name)
def conf = f.readYamlConfig(config)
//f.execute()

//entry{
//    image = 'maven'
//    message = 'This is Visharad'
//}