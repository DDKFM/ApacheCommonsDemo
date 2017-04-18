package de.mschaedlich.common.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitorExample {
	public static void main(String[] args) {
		File parentDir = new File("examples");
		

		FileAlterationObserver observer = new FileAlterationObserver(parentDir);
		observer.addListener(new FileAlterationListenerAdaptor() {

			@Override
			public void onFileCreate(File file) {
				System.out.println("File created: " + file.getName());
			}

			@Override
			public void onFileDelete(File file) {
				System.out.println("File deleted: " + file.getName());
			}

			@Override
			public void onDirectoryCreate(File dir) {
				System.out.println("Directory created: " + dir.getName());
			}

			@Override
			public void onDirectoryDelete(File dir) {
				System.out.println("Directory deleted: " + dir.getName());
			}
		});
		FileAlterationMonitor monitor = new FileAlterationMonitor(500, observer);
		try {
			monitor.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
