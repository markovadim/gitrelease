package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMajorRelease extends DefaultTask{

    def static final MIN_RELEASE_STEP = 0.1

    @TaskAction
    def createMajorRelease() {

        //input last tag for create major release
        def lastTag = CheckTag.resultTag

        //increment version
        def newMajorTag = Math.ceil(lastTag+MIN_RELEASE_STEP)

        //check new tag
        println("New tag for major release: " + newMajorTag)

        //add new tag
        GitUtil.addNewTag(newMajorTag, "added new major version")
    }
}
