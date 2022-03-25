package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.GradleScriptException
import org.gradle.api.tasks.TaskAction

class CheckTag extends DefaultTask {
    def static resultTag;

    @TaskAction

    def checkTags() {
        def resultOfCheck = GitUtil.checkTags()

        //if there is don't have tags

        if (resultOfCheck.isEmpty()) {
            throw new GradleScriptException("There is don't have tags", null)
        } else {

            //array of tags
            def tagsArray = resultOfCheck.split("\n")

            //get last tag
            def lastTag = Double.parseDouble(tagsArray.last().replaceAll("[^\\d.]", ""))

            //check last tag
            println("The last tag (double type): " + lastTag)
            resultTag = lastTag
        }
    }
}
