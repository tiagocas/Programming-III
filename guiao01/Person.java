package guiao01;

public class Person {
	private String nome;
	private int cc;
	private Date dataNasc;
	private int ccLenght = 8;
	
	Person(String nome, String cc, Date dataNasc) throws Exception{
	    if(!isInteger(cc)) {
	    	throw new Exception();
	    }
	    if(this.ccLenght != cc.length()) {
	    	throw new Exception();
	    }
		this.nome = nome;
		this.cc = Integer.parseInt(cc);
		this.dataNasc = dataNasc;
	}
	public String toString(){
		return "Nome: " + this.nome + "\ncc: " + this.cc + "\nData de Nascimento: " + this.dataNasc.toString();
	}
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) { 
            return false;
        }
    } 
    public int cc() {
    	return this.cc;
    }
    public Date birthday() {
    	return this.dataNasc;
    }
    public String name() {
    	return this.nome;
    }

}
