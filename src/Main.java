// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


    public class Main {
        public static void main(String[] args) {
            BankingApplication bankingApplication = new BankingApplication();

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (choice != 6) {
                System.out.println("1. Create customer");
                System.out.println("2. Create current account");
                System.out.println("3. View customer");
                System.out.println("4. View all customers");
                System.out.println("5. View balance");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter customer email: ");
                        String email = scanner.nextLine();
                        Customer customer = new Customer();
                        customer.setName(name);
                        customer.setEmail(email);
                        bankingApplication.createCustomer(customer);
                        System.out.println("Customer created with ID " + customer.getId());
                        break;
                    case 2:
                        System.out.print("Enter customer ID: ");
                        Long customerId = scanner.nextLong();
                        Customer currentCustomer = bankingApplication.createCurrentAccount(customerId);
                        if (currentCustomer == null) {
                            System.out.println("Customer not found");
                        } else {
                            System.out.println("Current account created for customer " + currentCustomer.getName());
                        }
                        break;
                    case 3:
                        System.out.print("Enter customer ID: ");
                        Long viewCustomerId = scanner.nextLong();
                       // System.out.println(viewCustomerId+"here");
                        Optional<Customer> viewCustomer = bankingApplication.getCustomerById(viewCustomerId);
                        if (viewCustomer.isPresent()) {
                            System.out.println(viewCustomer);
                          //  System.out.println(viewCustomer.toString());
                        } else {
                            System.out.println("Customer not found");
                        }
                        break;
                    case 4:
                        System.out.println("All customers:");
                        List<Customer> allCustomers = bankingApplication.getAllCustomers();
                        for (Customer c : allCustomers) {
                            System.out.println(c);
                        }
                        break;
                    case 5:
                        System.out.print("Enter customer ID: ");
                        Long balanceCustomerId = scanner.nextLong();
                        Optional<Customer> balanceCustomer = bankingApplication.getCustomerById(balanceCustomerId);
                        if (balanceCustomer.isPresent()) {
                            System.out.println("Savings account balance: " + balanceCustomer.get().getSavingsAccount().getBalance());
                            System.out.println("Current account balance: " + balanceCustomer.get().getCurrentAccount().getBalance());
                        } else {
                            System.out.println("Customer not found");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }
