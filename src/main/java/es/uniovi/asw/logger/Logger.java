package es.uniovi.asw.logger;

import java.io.*;
import java.util.Date;

public class Logger {

	BufferedWriter file;
	
	public Logger() {
		createLog("generatedFiles/errors.log");
	}
	
	public void log(String filename, String message) {
		try {
			Date date = new Date();
			file.append("Filename: " + filename + " ");
			file.append(date.toString() +" "+ message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createLog(String name) {
		try {
			file = new BufferedWriter(new FileWriter(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
