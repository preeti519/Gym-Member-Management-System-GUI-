package Coursework;
//Subclass PremiumMember
public class PremiumMember extends GymMember{
     final double premiumCharge=50000;
     String personalTrainer;
     boolean isFullPayment;
     double paidAmount;
     double discountAmount;
    
    public PremiumMember (int id, String name,String location, String phone,String email, String gender, String DOB, String membershipStartDate,String personalTrainer){
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.personalTrainer=personalTrainer;
        this.isFullPayment=false;
        this.paidAmount=0;
        this.discountAmount=0;
        
    }
    @Override
    public void markAttendance(){
        if(this.activeStatus){
            this.attendance++;
            this.loyaltyPoints+=10;
        }else{
            System.out.println("Membership is not active. Cannot mark attendance");
        }
    }
    public String paidDueAmount(double amount){
        if(this.isFullPayment){
            return "Payment is already completed";
        }
        if(amount> premiumCharge-paidAmount){
            return "Amount exceeds the due amount";
            }
            this.paidAmount+=amount;
            if(this.paidAmount >= premiumCharge){
                this.isFullPayment=true;
            }
            return "Payment successful. Remaining amount: " + (premiumCharge-paidAmount);
            
    }
    public void calculateDiscount(){
        if(this.isFullPayment){
            this.discountAmount=premiumCharge*0.10;
            System.out.println("Discount calculated: "+ discountAmount);
            
        }else{
            System.out.println("No discount available. Payment is not completed.");
        }
        
        }
        public void revertPremiumMember(){
            super.resetMember();
            this.personalTrainer="";
            this.isFullPayment=false;
            this.paidAmount=0;
            this.discountAmount=0;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("Personal trainer: "+personalTrainer);
        System.out.println("Paid amount: "+ paidAmount);
        System.out.println("Full payment: "+ isFullPayment);
        if(isFullPayment){
            System.out.println("Discount amount: "+ discountAmount);
        }
        System.out.println("Remaining amount: "+ (premiumCharge-paidAmount));
        
    }
    
    
    
    
}