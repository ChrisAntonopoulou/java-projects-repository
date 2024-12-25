import java.util.Scanner;

public class UserInput {
	
	private Scanner keyboard;
	
	public UserInput() {
		keyboard = new Scanner(System.in);
	}
	
	public int keyboard(String message, String errMessage, int limit) {
		int number = 0;
		String keyboardNum;
		boolean validNum = false;
		
		while(validNum == false) {
			System.out.println(message);
			keyboardNum = keyboard.nextLine();
			
			try {
				if(keyboardNum.matches("^(0+[1-9]|[1-9])[0-9]*$")) { // non zero positive integer
					number = Integer.parseInt(keyboardNum);
					if(number <= limit) validNum = true; // Check that user input is less or equal to limit.
				}else {
					System.out.println(errMessage);
					validNum = false;
				}
				
			} catch (Exception e) {
				System.out.println(errMessage);
			}
			
		}
		
		return number;
	}
	
	public String keyboard(String message, String errMessage) {
		String keyboardString="";
		boolean validString = false;
		
		while(validString == false) {
			try {
				System.out.println(message);
				keyboardString = keyboard.nextLine();
				if(keyboardString.matches("[a-zA-Z ]+")) { // If input doesn't start with number, then accept it.
					validString = true;
				}else {
					System.out.println(errMessage);
					validString = false;
				}
				
			} catch (Exception e) {
				System.out.println(errMessage);
			}
		} // End While.
		return keyboardString;
	}
	
}
