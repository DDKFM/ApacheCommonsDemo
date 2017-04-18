package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomFiles {

	public static void main(String[] args) {
		File directory = new File("examples");
		int maxFiles = 10;
		if(args.length > 0 && args[0].matches("\\d+"))
			maxFiles = Integer.parseInt(args[0]);
		for(int i = 0 ; i < maxFiles ; i++) {
			Random random = new Random();
			File randomFile = new File(directory.getAbsolutePath() + File.separator + random.nextInt() + ".txt");
			try {
				randomFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
