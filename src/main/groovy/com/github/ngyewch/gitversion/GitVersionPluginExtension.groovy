package com.github.ngyewch.gitversion

class GitVersionPluginExtension {
    def String gitTagPrefix = 'release-'
    def String defaultVersionName = '0.1-SNAPSHOT'
    def String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
    def String customVersionDateFormat = 'yyyyMMdd'

    private GitVersion versionInfo = null

    GitVersion getGitVersionInfo() {
        if (versionInfo != null) {
            return versionInfo
        }
        def versionData = [ gitBranchName: null, gitVersionName: defaultVersionName, gitVersionCode: 0, gitCommitId: null, gitCommitIdAbbreviated: null, gitCommitDate: null, buildDate: new Date().format(dateFormat), gitCustomVersionName: defaultVersionName ]
        try {
            def git = org.ajoberstar.grgit.Grgit.open()
            try {
                versionData.gitBranchName = git.branch.current.name
            } catch (Exception e) {
                // ignore exception
            }
            try {
                if (git.describe().startsWith(gitTagPrefix)) {
                    versionData.gitVersionName = git.describe().substring(gitTagPrefix.length()) + (git.status().clean ? '' : '-dirty')
                } else {
                    versionData.gitVersionName = git.describe() + (git.status().clean ? '' : '-dirty')
                }
            } catch (Exception e) {
                // ignore exception
            }
            try {
                versionData.gitVersionCode = git.tag.list().size()
            } catch (Exception e) {
                // ignore exception
            }
            try {
                versionData.gitCommitId = git.head().id
            } catch (Exception e) {
                // ignore exception
            }
            try {
                versionData.gitCommitIdAbbreviated = git.head().abbreviatedId
            } catch (Exception e) {
                // ignore exception
            }
            try {
                versionData.gitCommitDate = git.head().date.format(dateFormat)
            } catch (Exception e) {
                // ignore exception
            }
            try {
                versionData.gitCustomVersionName = git.head().date.format(customVersionDateFormat) + '-' + git.head().abbreviatedId + (git.status().clean ? '' : '-dirty')
            } catch (Exception e) {
                // ignore exception
            }
        } catch (Exception e) {
            // ignore exception
        }
        versionInfo = new GitVersion(versionData.gitBranchName, versionData.gitVersionName, versionData.gitCustomVersionName, versionData.gitVersionCode, versionData.gitCommitId, versionData.gitCommitIdAbbreviated, versionData.gitCommitDate, versionData.buildDate)
    }
}
