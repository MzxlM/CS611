import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
*@ClassName:Customer
*@Description:A Customer object. It is a subclass of User class. Customer has multiple bank accounts.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Customer extends User {
    private List<BankAccount> accounts = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public Customer(int UID, String name, String userName, String password){
        super(UID, name, userName, password, false);
//        updatedLoans();
//        updatedAccounts();
    }

    //check if there's an saving account which is greater than 5000 USD only.
    public boolean hasOver5000USDAccount() {
        updatedAccounts();
        List<BankAccount> bankAccounts = getAccounts().stream().filter(o -> o.getCurrency().getCode().equals("USD"))
                .filter(o -> o.getAccountType().equals(Constants.ACCOUNT_TYPE_SAVING))
                .filter(o -> o.getBalance() >= 5000.0).collect(Collectors.toList());
        return !bankAccounts.isEmpty();
    }

    //update accounts info from DB
    public void updatedAccounts() {
        DBSystem bankDB = new DBSystem();
        List<BankAccount> accounts = bankDB.getAccounts(this.getUID());
        setAccounts(accounts);
    }

    //update accounts info from DB
    public void updatedLoans() {
        DBSystem bankDB = new DBSystem();
        List<Loan> loans = bankDB.getLoans(this.getUID());
        setLoans(loans);
    }

    //return all trans from current user
    public List<Transaction> getHisTransactions(){
        DBSystem bankDB = new DBSystem();
        return bankDB.getTrans(this.getUID());
    }

    //getters and setters
    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
