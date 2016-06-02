package com.github.ngyewch.gitversion

import org.ajoberstar.grgit.Grgit
import org.gradle.api.Plugin
import org.gradle.api.Project

class GitVersionPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create('gitVersion', GitVersionPluginExtension)

        def git = Grgit.open()

        def versionCode = git.tag.list().size()
        project.ext.gitVersionCode = versionCode

        def versionName
        def gitDescribe = git.describe()
        if (gitDescribe == null) {
            versionName = '0.0.1'
        } else if (gitDescribe.startsWith(project.gitVersion.tagPrefix)) {
            versionName = gitDescribe.substring(project.gitVersion.tagPrefix.length())
        } else {
            versionName = gitDescribe
        }
        project.ext.gitVersionName = versionName

        project.task('generateGitVersionSources', type: GenerateGitVersionSourcesTask)
    }
}

