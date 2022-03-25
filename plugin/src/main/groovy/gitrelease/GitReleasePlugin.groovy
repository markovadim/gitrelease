package gitrelease

import gitrelease.tasks.CheckBranch
import gitrelease.tasks.CheckCommit
import gitrelease.tasks.CheckGit
import gitrelease.tasks.CheckTag
import gitrelease.tasks.CreateMajorRelease
import gitrelease.tasks.CreateMinorRelease

import org.gradle.api.Project
import org.gradle.api.Plugin

class GitReleasePlugin implements Plugin<Project> {

    void apply(Project project) {

        project.tasks.register("checkGit", CheckGit) {
            setGroup("git")
        }

        project.tasks.register("checkCommit", CheckCommit) {
            dependsOn("checkGit")
            setGroup("git")
        }

        project.tasks.register("checkTags", CheckTag) {
            dependsOn("checkCommit")
            setGroup("git")
        }

        project.tasks.register("checkBranch", CheckBranch) {
            dependsOn("checkTags")
            setGroup("git")
        }

        project.tasks.register("createMajorRelease", CreateMajorRelease) {
            setGroup("git")
        }

        project.tasks.register("createMinorRelease", CreateMinorRelease) {
            setGroup("git")
        }

        project.tasks.register("createRelease") {
            setGroup("git")
            if (CheckBranch.usersBranch.contains(CheckBranch.MASTER_BRANCH)) {
                dependsOn("createMajorRelease")
            } else {
                dependsOn("createMinorRelease")
            }
        }
    }
}
