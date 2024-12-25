
public class Guests extends Room{
	
	private String firstName;
	private String lastName;
	private int nights;

	public Guests(String roomClass, String description, int roomNum, String bedType, boolean booked, String firstName, String lastName, int nights) {
		super(roomClass, description, roomNum, bedType, booked);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nights = nights;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public int getNights(){
		return nights;
	}
	
	public void setNights(int nights){
		this.nights = nights;
	}
	
	@Override
    public String toString() {
        return (super.toString() + " , firstName: " + firstName + ", lastName: " + lastName + ", nights: " + nights); 
    }
	
}
