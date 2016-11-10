package com.github.ngyewch.gitversion

class GitVersion {
    final String gitBranchName
    final String gitVersionName
    final String gitCustomVersionName
    final int gitVersionCode
    final String gitCommitId
    final String gitCommitIdAbbreviated
    final String gitCommitDate
    final String buildDate

    GitVersion(String gitBranchName, String gitVersionName, String gitCustomVersionName, int gitVersionCode, String gitCommitId, String gitCommitIdAbbreviated, String gitCommitDate, String buildDate) {
        this.gitBranchName = gitBranchName
        this.gitVersionName = gitVersionName
        this.gitCustomVersionName = gitCustomVersionName
        this.gitVersionCode = gitVersionCode
        this.gitCommitId = gitCommitId
        this.gitCommitIdAbbreviated = gitCommitIdAbbreviated
        this.gitCommitDate = gitCommitDate
        this.buildDate = buildDate
    }
}
