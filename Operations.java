import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
	
	// Create a HashMap to store information about rooms.
	private Map<Integer, Room> roomsHashMap = new HashMap<>();
	
	// Create a HashMap to store information about room rates.
	// private Map<Integer, String> roomRatesHashMap = new HashMap<>();
	private Map<String, Double> roomRatesHashMap = new HashMap<>();
	
	// Create a HashMap to store information about guests.
	private Map<Integer, Guests> guestsHashMap = new HashMap<>();
	
	
	// The function below creates new Room based on assessment sample table.
	public void generateRooms() {
		
		String[] standardBedTypeArray = {"Twin", "Double"};
		String[] deluxeBedTypeArray = {"Queen"};
		String[] superiorBedTypeArray = {"Queen", "King"};
		
		Room room;
		
		try {
			for(int i = 1; i<=530; i++) {
				
				// Generate Standard class rooms.
				if(i <= 250) {
					
					Random randomStandard = new Random();
					int selectRandomStandard = randomStandard.nextInt(standardBedTypeArray.length);
					
					room = new Room("Standard", "This is a standard class room", i, standardBedTypeArray[selectRandomStandard], false);
					roomsHashMap.put(room.getRoomNum(), room);
					
				}
				else if(i > 250 && i <= 500) {
					
					Random randomDeluxe = new Random();
					int selectRandomDeluxe = randomDeluxe.nextInt(deluxeBedTypeArray.length);
					
					room = new Room("Deluxe", "This is a deluxe class room", i, deluxeBedTypeArray[selectRandomDeluxe], false);
					roomsHashMap.put(room.getRoomNum(), room);
					
				} else if(i > 500 && i <= 530) {
					
					Random randomSuperior = new Random();
					int selectRandomSuperior = randomSuperior.nextInt(superiorBedTypeArray.length);
					
					room = new Room("Superior", "This is a superior class room", i, superiorBedTypeArray[selectRandomSuperior], false);
					roomsHashMap.put(room.getRoomNum(), room);
					
				} // End If statement.
				
			} // End For Loop.
			
			// Print success message.
			System.out.println("\n\nAll the rooms have been created successfully!\n\n");
			
		}catch(Exception e) {
			System.out.println("Exception found in generateRooms() : " + e);
		}// End catch.
		
		
	} // End createRooms().
	
	
	// The function below creates Room Rates based on values provided on the assessment sample table.
	public void generateRoomRates() {
		
		try {
			// Hardcoded values.
			roomRatesHashMap.put("Standard", 1000.0);
			roomRatesHashMap.put("Deluxe", 1200.0);
			roomRatesHashMap.put("Superior", 1800.0);
			
			System.out.println("\n\nAll the room rates have been created successfully!\n\n");
			
		}catch(Exception e) {
			System.out.println("Exception found in generateRoomRates() : " + e);
		}// End catch.
		
	} // End generateRoomRates().
	
	
	// The function below creates Guests/Reservations based on values provided on the assessment sample table.
	public void generateGuestReservations() {
		
		if (roomsHashMap.size() > 0) {
			Room room = roomsHashMap.get(255);
			room.setBooked(true);
			room.setBedType("Queen");
			Guests guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Qazi", "Zubair", 1);
			guestsHashMap.put(1, guest);
			
			//Duplicate last name for testing purposes for query 5.
			room = roomsHashMap.get(256);
			room.setBooked(true);
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Qazi", "Zubair", 7);
			guestsHashMap.put(7, guest);
			
			room = roomsHashMap.get(501);
			room.setBooked(true);
			room.setBedType("King");
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Oliver", "Barker", 3);
			guestsHashMap.put(2, guest);
			
			room = roomsHashMap.get(30);
			room.setBooked(true);
			room.setBedType("Double");
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Akram", "Khan", 20);
			guestsHashMap.put(3, guest);
			
			room = roomsHashMap.get(45);
			room.setBooked(true);
			room.setBedType("Double");
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Jordan", "Robinson", 14);
			guestsHashMap.put(4, guest);
			
			room = roomsHashMap.get(22);
			room.setBooked(true);
			room.setBedType("Twin");
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Daniel", "Scott", 10);
			guestsHashMap.put(5, guest);
			
			room = roomsHashMap.get(20);
			room.setBooked(true);
			room.setBedType("Double");
			guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), "Alisha", "Aslam", 2);
			guestsHashMap.put(6, guest);
			
			System.out.println("\n\nThe following reservations have been created successfully!\n");
			for (Integer g : guestsHashMap.keySet()) {
				  System.out.println("Reservation details:	" + guestsHashMap.get(g));
			}
		}
		else if (roomsHashMap.size() <= 0) {
			System.out.println("\n\nPlease choose option 1 from the main menu to generate rooms, and then re-select option 3.\n\n");
		}
		
	} // End generateGuestReservations().
	

	public int choiceOfClassDynamic() {
		
		UserInput ui = new UserInput();
		int choiceOfClass = -1;
		String message2 = "Choose a number from the menu:\n"
    			+ "1: Standard.\n"
    			+ "2: Deluxe.\n"
    			+ "3: Superior.\n"
    			//+ "0: Go back.\n"
    			+ "Please choose number of room class: ";
		String errMessage2 = "\nInvalid Input. Please enter an Integer.\n";
		int limit = 3;
		choiceOfClass = ui.keyboard(message2, errMessage2, limit);
		
		return choiceOfClass;
		
	}
	
	// This method returns the choice of bed type for a specified room class.
	public int choiceOfBedTypeDynamic(int classSelection) {
		int bedTypeChoice = -1;
		
		UserInput ui = new UserInput();
		String message2 = "";
		String errMessage2 = "";
		int limit = 0;
		
		if (classSelection == 1) {
			// STANDARD
			message2 = "Choose a bed type (number) from the menu:\n"
	    			+ "1: Twin.\n"
	    			+ "2: Double.\n";
			errMessage2 = "\nInvalid Input.\n";
			limit = 2;
			bedTypeChoice = ui.keyboard(message2, errMessage2, limit);
			return bedTypeChoice;
		}else if(classSelection == 2) {
			// DELUXE
			message2 = "Choose a bed type (number) from the menu:\n"
	    			+ "1: Queen.\n";
			errMessage2 = "\nInvalid Input.\n";
			limit = 1;
			bedTypeChoice = ui.keyboard(message2, errMessage2, limit);
			return bedTypeChoice;
		}else if(classSelection == 3) {
			// SUPERIOR
			message2 = "Choose a bed type (number) from the menu:\n"
	    			+ "1: Queen.\n"
	    			+ "2: King.\n";
			errMessage2 = "\nInvalid Input.\n";
			limit = 2;
			bedTypeChoice = ui.keyboard(message2, errMessage2, limit);
			return bedTypeChoice;
		}
		
		return bedTypeChoice;
	}
	
	// This method gets first name from user.
	public String getGuestFirstName() {
		UserInput ui = new UserInput();
		String firstName = "";
		String message = "Please enter guest's first name: ";
		String errMessage = "\nInvalid Input. Please enter a String.\n";
		firstName = ui.keyboard(message, errMessage);
		
		return firstName;
	}
	
	// This method gets last name from user.
	public String getGuestLastName() {
		UserInput ui = new UserInput();
		String lastName = "";
		String message1 = "Please enter guest's last name: ";
		String errMessage1 = "\nInvalid Input. Please enter a String.\n";
		lastName = ui.keyboard(message1, errMessage1);
		
		return lastName;
	}
	
	// This method gets nights of stay from user.
	public int getGuestNights() {
		UserInput ui = new UserInput();
		int nights;
		String message2 = "Please enter guest's nights of stay: ";
		String errMessage2 = "\nInvalid Input. Please enter an Integer.\n";
		// get nights
		int limitNights = 365;
		nights = ui.keyboard(message2, errMessage2, limitNights);
		
		return nights;
	}
	
	// The function below books a Room for one guest based on values provided by the user.
	public void bookGuestRoom(boolean isGroup, int roomClass) {
		
		if(roomsHashMap.size() > 0) {
			
			int choiceOfClass = -1;
			int choiceOfBedType = -1;
			String firstName = "";
			String lastName = "";
			int nights = -1;
			int roomNumber = -1;
			int roomClassLocal = 0;
			
			if(roomClass == 0) { // Single guests.
				choiceOfClass = choiceOfClassDynamic();
			} else {
				choiceOfClass = roomClass;
			}
			choiceOfBedType = choiceOfBedTypeDynamic(choiceOfClass);
			firstName = getGuestFirstName();
			lastName = getGuestLastName();
			nights = getGuestNights();
			
			// Find an empty room based on user's preferences.
			roomNumber = findEmptyRoom(choiceOfClass, choiceOfBedType);
			
			if (roomNumber != -1 && roomNumber > 0) {
				// Reserve room
				Room room = roomsHashMap.get(roomNumber);
				room.setBooked(true);
				Guests guest = new Guests(room.getRoomClass(), room.getDescription(), room.getRoomNum(), room.getBedType(), room.getBooked(), firstName, lastName, nights);
				guestsHashMap.put(guestsHashMap.size() + 1, guest);
				
				System.out.println("Room " + room.getRoomNum() + " was booked successfully.\n" + room);
				
				// Run the following code only for "single" guests - not for groups.
				if (isGroup == false) {
					// Ask user if they wish to book another room.
					UserInput ui = new UserInput();
					int choiceToContinue = -1;
					String message2 = "\nDo you wish to book another room? "
							+ "\nType 1 to book another room."
							+ "\nType 2 to exit.";
					String errMessage2 = "\nInvalid Input.\n";
					int limit = 2;
					choiceToContinue = ui.keyboard(message2, errMessage2, limit);
					
					if(choiceToContinue == 1) {
						bookGuestRoom(isGroup, roomClassLocal);
					}else if(choiceToContinue == 2) {
						// do nothing. Just exit the method bookGuestRoom()
					}
				}
				else {
					// Do nothing. Just exit the method bookGuestRoom()
				}
				
			} else {
				System.out.println("There are no empty rooms with the specified room class and bed type. Please try again.");
				bookGuestRoom(isGroup, roomClassLocal);
			}
			
		}
		else if (roomsHashMap.size() <= 0) {
			System.out.println("Please initialise rooms by choosing option 1 from the main menu.");
		}
		
	} // End bookGuestRoom().
	
	// This method is looking for a non-booked room based on user's selected room class and bed type.
	public int findEmptyRoom(int choiceOfClass, int choiceOfBedType) {
		int roomNumber = 0;
		boolean roomFound = false;
		
		if(choiceOfClass == 1 && choiceOfBedType == 1) {
			
			// STANDARD & TWIN
			for (Integer room : roomsHashMap.keySet()) {
				//System.out.println("room size: " + roomsHashMap.size());
				//System.out.println("key: " + room +"   ,  value:     " + roomsHashMap.get(room));
				
				String check1 = roomsHashMap.get(room).getRoomClass().toLowerCase();
				String check2 = roomsHashMap.get(room).getBedType().toLowerCase();
				boolean check3 = roomsHashMap.get(room).getBooked();
				
				if((roomFound == false) && (check1.equals("standard")) && (check2.equals("twin")) && (check3 == false)) {
					roomNumber = room;
					//System.out.println("Room Number: " + roomNumber);
					roomFound = true;
				}
				
				if (roomFound == true) {break;} 
				  
			} // End For Loop.
			
		} // End if
		else if(choiceOfClass == 1 && choiceOfBedType == 2) {
			// STANDARD & DOUBLE
			for (Integer room : roomsHashMap.keySet()) {
				//System.out.println("room size: " + roomsHashMap.size());
				//System.out.println("key: " + room +"   ,  value:     " + roomsHashMap.get(room));
				
				String check1 = roomsHashMap.get(room).getRoomClass().toLowerCase();
				String check2 = roomsHashMap.get(room).getBedType().toLowerCase();
				boolean check3 = roomsHashMap.get(room).getBooked();
				
				if((roomFound == false) && (check1.equals("standard")) && (check2.equals("double")) && (check3 == false)) {
					roomNumber = room;
					//System.out.println("Room Number: " + roomNumber);
					roomFound = true;
				}
				
				if (roomFound == true) {break;} 
				  
			} // End For Loop.
		} // end if
		else if(choiceOfClass == 2 && choiceOfBedType == 1) {
			// DELUXE & QUEEN
			for (Integer room : roomsHashMap.keySet()) {
				//System.out.println("room size: " + roomsHashMap.size());
				//System.out.println("key: " + room +"   ,  value:     " + roomsHashMap.get(room));
				
				String check1 = roomsHashMap.get(room).getRoomClass().toLowerCase();
				String check2 = roomsHashMap.get(room).getBedType().toLowerCase();
				boolean check3 = roomsHashMap.get(room).getBooked();
				
				if((roomFound == false) && (check1.equals("deluxe")) && (check2.equals("queen")) && (check3 == false)) {
					roomNumber = room;
					//System.out.println("Room Number: " + roomNumber);
					roomFound = true;
				}
				
				if (roomFound == true) {break;} 
				  
			} // End For Loop.
		} // end if
		else if(choiceOfClass == 3 && choiceOfBedType == 1) {
			// SUPERIOR & QUEEN
			for (Integer room : roomsHashMap.keySet()) {
				//System.out.println("room size: " + roomsHashMap.size());
				//System.out.println("key: " + room +"   ,  value:     " + roomsHashMap.get(room));
				
				String check1 = roomsHashMap.get(room).getRoomClass().toLowerCase();
				String check2 = roomsHashMap.get(room).getBedType().toLowerCase();
				boolean check3 = roomsHashMap.get(room).getBooked();
				
				if((roomFound == false) && (check1.equals("superior")) && (check2.equals("queen")) && (check3 == false)) {
					roomNumber = room;
					//System.out.println("Room Number: " + roomNumber);
					roomFound = true;
				}
				
				if (roomFound == true) {break;} 
				  
			} // End For Loop.
		} // end if
		else if(choiceOfClass == 3 && choiceOfBedType == 2) {
			// SUPERIOR & QUEEN
			for (Integer room : roomsHashMap.keySet()) {
				//System.out.println("room size: " + roomsHashMap.size());
				//System.out.println("key: " + room +"   ,  value:     " + roomsHashMap.get(room));
				
				String check1 = roomsHashMap.get(room).getRoomClass().toLowerCase();
				String check2 = roomsHashMap.get(room).getBedType().toLowerCase();
				boolean check3 = roomsHashMap.get(room).getBooked();
				
				if((roomFound == false) && (check1.equals("superior")) && (check2.equals("king")) && (check3 == false)) {
					roomNumber = room;
					//System.out.println("Room Number: " + roomNumber);
					roomFound = true;
				}
				
				if (roomFound == true) {break;} 
				  
			} // End For Loop.
		} // end if
		else {
			System.out.println("Something went wrong. Please try again.");
		}
		
		return roomNumber;
	} // End findEmptyRoom
	
	
	// This function is getting a last name as input and prints all the guest's information
	public void searchGuestByLastName() {
		if(guestsHashMap.size() > 0) {
			String lastName = "";
			lastName = getGuestLastName();
			boolean guestFound = false;
			for (Integer g : guestsHashMap.keySet()) {
				
				if(lastName.toLowerCase().equals(guestsHashMap.get(g).getLastName().toLowerCase())) {
					System.out.println("\nGuest : " + lastName +" has the following booking(s): \n" + guestsHashMap.get(g));
					guestFound = true;
				}
				
			} // End For Loop.
			if (guestFound == false) {
				System.out.println("Guest: '" + lastName + "' doesn't exist on the system.");
			}
		}
		else if(guestsHashMap.size() <= 0) {
			System.out.println("Please add guests before searching for guests by their last name or choose 100 to auto-generate data for the application.");
		}
		
	} // End searchGuestByLastName()
	
	
	// This method reserves rooms for group of guests. (Limitation of 3 rooms per room class)
	public void bookGroupGuestRooms() {
		
		/*If number of rooms to be booked is greater than 3, I need to check:
		*
		* - can only book 9 rooms overall because of the 3 room classes.
		* - only 3 rooms per class e.g. 3 rooms for standard, 3 rooms for deluxe, and 3 rooms for superior.
		* - the rooms are available for booking (isBooked = false)
		* 
		*/
		
		if(roomsHashMap.size() > 0) {
			
			UserInput ui = new UserInput();
			boolean isGroup = true;
			int rooms;
			
			int availableRooms = getAvailableRooms();
			// Count available rooms.
			
			String message2 = "Please enter number of rooms to be booked (max 9 rooms per booking): ";
			String errMessage2 = "\nInvalid Input. Please enter an Integer.\n";
			
			// get max rooms
			int limitRooms = availableRooms;
			if (limitRooms > 9) limitRooms = 9; // 9 is the maximum number of rooms because we only have 3 room classes.
			rooms = ui.keyboard(message2, errMessage2, limitRooms);
						
			if(rooms <= 3) {
				int roomClass = choiceOfClassDynamic();
				
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass = getAvailableRoomsPerClass(roomClass);
				
				if(rooms <= availRoomsByClass) {
					for(int i = 1; i <= rooms; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass);
					}
				}
				
			} else if (rooms > 3 && rooms <= 6) {
				// ROOM CLASS 1
				int roomClass1 = choiceOfClassDynamic();
				
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass1 = getAvailableRoomsPerClass(roomClass1);
				
				if(rooms <= availRoomsByClass1) {
					for(int i = 1; i <= 3; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass1);
					}
				}
					
				// ROOM CLASS 2
				System.out.println("Please choose another room class for the remaining rooms.\n");
				int roomClass2 = 0;
				while(roomClass2 == roomClass1 || roomClass2 == 0) {
					roomClass2 = choiceOfClassDynamic();
				}
	
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass2 = getAvailableRoomsPerClass(roomClass2);
				if(rooms <= availRoomsByClass2) {
					for(int i = 4; i <= rooms; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass2);
					}
				}
			}
			else if(rooms > 6 && rooms <= 9) {
				
				// ROOM CLASS 1
				int roomClass1 = choiceOfClassDynamic();
				
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass1 = getAvailableRoomsPerClass(roomClass1);
				
				if(rooms <= availRoomsByClass1) {
					for(int i = 1; i <= 3; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass1);
					}
				}
					
				// ROOM CLASS 2
				System.out.println("Please choose another room class for the remaining rooms.\n");
				int roomClass2 = 0;
				while(roomClass2 == roomClass1 || roomClass2 == 0) {
					roomClass2 = choiceOfClassDynamic();
				}
	
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass2 = getAvailableRoomsPerClass(roomClass2);
				if(rooms <= availRoomsByClass2) {
					for(int i = 4; i <= rooms; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass2);
					}
				}
				
				// ROOM CLASS 3
				System.out.println("Please choose another room class for the remaining rooms.\n");
				int roomClass3 = 0;
				while(roomClass3 == roomClass1 || roomClass3 == roomClass2 || roomClass3 == 0) {
					roomClass3 = choiceOfClassDynamic();
				}
	
				// check if there are 3 available rooms for the selected room class.
				int availRoomsByClass3 = getAvailableRoomsPerClass(roomClass3);
				if(rooms <= availRoomsByClass3) {
					for(int i = 7; i <= rooms; i++) {
						System.out.println("\nGuest #"+i);
						bookGuestRoom(isGroup, roomClass3);
					}
				}
			
			}
		}
		else if (roomsHashMap.size() <= 0) {
			System.out.println("Please add rooms before you try to book rooms for guests. Choose option 1 or 100 from the main menu to generate rooms.");
		}
		
	} // End bookGroupGuestRooms()
	
	// This method returns the sum of all the available rooms for all the room classes.
	public int getAvailableRooms() {
		int availableRooms = 0;
		// Count available rooms.
		for (Integer r : roomsHashMap.keySet()) {
			if(roomsHashMap.get(r).getBooked() == false) availableRooms ++;
		}
		return availableRooms;
	}
	
	// This method returns the sum of available rooms per room class.
	public int getAvailableRoomsPerClass(int roomClass) {
		int availableRooms = 0;
		// Count available rooms.
		for (Integer r : roomsHashMap.keySet()) {
			if(roomClass == 1) {
				if(roomsHashMap.get(r).getBooked() == false && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("standard")) availableRooms ++;
			} 
			else if(roomClass == 2) {
				if(roomsHashMap.get(r).getBooked() == false && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("deluxe")) availableRooms ++;
			}
			else if(roomClass == 3) {
				if(roomsHashMap.get(r).getBooked() == false && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("superior")) availableRooms ++;
			}
			else {
				// do nothing.
			}
			
		}
		return availableRooms;
	}
	
	// This method returns the sum of available rooms per room class.
	public int getReservedRoomsPerClass(int roomClass) {
		int availableRooms = 0;
		// Count available rooms.
		for (Integer r : roomsHashMap.keySet()) {
			if(roomClass == 1) {
				if(roomsHashMap.get(r).getBooked() == true && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("standard")) availableRooms ++;
			} 
			else if(roomClass == 2) {
				if(roomsHashMap.get(r).getBooked() == true && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("deluxe")) availableRooms ++;
			}
			else if(roomClass == 3) {
				if(roomsHashMap.get(r).getBooked() == true && roomsHashMap.get(r).getRoomClass().toLowerCase().equals("superior")) availableRooms ++;
			}
			else {
				// do nothing.
			}
			
		}
		return availableRooms;
	}
	
	
	// This method calculates the total income per class for all reserved rooms.
	public void totalIncomeByClass() {
		
		if(roomsHashMap.size() > 0 && roomRatesHashMap.size() > 0) {
			
			double totalIncomeStandardRooms = 0.0;
			double totalIncomeDeluxeRooms = 0.0;
			double totalIncomeSuperiorRooms = 0.0;
			
			int resStandardRooms = getReservedRoomsPerClass(1); // 1 = Standard
			int resDeluxeRooms = getReservedRoomsPerClass(2); // 2 = Deluxe
			int resSuperiorRooms = getReservedRoomsPerClass(3); // 3 = Superior
			int totalResRooms = resDeluxeRooms + resStandardRooms + resSuperiorRooms;
			
			double standardRate = 0.0;
			double deluxeRate = 0.0;
			double superiorRate = 0.0;
			
			// rates per room class
			for (String r : roomRatesHashMap.keySet()) {
				System.out.println("Room Class: " + r +"   ,  Room Rate:     " + roomRatesHashMap.get(r));
				
				if(r.toLowerCase().equals("standard")) {
					standardRate = roomRatesHashMap.get(r);
				}
				else if(r.toLowerCase().equals("deluxe")) {
					deluxeRate = roomRatesHashMap.get(r);
				}
				else if(r.toLowerCase().equals("superior")) {
					superiorRate = roomRatesHashMap.get(r);
				}
			} // End For Loop.
			
			// Calculate total income per room class.
			totalIncomeStandardRooms = standardRate * resStandardRooms;
			totalIncomeDeluxeRooms = deluxeRate * resDeluxeRooms;
			totalIncomeSuperiorRooms = superiorRate * resSuperiorRooms;
			double totalIncome = totalIncomeDeluxeRooms + totalIncomeStandardRooms + totalIncomeSuperiorRooms;
			
			
			// Print the values on a table using printf ASCII
			/*
			 * Reference: https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
			 * 
			 * */
			System.out.printf("----------------------------------------------%n");
			System.out.printf("       Total Income For Reserved Rooms        %n");
			System.out.printf("              (per room class)                %n");
	
			System.out.printf("----------------------------------------------%n");
			System.out.printf("| %-12s | %-12s | %-12s |%n", "CLASS", "No #Rooms", "Total Income"); // %-12s o allocate 12 spaces for text String display. The minus signs forces left justification.
			System.out.printf("----------------------------------------------%n");
			
			
			System.out.printf("| %-12s | %-12s | %-12s |%n", "Standard", resStandardRooms, totalIncomeStandardRooms);
			System.out.printf("| %-12s | %-12s | %-12s |%n", "Deluxe", resDeluxeRooms, totalIncomeDeluxeRooms);
			System.out.printf("| %-12s | %-12s | %-12s |%n", "Superior", resSuperiorRooms, totalIncomeSuperiorRooms);
			
			System.out.printf("----------------------------------------------%n");
			System.out.printf("----------------------------------------------%n");
					
			System.out.printf("| %-12s | %-12s | %-12s |%n", "ALL", totalResRooms, totalIncome);
			
			System.out.printf("----------------------------------------------%n");
			
			
			 if (totalResRooms == 0) {
				System.out.println("\nThere are no guests!");
			}
		
		} // End if hashMap size > 0.
		else if (roomRatesHashMap.size() <= 0) {
			System.out.println("\nPlease generate Room Rates by selecting option 2 from the main menu.");
		}
		else if (roomsHashMap.size() <= 0 ) {
			System.out.println("\n***Please make sure to add rooms to use this function. Select 1 or 100from the main menu to auto-generate data for rooms.***");
		}
		
	} // End totalIncomeByClass()
	
	// The following method is used to sort guests by their last name.
	public void sortGuestsByLastName() {
		
		/*
		 * Resource: https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java
		 * 
		 * Resource: https://www.java67.com/2014/11/java-8-comparator-example-using-lambda-expression.html
		 * 
		 * Resource: https://www.java67.com/2015/01/how-to-sort-hashmap-in-java-based-on.html#:~:text=In%20order%20to%20sort%20HashMap,passing%20your%20customized%20value%20comparator.
		 * 
		 * Time Complexity: O(n log(n))
		 * Auxiliary Space: O(1)
		 * 
		 * */
		
		if(guestsHashMap.size() > 0) {
			
			// Create a custom comparator "compareByLastName" that compares two entries based on values.
			Comparator<Guests> compareByLastName = (Guests obj1, Guests obj2) -> obj1.getLastName().compareTo(obj2.getLastName());
			
			// Create a LinkedHashMap "sortedGuestsMap" and add the sorted entries.
	        LinkedHashMap<Integer, Guests> sortedGuestsMap = guestsHashMap.entrySet().stream()
	                .sorted(Map.Entry.<Integer, Guests>comparingByValue(compareByLastName))
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	        
	        //Print the sorted hashmap 
	        Set set = sortedGuestsMap.entrySet();
	        Iterator iterator = set.iterator();
	        
	        System.out.printf("---------------------------------------------------------------------------------------------------------%n");
			System.out.printf("                    Guests                    %n");
			System.out.printf("          (ordered alphabetically)            %n");

			System.out.printf("---------------------------------------------------------------------------------------------------------%n");
			System.out.printf("| %-15s | %-15s | %-14s | %-14s | %-14s | %-14s |%n", "Last Name", "First Name", "Nights", "No #Room", "Class", "Bed Type"); // %-12s o allocate 12 spaces for text String display. The minus signs forces left justification.
			System.out.printf("---------------------------------------------------------------------------------------------------------%n");
	        while (iterator.hasNext()) {
	            Map.Entry mapEntry = (Map.Entry) iterator.next();
	            
	    		System.out.printf("| %-15s | %-15s | %-14s | %-14s | %-14s | %-14s |%n", guestsHashMap.get(mapEntry.getKey()).getLastName(), guestsHashMap.get(mapEntry.getKey()).getFirstName(), guestsHashMap.get(mapEntry.getKey()).getNights(), guestsHashMap.get(mapEntry.getKey()).getRoomNum(), guestsHashMap.get(mapEntry.getKey()).getRoomClass(), guestsHashMap.get(mapEntry.getKey()).getBedType());
	    		
	        }
	        System.out.printf("---------------------------------------------------------------------------------------------------------%n");
	        
		}
		else if(guestsHashMap.size() <= 0) {
			System.out.println("\n***There are no guests on the list. Please choose option 3 or 100 to create guests.***");
		}
        
	} // End of sortGuestsByLastName()
	
	
	// This method returns total num of rooms per class.
	public void totalNumOfRoomsByClass() {
		if(roomsHashMap.size() <= 0) {
			System.out.println("No rooms have been created. Please choose either options 1, 2, and 3, or choose option 100 to auto-generate values.");
		}else if(roomsHashMap.size() > 0) {
			// User input for class.
			int choiceOfClass = choiceOfClassDynamic();
			
			// Get reserved and available rooms per class
			int resRoomsByClass = getReservedRoomsPerClass(choiceOfClass);
			int availRoomsByClass = getAvailableRoomsPerClass(choiceOfClass);
			int totalRoomsByClass = resRoomsByClass + availRoomsByClass;
			
			
			System.out.printf("--------------------------------------------------------------------------------------------%n");
			System.out.printf("                                           Rooms                                            %n");
			System.out.printf("                                         (By Class)                                         %n");
	
			System.out.printf("--------------------------------------------------------------------------------------------%n");
			System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", "Class", "No #Reserved Rooms", "No #Available Rooms", "Total #Rooms"); // %-12s o allocate 12 spaces for text String display. The minus signs forces left justification.
			System.out.printf("--------------------------------------------------------------------------------------------%n");
			
			System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", getRoomClassName(choiceOfClass), resRoomsByClass, availRoomsByClass, totalRoomsByClass);
			
			System.out.printf("--------------------------------------------------------------------------------------------%n");
		}
	} // End totalNumOfRoomsByClass()
	
	// This method returns the room class name based on the room class number. (1 = Standard, 2 = Deluxe, 3 = Superior)
	public String getRoomClassName(int roomClass) {
		
		String roomClassString = "";
		
		if(roomClass == 1) {
			roomClassString = "Standard";
			return roomClassString;
		}
		else if(roomClass == 2) {
			roomClassString = "Deluxe";
			return roomClassString;
		}
		else if(roomClass == 3) {
			roomClassString = "Superior";
			return roomClassString;
		} 
		else {
			return roomClassString;
		}
		
	} // End getRoomClassName()
	
}
