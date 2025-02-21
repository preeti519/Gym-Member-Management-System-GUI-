package Coursework;
//SuperClass GymMember
public abstract class GymMember{
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.loyaltyPoints=0;
        this.activeStatus=false;
        
        
    }
    public abstract void markAttendance();
    
    public void activeMembership(){
        this.activeStatus= true;
    }
    public void deactiveMembership(){
        if (this.activeStatus){
            this.activeStatus= false;
        }
        }
    public void resetMember(){
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
    }
    
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
        
}

    
    
