import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public void getMenu() {
		
		// Initialise the choice value with -1. 
		// This is necessary to cover the case that the user will provide a String instead an integer as a first value.
		int choice = -1;
		
	    // Initialise the Operations object in the Menu class in order 
		// to ensure that the generated values for rooms and rates won't be lost.
		Operations ops = new Operations();
		
		System.out.println("****** README ******"
				+ "\nHOW TO USE THE APP"
				+ "\n\nFor smooth operation of the application, please start by selecting options: 1, 2, and 3."
				+ "\n\nIf you don't choose them, there won't be any rooms, room rates or sample guests/reservations to show how the application works."
				+ "\n\nAlternatively, you can choose option 100 that will auto-generate values for all three objects (rooms, rates, and guests)."
				+ "\n\n**************************");
		
    	do {
	    	
	    	try {
		    	System.out.println(
		    			"\n\nChoose a number from the menu:\n"
		    			+ "1: Generate Rooms.\n"
		    			+ "2: Generate Room Rates.\n"
		    			+ "3: Create new reservations.\n"
		    			+ "4: Book Room for one guest.\n"
		    			+ "5: Search guest by 'Last Name'.\n"
		    			+ "6: Reserve a group of available rooms (Please note: no more than 3 per room class).\n"
		    			+ "7: Generate report for total income per room class for all the reserved rooms.\n"
		    			+ "8: Get all the guests sorted alphabetically by their last name.\n"
		    			+ "9: Display total number of rooms per class.\n"
		    			+ "100: Generate default values for rooms, room rates, and guests based on the assessment's table data."
		    			+ "\n0: Exit the application.\n");
				
			    System.out.print("Your input: ");
			    
			    Scanner scan = new Scanner(System.in);
			    // Read the number provided by the user.
			    choice = scan.nextInt();
			    
			    //Close the scanner after the use.
			    //scan.close();
			    //System.out.println("choice: " + choice + "\n");
			    switch(choice){
			    	case 0:
			    		break;
			    	case 1: 
			    		ops.generateRooms();
			        	break;
			        case 2:
			        	ops.generateRoomRates();
			        	break;
			        case 3:
			        	ops.generateGuestReservations();
			        	break;
			        case 4:
			        	boolean isGroup = false;
			        	int roomClass = 0; // Not needed for single guests.
			        	ops.bookGuestRoom(isGroup, roomClass);
			        	break;
			        case 5:
			        	//ops.bookGuestRoom();
			        	ops.searchGuestByLastName();
			        	break;
			        case 6:
			        	ops.bookGroupGuestRooms();
			        	break;
			        case 7:
			        	ops.totalIncomeByClass();
			        	break;
			        case 8:
			        	ops.sortGuestsByLastName();
			        	break;
			        case 9:
			        	ops.totalNumOfRoomsByClass();
			        	break;
			        case 100:
			        	ops.generateRooms();
			        	ops.generateRoomRates();
			        	ops.generateGuestReservations();
			        	break;
			        default:
			        	System.out.println("Invalid option.\n");
			        	break;
			    } // End switch
			    
	    	}catch(InputMismatchException | NumberFormatException ex ) {
	            System.out.println("\nInvalid Input. Please enter an integer.\n");
	        }catch(Exception e) {
	    		 System.out.println("Exception: " + e);
	    	}// End catch.
	    } while (choice != 0);    
		
		System.out.println("\n\nYou have now exited the hotel application.\n----------------------------------------------");
				
	} // End getMenu method.
	
}
