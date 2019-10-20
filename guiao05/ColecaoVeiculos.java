package guiao05;
import java.util.ArrayList;

public class ColecaoVeiculos {
	private ArrayList<IVeiculo> veiculos;
	private int max;
	private int sum;
	
	public ColecaoVeiculos(int max) {
		veiculos = new ArrayList<IVeiculo>();
		this.max = max;
		this.sum = 0;
	}
	
	public boolean addVeiculo(IVeiculo v) {
		if(this.max > this.sum) {
			veiculos.add(v);
			if(veiculos.contains(v)) {
				this.sum++;
				return true;
			}
		}
		return false;
	}
	
	
}
