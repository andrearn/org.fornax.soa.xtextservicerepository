package org.xkonnex.repo.server.core.config.impl

import java.io.File
import java.io.FileWriter
import org.xkonnex.repo.server.core.config.IProjectGenerator

class ProjectGenerator implements IProjectGenerator {
	
	override generateProject(File folder) {
		generateREADME(folder)
	}
	
	def generateREADME (File folder) {
		if (!folder.exists) {
			folder.mkdirs
		}
		val File readmeFile = new File(folder, "README.txt")
		val content='''
			This contains a service repository.
		'''
		val FileWriter writer = new FileWriter(readmeFile)
		writer.write(content)
		writer.close
	}
}