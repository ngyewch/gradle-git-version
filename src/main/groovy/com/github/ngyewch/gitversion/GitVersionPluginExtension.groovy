package com.github.ngyewch.gitversion

class GitVersionPluginExtension {
    String generatedSourceDir = 'generated/source/buildProperties'
    String tagPrefix = 'release-'
    String packageName
    String className = 'BuildProperties'
}
