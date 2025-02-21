package Coursework;
//Subclass RegularMember
public class RegularMember extends GymMember{
     final int attendanceLimit = 30;
     boolean isEligibleForUpgrade;
     String removalReason;
     String referralSource;
     String plan;
     double price;
    
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,String referralSource){
        super(id, name , location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource=referralSource;
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        this.removalReason="";
        
    }
    @Override
    public void markAttendance() {
        if(this.activeStatus){
            this.attendance ++;
            this.loyaltyPoints +=5;
            if (this.attendance >= attendanceLimit){
                this.isEligibleForUpgrade=true;
            }
            }else{
                System.out.println("Membership is not active. Cannot make attendance");
                
            }
            
        
    }
    public double getPlanPrice(String plan){
        switch (plan.toLowerCase()){
            case "basic": 
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                 return  18500;
            default:   
            return -1;
        }
        
        
    }
    public String upgradePlan(String newPlan){
        if(this.isEligibleForUpgrade){
            double newPrice= getPlanPrice(newPlan);
            if(newPrice!= -1){
                if(! this.plan. equalsIgnoreCase(newPlan)){
                    this.plan=newPlan;
                    this.price=newPrice;
                    return "Plan upgraded to"+ newPlan + "successfully ";
                } else{
                    return "You are already on the " + newPlan +"plan";
                    
                }
                
                
            }else{
                return "Invalid plan selected";
                
            }
            
        }else{
            return "You are not eligible for an upgrade";
        }
        
    }
    public void revertRegularmember(String removalReason){
        super.resetMember();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        this.removalReason=removalReason;
        }
        @Override
        public void display(){
            super.display();
            System.out.println("Plan: "+plan);
            System.out.println("Price: "+price);
            if (! removalReason. isEmpty()){
                System.out.println("RemovalReason: "+removalReason);
            }
        }
    
    }
    
    
