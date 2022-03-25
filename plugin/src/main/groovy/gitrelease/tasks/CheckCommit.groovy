package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckCommit extends DefaultTask{

    @TaskAction

    def checkCommit() {

        def commitStatus = GitUtil.checkCommit()
        if (commitStatus.containsIgnoreCase("not a git repository")){
            throw new GradleScriptException("Not a git repository", null)
        }else{
            if (commitStatus.containsIgnoreCase("modified")) {
                throw new GradleScriptException("Add commit to repository", null)
            } else if (commitStatus.containsIgnoreCase("new file")) {
                throw new GradleScriptException("Create commit", null)
            }
        }
    }
}
