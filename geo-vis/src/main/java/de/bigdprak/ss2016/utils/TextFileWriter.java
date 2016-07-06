package de.bigdprak.ss2016.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;

public abstract class TextFileWriter {

	public static RandomAccessFile coordFile;
	public static BufferedWriter coordWriter;
	
	public static void initializeCoordWriter(String path)
	{
		try 
		{
			coordFile = new RandomAccessFile(path, "rw");
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
//		coordWriter = new BufferedWriter(new Writer(path));
	}
	
	public static void closeCoordWriter()
	{
		try
		{
			coordWriter.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void writeCoordinates(double lng, double lat)
	{
		int anchor = TextFileReader.getLinesRead();
		
		
	}
	
	
	
	
	
	/**
	 * Liest directory. Existiert die angegebene Datei nicht, so wird sie mit
	 * dem angegebenen Text als Inhalt erstellt. Existiert die Datei bereits, so
	 * schreibt diese Methode den angegebenen Text ans Ende der Datei.
	 * 
	 * @param directory
	 *            Dateipfad
	 * @param text
	 *            in Datei zu schreibender Text
	 * @return true, falls Datei neu erstellt wurde, ansonsten false
	 */
	public static boolean writeOn(String directory, String text) {
		boolean created = true;
		try {
			File file = new File(directory);
			created = !file.exists();
			FileWriter fw = new FileWriter(file, true);

			fw.write(text);

			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			created = false;
			e.printStackTrace();
		} catch (IOException e) {
			created = false;
			e.printStackTrace();
		}
		return created;
	}
	
	/**
	 * Liest file. Existiert die angegebene Datei nicht, so wird sie mit
	 * dem angegebenen Text als Inhalt erstellt. Existiert die Datei bereits, so
	 * schreibt diese Methode den angegebenen Text ans Ende der Datei.
	 * 
	 * @param file
	 *            Datei mit hinterlegter Directory
	 * @param text
	 *            in Datei zu schreibender Text
	 * @return true, falls Datei neu erstellt wurde, ansonsten false
	 */
	public static boolean writeOn(File file, String text) {
		boolean created = !file.exists();
		try {
			FileWriter fw = new FileWriter(file, true);

			fw.write(text);

			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			created = false;
			e.printStackTrace();
		} catch (IOException e) {
			created = false;
			e.printStackTrace();
		}
		return created;
	}

	/**
	 * Liest directory. Existiert die angegebene Datei nicht, so wird sie mit
	 * dem angegebenen Text als Inhalt erstellt. Existiert die Datei bereits, so
	 * überschreibt diese Methode die Datei mit dem angegebenen Text.
	 * 
	 * @param directory
	 *            Dateipfad
	 * @param text
	 *            in Datei zu schreibender Text
	 * @return true, falls Datei neu erstellt wurde, ansonsten false
	 */
	public static boolean writeOver(String directory, String text) {
		boolean created = true;
		try {
			File file = new File(directory);
			created = !file.exists();
			FileWriter fw = new FileWriter(file, false);
			
			fw.write(text);

			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			created = false;
			e.printStackTrace();
		} catch (IOException e) {
			created = false;
			e.printStackTrace();
		}
		return created;
	}

	/**
	 * Liest file. Existiert die angegebene Datei nicht, so wird sie mit
	 * dem angegebenen Text als Inhalt erstellt. Existiert die Datei bereits, so
	 * überschreibt diese Methode die Datei mit dem angegebenen Text.
	 * 
	 * @param file
	 *            Datei mit hinterlegter Directory
	 * @param text
	 *            in Datei zu schreibender Text
	 * @return true, falls Datei neu erstellt wurde, ansonsten false
	 */
	public static boolean writeOver(File file, String text) {
		boolean created = !file.exists();
		try {
			FileWriter fw = new FileWriter(file, false);

			fw.write(text);

			fw.flush();
			fw.close();
		} catch (FileNotFoundException e) {
			created = false;
			e.printStackTrace();
		} catch (IOException e) {
			created = false;
			e.printStackTrace();
		}
		return created;
	}
	
}