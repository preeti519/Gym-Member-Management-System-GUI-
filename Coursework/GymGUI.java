package Coursework;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GymGUI extends JFrame {
    private ArrayList<GymMember> members = new ArrayList<>();
    private Set<Integer> memberIds = new HashSet<>();

    // Text Fields
    private JTextField idField, nameField, locationField, phoneField, emailField, dobField,
            membershipStartField, referralField, removalReasonField, trainerField,
            paidAmountField, regularPriceField, premiumChargeField, discountField;

    // Radio Buttons for Gender
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private ButtonGroup genderGroup;

    // Plan ComboBox
    private JComboBox<String> planComboBox;

    // Buttons
    private JButton addRegularButton, addPremiumButton, activateButton, deactivateButton,
            markAttendanceButton, upgradePlanButton, calculateDiscountButton,
            revertRegularButton, revertPremiumButton, payDueButton, displayButton,
            clearButton, saveButton, readButton;

    // Text Area for Display
    private JTextArea displayArea;

    public GymGUI() {
        setTitle("Gym Management System");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeComponents();
        addComponentsToFrame();
        addEventHandlers();

        // Set non-editable fields
        regularPriceField.setText("6500");
        regularPriceField.setEditable(false);
        premiumChargeField.setText("50000");
        premiumChargeField.setEditable(false);
        discountField.setEditable(false);
    }

    private void initializeComponents() {
        // Text Fields
        idField = new JTextField(10);
        nameField = new JTextField(20);
        locationField = new JTextField(20);
        phoneField = new JTextField(15);
        emailField = new JTextField(25);
        dobField = new JTextField(10);
        membershipStartField = new JTextField(10);
        referralField = new JTextField(20);
        removalReasonField = new JTextField(20);
        trainerField = new JTextField(20);
        paidAmountField = new JTextField(10);
        regularPriceField = new JTextField(10);
        premiumChargeField = new JTextField(10);
        discountField = new JTextField(10);

        // Gender Radio Buttons
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        // Plan ComboBox
        planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});

        // Buttons
        addRegularButton = new JButton("Add Regular Member");
        addPremiumButton = new JButton("Add Premium Member");
        activateButton = new JButton("Activate Membership");
        deactivateButton = new JButton("Deactivate Membership");
        markAttendanceButton = new JButton("Mark Attendance");
        upgradePlanButton = new JButton("Upgrade Plan");
        calculateDiscountButton = new JButton("Calculate Discount");
        revertRegularButton = new JButton("Revert Regular Member");
        revertPremiumButton = new JButton("Revert Premium Member");
        payDueButton = new JButton("Pay Due Amount");
        displayButton = new JButton("Display Members");
        clearButton = new JButton("Clear Fields");
        saveButton = new JButton("Save to File");
        readButton = new JButton("Read from File");

        // Display Area
        displayArea = new JTextArea(20, 80);
        displayArea.setEditable(false);
    }

    private void addComponentsToFrame() {
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Member Details"));

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Location:"));
        inputPanel.add(locationField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        inputPanel.add(genderPanel);
        inputPanel.add(new JLabel("DOB (DD/MM/YYYY):"));
        inputPanel.add(dobField);
        inputPanel.add(new JLabel("Membership Start Date (DD/MM/YYYY):"));
        inputPanel.add(membershipStartField);
        inputPanel.add(new JLabel("Referral Source:"));
        inputPanel.add(referralField);
        inputPanel.add(new JLabel("Removal Reason:"));
        inputPanel.add(removalReasonField);
        inputPanel.add(new JLabel("Trainer's Name:"));
        inputPanel.add(trainerField);
        inputPanel.add(new JLabel("Paid Amount:"));
        inputPanel.add(paidAmountField);
        inputPanel.add(new JLabel("Regular Plan Price:"));
        inputPanel.add(regularPriceField);
        inputPanel.add(new JLabel("Premium Charge:"));
        inputPanel.add(premiumChargeField);
        inputPanel.add(new JLabel("Discount Amount:"));
        inputPanel.add(discountField);
        inputPanel.add(new JLabel("Plan:"));
        inputPanel.add(planComboBox);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 5, 5));
        buttonPanel.add(addRegularButton);
        buttonPanel.add(addPremiumButton);
        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);
        buttonPanel.add(markAttendanceButton);
        buttonPanel.add(upgradePlanButton);
        buttonPanel.add(calculateDiscountButton);
        buttonPanel.add(revertRegularButton);
        buttonPanel.add(revertPremiumButton);
        buttonPanel.add(payDueButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(readButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        // Add Regular Member
        addRegularButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (memberIds.contains(id)) {
                    JOptionPane.showMessageDialog(this, "ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String gender = getSelectedGender();
                String dob = dobField.getText();
                String membershipStart = membershipStartField.getText();
                String referralSource = referralField.getText();

                RegularMember member = new RegularMember(id, name, location, phone, email, gender, dob, membershipStart, referralSource);
                members.add(member);
                memberIds.add(id);
                JOptionPane.showMessageDialog(this, "Regular Member Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add Premium Member
        addPremiumButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (memberIds.contains(id)) {
                    JOptionPane.showMessageDialog(this, "ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String name = nameField.getText();
                String location = locationField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String gender = getSelectedGender();
                String dob = dobField.getText();
                String membershipStart = membershipStartField.getText();
                String personalTrainer = trainerField.getText();

                PremiumMember member = new PremiumMember(id, name, location, phone, email, gender, dob, membershipStart, personalTrainer);
                members.add(member);
                memberIds.add(id);
                JOptionPane.showMessageDialog(this, "Premium Member Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Activate Membership
        activateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                for (GymMember member : members) {
                    if (member.id == id) {
                        member.activeMembership();
                        JOptionPane.showMessageDialog(this, "Membership Activated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Deactivate Membership
        deactivateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                for (GymMember member : members) {
                    if (member.id == id) {
                        member.deactiveMembership();
                        JOptionPane.showMessageDialog(this, "Membership Deactivated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Mark Attendance
        markAttendanceButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                for (GymMember member : members) {
                    if (member.id == id) {
                        if (member.activeStatus) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(this, "Attendance Marked!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Member is Inactive!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Upgrade Plan
        upgradePlanButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String newPlan = (String) planComboBox.getSelectedItem();
                for (GymMember member : members) {
                    if (member.id == id && member instanceof RegularMember) {
                        RegularMember regularMember = (RegularMember) member;
                        String result = regularMember.upgradePlan(newPlan);
                        JOptionPane.showMessageDialog(this, result, "Upgrade Plan", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found or Not Regular!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Calculate Discount
        calculateDiscountButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                for (GymMember member : members) {
                    if (member.id == id && member instanceof PremiumMember) {
                        PremiumMember premiumMember = (PremiumMember) member;
                        premiumMember.calculateDiscount();
                        discountField.setText(String.valueOf(premiumMember.discountAmount));
                        JOptionPane.showMessageDialog(this, "Discount Calculated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found or Not Premium!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Revert Regular Member
        revertRegularButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String removalReason = removalReasonField.getText();
                for (GymMember member : members) {
                    if (member.id == id && member instanceof RegularMember) {
                        RegularMember regularMember = (RegularMember) member;
                        regularMember.revertRegularMember(removalReason);
                        JOptionPane.showMessageDialog(this, "Regular Member Reverted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found or Not Regular!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Revert Premium Member
        revertPremiumButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                for (GymMember member : members) {
                    if (member.id == id && member instanceof PremiumMember) {
                        PremiumMember premiumMember = (PremiumMember) member;
                        premiumMember.revertPremiumMember();
                        JOptionPane.showMessageDialog(this, "Premium Member Reverted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found or Not Premium!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Pay Due Amount
        payDueButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                double amount = Double.parseDouble(paidAmountField.getText());
                for (GymMember member : members) {
                    if (member.id == id && member instanceof PremiumMember) {
                        PremiumMember premiumMember = (PremiumMember) member;
                        String result = premiumMember.payDueAmount(amount);
                        JOptionPane.showMessageDialog(this, result, "Payment", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Member Not Found or Not Premium!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Display Members
        displayButton.addActionListener(e -> {
            displayArea.setText("");
            for (GymMember member : members) {
                member.display();
                displayArea.append("----------------------------------------\n");
            }
        });

        // Clear Fields
        clearButton.addActionListener(e -> clearFields());

        // Save to File
        saveButton.addActionListener(e -> {
            try (PrintWriter writer = new PrintWriter(new File("MemberDetails.txt"))) {
                for (GymMember member : members) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        writer.println(String.format("Regular Member: ID=%d, Name=%s, Plan=%s, Price=%.2f",
                                rm.id, rm.name, rm.plan, rm.price));
                    } else if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        writer.println(String.format("Premium Member: ID=%d, Name=%s, Paid=%.2f, Due=%.2f",
                                pm.id, pm.name, pm.paidAmount, (pm.premiumCharge - pm.paidAmount)));
                    }
                }
                JOptionPane.showMessageDialog(this, "Data Saved to File!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Saving File!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Read from File
        readButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                members.clear();
                memberIds.clear();
                String line;
                while ((line = reader.readLine()) != null) {
                    displayArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "Data Loaded from File!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Reading File!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private String getSelectedGender() {
        if (maleRadio.isSelected()) return "Male";
        else if (femaleRadio.isSelected()) return "Female";
        else if (otherRadio.isSelected()) return "Other";
        else return "";
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        dobField.setText("");
        membershipStartField.setText("");
        referralField.setText("");
        removalReasonField.setText("");
        trainerField.setText("");
        paidAmountField.setText("");
        discountField.setText("");
        genderGroup.clearSelection();
        planComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GymGUI().setVisible(true));
    }
}