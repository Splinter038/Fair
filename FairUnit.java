package fair;

import java.util.ArrayList;

abstract class FairUnit {
	private 		int 	id;	
	private 		String 	name;
	private 		double 	price;
	private 		int 	fairUnitTickets;
	private static 	int 	fairTickets;
	private 		double 	fairUnitSales;
	private static 	double 	fairSales;
	
	FairUnit(int id, String name, double price){
		setId(id);
		setName(name);
		setPrice(price);
		if(id<10)System.out.print(" ");
		System.out.println(id + " " + name + " built.");	// test
	}
	
	public void setName(String name){this.name = name;}
	public String getName(){return this.name;}
	public void setId(int id){this.id = id;}
	public int getId(){return this.id;}
	public void plusTicketsSold(){this.fairUnitTickets++;}
	public int getTicketsSold(){return this.fairUnitTickets;}
	public void setFairUnitSales(){this.fairUnitSales += this.price;}
	public double getFairUnitSales(){return this.fairUnitSales;}
	public void setFairUnitTickets(){this.fairUnitTickets++;}
	public int getFairUnitTickets(){return this.fairUnitTickets;}
	public void setPrice(double price){this.price = price;}
	public double getPrice(){return this.price;}
	public void setFairSales(){FairUnit.fairSales = fairSales + this.price;}
	public static double getFairSales(){return fairSales;}
	public void plusFairTickets(){FairUnit.fairTickets++;}
	public static int getFairTickets(){return fairTickets;}

	public void imIn(){
		if (this instanceof Attraction){
			String price2dec = String.format("%.2f", this.price);
			System.out.print("You're in " + this.getName() + " (€ " + price2dec + "). ");
			((Attraction)this).turnen();
			
		}
		else if (this instanceof Food){
			System.out.println("Having a break at the " + this.getName() + ".");
		}
		else {
			System.out.println("Are you in the Fair at all?");

		}
	}

	public static void showSales(){
		String fS2dec = String.format("%.2f", getFairSales());
		System.out.println("Fair sales: € " + fS2dec + ". ");
	}

	public static void showTickets(){
		System.out.println("Fair tickets sold: " + getFairTickets() + ". ");
	}

	public static void showAllTickets(ArrayList<FairUnit> attractions, ArrayList<FairUnit> foods){
		String line = "*******************************************************************";
		System.out.println(line);
		int enter = 0;
		for(FairUnit attraction : attractions){
			if(enter%2==0)System.out.print("* ");
			else System.out.print("\t");
			System.out.print(attraction.getName() + " tickets: \t ");
			if (attraction.getFairUnitTickets() < 10) System.out.print(" ");
			System.out.print(attraction.getFairUnitTickets() + " ");
			if(enter%2!=0)System.out.println();
			enter++;			
		}
		for(FairUnit food : foods){
			if(enter%2==0)System.out.print("* ");
			else System.out.print("\t");
			System.out.print(food.getName() + " items sold:\t ");
			if (food.getFairUnitTickets() < 10) System.out.print(" ");
			System.out.print(food.getFairUnitTickets() + " ");
			if(enter%2!=0)System.out.println();
			enter++;			
		}
		System.out.println();
		System.out.print("* Total fair tickets: \t\t ");
		if (getFairTickets() < 10) System.out.print(" ");
		System.out.println(getFairTickets() + " ");
		System.out.println(line);
	}
	
	public static void showAllSales(ArrayList<FairUnit> attractions, ArrayList<FairUnit> foods){
		String line = "************************************************************************";
		System.out.println(line);
		int enter0 = 0;
		for(FairUnit attraction : attractions){
			if(enter0%2==0)System.out.print("* ");

			else System.out.print("\t");
			String fUS2dec = String.format("%.2f", attraction.getFairUnitSales());
			System.out.print(attraction.getName() + " sales: \t€ ");
			if (attraction.getFairUnitSales() < 10) System.out.print(" ");
			System.out.print(" " + fUS2dec + " ");
			if(enter0%2!=0)System.out.println();
			enter0++;			
		}
		int enter1 = 0;
		for(FairUnit food : foods){
			if(enter1%2==0)System.out.print("* ");
			else System.out.print("\t");
			String fUS2dec = String.format("%.2f", food.getFairUnitSales());
			System.out.print(food.getName() + " sales: \t€ ");
			if (food.getFairUnitSales() < 10) System.out.print(" ");
			System.out.print(" " + fUS2dec + " ");
			if(enter1%2!=0)System.out.println();
			enter1++;			
		}
		String fS2dec = String.format("%.2f", getFairSales());
		System.out.println();
		System.out.print("* Total fair sales: \t€  ");
		if (getFairSales() < 10) System.out.print(" ");
		System.out.println( fS2dec + ". ");
		System.out.println(line);
	}
	
	public static void showFairUnits(){
		
	}
	
	public static void visit(int inputInt, FairUnit fairunit) {
		fairunit.plusTicketsSold();
		fairunit.setFairUnitSales();

		fairunit.plusFairTickets();
		fairunit.setFairSales();

		fairunit.imIn();
	}
}
