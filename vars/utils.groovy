/*
This file should contain all the functionality 
which should be common or intend to be consumed 
within shared lib inrrespective of project and technology
*/

def getBranch() {
    def branch = env.BRANCH_NAME
    if (!branch) {
        try {
            branch = sh(script: 'git symbolic-ref --short HEAD', returnStdout: true).toString().trim()
        } catch (err) {
            echo('Unable to get git branch and in a detached HEAD. You may need to select Pipeline additional behaviour and \'Check out to specific local branch\'')
            return null
        }
    }
    echo "Using branch ${branch}"
    return branch
}

def isCD() {
    def branch = getBranch()
    if (!branch || branch.equals('master')) {
        return true
    }
    // if we can't get the branch assume we're not in a CI pipeline as that would be a PR branch
    return false
}

def getRepoName() {
    def jobName = env.JOB_NAME
    // job name from the org plugin
    if (jobName.count('/') > 1) {
        return jobName.substring(jobName.indexOf('/') + 1, jobName.lastIndexOf('/'))
    }
    // job name from the branch plugin
    if (jobName.count('/') > 0) {
        return jobName.substring(0, jobName.lastIndexOf('/'))
    }
    // normal job name
    return jobName
}

def readYaml(String filePath){
    def config = readYaml(file: "${WORKSPACE}/${filePath}}")    
}

void log(String message, String type = "INFO") 
{        
    switch(type)
    {
        case 'INFO':
            println("INFO: ${message}")
        break
        case 'ERROR':
            println("ERROR: ${message}")
        break
        case 'WARN':
            println("WARN: ${message}")
        break
        default:
            println("UNKNOWN LOG: ${message}")
        break
    }    
}