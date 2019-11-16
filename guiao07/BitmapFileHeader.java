package guiao07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitmapFileHeader {
	private short type;					// must be 'BM' to declare a bmp-file
	private int size;					// specifies the size of the file in bytes
	private short reserved1;			// must always be set to zero
	private short reserved2;			// specifies the offset from the
	private int offBits;				// beginning of the file to the bitmap data
	
	public BitmapFileHeader(RandomAccessFile raf) {
		try {
			this.type = Short.reverseBytes(raf.readShort());
			this.size = Integer.reverseBytes(raf.readInt());
			this.reserved1 = Short.reverseBytes(raf.readShort());
			this.reserved2 = Short.reverseBytes(raf.readShort());
			this.offBits = Integer.reverseBytes(raf.readInt());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public BitmapFileHeader(BitmapFileHeader bfh) {
		this.type = bfh.type;
		this.size = bfh.size;
		this.reserved1 = bfh.reserved1;
		this.reserved2 = bfh.reserved2;
		this.offBits = bfh.offBits;
	}
	
	public BitmapFileHeader clone() {
		return new BitmapFileHeader(this);
	}
	/*
	public BitmapFileHeader clone() throws CloneNotSupportedException {
        return (BitmapFileHeader) super.clone();
    }*/
	
	public String toString() {
		return "Type: " + this.type + "\n"
				+ "Size: " + this.size + "\n"
				+ "Reserved1: " + this.reserved1 + "\n"
				+ "Reserved2: " + this.reserved2 + "\n"
				+ "OffBits: " + this.offBits;
	}
	
	public void writeToFile(RandomAccessFile raf, int size) throws IOException {
		raf.writeShort(Short.reverseBytes(this.type));
		raf.writeInt(Integer.reverseBytes(size));
		raf.writeShort(Short.reverseBytes(this.reserved1));
		raf.writeShort(Short.reverseBytes(this.reserved2));
		raf.writeInt(Integer.reverseBytes(offBits));
	}
	
	public void setSize(int value) {
		this.size = value;
	}
	
	public int getSize() {
		return this.size;
	}
	
}