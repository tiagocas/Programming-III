package guiao05;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import guiao05_ex2.StringFormat;

public class Person {
	private String nome;
	private int cc;
	private Date dataNasc;
	private int ccLenght = 8;
	
	Person(String nome, String cc, String date) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.dataNasc = dateFormat.parse(date);
		}
		catch(ParseException e) {
			try {
				dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				this.dataNasc = dateFormat.parse(date);
			}
			catch(ParseException e2) {
				System.out.println("Objeto nao reconhecido por causa da data");
			}
		}
	   /* if(!isInteger(cc)) {
	    	throw new Exception();
	    }*/
		/*
	    if(this.ccLenght != cc.length()) {
	    	throw new Exception("cc length tem q ser 8");
	    }*/
		this.nome = nome;
		this.cc = Integer.parseInt(cc);
	}
	public String toString(){
		return "Nome: " + this.nome + "\ncc: " + this.cc + "\nData de Nascimento: " + this.getDateUTC();
	}
	
	public String toString(String sep){
		return this.nome + sep + this.cc + sep + this.getDateUTC();
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
    
    public boolean equals(Person p) {
    	return p.name().equals(this.name()) && p.cc() == (this.cc()) && p.getDate().equals(this.getDate());
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
    
    public Date getDate() {
		return this.dataNasc;
	}
	
	public String getDateUTC() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		return dateformat.format(this.dataNasc);
	}

}
