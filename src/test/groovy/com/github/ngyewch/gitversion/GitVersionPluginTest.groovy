package com.github.ngyewch.gitversion

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class GitVersionPluginTest {
    @Test
    public void gitVersionPluginTest() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'com.github.ngyewch.git-version'
    }
}