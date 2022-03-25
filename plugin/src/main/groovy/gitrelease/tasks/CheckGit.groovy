package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckGit extends DefaultTask{

    @TaskAction

    def checkGit() {

        def result = GitUtil.checkGit()

        //check git in system
        if (result.contains("git version")) {
            println(result)
        } else {
            throw new GradleScriptException("Git is not in system", null)
        }
    }
}
