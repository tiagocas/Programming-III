package guiao07;

import java.util.Arrays;

public class PixelGrid {
	public Pixel[][] grid;
	private byte[] data;
	private int height;
	private int width;
	private int h;
	
	public PixelGrid(byte[] data, int height, int width, int h) {		
		this.h = h;
		this.height = height;
		this.width = width;
		this.grid = this.byteToPixelArray(data, height, width);		
		this.data = data;
	}
	
	public PixelGrid(PixelGrid gridInicial) {
		this.grid = new Pixel[gridInicial.height][];
		for(int i = 0; i < gridInicial.height; i++) {
		    this.grid[i] = gridInicial.grid[i].clone();
		}
		this.data = Arrays.copyOf(gridInicial.data, gridInicial.data.length);
		this.height = gridInicial.height;
		this.width = gridInicial.width;
		this.h = gridInicial.h;
	}
	
	public PixelGrid(Pixel[][] grid, int height, int width, int h) {
		this.h = h;
		this.height = height;
		this.width = width;
		this.grid = grid;
		this.data = pixelGridToByte();
	}
	
	public PixelGrid(byte[] data, int height, int width) {
		this(data, height, width, 3);
	}
	
	public void adjustSize(double value) {
		int height = (int) (this.height/value);
		int width = (int) (this.width/value);
		Pixel[][] newGrid = new Pixel[height][width];
		for(int i=0; i<height;i++) {
			for(int j=0;j<width;j++) {
				newGrid[i][j] = this.grid[(int) (i*value)][(int) (j*value)];
			}
		}
		this.height = height;
		this.width = width;
		this.grid = newGrid;
	}
	
	public PixelGrid clone() {
		return new PixelGrid(this);
	}
	
	//public PixelGrid clone() {
	//	return new PixelGrid(this.grid, this.height, this.width, this.h);
	//}
	
	public Pixel[][] getInvertImageVertically(){
		Pixel[][] newGrid= new Pixel[this.height][this.width];
		for(int i=0;i<this.height/2;i++) {
			for(int j=0;j<this.width;j++) {
				Pixel aux = this.grid[i][j];
				newGrid[i][j] = this.grid[this.height-i-1][j];
				newGrid[this.height-i-1][j] = aux;
			}
		}
		return newGrid;
	}
	
	public Pixel[][] getInvertImageHorizontally(){
		Pixel[][] newGrid= new Pixel[this.height][this.width];
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width/2;j++) {
				Pixel aux = this.grid[i][j];
				newGrid[i][j] = this.grid[i][this.width-j-1];
				newGrid[i][this.width-j-1] = aux;
			}
		}
		return newGrid;
	}
	
	public void invertImageVertically() {
		for(int i=0;i<this.height/2;i++) {
			for(int j=0;j<this.width;j++) {
				Pixel aux = this.grid[i][j];
				this.grid[i][j] = this.grid[this.height-i-1][j];
				this.grid[this.height-i-1][j] = aux;
			}
		}
	}
	
	public void invertImageHorizontally() {
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width/2;j++) {
				Pixel aux = this.grid[i][j];
				this.grid[i][j] = this.grid[i][this.width-j-1];
				this.grid[i][this.width-j-1] = aux;
			}
		}
	}
	
	public void invertImage(){
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width/2;j++) {
				Pixel aux = this.grid[i][j];
				this.grid[i][j] = this.grid[this.height-i-1][this.width-j-1];
				this.grid[this.height-i-1][this.width-j-1] = aux;
			}
		}
	}
	
	public Pixel[][] byteToPixelArray(byte[] data, int height, int width) {
		Pixel[][] b = new Pixel[height][width];
		int count = 0;
		for(int i=0;i<height; i++) {
			for(int j=0;j<width;j++) {
				b[i][j] = new Pixel(data[count+2], data[count+1], data[count]);
				count += this.h;
			}
		}
		return b;
	}
	
	public int numberOfPixels() {
		return ((this.width + this.h ) * this.height)*this.h;
	}
	
	public byte[] pixelGridToByte() {
		byte[] b = new byte[(this.width * this.height)*this.h];
		int count = 0;
		for(int i=0;i<this.height;i++) {
			for(int j=0;j<this.width;j++) {
				Pixel p = this.grid[i][j];
				b[count] = p.b;
				b[count + 1] = p.g;
				b[count + 2] = p.r;
				count += this.h;
			}
		}
		return b;
	}
	
	/*
	public PixelGrid adjustSize(double value) {
		int height = (int) (this.height/value);
		int width = (int) (this.width/value);
		Pixel[][] newGrid = new Pixel[height][width];
		for(int i=0; i<height;i++) {
			for(int j=0;j<width;j++) {
				newGrid[i][j] = this.grid[(int) (i*value)][(int) (j*value)];
			}
		}
		System.out.println("------------------------------------------------");
		
		return new PixelGrid(newGrid, height, width, this.h);
	}
	*/
}
