package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;


public class DiskSpace {
	public static void main(String[] args) {
		File[] rootFolders = File.listRoots();
		for(File rootFolder : rootFolders) {
			try {
				System.out.println("[Pfad: " + rootFolder.getPath() + "]");
				
				long totalSpace = rootFolder.getTotalSpace();
				long freeSpace = FileSystemUtils.freeSpaceKb(rootFolder.getPath()) * 1000;
				double percentage = freeSpace / ((double) totalSpace) * 100;
				
				System.out.println("\tgesamter Speicher: " + formatFileSize(totalSpace) + "");
				System.out.println("\tfreier Speicher: " + formatFileSize(freeSpace) + "");
				System.out.println("\tfreier Speicher( in Prozent): " + String.format("%.2f", percentage) + " %");
			} catch (IOException e) {
				System.err.println("Fehler beim Auslesen der Dateinformationen: " + e);
			}
		}
	}
	
	public static String formatFileSize(long fileSize) {
		String[] suffix = new String[] {"Byte", "KiB", "MiB", "GiB", "TiB", "PiB"};
		int maxCount = 6;
		int i = 0;
		int suffixCount = 0;
		double fileSizeAsDouble = fileSize;
		while (fileSizeAsDouble> 1024 && i < maxCount) {
			fileSizeAsDouble /= 1024;
			suffixCount++;
			i++;
		}
		return String.format("%.2f", fileSizeAsDouble) + " " + suffix[suffixCount];
	}
}
