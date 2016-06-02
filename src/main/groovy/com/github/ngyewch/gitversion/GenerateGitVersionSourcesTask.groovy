package com.github.ngyewch.gitversion

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenerateGitVersionSourcesTask extends DefaultTask {

    @TaskAction
    def generateGitVersionSources() {
        def generatedSourceDir = new File(project.buildDir, project.gitVersion.generatedSourceDir)
        def file = new File(generatedSourceDir, project.gitVersion.packageName.replace('.', '/') + '/' + project.gitVersion.className + '.java')
        file.getParentFile().mkdirs()

        def writer = new PrintWriter(new FileWriter(file))
        try {
            writer.printf("package %s;\n", project.gitVersion.packageName);
            writer.printf("\n");
            writer.printf("public final class %s {\n", project.gitVersion.className);
            writer.printf("    public static final String GIT_BRANCH = \"%s\";\n", git.branch.current.name);
            writer.printf("    public static final String GIT_COMMIT_ID = \"%s\";\n", git.head().id);
            writer.printf("    public static final String GIT_COMMIT_ID_ABBREV = \"%s\";\n", git.head().abbreviatedId);
            writer.printf("    public static final String GIT_COMMIT_DATE = \"%s\";\n", git.head().date.format("yyyy-MM-dd'T'HH:mm:ssZ"));
            writer.printf("\n");
            writer.printf("    public static final String BUILD_DATE = \"%s\";\n", new Date().format("yyyy-MM-dd'T'HH:mm:ssZ"));
            writer.printf("\n");
            writer.printf("    public static final String VERSION = \"%s\";\n", versionName);
            writer.printf("\n");
            writer.printf("    private %s() {\n", project.gitVersion.className);
            writer.printf("        super();\n");
            writer.printf("    }\n");
            writer.printf("}\n");
            writer.flush()
        } finally {
            writer.close()
        }
    }
}