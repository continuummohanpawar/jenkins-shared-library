def call(String projectType)
{       
    switch(projectType) {
        case "go":
            println("I am building GO project")           
        break
        default:
            println("Unable to judge project type")
        break
    }
}

def testCall()
{       
    node{
        stage('Build a Maven project from src') {
        git 'https://github.com/jenkinsci/kubernetes-plugin.git'                    
        }
    }
}