package guiao07;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BitmapInfoHeader {
	private int size;							// the size of this header (40 bytes)
	private int width;							// the bitmap width in pixels	
	private int height;							// the bitmap height in pixels
	private short planes;						// the number of color planes being used. Must be set to 1
	private short bitcount;						// the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	private int compression;					// the compression method being used
	private int sizeImage;						// the image size. This is the size of the raw bitmap data
	private int xPelsPerMeter;					// the horizontal resolution of the image (pixel per meter)
	private int yPelsPerMeter;					// the vertical resolution of the image (pixel per meter)
	private int clrUsed;						// the number of colors in the color palette, or 0 to default to 2n
	private int clrImportant;					// the number of important colors used, or 0 when every color is important
	
	public BitmapInfoHeader(RandomAccessFile raf) {
		try {
			this.size = Integer.reverseBytes(raf.readInt());
			this.width = Math.abs(Integer.reverseBytes(raf.readInt()));
			this.height = Math.abs(Integer.reverseBytes(raf.readInt()));
			this.planes = Short.reverseBytes(raf.readShort());
			this.bitcount = Short.reverseBytes(raf.readShort());
			this.compression = Integer.reverseBytes(raf.readInt());
			this.sizeImage = Integer.reverseBytes(raf.readInt());
			this.xPelsPerMeter = Integer.reverseBytes(raf.readInt());
			this.yPelsPerMeter = Integer.reverseBytes(raf.readInt());
			this.clrUsed = Integer.reverseBytes(raf.readInt());
			this.clrImportant = Integer.reverseBytes(raf.readInt());
			
			if(this.bitcount < 16) {
				System.out.println("Only more than 16-bit count are allowed for now");
				System.exit(0);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public BitmapInfoHeader(BitmapInfoHeader bih) {
		this.size = bih.size;
		this.width = bih.width;
		this.height = bih.height;
		this.planes = bih.planes;
		this.bitcount = bih.bitcount;
		this.compression = bih.compression;
		this.sizeImage = bih.sizeImage;
		this.xPelsPerMeter = bih.xPelsPerMeter;
		this.yPelsPerMeter = bih.yPelsPerMeter;
		this.clrUsed = bih.clrUsed;
		this.clrImportant = bih.clrImportant;
	}
	
	public void setHeight(int value) {
		this.height = value;
	}
	
	public void setWidth(int value) {
		this.width = value;
	}
	
	public BitmapInfoHeader clone() {
		return new BitmapInfoHeader(this);
	}
	/*
	public BitmapInfoHeader clone() throws CloneNotSupportedException {
        return (BitmapInfoHeader) super.clone();
    }*/
	
	public void writeToFile(RandomAccessFile raf, int width, int height) throws IOException {
		raf.writeInt(Integer.reverseBytes(this.size));
		raf.writeInt(Integer.reverseBytes(width));
		raf.writeInt(Integer.reverseBytes(height));
		raf.writeShort(Short.reverseBytes(this.planes));
		raf.writeShort(Short.reverseBytes(this.bitcount));
		raf.writeInt(Integer.reverseBytes(this.compression));
		raf.writeInt(Integer.reverseBytes(this.sizeImage));
		raf.writeInt(Integer.reverseBytes(this.xPelsPerMeter));
		raf.writeInt(Integer.reverseBytes(this.yPelsPerMeter));
		raf.writeInt(Integer.reverseBytes(this.clrUsed));
		raf.writeInt(Integer.reverseBytes(this.clrImportant));
	}
	
	public void writeToFile(RandomAccessFile raf) throws IOException {
		writeToFile(raf, this.width, this.height);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public String toString() {
		return "Size: " + this.size + 
				"\nWidth: " + this.width + 
				"\nHeight: " + this.height + 
				"\nPlanes: " + this.planes + 
				"\nBitCount: " + this.bitcount + 
				"\nCompression: " + this.compression + 
				"\nSizeImage: " + this.sizeImage + 
				"\nXPelsPerMeter: " + this.xPelsPerMeter + 
				"\nYPelsPerMeter: " + this.yPelsPerMeter + 
				"\nClrUsed: " + this.clrUsed + 
				"\nclrImportant: " + this.clrImportant;
	}
	
}