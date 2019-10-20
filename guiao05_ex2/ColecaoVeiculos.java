package guiao05_ex2;

import java.util.ArrayList;

public class ColecaoVeiculos {
	private ArrayList<Veiculo> veiculos;
	private int max;
	private int sum;
	
	public ColecaoVeiculos(int max) {
		veiculos = new ArrayList<Veiculo>();
		this.max = max;
		this.sum = 0;
	}
	
	public boolean addVeiculo(Veiculo v) {
		if(this.max > this.sum) {
			veiculos.add(v);
			if(veiculos.contains(v)) {
				this.sum++;
				return true;
			}
		}
		System.out.println("Espaco para Veiculos totalmente ocupado");
		return false;
	}
	
	public boolean deleteVeiculo(Veiculo v) {
		if(veiculos.contains(v)) {
			Veiculo fAux = v;
			veiculos.remove(v);
			this.sum--;
			return veiculos.contains(fAux);
		}
		return false;
	}
	
	public boolean exists(Veiculo v) {
		return veiculos.contains(v);
	}
	
	public int count() {
		return this.veiculos.size();
	}
	
	public String toString() {
		String content = "";
		Veiculo[] vs = this.getVeiculos();
		int count = 0;
		for(int i=0;i<vs.length;i++) {
			count = i + 1;
			content += "Veiculo " + count + ":\n";
			content += vs[i].toString() + "\n\n";
		}
		return content;
	}
	
	public Veiculo[] getVeiculos() {
		Veiculo[] v = new Veiculo[veiculos.size()];
		for(int i=0;i < veiculos.size(); i++) {
			v[i] = veiculos.get(i);
		}
		return v;
	}
	
	
}
