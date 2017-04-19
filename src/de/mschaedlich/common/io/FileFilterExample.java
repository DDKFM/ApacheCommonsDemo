package de.mschaedlich.common.io;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class FileFilterExample {

	public static void main(String[] args) {
		File parentFile = new File("examples");
		/*
		 * Alle Dateinamen anzeigen
		 * */
		
		/*
		 * Wildcard-Filter: erkennet * als belebig viele Zeichen und 
		 * 							 ? als ein beliebiges Zeichen
		 * */
		
		FilenameFilter filter = new WildcardFileFilter("BWL*");
		
		/*
		 * Prefix - und Suffix-Filter
		 * alle Filter sind kombinierbar mit "logischen" Filtern wie AND, OR, NOT 
		 * */
		FilenameFilter prefixFilter = new PrefixFileFilter("BWL");
		FilenameFilter suffixFilter = new SuffixFileFilter("odt");
		
		FilenameFilter andFilter = new AndFileFilter(
									new PrefixFileFilter("BWL"),//beginnt mit "BWL" UND
									new SuffixFileFilter("odt")//endet mit "odt"
									);
		//weitere Filter: NotFileFilter, OrFileFilter,
		
		String[] fileNames = parentFile.list();
		
		
		/*
		 * Ausgabe
		 * */
		for(String fileName : fileNames) {
			System.out.println("Datei: " + fileName);
		}
	}

}
