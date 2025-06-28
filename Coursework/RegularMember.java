package Coursework;
// Subclass RegularMember
public class RegularMember extends GymMember {
    private final int attendanceLimit = 30;//Maximum attendance limit for regular members
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor to initialize RegularMember object
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    // Accessor Methods (Fixed Naming Conventions)
    public String getRemovalReason() {
        return removalReason;
    }

    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    public boolean getEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    // Implement abstract method markAttendance()
    @Override
    public void markAttendance() {
        if (this.activeStatus) {// Check if the membership is active before marking attendance
            this.attendance++; // Increment attendance
            this.loyaltyPoints += 5; // Increase loyalty points by 5
            // Check if attendance limit is reached and mark member as eligible for an upgrade
            if (this.attendance >= attendanceLimit && !this.isEligibleForUpgrade) {
                this.isEligibleForUpgrade = true;
            }
        } else {
            // Display message if membership is not active
            System.out.println("Membership is not active. Cannot mark attendance.");
        }
    }
    public String upgradePlan(String plan) {
    //  Check if the member is active instead of using isEligibleForUpgrade
    if (!getActiveStatus()) {
        return "Membership is not active. Cannot upgrade plan.";
    }

    // Get the price of the new plan
    double newPrice = getPlanPrice(plan);

    // If an invalid plan is provided, return an error message
    if (newPrice == -1) {
        return "Invalid plan selected.";
    }

    // Check if the new plan is the same as the current plan
    if (this.plan.equalsIgnoreCase(plan)) {
        return "You are already on the " + plan + " plan.";
    }

    // Update the plan and its price
    this.plan = plan;
    this.price = newPrice;

    // Return success message
    return "Plan upgraded to " + plan + " successfully.";
}

    // Method to get the price of a provided plan using switch statement
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {// Convert input to lowercase for case-insensitive comparison
            case "basic":
                return 6500;// Return price for the basic plan
            case "standard":
                return 12500;// Return price for the standard plan
            case "deluxe":
                return 18500;// Return price for the deluxe plan
            default:
                return -1; // Return -1 for invalid plans
        }
    }

    
    

    // Method to revert regular member
    public void revertRegularMember(String removalReason) {
        super.resetMember();// Call resetMember() from GymMember to reset member details
        this.isEligibleForUpgrade = false;// Reset eligibility status
        this.plan = "basic";// Reset to the basic plan
        this.price = 6500;// Reset the price to basic plan price
        this.removalReason = removalReason;// Store the reason for removal
    }

    // Display method override
    @Override
    public void display() {
        super.display();// Call the parent class display method to show common details
        System.out.println("Plan: " + plan);// Display the membership plan
        System.out.println("Price: " + price);// Display the plan price
        // If the removal reason is not empty, display it
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
    public boolean revertMember(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            return false;
        }
        // Any additional premium member specific checks
        return true;
    }
    
    
}