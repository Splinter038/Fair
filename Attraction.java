package fair;

abstract class Attraction extends FairUnit{
	Attraction(int id, String name, double price) {
		super(id, name, price);
	}
	
	public void turnen(){
		System.out.println("You're in an attraction.");
	}


}