package guiao07;

public class Pixel {
	public byte r;
	public byte g;
	public byte b;
	
	public Pixel(byte r, byte g, byte b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Pixel(Pixel p) {
		this.r = p.r;
		this.g = p.g;
		this.b = p.b;
	}
	
	@Override
	public String toString() {
		return "RGB("+(r & 0xff)+","+(g & 0xff)+","+(b & 0xff)+")";
	}
	
	public Pixel clone() {
		return new Pixel(this);
	}
	/*
	public Pixel clone() throws CloneNotSupportedException {
        return (Pixel) super.clone();
    }*/
}
