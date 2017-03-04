package de.init.main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.init.usage.Constants;


public class Main {

	public static void main(String[] args) {
		String path = "";

		if (args.length == 0) {
			Path currentRelativePath = Paths.get("");
			path = currentRelativePath.toAbsolutePath().toString();
		} else {
			try {
				path = args[0];
			} catch (Exception e) {
				showErrorMessageAndExit();
			}
		}

		System.out.println("Current Path is: " + path + ".");
		// read the files			
		for (File file : new File(path).listFiles()) {
			System.out.println("The current file is: " + file.getAbsolutePath());
			String filename = file.getName();
			
			filename = Constants.removeInvalidCharacters(filename).trim();
							
			// save the file
			File newFile = new File(path+File.separator+filename);
			file.renameTo(newFile);
			
			}
		System.exit(0);
	}

	private static void showErrorMessageAndExit() {
		System.out.println("No files found.");
		System.exit(1);
	}
}
