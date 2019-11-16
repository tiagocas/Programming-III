package guiao06;

public class PratoVegetariano extends Prato implements Vegetariano {

	public PratoVegetariano(String name) {
		super(name);
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a instanceof Vegetariano) {
			return super.addIngrediente(a);
		}
		return false;
	}

}
