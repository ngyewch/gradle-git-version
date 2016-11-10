# gradle-git-version

Simple git version info plugin for Gradle.

## Setup

    plugins {
      id "com.github.ngyewch.git-version" version "0.1"
    }

## Configuration

    gitVersion {
        gitTagPrefix 'release-'                  // Tag prefix to extract version from.
        defaultVersionName = '0.1-SNAPSHOT'      // Default version name to use if no tags are found.
        dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"    // Date format.
        customVersionDateFormat = 'yyyyMMdd'     // Date format for custom version name.
    }

## Properties (gitVersion.gitVersionInfo)

| Name                   | Example                                  | Description                |
| ---------------------- | ---------------------------------------- | -------------------------- |
| gitBranchName          | master                                   | git branch name.           |
| gitVersionName         | 1.2.7                                    | Version name.              |
| gitCustomVersionName   | 20161110-gce36502                        | Custom version name.       |
| gitVersionCode         | 12                                       | git tag count.             |
| gitCommitId            | gce36502369ed50c578b3bca0060b2686e5541f7 | git commit ID.             |
| gitCommitIdAbbreviated | gce36502                                 | git abbreviated commit ID. |
| gitCommitDate          | 2016-11-09T19:14:48+0000                 | git commit date.           |
| buildDate              | 2016-11-10T11:12:41+0000                 | Build date.                |

### gitVersionName format

| Scenario                                                 | Example                | Format                                                                   |
| -------------------------------------------------------- | ---------------------- | ------------------------------------------------------------------------ |
| git head has a release tag, working copy is clean.       | 1.2.7                  | (version)                                                                |
| git head is not on a release tag, working copy is clean. | 1.2.7-3-gce36502       | (version)-(commits since last release tag)-(abbreviated commit ID)       |
| git head is not on a release tag, working copy is dirty. | 1.2.7-3-gce36502-dirty | (version)-(commits since last release tag)-(abbreviated commit ID)-dirty |

### gitCustomVersionName format

| Scenario               | Example                 | Format                                      |
| ---------------------- | ----------------------- | ------------------------------------------- |
| Working copy is clean. | 20161110-gce36502       | (commit date)-(abbreviated commit ID)       |
| Working copy is dirty. | 20161110-gce36502-dirty | (commit date)-(abbreviated commit ID)-dirty |
