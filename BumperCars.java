package fair;

public class BumperCars extends Attraction{

	BumperCars(int id, String name, double price) {
		super(id, name, price);
	}
	public void turnen(){
		System.out.println("You're bumpin' and rollin' in the Bumperr Cars.");
	}
}
