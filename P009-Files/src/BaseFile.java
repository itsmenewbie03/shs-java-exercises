import java.io.File;
import java.io.IOException;

public class BaseFile {
	protected File infile, outfile;
	protected String inpath, outpath;
	
	BaseFile(String inpath, String outpath){
		this.inpath = inpath;
		this.outpath = outpath;
		
		this.infile = new File(this.inpath);
		if (!this.infile.exists()) {
			try {
				this.infile.createNewFile();
			} catch (IOException e) {
				System.out.println("ERROR creating file: " + this.infile.getName());
			}
		}
		
		this.outfile =  new File(this.outpath);
		if(!this.outfile.exists()) {
			try {
				this.outfile.createNewFile();
			} catch(IOException e) {
				System.out.println("ERROR creating file: " + this.outfile.getName());
			}
		}
	}

	public File getInfile() {
		return this.infile;
	}

	public File getOutfile() {
		return this.outfile;
	}

	public String getInpath() {
		return this.inpath;
	}

	public String getOutpath() {
		return this.outpath;
	}
	
	public String inFileInfo() {
		return  "	 File name: " + infile.getName()+"\n"+
				"	 File path: " + infile.getPath()+"\n"+
				"	 File size: " + infile.length()+"\n"+
				" Can execute?: " + infile.canExecute()+"\n"+
				"	 Can read?: " + infile.canRead()+"\n"+
				"   Can write?: " + infile.canWrite()+"\n"+
				"     Is file?: " + infile.isFile()+"\n"+
				"   Is hidden?: " + infile.isHidden()+"\n"+
				"Is directory?: " + infile.isDirectory()+"\n";
						
	}
	
	public String outFileInfo() {
		return  "	 File name: " + outfile.getName()+"\n"+
				"	 File path: " + outfile.getPath()+"\n"+
				"	 File size: " + outfile.length()+"\n"+
				" Can execute?: " + outfile.canExecute()+"\n"+
				"	 Can read?: " + outfile.canRead()+"\n"+
				"   Can write?: " + outfile.canWrite()+"\n"+
				"     Is file?: " + outfile.isFile()+"\n"+
				"   Is hidden?: " + outfile.isHidden()+"\n"+
				"Is directory?: " + outfile.isDirectory()+"\n";					
	}
}
