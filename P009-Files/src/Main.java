import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/****************************************************************************
 * PROBLEM:		Java file demo program
 * 				
 * AUTHOR:		Salvador, 1 M.Ligayao
 * DATE:		06/07/2021
 * VERSION:		1.0
 * 
 * 
 * PROJECT:		P009-Files
 ****************************************************************************/
public class Main {

	final static int KBYTE = 1024;
	
	public static void main(String[] args) {
		
		/*
		 * TWO TYPES OF FILES
		 *  1. TEXT FILES
		 *  	- ASCII files organized into lines of text with a CR (carriage return)
		 *  		and/or LF (line feed) control characters at the end
		 *  		(American Standard Code for Information Interchange)
		 *  2. BINARY FILES
		 *  	- 	native binary code files which maybe user files or executable files
		 *  		(i.e programs)
		 *  
		 *  NOTE:	since computers only understand BINARY... all these types of files ARE 
		 *  		BINARY
		 */
		
		/*********************************************************
		 * BASIC FILES CREATION
		 *********************************************************
		 * 1. CREATE A FILE
		 * 		- file must not exist
		 * 		- if it exists the file will be overwritten or
		 * 			truncated (file size will be set to zero).
		 * 			BE CAREFUL!
		 * 
		 * 2. OPEN A FILE
		 * 		- file must exist
		 * 		- an ERROR occurs when opening non-existent file
		 * 
		 * 3. READ FROM A FILE
		 * 		- if EOF (End of File) then there is nothing
		 * 			more to be read from the file
		 * 		- file might not be accessible
		 * 
		 * 4. WRITE TO A FILE
		 * 		-if bytes written is zero the disk/media is full
		 * 		- file might not be accessible
		 * 
		 * 5. CLOSE A FILE
		 * 		- close a file in order to reclaim resources and
		 * 			guarantee that file buffer contents are flushed
		 * 			or written to disk/media
		 * 
		 * 6. ERASE A FILE
		 * 		- file must exist
		 * 		- an ERROR occurs when deleting non-existent file
		 * 
		 * 7. RENAME A FILE
		 * 		- file must exist
		 * 		- an ERROR occurs when renaming non-existent file
		 * 		- follow OS conventions in naming a file
		 * 
		 *********************************************************/

		//---------------------------------------------------------
		// CREATE A FILE USING THE FILE CLASS
		//---------------------------------------------------------
		File file = new File("Sample.TXT");
		
		// try to create a file
		try {
			file.createNewFile();
		} catch(Exception e) {
			System.out.println("ERROR: File is not created");
			return;
		}
		
		//file is created
		System.out.println("        File Name: " +file.getName());
		System.out.println("        File Path: " +file.getPath());
		System.out.println("      File Length: " +file.length());
		System.out.println("    Absolute Path: " +file.getAbsolutePath());
		System.out.println();
		System.out.println("       Directory?: " +file.isDirectory());
		System.out.println("            File?: " +file.isFile());
		System.out.println("          Hidden?: " +file.isHidden());
		System.out.println("      Executable?: " +file.canExecute());
		System.out.println("        Readable?: " +file.canRead());
		System.out.println("        Writable?: " +file.canWrite());
		
		//---------------------------------------------------------
		// WRITE TO A FILE USING THE FILEWRITER CLASS
		//---------------------------------------------------------	
		System.out.println("WRITING TO FILE...");
		try {
			FileWriter filewriter = new FileWriter(file);
			
			filewriter.write("----------------------------------------\n");
			filewriter.write("------- SAMPLE TEXT FILE----------------\n");
			filewriter.write("----------------------------------------\n");
			filewriter.write("Writing some numbers...\n");
			for (int i=1; i<=20; i++) {
				filewriter.write(i+"\n");
			}
			filewriter.close();
		} catch(IOException e1) {
			System.out.println("ERROR: Unable to write to file");
		}
		System.out.println("**DONE.");
		System.out.println();
		
		//---------------------------------------------------------
		// READ A FILE USING THE FILEREADER CLASS
		//---------------------------------------------------------	
		System.out.println("READING FILE...");
		try {
			FileReader filereader = new FileReader(file);
			int c;
			
			while((c = filereader.read())!= -1) {
				System.out.print((char)c);
			}
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		} catch (IOException e) {
			System.out.println("ERROR: Unable to read file.");
		}
		System.out.println("***FINISHED");
		System.out.println();
		
		//---------------------------------------------------------
		// SET FILE TO READ-ONLY
		//---------------------------------------------------------
		file.setReadOnly();
		System.out.println("File set to READ-ONLY.");
		System.out.println();
		pause("PRESS ENTER TO CONTINUE...");
		
		//---------------------------------------------------------
		// DELETE FILE
		//---------------------------------------------------------
		try{
			file.delete();
			System.out.printf("Files (%s) Deleted.\n", file.getName());
		} catch(Exception e) {
			System.out.println("ERROR: Unable to delete file.");
		}
		
			//---------------------------------------------------------
			// Call demonstration method for TextFile class
			//---------------------------------------------------------
			System.out.println();
			pause("PRESS ENTER TO START TEXTFILE CLASS DEMO...");
			DemoTextFile();
			
			//---------------------------------------------------------
			// Call demonstration method for BinaryFile class
			//---------------------------------------------------------
			System.out.println();
			pause("PRESS ENTER TO START BINARYFILE CLASS DEMO...");
			DemoBinaryFile();
				
		}
	
	//---------------------------------------------------------
	// TEXTFILE CLASS DEMONSTRATION METHOD
	//---------------------------------------------------------
	public static void DemoTextFile() {
		try {
			TextFile textfile = new TextFile("textdemo.txt", "output.txt");
			
			System.out.println("GENERATING FILE CONTENT...");
			for (int i=1; i<=100; i++) {
				textfile.getLines().add("TextFile Demo Line #"+String.format("%03d\n", i));
			}
			
			System.out.println("SAVING FILE...");
			textfile.saveFile();
			pause("PRESS ENTER TO CONTINUE...");
			
			System.out.println("LOADING FILE...");
			textfile.loadFile();
			
			System.out.println("VIEWING FILE CONTENTS");
			System.out.println("-------------------------------------------------------------");
			for(int i = 0; i<textfile.getLines().size(); i++) {
				System.out.println(String.format("Line %3d: ", i)+textfile.getLines().get(i));
				System.out.println("*** END ***");
				System.out.println();
			}
			
		} catch(Exception e) {
			System.out.println("ERROR: accessing file.");
		}
	}
	
	//---------------------------------------------------------
	// BINARYFILE CLASS DEMONSTRATION METHOD
	//---------------------------------------------------------
	public static void DemoBinaryFile() {
		try {
			BinaryFile binaryfile = new BinaryFile("cat.jpg", "temp.dat");
			System.out.println("VIEWING FILE CONTENTS");
			System.out.println("-------------------------------------------------------------");
			
			if (binaryfile.readAll()) {
				bufferToHex(binaryfile.getBuffer());
			} else {
				System.out.println("ERROR: file too large");
			}
			
			System.out.println("*** END ***");
			System.out.println();
		} catch(IOException e) {
			System.out.println("ERROR: accessing file");
		}
	}
	
	//---------------------------------------------------------
	// SHOW CONTENTS OF BUFFER IN HEX AND CHAR
	//---------------------------------------------------------
	public static void bufferToHex(byte[] buffer) {
		String hexStr = "";
		String byteStr = "";
		
		int j=0;
		for(int i = 0; i<buffer.length; i++) {
			
			if(byteStr.length()==16) {
				 System.out.println(String.format("%06x", i)+": "+hexStr+" "+byteStr);
				 hexStr = "";
				 byteStr= "";
			}
			char c = (char) buffer[i];
			if(c<32) {
				c = ' ';
			}
			hexStr += byteToHex(buffer[i])+" ";
			byteStr +=c;
			j=1;
			
		}
		System.out.println(String.format("%06x", j) +": "+hexStr+" "+byteStr);
		}
	//---------------------------------------------------------
	// METHOD TO CONVERT BYTE TI HEX USING TRANSLATION TABLE
	//---------------------------------------------------------
	public static String byteToHex(byte b) {
		String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		// AND first nibble with 11110000 and shift right 4 times
		//		then use the value as index to the String array "hex"
		// AND second nibble with 00001111 and also use the value
		//		as index to the String array "hex"
		return hex[(b & 0xF0) >> 4 ] + hex[b & 0x0F];
	}
	
	//---------------------------------------------------------
	// Pause
	//---------------------------------------------------------
	public static void pause(String message) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.print(message);
		while(!in.hasNextLine()) {
			// empty
		}
	}
}
	

