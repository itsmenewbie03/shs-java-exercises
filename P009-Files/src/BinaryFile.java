import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFile extends BaseFile{
	private FileInputStream binfile;
	private FileOutputStream boutfile;
	private byte[] buffer;
	
	BinaryFile(String inpath, String outpath) throws IOException{
		super(inpath, outpath);
		
		this.binfile = new FileInputStream(infile);
		this.boutfile = new FileOutputStream(outfile); // this truncates the target file
		
	}
	
	public boolean read(int recsize) {
		try {
			int bytesread = 0;
			this.buffer =  new byte[recsize];
			if(this.binfile.available()>0) {
				bytesread = this.binfile.read(buffer);
				return bytesread<=this.buffer.length;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean readAll() {
		try {
			int byteread = 0;
			
			// debug
			System.out.println(this.infile.length());
			
			this.buffer = new byte[(int) this.infile.length()];
			if (this.binfile.available()>0) {
				byteread = this.binfile.read(buffer);
				return byteread <= this.buffer.length;
			}
		} catch(Exception e) {
			return false;
		}	
		return false;
	}
	
	public boolean write() {
		try {
			this.boutfile.write(this.buffer);
			this.boutfile.flush();
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public byte[] getBuffer(){
		return buffer;
	}
}
