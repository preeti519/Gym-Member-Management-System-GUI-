package Coursework;
// SuperClass GymMember
// Abstract class representing a gym member
public abstract class GymMember {
    // Protected attributes to store member details
    protected int id;// Unique ID for the gym member
    protected String name;// Name of the gym member
    protected String location;// Address or location of the member
    protected String phone;// Contact phone number
    protected String email;// Email address of the member
    protected String gender;// Gender of the member
    protected String DOB;// Date of birth of the member
    protected String membershipStartDate;// The date when membership started
    protected int attendance;// Number of times the member attended the gym
    protected double loyaltyPoints;// Reward points for the member
    protected String plan;
    protected boolean isFullPayment;
    protected int price;
    protected double DiscountAmount;
    private double NetAmountPaid;
    protected boolean activeStatus; // Status to check if the membership is active or not
    
    
    // Constructor to initialize a gym member's details
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;  // Initialize attendance to 0
        this.loyaltyPoints = 0;// Loyalty points start from 0
        this.activeStatus = false;// Membership is inactive by default
    }
     // Accessor methods (getters) for all attributes
    public int getId() {
        return this.id;// Returns member ID
    }
    public String getPlan(){
        return this .plan;
    }
    public double getDiscountAmount() {
    return DiscountAmount;
    }

    public String getName() {
        return this.name;// Returns member name
      }

    public String getLocation() {
        return this.location;// Returns location
    }
    public double getPrice(){
        return this. price;
    }

    public String getPhone() {
        return this.phone;// Returns phone number
    }
    public boolean isFullPayment() {
    return isFullPayment;
    }

    public String getEmail() {
        return this.email;// Returns email address
    }
    public double netAmountPaid(){
        return price - DiscountAmount;
    }

    public String getGender() {
        return this.gender;// Returns gender
    }

    public String getDOB() {
        return this.DOB;// Returns date of birth
    }

    public String getMembershipStartDate() {
        return this.membershipStartDate;// Returns membership start date
    }

    public int getAttendance() {
        return this.attendance;// Returns number of attendances
    }

    public double getLoyaltyPoints() {
        return this.loyaltyPoints;// Returns loyalty points earned
    }

    public boolean getActiveStatus() {
        return this.activeStatus;// Returns whether membership is active or not
    }
    // Abstract method to be implemented by subclasses
    public abstract void markAttendance();
    // Activate membership
    public void activateMembership() {
        this.activeStatus = true;// Set membership status to active
    }
    // Deactivate membership (only if it's active)
    public void deactivateMembership() {
        if (this.activeStatus) {// Check if membership is active
            this.activeStatus = false;// Set membership status to inactive
        }
    }
    
    // Reset member details
    public void resetMember() {
        this.activeStatus = false;// Deactivate membership
        this.attendance = 0;// Reset attendance count
        this.loyaltyPoints = 0;// Reset loyalty points
    }

    // Display member details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
    public String getDisplayInfo() {
        return String.format(
            "ID: %d\nName: %s\nLocation: %s\nPhone: %s\nEmail: %s\nGender: %s\nDOB: %s\nMembership Start: %s\nActive: %s",
            id, name, location, phone, email, gender, DOB, membershipStartDate, activeStatus
        );
    }
    //revert a member
    public abstract boolean revertMember(String reason);

}