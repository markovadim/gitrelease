package gitrelease

import org.gradle.api.GradleScriptException

class GitUtil {

    static def checkGit() {
        return ("git --version").execute().text
    }

    static def checkCommit() {
        return ("git status").execute().text
    }

    static def checkTags() {
        return ("git tag").execute().text
    }

    static def showCurrentBranch() {
        return ("git branch --show-current").execute().text
    }

    static def showAllBranches() {
        return ("git branch").execute().text
    }

    static def switchBranch(def branch) {
        if (showAllBranches().contains(branch)) {
            return ("git checkout " + branch).execute().text
        } else {
            throw new GradleScriptException("Branch <" + branch + "> was not found", null)
        }
    }

    static def addNewTag(def inputTag, def message) {
        return ("git tag -a v" + inputTag + " -m \"" + message + "\"").execute().text
    }

    static def setUsersBranch() {
        println("Enter the branch for create new release: ")
        def branch = System.in.newReader().readLine()
        return branch
    }
}
