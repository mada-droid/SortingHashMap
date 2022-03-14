# SortingHashMap
Getting to know Collections throught out sorting a hashmap

package Tim;

import java.util.ArrayList;

public class BranchTim {

    private String name;
    private ArrayList<CustomerTim> customerTims;

    public BranchTim(String name) {
        this.name = name;
        this.customerTims = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == -1){
            this.customerTims.add(new CustomerTim(customerName,initialAmount));
            return true;
        }
        return false;
    }

    public int findCustomer(String customerName){
        int currentIndex = -1;
        for(int i = 0; i < customerTims.size(); i++){
            if(customerTims.get(i).getName().equals(customerName)){
                currentIndex = i;
                break;
            }
        }
        return currentIndex;
    }

    public ArrayList<CustomerTim> getCustomerTims() {
        return customerTims;
    }

    public void addCustomerTransaction(String customerName, double amount){
        int customerIndex = findCustomer(customerName);
        if(customerIndex != -1){
            CustomerTim customerTim1 = new CustomerTim(customerName,customerTims.get(customerIndex).getTransaction());
            customerTim1.addTransaction(amount);
            this.customerTims.set(customerIndex,customerTim1);
        }else {
            System.out.println("Customer's name not found !");
        }
    }

}


package Tim;

import java.util.ArrayList;

public class BankTim {

    private String name;
    private ArrayList<BranchTim> branchTims;

    public BankTim(String name) {
        this.name = name;
        this.branchTims = new ArrayList<>();
    }

    public BankTim(String name, ArrayList<BranchTim> branchTims) {
        this.name = name;
        this.branchTims = new ArrayList<>();
    }

    public void addBranch(String branchName){
        if(findBranch(branchName) == -1){
            this.branchTims.add(new BranchTim(branchName));
        }else {
            System.out.println("Branch does already exist !");
        }
    }

    public int findBranch(String branchName){
        int currentIndex = -1;
        for(int i = 0; i < branchTims.size(); i++){
            if(branchTims.get(i).getName().equals(branchName)){
                currentIndex = i;
                break;
            }
        }
        return currentIndex;
    }

    public void addCustomer(String branchName, String customerName, double initialAmount){
        int indiceBranch = findBranch(branchName);
        if(indiceBranch != -1){
            branchTims.get(indiceBranch).newCustomer(customerName,initialAmount);
        }else {
            System.out.println("Branch or Customer's name not valid");
        }
    }

    public void addCustomerTransaction(String branchName, String customerName, double amount){
        int indiceBranch = findBranch(branchName);
        if(indiceBranch != -1){
            branchTims.get(indiceBranch).addCustomerTransaction(customerName,amount);
        }else{
            System.out.println("something went wrong !");
        }
    }

     public void listaCustomers(String branchName, boolean showTransactions){
        int indiceBranch = findBranch(branchName);
        ArrayList<CustomerTim> customerSizeWithinBranch = branchTims.get(indiceBranch).getCustomerTims();
        if(indiceBranch != -1) {
            for(int i = 0; i < customerSizeWithinBranch.size(); i++){
                System.out.println("Customer : "+ customerSizeWithinBranch.get(i).getName());
                if(showTransactions){
                    int transactionSize = branchTims.get(indiceBranch).getCustomerTims().get(i).getTransactionSize();
                    ArrayList<Double> transactionSizeWithinCustomer = customerSizeWithinBranch.get(i).getTransaction();
                    for(int j = 0; j < transactionSize; j++){
                        System.out.println("\t " + (j+1) + " Transaction " + transactionSizeWithinCustomer.get(j));
                    }
                }
            }
        }
     }

}



package Tim;

import java.util.ArrayList;

public class CustomerTim {

    private String name;
    private ArrayList<Double> transaction;

    public CustomerTim(String name, double initialTransaction) {
        this.name = name;
        this.transaction = new ArrayList<>();
        addTransaction(initialTransaction);
    }

    public CustomerTim(String name, ArrayList<Double> transaction) {
        this.name = name;
        this.transaction = transaction;
    }

    public void addTransaction (double amount){
        this.transaction.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public int getTransactionSize(){
        return transaction.size();
    }
}









