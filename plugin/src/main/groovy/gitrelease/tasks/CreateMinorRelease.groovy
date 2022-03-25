package gitrelease.tasks

import gitrelease.GitUtil
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateMinorRelease extends DefaultTask{

    static def final MINOR_RELEASE_STEP = 0.1
    static def final MINOR_PROBLEM_TAG = 0.2
    static def final MINOR_SYSTEMS_TAG = 0.3

    @TaskAction
    def createMinorRelease() {

        def newMinorTag

        //input last tag for create major release
        def lastTag = CheckTag.resultTag
        println(lastTag)

        //check problem tag (specification IEEE754)
        if (lastTag == MINOR_PROBLEM_TAG) {
            newMinorTag = MINOR_SYSTEMS_TAG
            //check new tag
            println("New tag for minor release: " + newMinorTag)

        } else {

            //increment version
            newMinorTag = lastTag + MINOR_RELEASE_STEP

            //check new tag
            println("New tag for minor release: " + newMinorTag)
        }


        //add new tag
        GitUtil.addNewTag(newMinorTag, "added new minor version")
    }
}
