import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFile extends BaseFile{
	private BufferedReader reader;
	private BufferedWriter writer;
	
	// this may contain ALL the lines of the textfile
	protected ArrayList<String> lines;
	
	TextFile(String inpath, String outpath){
		super(inpath, outpath);
		
		try {
			this.reader = new BufferedReader(new FileReader(infile));
		} catch(FileNotFoundException e) {
			System.out.println("ERROR opening input file: "+this.infile.getName());
		}
		
		try {
			this.writer = new BufferedWriter(new FileWriter(outfile));
		} catch(IOException e) {
			System.out.println("ERROR opening output file: "+this.outfile.getName());
		}
		
		this.lines = new ArrayList<String>();
	}
	//---------------------------------------------------------
	// Load contents of file to line buffer list
	//---------------------------------------------------------
	public boolean loadFile() {
		String line;
		
		this.lines.clear();
		
		try {
			line = this.reader.readLine();
			while (line!=null) {
				this.lines.add(line);
				line = this.reader.readLine();
			}
		} catch(IOException e) {
			System.out.println("ERROR reading file: " + this.infile.getName());
			return false;
		}
		return true;
	}
	//---------------------------------------------------------
	// Save contents of line buffer list to file
	//---------------------------------------------------------
	public boolean saveFile() {
		int count = 0;
		try {
			while(count<this.lines.size()) {
				this.writer.write(lines.get(count));
				count++;
			}
			this.writer.flush();
		} catch(IOException e) {
			System.out.println("ERROR writing file "+this.outfile.getName());
			return false;
		}
		return true;
	}
	
	//---------------------------------------------------------
	// Save contents of line buffer list to file
	//---------------------------------------------------------
	public boolean appendFile() {
		int count = 0;
		try {
			while(count<this.lines.size()) {
				this.writer.append(lines.get(count));
				count++;
			}
			this.writer.flush();
		} catch(IOException e) {
			System.out.println("ERROR writing file "+this.outfile.getName());
			return false;
		}
		return true;
	}
	//---------------------------------------------------------
	// Get the line buffer list
	//---------------------------------------------------------
	public ArrayList<String> getLines(){
		return lines;
	}
}
