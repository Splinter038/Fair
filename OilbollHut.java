package fair;

public class OilbollHut extends Food {

	OilbollHut(int id, String name, double price) {
		super(id, name, price);
	}
	public void turnen(){
		System.out.println("Here's a tasty oil ball for you!");
	}
}
