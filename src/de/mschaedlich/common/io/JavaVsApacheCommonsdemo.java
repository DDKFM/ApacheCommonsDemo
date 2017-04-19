package de.mschaedlich.common.io;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class JavaVsApacheCommonsdemo {

	public static void main(String[] args) {
		File directory = new File("examples");
		
		long folderSizeJava = folderSize(directory);
		long folderSizeApacheCommons = FileUtils.sizeOfDirectory(directory);
		
		//"von Hand rekursiv durchgehen"
		System.out.println("Ordnergr��e Java: " + DiskSpace.formatFileSize(folderSizeJava));
		//Apache Commons nutzen
		System.out.println("Ordergr��e Apache Commons: " + DiskSpace.formatFileSize(folderSizeApacheCommons));
	}
	private static long folderSize(File directory) {
		long length = 0;
		for(File file : directory.listFiles()) {
			if(file.isDirectory())
				length += folderSize(file);
			else
				length += file.length();
		}
		return length;
	}

}
