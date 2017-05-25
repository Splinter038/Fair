package fair;

public class Drinks4Sale extends Food {

	Drinks4Sale(int id, String name, double price) {
		super(id, name, price);
	}
	
	public static void turnen(){
		System.out.println("Here you are, your drink.");
	}
}
