package Coursework;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.io.FileNotFoundException;

public class GymGUI{
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel locationLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel genderLabel;
    private JLabel referralSourceLabel;
    private JLabel trainerNameLabel;
    private JLabel dobLabel;
    private JLabel regularPriceLabel;
    private JLabel premiumChargeLabel;
    private JLabel discountAmountLabel;
    private JLabel paidAmountLabel;
    private JLabel removalReasonLabel;
    private JLabel planLabel;
    private JLabel membershipStartLabel;
    private ArrayList<GymMember> members = new ArrayList<>();
    
    //private ArrayList<GymMember> members = new ArrayList<>();
    
    private JFrame frame;
    private JLabel ReferralSource;
    private JTextField idtxt, nametxt, gendertxt,locationtxt, phonetxt, emailtxt, 
    referralSourcetxt, paidAmounttxt, removalReasontxt, trainerNametxt;
    
    private JComboBox<String> dobDay, dobMonth, dobYear, msDay, msMonth, msYear;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private JTextArea displayArea;
    private ButtonGroup genderGroup;
    private JButton calculateDiscountButton;
    private JTextField regularPriceField, premiumChargeField, discountField;
    

    
    public GymGUI(){
    //ArrayList<GymMember> members= new ArrayList<GymMember>();
    JFrame frame;
    frame= new JFrame("GymGUI");
    frame.setSize(1000,700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    
    
    //frame.setVisible(true);
    JPanel panel= new JPanel();
    panel.setSize(500,500);
    panel.setBounds(10,10,980,300 );
    panel.setLayout(null); // Using null layout

    frame.add (panel);
    panel.setBackground(new Color(250, 250, 250));
    panel.setFont(new Font("SanSerif",Font.BOLD,20));
    panel.setLayout( null);
    panel.setBorder(BorderFactory.createTitledBorder("Member Information"));
    
    // Left column components

    //ID
    JLabel ID= new JLabel ("ID :");
    ID.setFont(new Font("Arial", Font.BOLD,13));
    ID.setBounds(20,30,100,25);
    idtxt = new JTextField();
    idtxt.setBounds(130,30,220,25);
    panel.add(ID);
    panel.add(idtxt);
    
    //Name
    JLabel Name=new  JLabel("Name :");
    Name.setFont(new Font("Arial", Font.BOLD,14));
    Name.setBounds(20,60,100,25);
    JTextField Nametxt= new JTextField(50);
    Nametxt.setBounds(130,60,220,25);
    panel.add(Name);
    //frame.add(panel);
    panel.add(Nametxt);
    
    //Location
    JLabel Location =new JLabel("Location :");
    Location.setFont(new Font("Arial", Font.BOLD,16));
    Location.setBounds(20,90,100,25);
    JTextField Locationtxt= new JTextField(50);
    Locationtxt.setBounds(130,90,220,25);
    panel.add(Location);
    panel.add(Locationtxt);
    
    //Phone
    JLabel Phone=new JLabel("Phone :");
    Phone.setFont(new Font("Arial", Font.BOLD,16));
    Phone.setBounds(20,120,100,25);
    JTextField Phonetxt= new JTextField(50);
    Phonetxt.setBounds(130,120,220,25);
    panel.add(Phone);
    panel.add(Phonetxt);
    
    //Email
    JLabel Email=new JLabel("Email :");
    Email.setFont(new Font("Arial", Font.BOLD,16));
    Email.setBounds(20,150,100,25);
    JTextField Emailtxt= new JTextField(50);
    Emailtxt.setBounds(130,150,220,25);
    panel.add(Email);
    panel.add(Emailtxt);
    // Right column components

    //Gender
    JLabel genderLabel = new JLabel("Gender:");
    genderLabel.setBounds(20, 180, 100,25);  // Position label
    genderLabel.setFont(new Font("Arial", Font.BOLD,16));
    panel.add(genderLabel);
    
    
    JRadioButton Femalbutton= new JRadioButton ("Female");
    Femalbutton.setBounds(130,180,70,25);
    JRadioButton Malebutton= new JRadioButton ("Male");
    Malebutton.setBounds(200,180,80,25);
    JRadioButton Otherbutton =new JRadioButton("Other");
    Otherbutton.setBounds(280,180,80,25);
    ButtonGroup group=new ButtonGroup();
    group.add(Femalbutton);
    group.add(Malebutton);
    group.add(Otherbutton);
    
    panel.add(Femalbutton);
    panel.add(Malebutton);
    panel.add(Otherbutton);
    
    //Referral source
    JLabel RefferralSource=new JLabel("Referral Source :");
    RefferralSource.setFont(new Font("Arial", Font.BOLD,16));
    RefferralSource.setBounds(500, 30, 180, 25);
    JTextField ReferralSourcetxt=new JTextField(50);
    ReferralSourcetxt.setBounds(690, 30, 220, 25);
    //ReferralSourcetxt.setFont(new Font("Arial", Font.BOLD,16));
    
    panel.add(RefferralSource);
    panel.add(ReferralSourcetxt);
    
    //Trainer's Name
    JLabel TrainerName=new JLabel("Trainer Name:");
    TrainerName.setFont(new Font("Arial", Font.BOLD,16));
    TrainerName.setBounds(500, 120, 180, 25);
    JTextField TrainerNametxt=new JTextField(50);
    TrainerNametxt.setBounds(690, 120, 220, 25);
    TrainerName.setFont(new Font("Arial", Font.BOLD,16));
    
    panel.add(TrainerName);
    panel.add(TrainerNametxt);
    
    //DOB
    JLabel dobLabel = new JLabel("Date of Birth:");
    dobLabel.setBounds(20, 210, 120, 32);
    panel.add(dobLabel);
    dobLabel.setFont(new Font("Arial", Font.BOLD,16));
    
    
    JComboBox comboBox=new JComboBox();
    String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    String [] months = {"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
    String [] years = {"1990","1991","1992","1993","1994","1995","1996","1996","1997","1998","1999","2000","2001","2018","2019","2020","2021","2022","2023","2024","2025"};
        
    
    JComboBox<String> dobDay = new JComboBox<>(days);
    dobDay.setBounds(140, 212, 60, 25);
    
    JComboBox<String> dobMonth = new JComboBox<>(months);
    dobMonth.setBounds(195, 212, 70, 25);
    
    JComboBox<String> dobYear = new JComboBox<>(years);
    dobYear.setBounds(260, 212, 80, 25);
    
    panel.add(dobDay);
    panel.add(dobMonth);
    panel.add(dobYear);
    //panel.add(dobPanel);
    
    //regular price
    JLabel regularPriceLabel = new JLabel("Regular Plan Price:");
    regularPriceLabel.setBounds(500, 150, 150, 25);
    regularPriceLabel.setFont(new Font("Arial", Font.BOLD,16));
    panel.add(regularPriceLabel);
    JTextField regularPricetxt=new JTextField("6500");
    regularPricetxt.setEditable(false);
    regularPricetxt.setBounds(690,150, 220, 25);
    panel.add(regularPricetxt);
    
    
    //premium charge
    JLabel premiumCharge = new JLabel("Premium Plan Charge:");
    premiumCharge.setBounds(500, 180, 190, 25);
    premiumCharge.setFont(new Font("Arial", Font.BOLD,16));
    JTextField premiumChargetxt = new JTextField("50000");
    premiumChargetxt.setBounds(690, 180, 220, 25);
    premiumChargetxt.setEditable(false);
    panel.add(premiumChargetxt);
    panel.add(premiumCharge);
    
    //discount
    JLabel discountAmount = new JLabel("Discount Amount:");
    discountAmount.setBounds(500, 210, 150, 25);
    discountAmount.setFont(new Font("Arial", Font.BOLD,16));
    JTextField discountAmounttxt = new JTextField("0");
    discountAmounttxt.setBounds(690, 210, 220, 25);
    discountAmounttxt.setEditable(false);
    panel.add(discountAmounttxt);
    panel.add(discountAmount);
    
    //paid Amount
    JLabel paidAmount = new JLabel("Paid Amount:");
    paidAmount.setBounds(500, 60, 120, 25);
    paidAmount.setFont(new Font("Arial", Font.BOLD,16));
    JTextField paidAmounttxt = new JTextField(50);
    paidAmounttxt.setBounds(690, 60, 220, 25);
    panel.add(paidAmounttxt);
    panel.add(paidAmount);
    
    //removal reason
    JLabel removalReason = new JLabel("Removal Reason :");
    removalReason.setBounds(500, 90, 160, 25);
    removalReason.setFont(new Font("Arial", Font.BOLD,16));
    JTextField removalReasontxt = new JTextField(50);
    removalReasontxt.setBounds(690, 90, 220, 25);
    panel.add(removalReasontxt);
    panel.add(removalReason );
    
    
    // Plan ComboBox
    JLabel Plan = new JLabel("Select Plan:");
    Plan.setFont(new Font("Arial", Font.BOLD, 16));
    Plan.setBounds(500, 240, 150, 25);
    String[] plans = {"Basic", "Standard", "Deluxe"};
    JComboBox<String> planCombo = new JComboBox<>(plans);
    planCombo.setBounds(690, 240, 150, 32);
    panel.add(Plan); panel.add(planCombo);
    JLabel msLabel = new JLabel("Membership Start:");
    msLabel.setBounds(20, 240, 120, 25);
    panel.add(msLabel);

    //"Membership Start
    JLabel ms = new JLabel("Membership Start:");
    msLabel.setBounds(20, 240, 190, 25);
    //panel.add(msLabel);
    msLabel.setFont(new Font("Arial", Font.BOLD, 16));
    panel.add(msLabel);
    
    JComboBox<String> msDay = new JComboBox<>(days);
    msDay.setBounds(160, 240, 60, 25);
    panel.add(msDay);
    JComboBox<String> msMonth = new JComboBox<>(months);
    msMonth.setBounds(217, 240, 70, 25);
    panel.add(msMonth);
    
    JComboBox<String> msYear = new JComboBox<>(years);
    msYear.setBounds(280, 240, 80, 25);
    panel.add(msYear);
    
    //  Create button panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(null);
    buttonPanel.setSize(500,500);
    buttonPanel.setBounds(10, 331, 980, 180); // Position it below the form panel
    panel.add(buttonPanel);
    buttonPanel.setBackground (Color.WHITE);
    frame.add(buttonPanel);

    JButton addRegularButton = new JButton("Add Regular Member");
    addRegularButton.setBounds(10, 30, 200, 32);
    //buttonPanel.add(addRegularButton);
    buttonPanel.add(addRegularButton);

    // For the Add Regular Member button action listener
    addRegularButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get values from text fields
                String idText = idtxt.getText();
                String name = Nametxt.getText();
                String location = Locationtxt.getText();
                String phone = Phonetxt.getText();
                String email = Emailtxt.getText();
                String referralSource = ReferralSourcetxt.getText();
                String plan = planCombo.getSelectedItem().toString();
                String paidAmountText = paidAmounttxt.getText();
    
                // Validate all required fields
                if (idText.isEmpty() || name.isEmpty() || location.isEmpty() ||
                    phone.isEmpty() || email.isEmpty() || referralSource.isEmpty() ||
                    paidAmountText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "All fields are required except trainer name to add regular member");
                    return;
                }
    
                // Validate that paid amount is a number
                double paidAmount;
                try {
                    paidAmount = Double.parseDouble(paidAmountText);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(frame, 
                        "Payment amount must be a number. Please enter a valid numeric value.");
                    return;
                }
    
                // Convert ID to integer after validation
                int id = Integer.parseInt(idText);
    
                // Validate gender selection
                String gender = "";
                if (Femalbutton.isSelected()) {
                    gender = "Female";
                } else if (Malebutton.isSelected()) {
                    gender = "Male";
                } else if (Otherbutton.isSelected()) {
                    gender = "Other";
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a gender.");
                    return;
                }
    
                // Get date of birth
                String dob = dobDay.getSelectedItem() + "-" + dobMonth.getSelectedItem() + "-" + dobYear.getSelectedItem();
    
                // Get membership start date
                String membershipStart = msDay.getSelectedItem() + "-" + msMonth.getSelectedItem() + "-" + msYear.getSelectedItem();
    
                // Check if this ID already exists
                boolean idExists = false;
                for (GymMember m : members) {
                    if (m.getId() == id) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists. Please use a different one.");
                } else {
                    // Create regular member and add to list
                    RegularMember regular = new RegularMember(id, name, location, phone, email, gender, dob, membershipStart, referralSource);
                    regular.upgradePlan(plan);
                    members.add(regular);
    
                    JOptionPane.showMessageDialog(frame, "Regular member added successfully!");
                }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for ID.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Something went wrong: " + ex.getMessage());
        }
    }
});

//premiumButton
    JButton addPremiumButton= new JButton("Add Premium member");
    addPremiumButton.setBounds(300,30,200,32);
    buttonPanel.add(addPremiumButton);

    addPremiumButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                // Get input from fields
                String idText = idtxt.getText();
                String name = Nametxt.getText();
                String location = Locationtxt.getText();
                String phone = Phonetxt.getText();
                String email = Emailtxt.getText();
                String trainerName = TrainerNametxt.getText();
                String paidAmountText = paidAmounttxt.getText();
    
                // Validate required fields
                if (idText.isEmpty() || name.isEmpty() || location.isEmpty() || 
                    phone.isEmpty() || email.isEmpty() || trainerName.isEmpty() ||
                    paidAmountText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, 
                        "All fields are required to add premium member");
                    return;
                }
    
                // Validate that paid amount is a number
                double paidAmount;
                try {
                    paidAmount = Double.parseDouble(paidAmountText);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(frame, 
                        "Payment amount must be a number. Please enter a valid numeric value.");
                    return;
                }
    
                // Convert ID to integer after validation
                int id = Integer.parseInt(idText);
    
                //  Get selected gender
                String gender = "";
                if (Femalbutton.isSelected()) {
                    gender = "Female";
                } else if (Malebutton.isSelected()) {
                    gender = "Male";
                } else if (Otherbutton.isSelected()) {
                    gender = "Other";
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a gender.");
                    return;
                }
    
                //  Get selected DOB
                String dob = dobDay.getSelectedItem() + "-" + dobMonth.getSelectedItem() + "-" + dobYear.getSelectedItem();
    
                //  Get membership start date
                String membershipStart = msDay.getSelectedItem() + "-" + msMonth.getSelectedItem() + "-" + msYear.getSelectedItem();
    
                //  Check if this ID is already used
                boolean exists = false;
                for (GymMember member : members) {
                    if (member.getId() == id) {
                        exists = true;
                        break;
                    }
                }
    
                if (exists) {
                    JOptionPane.showMessageDialog(frame, " Member with this ID already exists. Use a different ID.");
                } else {
                    // Create PremiumMember object
                    PremiumMember premium = new PremiumMember(id, name, location, phone, email, gender, dob, membershipStart, trainerName);
    
                    //  Add to members list
                    members.add(premium);
    
                    //  Show confirmation
                    JOptionPane.showMessageDialog(frame, " Premium member added successfully!");
                }
    
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, " Please enter a valid number for ID.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, " Error: " + ex.getMessage());
            }
        }
    });
    
// Clear Form button
    JButton clearFormButton = new JButton("Clear Form");
    clearFormButton.setBounds(600, 65, 200, 32);
    buttonPanel.add(clearFormButton);
    clearFormButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Clear all text fields
        idtxt.setText("");
        Nametxt.setText("");
        Locationtxt.setText("");
        Phonetxt.setText("");
        Emailtxt.setText("");
        ReferralSourcetxt.setText("");
        TrainerNametxt.setText("");
        paidAmounttxt.setText("");
        removalReasontxt.setText("");

        // Clear gender radio buttons
        group.clearSelection();

        // Reset combo boxes to first item (index 0)
        dobDay.setSelectedIndex(0);
        dobMonth.setSelectedIndex(0);
        dobYear.setSelectedIndex(0);

        msDay.setSelectedIndex(0);
        msMonth.setSelectedIndex(0);
        msYear.setSelectedIndex(0);
        planCombo.setSelectedIndex(0);

        JOptionPane.showMessageDialog(frame, "Form cleared successfully!");
    }
    });
   
    // Mark Attendance
   JButton markAttendanceButton = new JButton("Mark Attendance");
   markAttendanceButton.setBounds(600, 30, 200, 32);
   buttonPanel.add(markAttendanceButton);
   markAttendanceButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText().trim());

            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    found = true;

                    if (member.getActiveStatus()) {
                        member.markAttendance();
                        //JOptionPane.showMessageDialog(frame," Attendance "+ member.getAttendance());
                        
                        JOptionPane.showMessageDialog(frame, " Attendance marked for member ID: " + id);
                        JOptionPane.showMessageDialog(frame," Attendance "+ member.getAttendance());
                        JOptionPane.showMessageDialog(frame," Attendance "+ member.getLoyaltyPoints());
                    } else {
                        JOptionPane.showMessageDialog(frame, " Membership is not active. Please activate first.");
                    }
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, " Member ID not found.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }
});

   // Activate Membership
   JButton activateButton = new JButton("Activate Membership");
   activateButton.setBounds(10, 100, 200, 32);
   buttonPanel.add(activateButton);
   activateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText().trim());

            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    member.activateMembership(); // Call method from GymMember
                    found = true;
                    JOptionPane.showMessageDialog(frame, "Membership activated for member ID: " + id);
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "Member ID not found. Please check and try again.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, " Invalid Member ID. Please enter a number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }
});
   
  // Deactivate Membership
   JButton deactivateButton = new JButton("Deactivate Membership");
   deactivateButton.setBounds(300,65, 200, 32);
   buttonPanel.add(deactivateButton);
   deactivateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText());

            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    member.deactivateMembership(); // Call method from GymMember
                    found = true;
                    JOptionPane.showMessageDialog(frame, " Membership deactivated for member ID: " + id);
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, " Member ID not found. Please check and try again.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, " Invalid Member ID. Please enter a number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, " Error: " + ex.getMessage());
        }
    }
});

// Revert Regular Member button
JButton revertRegularButton = new JButton("Revert Regular Member");
revertRegularButton.setBounds(10, 135, 200, 32);  // Adjust position as needed
buttonPanel.add(revertRegularButton);

        //adding action listener
revertRegularButton.addActionListener(e -> {
    String id = idtxt.getText(); // Get ID from text field
    String reason = removalReason.getText(); // Get removal reason from the declared JTextField

    if (id == null || id.equals("")) {
        JOptionPane.showMessageDialog(frame, "Please enter a Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (reason == null || reason.equals("")) {
        JOptionPane.showMessageDialog(frame, "Please enter a removal reason!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean memberFound = false;

    for (GymMember member : members) {
        if (String.valueOf(member.getId()).equals(id)) { // Match the member ID
            memberFound = true;

            if (member instanceof RegularMember) {
                ((RegularMember) member).revertRegularMember(reason); // Cast and call method with reason
                JOptionPane.showMessageDialog(frame, "Regular membership reverted successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Member is not a Regular Member!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return; // Exit the loop once the member is processed
        }
    }

    if (!memberFound) {
        JOptionPane.showMessageDialog(frame, "Member ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
    }
});
    

// Revert Premium Member button
JButton revertPremiumButton = new JButton("Revert Premium Member");
revertPremiumButton.setBounds(300, 100, 200, 32);  // Adjust position as needed
buttonPanel.add(revertPremiumButton);
revertPremiumButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String idStr = idtxt.getText();

        if (idStr == null || idStr.equals("")) {
            JOptionPane.showMessageDialog(frame, "Please enter a Member ID.");
            return;
        }

        int memberId = -1;
        try {
            memberId = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID format.");
            return;
        }

        boolean found = false;

        for (int i = 0; i < members.size(); i++) {
            GymMember member = members.get(i);

            if (member.getId() == memberId && member instanceof PremiumMember) {
                ((PremiumMember) member).revert();
                members.remove(i);
                JOptionPane.showMessageDialog(frame, "Premium Member removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(frame, "Premium Member ID not found.");
        }
    }
});


//Save button
JButton saveButton = new JButton("Save to File");
saveButton.setBounds(820, 30, 150, 30);  // adjust position as needed
buttonPanel.add(saveButton); // or frame.add(saveButton);
// Save to File Button ActionListener
        saveButton.addActionListener(e -> {
            if (members.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No members to save!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            try (FileWriter writer = new FileWriter("MemberDetails.txt")) {
                // Write header
                writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start", "Plan", "Price", 
                    "Attendance", "Loyalty", "Active", "Full Pay", "Discount"));
                
                // Write member details
                for (GymMember member : members) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f\n",
                            rm.getId(), rm.getName(), rm.getLocation(), rm.getPhone(), rm.getEmail(),
                            rm.getMembershipStartDate(), rm.getPlan(), rm.getPrice(), rm.getAttendance(),
                            rm.getLoyaltyPoints(), rm.getActiveStatus() ? "Yes" : "No", "N/A", 0.0));
                    } else if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        // Ensure discount is calculated if payment is complete
                        if(pm.isFullPayment() && pm.getDiscountAmount() == 0) {
                            pm.calculateDiscount();
                        }
                        
                        writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f\n",
                            pm.getId(),
                            pm.getName(),
                            pm.getLocation(),
                            pm.getPhone(),
                            pm.getEmail(),
                            pm.getMembershipStartDate(),
                            "Premium",
                            pm.getpremiumCharge(),
                            pm.getAttendance(),
                            pm.getLoyaltyPoints(),
                            pm.getActiveStatus() ? "Yes" : "No",
                            pm.isFullPayment() ? "Yes" : "No",
                            pm.getDiscountAmount())); // This will now show the discount
                }
                    
                }
                
                JOptionPane.showMessageDialog(frame, "Member details saved to MemberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


// Upgrade Plan 
JButton upgradePlanButton= new JButton ("Upgrade Plan");
upgradePlanButton.setBounds (300,135,200,32);
buttonPanel.add(upgradePlanButton);
upgradePlanButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText());
            String selectedPlan = (String) planCombo.getSelectedItem();
            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    found = true;

                    if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member;

                        String result = regular.upgradePlan(selectedPlan); // directly call method
                        JOptionPane.showMessageDialog(frame, result);
                    } else {
                        JOptionPane.showMessageDialog(frame, "This member is not a Regular Member.");
                    }
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "Member ID not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID. Please enter a number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }
});

// Calculate discount
JButton calculateDiscountButton= new JButton ("Calculate Discount");
calculateDiscountButton.setBounds (600, 100, 200, 32);
buttonPanel.add(calculateDiscountButton);
frame.add(buttonPanel);
// Add action listener to handle button click
// Calculate Discount ActionListener
calculateDiscountButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText());  // get Member Id input
            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    found = true;

                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        String discountInfo = Double.toString(premium.calculateDiscount());
                        //String discountInfo = premium.calculateDiscount();  // call method
                        JOptionPane.showMessageDialog(frame, discountInfo);
                    } else {
                        JOptionPane.showMessageDialog(frame, "This member is not a Premium Member.");
                    }
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "Member ID not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Member ID. Please enter a valid number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }
});

// Pay Due Amount
JButton payDueAmountButton= new JButton ("Pay Due Amount");
payDueAmountButton.setBounds (600, 135, 200, 32);
buttonPanel.add(payDueAmountButton);
payDueAmountButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idtxt.getText());
            double amount = Double.parseDouble(paidAmounttxt.getText());
            boolean found = false;

            for (GymMember member : members) {
                if (member.getId() == id) {
                    found = true;
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        String result = premium.payDueAmount(amount);
                        JOptionPane.showMessageDialog(frame, result);
                    } else {
                        JOptionPane.showMessageDialog(frame, "This member is not a Premium Member.");
                    }
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "Member ID not found.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for ID and amount.");
        }
    }
});
// Read From File
JButton readFromFileButton= new JButton ("Read From File");
readFromFileButton.setBounds (820, 68, 150, 30);
buttonPanel.add(readFromFileButton);
// Read from File Button ActionListener
        readFromFileButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                // Create text area with scroll pane
                JTextArea textArea = new JTextArea(20, 80);
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                
                // Read file line by line
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                
                // Show in dialog
                JOptionPane.showMessageDialog(frame, scrollPane, "Member Details from File", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "File not found: MemberDetails.txt", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });



                    

  // Display All Members
  JButton displayButton = new JButton("Display All Members");
  displayButton.setBounds(10, 65, 200,32);
  buttonPanel.add(displayButton);
  displayButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Create a new frame (a new window)
        JFrame displayFrame = new JFrame("All Members");
        displayFrame.setSize(600, 400);
        displayFrame.setLocationRelativeTo(null); // center on screen

        // Create a text area inside scroll pane
        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(10, 10, 560, 340);

        // Fill the text area with member info
        String text = "";

        if (members.isEmpty()) {
            text = "No members found.";
        } else {
            for (GymMember member : members) {
                text += "ID: " + member.getId() + "\n";
                text += "Name: " + member.getName() + "\n";
                text += "Email: " + member.getEmail() + "\n";
                text += "Phone: " + member.getPhone() + "\n";

                if (member instanceof RegularMember) {
                    RegularMember rm = (RegularMember) member;
                    text += "Type: Regular\n";
                    text += "Plan: " + rm.getPlan() + "\n";
                    text += "Referral: " + rm.getReferralSource() + "\n";
                } else if (member instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) member;
                    text += "Type: Premium\n";
                    text += "Trainer: " + pm.getPersonalTrainer() + "\n";
                }

                text += "Status: " + (member.getActiveStatus() ? "Active" : "Inactive") + "\n\n";
            }
        }

        area.setText(text);

        // Add to new frame
        displayFrame.setLayout(null);
        displayFrame.add(scrollPane);
        displayFrame.setVisible(true);
    }
});


    //memberlist panel 
    JPanel memberlistPanel= new JPanel();
    memberlistPanel.setLayout(null);
    memberlistPanel.setSize(500,500);
    memberlistPanel.setBounds(10, 531, 980, 120);
    memberlistPanel.setBackground(Color.WHITE);
    memberlistPanel.setBorder(BorderFactory.createTitledBorder("Member List"));
    frame.add(memberlistPanel);
  
    // Add text area to display member information
    displayArea = new JTextArea();
    displayArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(displayArea);
    scrollPane.setBounds(10, 20, 960, 90);
    memberlistPanel.add(scrollPane);
    frame.setVisible(true);
} 
    // Home page 
    public static class GUI {
        private JFrame homeFrame;

        public GUI() {
            homeFrame = new JFrame("Gym Management System");
            homeFrame.setSize(700, 500);
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeFrame.setLayout(null);

            JPanel titlePanel = new JPanel();
            titlePanel.setBounds(250, 10, 680, 70);
            titlePanel.setBackground(new Color(255, 255, 255));
            titlePanel.setLayout(null);
            titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            JLabel titleLabel = new JLabel("GYM MANAGEMENT SYSTEM");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            titleLabel.setBounds(150, 15, 980, 40);
            titlePanel.add(titleLabel);
            homeFrame.add(titlePanel);

            JPanel contentPanel = new JPanel();
            contentPanel.setBounds(100, 90, 980, 500);
            contentPanel.setBackground(new Color(240, 240, 240));
            contentPanel.setLayout(null);
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            JLabel welcomeLabel = new JLabel("Welcome to the Gym Management System");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            welcomeLabel.setBounds(265, 20, 700, 30);
            contentPanel.add(welcomeLabel);

            JButton openGymButton = new JButton("Open Member Management");
            openGymButton.setBounds(300, 100, 350, 100);
            openGymButton.setFont(new Font("Arial", Font.BOLD, 14));
            openGymButton.setBackground(new Color(100, 149, 237));
            openGymButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    homeFrame.dispose();
                    new GymGUI();
                }
            });
            contentPanel.add(openGymButton);

            JButton exitButton = new JButton("Exit");
            exitButton.setBounds(300, 250, 350, 100);
            exitButton.setFont(new Font("Arial", Font.BOLD, 14));
            exitButton.setBackground(new Color(0, 102, 204));
            
            exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int response = JOptionPane.showConfirmDialog(
                        homeFrame,
                        "Are you sure you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    );
                    if (response == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            });
            contentPanel.add(exitButton);
            homeFrame.add(contentPanel);
            homeFrame.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
    new GUI();
}

}




    

    



    
