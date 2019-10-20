package guiao04;
import java.util.ArrayList;

public class ColecaoFiguras {
	private double maxArea;
	private double sumArea;
	private ArrayList<Figura> figures;
	
	public ColecaoFiguras(double maxArea) {
		figures = new ArrayList<Figura>();
		this.maxArea = maxArea;
		this.sumArea = 0;
	}
	
	public boolean addFigura(Figura fig) {
		if(fig.area() + this.sumArea <= maxArea) {
			figures.add(fig);
			if(figures.contains(fig)) {
				this.sumArea += fig.area();
				return true;
			}
		}
		return false;
	}
	
	public boolean delFigura(Figura f) {
		if(figures.contains(f)) {
			Figura fAux = f;
			figures.remove(f);
			this.sumArea -= fAux.area();
			return figures.contains(fAux);
		}
		return false;
	}
	
	public boolean exists(Figura f) {
		return figures.contains(f);
	}
	
	public String toString() {
		return "Area maxima: " + this.maxArea + ", Area usada: " + this.sumArea;
	}
	
	public Figura[] getFiguras() {
		Figura[] f = new Figura[figures.size()];
		for(int i=0;i < figures.size(); i++) {
			f[i] = figures.get(i);
		}
		return f;
	}
	
	public Ponto[] getCentros() {
		Ponto[] p = new Ponto[figures.size()];
		for(int i=0;i < figures.size(); i++) {
			p[i] = figures.get(i).middle();
		}
		return p;
	}
	
	public double areaTotal() {
		return sumArea;
	}
}
