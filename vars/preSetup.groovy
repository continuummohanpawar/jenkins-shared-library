def goSetup()
{
    options
    {
        def repoName = utils.getRepoName()
        sh 'echo ${repoName}'
        checkoutToSubdirectory 'src/github.com/ContinuumLLC/${repoName}'
    }
}