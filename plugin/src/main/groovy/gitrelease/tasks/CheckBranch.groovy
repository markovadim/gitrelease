package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CheckBranch extends DefaultTask {
    static final def MASTER_BRANCH = "master"
    static def currentBranch
    static def usersBranch

    @TaskAction
    def checkBranch() {

        //get current branch
        currentBranch = GitUtil.showCurrentBranch()

        //check current branch
        println("Current branch: " + currentBranch)

        usersBranch = GitUtil.setUsersBranch()
        GitUtil.switchBranch(usersBranch)
    }
}
