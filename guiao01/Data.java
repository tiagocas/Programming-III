package guiao01;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	Data(int dia, int mes, int ano){
		if(isValid(dia, mes, ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}
	Data(String string) throws Exception{
		String regex = "-";
		String[] split = string.split(regex);
		
		if(split.length == 3) {
			this.mes = Integer.parseInt(split[1]);
			if(Integer.parseInt(split[0]) > 31) {		// inutil e n serve de grande coisa pq pode n ser vdd
				if(isValid(Integer.parseInt(split[2]),Integer.parseInt(split[1]),Integer.parseInt(split[0]))) {
					this.dia = Integer.parseInt(split[2]);
					this.ano = Integer.parseInt(split[0]);
				}
			}
			else {
				if(isValid(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]))) {
					this.dia = Integer.parseInt(split[0]);
					this.ano = Integer.parseInt(split[2]);
				}
			}
		}
		else {
			throw new Exception();
		}
	}
	private boolean isValid(int dia, int mes, int ano) {
		if(dia<=31 && dia>0 && mes>0 && mes<=12 && ano>0) {
			return true;
		}
		return false;
	}
	public String toString(){
		return this.dia + "-" + this.mes + "-" + this.ano;
	}
	public String toString(String sep) {
		String date = this.dia + sep + this.mes + sep + this.ano;
		return date;
	}

}
