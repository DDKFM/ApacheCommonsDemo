package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;
import java.util.zip.Checksum;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class CheckSum {
	public static void main(String[] args) throws IOException {
		File examplesDirectory = new File("examples");
		System.out.println("Informationen zum Ordner: " + examplesDirectory.getAbsolutePath());
		long directorySize = FileUtils.sizeOf(examplesDirectory);
		System.out.println("\tOrdnergröße: " + DiskSpace.formatFileSize(directorySize));
		
		System.out.println("\tOrdnergröße: " + DiskSpace.formatFileSize(directorySize));
		for(File childFile : examplesDirectory.listFiles()) {
			System.out.println("\t\tDatei: " + childFile.getName() + ", CheckSum: " + FileUtils.checksumCRC32(childFile));
		}
	}
}
