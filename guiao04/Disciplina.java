package guiao04;
import java.util.ArrayList;


public class Disciplina {
	private String name;
	private String area;
	private int ECTS;
	private Professor prof;
	private ArrayList<Estudante> al;
	
	public Disciplina(String name, String area, int ECTS, Professor prof) {
		this.name = name;
		this.area = area;
		this.ECTS = ECTS;
		this.prof = prof;
		this.al = new ArrayList<>();
	}
	
	public boolean addAluno(Estudante est) {
		if(!this.al.contains(est)) {
			this.al.add(est);
			return this.al.contains(est);
		}
		return false;
	}
	
	public int numAlunos() {
		return this.al.size();
	}
	
	public Estudante[] getAlunos() {
		Estudante[] alunos = new Estudante[al.size()];
		for(int i=0; i<al.size(); i++) {
			alunos[i] = al.get(i);
		}
		return alunos;
	}
	
	public Estudante[] getAlunos(String area) {
		int count = 0, size = 0;
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getClass().getSimpleName().equals(area)) {
				size++;
			}
		}
		Estudante[] alunos = new Estudante[size];
		for(int i=0; i<al.size(); i++) {
			if(al.get(i).getClass().getSimpleName().equals(area)) {
				alunos[count++] = al.get(i);
			}
		}
		return alunos;
	}
	
	public String toString() {
		String content = "Disciplina: " + this.name + " (" + this.al.size() + "ECTS) da Area de " + this.name + "\n";
		content += "Responsavel: " + this.prof.toString() + "\n";
		content += "Existem " + this.al.size() + " alunos inscritos\n";
		return content;
	}
	
	public boolean alunoInscrito(int nMec) {
		for(int i = 0;i<al.size();i++) {
			if(nMec == al.get(i).nMec()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean delAluno(int nMec) {
		for(int i = 0;i<al.size();i++) {
			if(nMec == al.get(i).nMec()) {
				Estudante est = al.get(i);
				al.remove(i);
				return !al.contains(est);
			}
		}
		return false;
	}
	
	
}
