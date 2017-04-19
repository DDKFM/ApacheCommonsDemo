package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;

public class FilenameUtilsExample {

	public static void main(String[] args) {
		
		String path = "examples" + File.separator + "HalloWelt.txt";
		String fullPath = FilenameUtils.getFullPath(path);
		String extension = FilenameUtils.getExtension(path);
		String baseName = FilenameUtils.getBaseName(path);
		
		System.out.println("File: " + path);
		System.out.println("Full Path: " + fullPath);
		System.out.println("Extension: " + extension);
		System.out.println("Base Name: " + baseName);
		
		System.out.println("");
		
		File childFile = new File("examples" + File.separator + "HalloWelt.txt");
		File parentFile = new File("examples");
		
		try {
			boolean directoryContainsFile = FileUtils.directoryContains(parentFile, childFile);
			
			System.out.println("Die Datei " + childFile.getName() + " befindet sich "
					+ (directoryContainsFile ? "" : "nicht")
					+ " im Ordner " + parentFile.getName());
		} catch (IOException e) {
			System.err.println("Fehler beim Überprüfen von directoryContains");
		}
		
	}

}
