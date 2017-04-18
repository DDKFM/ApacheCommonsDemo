package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;

public class FilenameUtilsExample {

	private static final File EXAMPLE_FILE = new File("examples" + File.separator + "HalloWelt.txt");
	public static void main(String[] args) {
		
		String fullPath = FilenameUtils.getFullPath( EXAMPLE_FILE.getAbsolutePath());
		String extension = FilenameUtils.getExtension(EXAMPLE_FILE.getAbsolutePath());
		String baseName = FilenameUtils.getBaseName(EXAMPLE_FILE.getAbsolutePath());
		
		System.out.println("Voller Pfad: " + fullPath);
		System.out.println("Dateiendung: " + extension);
		System.out.println("Basis: " + baseName);
		/*
		 * 
		 * */
		try {
			LineIterator lineIterator = FileUtils.lineIterator(EXAMPLE_FILE);
			System.out.println("Inhalt der Datei: " + EXAMPLE_FILE.getName());
			
			while(lineIterator.hasNext()) {
				System.out.println("\t" + lineIterator.next());
			}
			lineIterator.close();
		
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Datei" + e);
		}
		/*
		 * 
		 * 
		 * */
		File childFile = new File("examples" + File.separator + "HalloWelt.txt");
		File parentFile = new File("examples");
		
		try {
			boolean directoryContainsFile = FileUtils.directoryContains(parentFile, childFile);
			
			System.out.println("Die Datei " + childFile.getName() + "befindet sich "
					+ (directoryContainsFile ? "nicht" : "")
					+ " im Ordner " + parentFile.getName());
		} catch (IOException e) {
			System.err.println("Fehler beim Überprüfen von directoryContains");
		}
		
	}

}
