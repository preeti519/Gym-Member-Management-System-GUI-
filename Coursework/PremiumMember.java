package Coursework;

// Subclass PremiumMember
public class PremiumMember extends GymMember {// PremiumMember class inherits from GymMember
    final double premiumCharge = 50000;// Fixed premium membership charge
    String personalTrainer;// Sets personal trainer name
    boolean isFullPayment;// Tracks if full payment is completed
    double paidAmount;// Stores the total amount paid by the member
    double discountAmount;// Stores the discount amount if applicable
    int membershipFee;

    // Constructor
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;// Sets personal trainer name
        this.isFullPayment = false;// Initially, payment is not completed
        this.paidAmount = 0;// No amount is paid at the start
        this.discountAmount = 0;// No discount at the beginning
    }
    // Getter method for premium charge
    public double getpremiumCharge() {
        return premiumCharge;
    }
    // Getter method for personal trainer
    public String getPersonalTrainer() {
        return personalTrainer;
    }
    // Getter method for full payment status
    public boolean getFullPayment() {
        return isFullPayment;
    }
    // Getter method for the amount paid
    public double getPaidAmount() {
        return paidAmount;
    }
    // Getter method for discount amount
    public double getDiscountAmount() {
        return discountAmount;
    }
    public int getMembershipFee() {
    return membershipFee;  // or whatever variable holds the fee
}

    // Override markAttendance method
    @Override
    public void markAttendance() {
        if (this.activeStatus) {
            this.attendance++;
            this.loyaltyPoints += 10;
        } else {
            System.out.println("Membership is not active. Cannot mark attendance.");
        }
    }

    // Pay the due amount
    public String payDueAmount(double amount) {
        if (this.isFullPayment) {// If payment is already completed
            return "Payment is already completed.";
        }
        if (this.paidAmount + amount > premiumCharge) {
            return "Amount exceeds the due amount.";// If payment exceeds required amount
        }
        
        this.paidAmount += amount;

        if (this.paidAmount >= premiumCharge) {// If full amount is paid
            this.isFullPayment = true;// Marks payment as completed
        }

        double remainingAmount = premiumCharge - this.paidAmount;// Calculates remaining amount
        return "Payment successful. Remaining amount: " + remainingAmount;
    }

    // Calculate discount based on payment status
   // public String calculateDiscount() {
    //this.isFullPayment = true; // Temporary for testing
    //if (this.isFullPayment == true) {
      //  this.discountAmount = premiumCharge * 0.1;
      //  return "Discount calculated: " + discountAmount;
    //} else {
      //  return "No discount available. Payment is not completed.";
    //}
//}
public double calculateDiscount() {
    if (isFullPayment) {
        discountAmount = 0.10 * premiumCharge;
        return discountAmount;
    } else {
        return 0;
    }
}




    // Revert Premium Member
    public void revertPremiumMember() {
        super.resetMember();// Calls parent class method to reset member details
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // Display method override
    @Override
    public void display() {
        super.display();// Calls parent class display method
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);

        if (isFullPayment==true) {// If full payment is completed, show discount
            System.out.println("Discount Amount: " + discountAmount);
        } else {// Otherwise, show the remaining amount
            double remainingAmount = premiumCharge - this.paidAmount;
            System.out.println("Remaining Amount: " + remainingAmount);
        }
    }
    public boolean revertMember(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            return false;
        }
        // Any additional premium member specific checks
        return true;
    }
    public void revert() {
    System.out.println("Member reverted: " + getName());
}




}
