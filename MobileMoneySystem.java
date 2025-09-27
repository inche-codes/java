import java.util.Scanner;

public class MobileMoneySystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Read initial balance
        System.out.print("Enter your initial balance: ");
        double balance = input.nextDouble();
        
        // Variables for transaction tracking
        int choice;
        double amount;
        double fee;
        
        System.out.println("\n=== Welcome to Mobile Money System ===");
        
        // Main loop - continues until user exits
        do {
            // Display menu
            System.out.println("\nCurrent Balance: $" + balance);
            System.out.println("1. Make Deposit");
            System.out.println("2. Make Withdrawal");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            
            choice = input.nextInt();
            
            if (choice == 1) {
                // Deposit money
                System.out.print("Enter deposit amount: $");
                amount = input.nextDouble();
                
                // Check if amount is valid
                if (amount <= 0) {
                    System.out.println("Invalid amount! Please enter a positive number.");
                } else {
                    balance = balance + amount;
                    
                    // Print deposit receipt
                    System.out.println("\n--- DEPOSIT RECEIPT ---");
                    System.out.println("Transaction Type: DEPOSIT");
                    System.out.println("Amount: $" + amount);
                    System.out.println("Fee: $0.00");
                    System.out.println("New Balance: $" + balance);
                    System.out.println("Thank you for your transaction!");
                }
                
            } else if (choice == 2) {
                // Withdraw money
                System.out.print("Enter withdrawal amount: $");
                amount = input.nextDouble();
                
                // Check if amount is valid
                if (amount <= 0) {
                    System.out.println("Invalid amount! Please enter a positive number.");
                } else if (amount > balance) {
                    System.out.println("Insufficient funds! Your balance is $" + balance);
                } else {
                    // Calculate fee (1.5% of withdrawal amount)
                    fee = amount * 0.015;
                    double totalDeduction = amount + fee;
                    
                    // Check if balance can cover amount + fee
                    if (totalDeduction > balance) {
                        System.out.println("Insufficient funds! You need $" + totalDeduction + 
                                         " (including $" + fee + " fee)");
                    } else {
                        balance = balance - totalDeduction;
                        
                        // Print withdrawal receipt
                        System.out.println("\n--- WITHDRAWAL RECEIPT ---");
                        System.out.println("Transaction Type: WITHDRAWAL");
                        System.out.println("Amount: $" + amount);
                        System.out.println("Fee (1.5%): $" + fee);
                        System.out.println("Total Deducted: $" + totalDeduction);
                        System.out.println("New Balance: $" + balance);
                        System.out.println("Thank you for your transaction!");
                    }
                }
                
            } else if (choice == 3) {
                System.out.println("Thank you for using Mobile Money System!");
                
            } else {
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
            
        } while (choice != 3);
        
        input.close();
    }
}