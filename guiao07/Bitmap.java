package guiao07;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Bitmap {
	private BitmapFileHeader bitmapFileHeader;
	private BitmapInfoHeader bitmapInfoHeader;
	private byte[] rgbQuad;									// color pallete
	private byte[] data;									// pixel data
	private PixelGrid grid;
	private int h;
	
	public Bitmap(Bitmap bm) {
		this.bitmapFileHeader = bm.bitmapFileHeader.clone();
		this.bitmapInfoHeader = bm.bitmapInfoHeader.clone();
		if(bm.rgbQuad != null) {
			this.rgbQuad = Arrays.copyOf(bm.rgbQuad, bm.rgbQuad.length);
		}
		this.data = Arrays.copyOf(bm.data, bm.data.length);
		this.h = bm.h;
		this.grid = bm.grid.clone();
	}
	
	public Bitmap(String file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file , "rw");
			bitmapFileHeader = new BitmapFileHeader(raf);
			bitmapInfoHeader = new BitmapInfoHeader(raf);			
			this.h = 3;
			this.data = new byte[((bitmapInfoHeader.getWidth()) * bitmapInfoHeader.getHeight())*this.h];
			try {
				raf.read(this.data);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			this.grid = new PixelGrid(this.data, Math.abs(bitmapInfoHeader.getHeight()), Math.abs(bitmapInfoHeader.getWidth()));
			this.grid.invertImageVertically();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not able to be read");
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}
	
	public void adjustSize(double value) {
		int area = this.bitmapInfoHeader.getHeight()*this.bitmapInfoHeader.getWidth()*this.h;
		int size = this.bitmapFileHeader.getSize()*this.h;
		int nextSize = (int) (((area-size)+size)*value*value);
		
		value = Math.abs(1/value);
		this.grid.adjustSize(value);
		this.bitmapInfoHeader.setHeight((int) Math.abs(this.bitmapInfoHeader.getHeight()/value));
		this.bitmapInfoHeader.setWidth((int) Math.abs(this.bitmapInfoHeader.getWidth()/value));
		this.bitmapFileHeader.setSize(Math.abs(nextSize));
	}
	
	public void invertImageVertically() {
		this.grid.invertImageVertically();
	}
	
	public void invertImageHorizontally() {
		this.grid.invertImageHorizontally();
	}
	
	private void saveFile(String file, PixelGrid grid) {
		saveFile(file, grid.pixelGridToByte());
	}
	
	public void makeCopy(String file) {
		saveFile(file, this.grid);
	}
	
	public Bitmap clone() {
		return new Bitmap(this);
	}
	
	public void getInitialImage() {
		this.grid = new PixelGrid(this.data, Math.abs(bitmapInfoHeader.getHeight()), Math.abs(bitmapInfoHeader.getWidth()));
		this.grid.invertImageVertically();
	}
	
	/*
	public Bitmap clone() throws CloneNotSupportedException {
        return (Bitmap) super.clone();        
    }*/
	
	public void save(String file) {
		saveFile(file, this.grid.pixelGridToByte());
	}
	
	public void saveFile(String file, byte[] b) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			try {
				writeHeader(raf);
				raf.write(b);
				System.out.println("File \"" + file + "\" created successfuly");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void saveRawFile(String file) {
		saveFile(file + ".raw", this.data);
	}
	
	public void saveImageWithByteArray(String file, byte[] b) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			try {
				writeHeader(raf);
				raf.write(b);
				System.out.println("File \"" + file + "\" created successfuly");
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void writeHeader(RandomAccessFile raf) {
		writeHeader(raf, this.bitmapFileHeader.getSize(), this.bitmapInfoHeader.getWidth(), this.bitmapInfoHeader.getHeight());
	}
	
	private void writeHeader(RandomAccessFile raf, int size, int width, int height) {
		try {
			bitmapFileHeader.writeToFile(raf, size);
			bitmapInfoHeader.writeToFile(raf, width, height);	// can also do bitmapInfoHeader.writeToFile(raf);
		} catch (IOException e) {
			System.out.println("Erro na funçao \" writeInfo(RandomAccessFile raf) \"");
			e.printStackTrace();
		}	
	}
	
	public BitmapFileHeader getBitmapFileHeader() {return this.bitmapFileHeader;}
	public BitmapInfoHeader getBitmapInfoHeader() {return this.bitmapInfoHeader;}
	public byte[] getRgbQuad() {return this.rgbQuad;}
	public byte[] getData() {return this.data;}
	public PixelGrid getGrid() {return this.grid;}
	public int getH() {return this.h;}
	
	public String toString() {
		return "BitmapFileHeader:\n" + this.bitmapFileHeader.toString() + "\nBitmapInfoHeader:\n" + this.bitmapInfoHeader.toString();
	}
}	
