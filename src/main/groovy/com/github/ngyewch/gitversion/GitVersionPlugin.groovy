package com.github.ngyewch.gitversion

import org.ajoberstar.grgit.Grgit
import org.gradle.api.Plugin
import org.gradle.api.Project

class GitVersionPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create('gitVersion', GitVersionPluginExtension)
    }
}

