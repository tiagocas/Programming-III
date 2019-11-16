package guiao06;

public class PratoDieta extends Prato {
	private double maxCalories;
	private double calories;
	
	public PratoDieta(String name, double maxCalories) {
		super(name);
		this.maxCalories = maxCalories;
	}
	
	public boolean addIngrediente(Alimento a) {
		if(a.getCalories() + this.calories > this.maxCalories) {
			return false;
		}
		return super.addIngrediente(a);
	}
	
}
