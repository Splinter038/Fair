package fair;

import java.util.ArrayList;
import java.util.Scanner;

public class FancyFair {
	public static ArrayList<FairUnit> attractions = new ArrayList<FairUnit>();
	public static ArrayList<FairUnit> foods = new ArrayList<FairUnit>();

	public static void main(String[] flipflop){
		
		setupFancyFair();
		whereAreYouNow();
	}

	static void setupFancyFair() {
		System.out.println("|||The|||Fantastic|||Fabulous|||Freakin|||Fancy|||Fair|||Is|||Comin|||To|||Town|||");
		try{
			BumperCars bumperCars 		= new BumperCars(1, "Bumperr Cars", 2.50);		Thread.sleep(200);
			SpiderSwirl spiderSwirl 	= new SpiderSwirl(2, "Spider Swirl", 2.25);		Thread.sleep(200);
			MirrorPalace mirrorPalace 	= new MirrorPalace(3, "Mirror Palace", 2.75);	Thread.sleep(200);
			HauntedHouse spukhaus		= new HauntedHouse(4, "Spukhaus" , 3.20);		Thread.sleep(200);
			HawaiiDance hawaiiDance		= new HawaiiDance(5, "Hawaii Dance", 2.90);		Thread.sleep(200);
			PikesPeak pikesPeak			= new PikesPeak(6, "Pikes Peak", 5.0);			Thread.sleep(200);
			LoempiaToko loempiaToko		= new LoempiaToko(11, "Loempia toko", 1.10);	Thread.sleep(200);
			Drinks4Sale drinks4Sale		= new Drinks4Sale(22, "Drinks4Sale", 0.90);		Thread.sleep(200);
			ShoarmaTent shoarmaTent		= new ShoarmaTent(33, "Shoarma tent", 5.90);	Thread.sleep(200);
			OilbollHut oilbollHut		= new OilbollHut(44, "Oilboll Hut", 1.20);		Thread.sleep(200);
			
			attractions.add	(bumperCars);		
			attractions.add	(spiderSwirl);	
			attractions.add	(mirrorPalace);	
			attractions.add	(spukhaus);
			attractions.add	(hawaiiDance);
			attractions.add	(pikesPeak);
			foods.add		(loempiaToko);
			foods.add		(drinks4Sale);
			foods.add		(shoarmaTent);
			foods.add		(oilbollHut	);
		} catch (InterruptedException e) {e.printStackTrace();}			// for thread.sleep
		System.out.println("Typ 'at' for ticket overview; 'as' for sales overview");
		System.out.println("\n|||Welcome|||At|||The|||Fantastic|||Fabulous|||Freakin|||Fancy|||Fair");
	}

	static void whereAreYouNow(){
		while(true){
			System.out.print("Where do you want to go?");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			switch(input){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				int inputInt0 = Integer.parseInt(input);
				FairUnit.visit(inputInt0, attractions.get(inputInt0 - 1));
				break;
			case "11":
			case "22":
			case "33":
			case "44":
				int inputInt1 = (((int)Integer.parseInt(input))/10)-1;
				FairUnit.visit(inputInt1, foods.get(inputInt1));
				break;
			case "t": 
				FairUnit.showTickets();
				break;
			case "at": 
				FairUnit.showAllTickets(attractions, foods);
				break;
			case "as": 
				FairUnit.showAllSales(attractions, foods);
				break;
			case "s": 
				FairUnit.showSales();
				break;
			default:
				System.out.println("Choose other input");
			}
			
		}
		
	}

	static boolean isNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}