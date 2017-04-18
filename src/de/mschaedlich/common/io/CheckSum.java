package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CheckSum {
	public static void main(String[] args) throws IOException {
		File examplesDirectory = new File("examples");
		
		try {
			File testordner = new File(examplesDirectory.getAbsolutePath() + File.separator + "testordner");
			FileUtils.forceMkdir(testordner);
			FileUtils.forceDelete(testordner);
			
			File file0 = new File("examples" + File.separator + "BWL.txt");
			File file1 = new File("examples" + File.separator + "BWL2.txt");
			FileUtils.copyFile(file0, file1);
			FileUtils.forceDelete(file0);
			FileUtils.moveFile(file1, file0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
