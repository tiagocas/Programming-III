package guiao03;

public class Ex3_3 {

	public static void main(String[] args) {
		
		Driver d1 = new Driver("Tiago", "A");
		Driver d2 = new Driver("Filipe", "B");
		Driver d3 = new Driver("Pedro", "C");
		
			//	LigthCars
		
		LightCar lc1 = new LightCar("black light car", 120, 750, 2, 1300, d1);
		System.out.println(lc1.toString());
		
		LightCar lc2 = new LightCar("red light car", 300, 1250, 4, 1900, d2);
		System.out.println(lc2.toString());
		
		LightCar lc3 = new LightCar(lc1);
		System.out.println(lc3.toString());
		
		System.out.println("lc1 == lc3 -> " + lc1.equals(lc3));		// TRUE
		System.out.println("lc2 == lc3 -> " + lc2.equals(lc3));		// FALSE
		
			//	Motorcycles
		
		Motorcycle m1 = new Motorcycle("black motorcycle", 70, 120, 1, 230, d2);
		System.out.println(m1.toString());
		
		Motorcycle m2 = new Motorcycle("red motorcycle", 80, 125, 1, 190, d1);
		System.out.println(m2.toString());
		
		Motorcycle m3 = new Motorcycle(m1);
		System.out.println(m3.toString());
		
		m3.setDriver(d1);		// change driver
		
		System.out.println("m1 == m3 -> " + m1.equals(m3));		// FALSE
		System.out.println("m2 == m3 -> " + m2.equals(m3));		// FALSE
		
			//	HeavyTrucks
		
		HeavyTruck ht1 = new HeavyTruck("black heavy truck", 800, 7000, 3, 6500, d3);
		System.out.println(ht1.toString());
		
		HeavyTruck ht2 = new HeavyTruck("red heavy truck", 1200, 7500, 4, 7250, d2);
		System.out.println(ht2.toString());
		
		HeavyTruck ht3 = new HeavyTruck(ht1);
		System.out.println(ht3.toString());
		
		System.out.println("ht1 == ht3 -> " + ht1.equals(ht3));		// TRUE
		System.out.println("ht2 == ht3 -> " + ht2.equals(ht3));		// FALSE
		
			//	Buses
		
		Bus b1 = new Bus("black bus", 500, 3500, 25, 5000, d1);
		System.out.println(b1.toString());
		
		Bus b2 = new Bus("red bus", 700, 5000, 32, 6050, d3);
		System.out.println(b2.toString());
		
		Bus b3 = new Bus(b1);
		System.out.println(b3.toString());
		
		System.out.println("b1 == 3 -> " + b1.equals(b3));		// TRUE
		System.out.println("b2 == 3 -> " + b2.equals(b3));		// FALSE
		
	}

}
