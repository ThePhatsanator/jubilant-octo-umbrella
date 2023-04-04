import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Define the main class for the banking application
public class BankingApplication {

    // Define a map to store customer accounts
    private Map<Long, Customer> customers = new HashMap<>();

    // Define a method to create a new customer account
    public Customer createCustomer(Customer customer) {
        // Generate a unique ID for the new customer account
        Long id = System.currentTimeMillis();
        customer.setId(id);
        // Set up default values for new customer account
        customer.setJoiningCredit(500);
        customer.setCurrentAccount(new Account());
        customer.getSavingsAccount().setBalance(500);
        // Add new customer account to map
        customers.put(id, customer);
        return customer;
    }

    // Define a method to retrieve all customer accounts
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    // Define a method to retrieve a customer account by ID
    public Optional<Customer> getCustomerById(Long customerId) {
        if (customers.containsKey(customerId)) {
            return Optional.of(customers.get(customerId));
        } else {
            return Optional.empty();
        }
    }

    // Define a method to create a new current account for a customer
    public Customer createCurrentAccount(Long customerId) {
        Optional<Customer> customer = getCustomerById(customerId);
        if (customer.isPresent()) {
            // Create new current account for customer
            customer.get().setCurrentAccount(new Account());
            customers.put(customerId, customer.get());
            return customer.get();
        } else {
            return null;
        }
    }

}

// Define the Customer class for customer accounts
class Customer {
    private Long id;
    private String name;
    private String email;
    private Account currentAccount;
    private Account savingsAccount = new Account();
    private int joiningCredit;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Account getCurrentAccount() { return currentAccount; }
    public void setCurrentAccount(Account currentAccount) { this.currentAccount = currentAccount; }
    public Account getSavingsAccount() { return savingsAccount; }
    public void setSavingsAccount(Account savingsAccount) { this.savingsAccount = savingsAccount; }
    public int getJoiningCredit() { return joiningCredit; }
    public void setJoiningCredit(int joiningCredit) { this.joiningCredit = joiningCredit; }
}

// Define the Account class for bank accounts
class Account {
    private int balance;

    // Getters and setters
    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}

// Define the main method to run the banking application
public class Main {
    public static void main(String[] args) {
        // Create a new instance of the banking application
        BankingApplication bankingApplication = new BankingApplication();

        // Create a new customer account
        Customer customer1 = new Customer();
        customer1.setName("John Doe");
        customer1.setEmail("johndoe@example.com");
        bankingApplication.createCustomer(customer1);

        // Create a new current account for the customer
        bankingApplication.createCurrentAccount(customer1.getId());

        // Retrieve all customer
