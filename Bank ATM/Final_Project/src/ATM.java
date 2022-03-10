import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;
/**
*@ClassName:ATM
*@Description: A ATM object. It serves as a bridge between Database and GUI. It handle data passed in by GUI and send it to database
 * for verification/action then pass the verification result/action result back to GUI.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/


public class ATM {
    private final DBSystem db = new DBSystem();
    private User user;

    private final Helper helper = new Helper();

    public ATM(){
        login();
    }

    private void login(){
        new LoginWindow(this);
    }

    //let user creat accounts
    public boolean createAccount(int accountType, String currency, double amount) {
        if (amount < Constants.Minimum_Account_Amount) {
            JOptionPane.showMessageDialog(null,"You have to deposit more than 30 dollars","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //saving account checks
        if (accountType == Constants.ACCOUNT_TYPE_SAVING_INT) {
            List<BankAccount> accounts = db.getAccounts(user.getUID());
            for (BankAccount account : accounts) {
                if (account.getAccountType().equals(Constants.ACCOUNT_TYPE_SAVING)&&account.getCurrency().getCode().equals(currency)) {
                    JOptionPane.showMessageDialog(null,"Saving account under this currency already exists","Error",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }

        BankAccount account = db.createAccount(user.getUID(), helper.convertTypeToString(accountType), amount,
                helper.convertCurrencyFromString(currency));
        if (account == null) {
            JOptionPane.showMessageDialog(null,"DB error!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //if its security account
        if (account.getAccountType().equals(Constants.ACCOUNT_TYPE_SECURITY) && account instanceof SecurityAccount) {
            JOptionPane.showMessageDialog(null,"Wrong atm method call create security account.","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //charge fees add transaction
        boolean accountCharges = createAccountCharges(account.getAccountID());
        if (!accountCharges) {
            JOptionPane.showMessageDialog(null,"Failure while charging!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.user instanceof Customer) {
            Customer user = (Customer) getUser();
            //add account to account list.
            user.getAccounts().add(account);
            user.setAccounts(user.getAccounts());
            return true;
        }

        return false;
    }

    //method for closingAccount
    public boolean closeAccount(int accountId) {
        BankAccount account = db.selectAccountById(accountId);
        if (account == null) {
            JOptionPane.showMessageDialog(null,"No such account while closing","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (account.getBalance()<Constants.OpenClose_Fee) {
            JOptionPane.showMessageDialog(null,"Balance is not enough for closing. Try it later.","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean b = closeAccountCharges(accountId);
        if (!b) {
            JOptionPane.showMessageDialog(null,"Failure while charging!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return db.deleteAccount(accountId);
    }

        //function signup which let a new user sign up on the system. isAdmin = 0 means customer. 1 means manager
    public boolean signUp(String name, String userName, String password, int isAdmin){
        //input check if empty return not empty.
        if (name.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"One of required information is empty please try again!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
//            throw new IllegalArgumentException("One of required information is empty please try again!");
        }
        //if the user name is not available
        if (!db.usernameCheck(userName)) {
            JOptionPane.showMessageDialog(null,"Username is not available!!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
//            throw new IllegalArgumentException("Username is not available!!");
        }

        //create on database and read the info.
        User user = db.addUser(name, userName, password, isAdmin);

        if (user == null)  {
            JOptionPane.showMessageDialog(null,"Unexpected error, Can't create user, please try it again!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
//            throw new IllegalArgumentException("Unexpected error, Can't create user, please try it again!");
        }

        //login the user directly after signup
        setUser(user);
        if (!user.isAdmin()) {
            login(user.getUserName(),user.getPassword());
        }
        return true;
    }
    //function login which let a user login on the system.
    public boolean login(String userName, String password){
        //input check if empty return not empty.
        if (userName.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"One of required information is empty please try again!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
//            throw new IllegalArgumentException("One of required information is empty please try again!");
        }

        User user = db.login(userName, password);

        //the user object is null
        if (user == null)  {
            JOptionPane.showMessageDialog(null,"Can't log in, please try it again!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
//            throw new IllegalArgumentException("Unexpected error, Can't create user, please try it again!");
        }

        //login the user directly after signup
        setUser(user);

        if (user.isAdmin()) {
            //load manager screen
            new ManagerWindow(this);

        }
        if (!user.isAdmin()) {
            //load customer screen
            new CustomerWindow(this);
        }
        return true;
    }

    //method for charging fee while open account
    public boolean createAccountCharges(int accountId){
        return makeTransaction(accountId, Constants.ADMIN_ACCOUNT_ID, Constants.OpenClose_Fee, "Open Account Fee");
    }

    //method for charging fee while open account
    public boolean closeAccountCharges(int accountId){
        return makeTransaction(accountId, Constants.ADMIN_ACCOUNT_ID, Constants.OpenClose_Fee, "Close Account Fee");
    }

    //basic make transaction method without any addition fees.
    public boolean makeTransaction(int accountId, int targetAccountId, double amount, String type) {
        List<BankAccount> allAccounts = db.getAccounts(Constants.SELECT_ALL_ACCOUNTS);

        //get the information of two accounts
        BankAccount initialAccount = null;
        BankAccount targetAccount = null;
        for (BankAccount account : allAccounts) {
            if (account.getAccountID() == accountId) initialAccount = account;
            if (account.getAccountID() == targetAccountId) targetAccount = account;
        }

        //check accounts
        if (targetAccount == null) {
            JOptionPane.showMessageDialog(null,"initial account information isn't correct","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (initialAccount == null) {
            JOptionPane.showMessageDialog(null,"target account information isn't correct","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //check if the two accounts are under same currency
        if (!targetAccount.getCurrency().getCode().equals(initialAccount.getCurrency().getCode())&& targetAccountId!=1) {
            JOptionPane.showMessageDialog(null,"Two accounts are not under same currency","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (initialAccount.getBalance()< amount && initialAccount.getAccountID() != 1) {
            JOptionPane.showMessageDialog(null,"Your account doesnt have enough money! The transaction fee is 10 bucks!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (initialAccount instanceof CheckingAccount && initialAccount.getBalance()< amount+Constants.Checking_Transaction_Fee) {
            JOptionPane.showMessageDialog(null,"Your account doesnt have enough money! The transaction fee is 10 bucks!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //change balance of both accounts
        db.updateAccount(initialAccount.getAccountID(), initialAccount.getBalance()-amount);
        db.updateAccount(targetAccount.getAccountID(), targetAccount.getBalance()+amount);
        //create transactions
        db.createTransaction(accountId,targetAccountId, initialAccount.getCurrency().getCode(), amount, type);

        return true;
    }

    //let user withDraw Money
    public boolean withDraw(int accountId, double amount){
        BankAccount account = db.selectAccountById(accountId);
        if (inputCheckForAccount(amount, account)) return false;

        //if not enough money
        if (account.getBalance()-amount < 0) {
            JOptionPane.showMessageDialog(null,"You dont have enough money to withdraw","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //if the update success or not.
        return db.updateAccount(accountId, account.getBalance() - amount);
    }

    private boolean inputCheckForAccount(double amount, BankAccount account) {
        //if the account is wrong
        if (account == null) {
            JOptionPane.showMessageDialog(null,"No such account","Error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (amount <= 0) {
            JOptionPane.showMessageDialog(null,"The money input should be larger than 0","Error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    //let user withDraw Money
    public boolean deposit(int accountId, double amount){
        BankAccount account = db.selectAccountById(accountId);
        //if the account is wrong
        if (inputCheckForAccount(amount, account)) return false;

        //if the update success or not.
        return db.updateAccount(accountId, account.getBalance() + amount);
    }

    //let user create loan
    public boolean createLoan(int user_id, double amount, String currency, String collateral) {

        //let db create loan
        Loan loan = db.createLoan(user_id, currency, amount, collateral);
        if (loan == null) {
            JOptionPane.showMessageDialog(null,"Creating loan error!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    //let user payback loan
    public boolean payLoans(int user_id, int loanId, double amount) {

        //let db create loan
        Loan loan = db.selectLoanById(loanId);
        if (loan == null) {
            JOptionPane.showMessageDialog(null,"Getting loan info error!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //make sure its the right user
        if (loan.getUID() != user_id) {
            JOptionPane.showMessageDialog(null,"You are not paying your loans sth wrong","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (amount<=0 && amount>loan.getAmount()) {
            JOptionPane.showMessageDialog(null,"invalid amount. put an number which is greater than 0 and smaller or equal to your loan amount","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //end loan
        if (amount == loan.getAmount()) {
            return db.deleteLoan(loanId);
        }

        //update amount
        return db.updateLoan(loanId,loan.getAmount()-amount);

    }

    // get accounts on specific user if userid = Constants.SELECT_ALL_ACCOUNTS = -10086 get all accounts
    public List<BankAccount> getAccountsOfUser(int userId) {
        return db.getAccounts(userId);
    }

    // get loans on specific user if userid = Constants.SELECT_ALL_ACCOUNTS = -10086 get all loans
    public List<Loan> getLoansOfUser(int userId) {
        return db.getLoans(userId);
    }

    // let admin create stock
    public boolean createStock(String ticker, String companyName, double currentPrice) {
        //input check
        String currency = "USD";
        int amountAvailable = 999999;
        if (currentPrice <= 0 || amountAvailable<0) {
            JOptionPane.showMessageDialog(null,"invalid price or invalid amountAvailable","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (ticker.isEmpty() || companyName.isEmpty()) {
            JOptionPane.showMessageDialog(null,"invalid name or ticker.","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!helper.currencyCheck(currency)) {
            JOptionPane.showMessageDialog(null,"invalid currency.","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //createStock
        Stock stock = db.createStock(ticker, companyName, currentPrice, currency, amountAvailable);
        if (stock == null) {
            System.err.println("DB error");
            return false;
        }
        return true;
    }

    //delete stock from list
    public boolean deleteStock(int stockId) {
        if (!db.deleteStock(stockId)) return false;
        //delete relatives
        return db.deleteStockUserByStockId(stockId);
    }

    //hide stock for user
    public boolean hideStock(int stockId) {
        return db.hideStock(stockId);
    }

    //change stock price by admin
    public boolean updateStockPrice(int stockId, double newPrice) {
        return db.updateStock(stockId, newPrice);
    }

    //change stock amount that are available
    public boolean updateStockAva(int stockId, int newAmount) {
        return db.updateAmountAvailable(stockId, newAmount);
    }

    //get all stocks from DB for admin use
    public List<Stock> getAllStocks() {
        return db.getStocks();
    }

    //get all stocks from DB for user shown. All available stocks that user can browse.
    public List<Stock> getAllStocksForUser() {
        return db.getStocksForUser();
    }

    //show user their info about stocks
    public StockOfUser getAllPurchasedStocks(int userId) {
        StockOfUser result = new StockOfUser();
        BankAccount securityAccount = getBankAccount(userId);
        if (securityAccount == null) {
            System.err.println("security Account is null");
            return null;
        }
        //update stock info and realized profit info.
        result.updateStockOfUser(userId, securityAccount.getAccountID());
        return result;
    }

    //create securityAccount
    public boolean createSecurityAccount(int userId, double amount) {
        String currency = Constants.CURRENCY_CODE[0];
        if (amount < Constants.MINIMUM_SECURITY_ACCOUNT_AMOUNT) {
            JOptionPane.showMessageDialog(null,"You have to deposit more than or equal to 1000 dollars","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        List<BankAccount> accounts = db.getAccounts(userId);
        List<BankAccount> collect = accounts.stream().filter(o -> o.getAccountType().equals(Constants.ACCOUNT_TYPE_SAVING))
                .filter(o -> o.getCurrency().getCode().equals(currency))
                .collect(Collectors.toList());
        SavingAccount savingAccount = (SavingAccount) collect.get(0);

        if (savingAccount == null) {
            JOptionPane.showMessageDialog(null,"You have related saving account","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //if saving has less than minimum required
        if (savingAccount.getBalance()-amount < Constants.MINIMUM_SECURITY_ACCOUNT_AMOUNT_REMAIN) {
            JOptionPane.showMessageDialog(null,"You have to keep your saving account holds greater than 2500 dollars","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!db.updateAccount(savingAccount.getAccountID(), savingAccount.getBalance()-amount)) {
            System.err.println("Charge from Saving error");
            return false;
        }


        BankAccount account = db.createAccount(user.getUID(), helper.convertTypeToString(Constants.ACCOUNT_TYPE_SECURITY_INT), amount,
                helper.convertCurrencyFromString(currency));
        if (account == null) {
            JOptionPane.showMessageDialog(null,"DB error!","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //if its security account created related info
        if (account instanceof SecurityAccount) {
            boolean userProfitTable = db.createUserProfitTable(account.getAccountID());
            if (!userProfitTable) {
                System.err.println("error while creating security account");
                return false;
            }
        }

        if (this.user instanceof Customer) {
            Customer user = (Customer) getUser();
            //add account to account list.
            user.getAccounts().add(account);
            user.setAccounts(user.getAccounts());
            return true;
        }

        return false;
    }

    //let user buy stock on their securityAccount
    public boolean buyStock(int userId, int stockId, int amount) {
        List<BankAccount> bankAccounts = db.getAccounts(userId);
        Stock currentStock = db.selectStockById(stockId);
        //get the only security Account
        BankAccount securityAccount = null;
        List<BankAccount> collect = bankAccounts.stream().filter(o -> o.getAccountType().equals(Constants.ACCOUNT_TYPE_SECURITY))
                .collect(Collectors.toList());
        if (!collect.isEmpty()) {
            securityAccount = collect.get(0);
        }
        if (inputCheck(amount, currentStock, securityAccount)) return false;

        if (amount > currentStock.getAvailableAmount()) {
            JOptionPane.showMessageDialog(null,"Stock has amount available less than your input amount","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //create stocks_user or update stocks_user
        List<StockUserDTO> stockDTOList = db.getStockDTOList(userId, securityAccount.getAccountID());
        boolean created = false;
        StockUserDTO stockDTO = null;
        for (StockUserDTO stockUserDTO : stockDTOList) {
            if (stockUserDTO.getStockId() == stockId) {
                created = true;
                //already created just update.
                stockDTO = stockUserDTO;
                break;
            }
        }

        if (created) {
            //update amount hold
            int amountHold = stockDTO.getAmountHold();
            db.updateStockUser(stockDTO.getId(), amountHold+amount);
            //update avgPrice
            double pastAvgPrice = stockDTO.getAvgPrice();
            double avgPrice = (pastAvgPrice * amountHold + currentStock.getCurrentPrice() * amount) / (amountHold + amount);
            db.updateStockUserAvgPrice(stockDTO.getId(),avgPrice);
        } else {
            //create
            StockUserDTO stockUserForm = db.createStockUserForm(userId, securityAccount.getAccountID(), stockId, currentStock.getCurrentPrice(),
                    helper.convertCurrencyFromString(currentStock.getCurrency()), amount);
            if (stockUserForm == null) { return false; }
        }
        db.updateAccount(securityAccount.getAccountID(),securityAccount.getBalance() - amount*currentStock.getCurrentPrice());
        //update sotcks reduce amount available
        return db.updateAmountAvailable(stockId, currentStock.getAvailableAmount() - amount);
    }

    private boolean inputCheck(int amount, Stock currentStock, BankAccount securityAccount) {
        if (securityAccount == null) {
            JOptionPane.showMessageDialog(null, "No related security Account", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        //read info of current stockDTO

        if (currentStock == null) {
            JOptionPane.showMessageDialog(null, "No stockDTO info related to this stockId", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println("No stockDTO info related to this stockId");
            return true;
        }

        if (amount * currentStock.getCurrentPrice() > securityAccount.getBalance()) {
            JOptionPane.showMessageDialog(null, "You dont have enough money on your securityAccount", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    //let user sell their stock and calculte profit.
    public boolean sellStock(int userId, int stockId, int amount) {
        //update stockUser or delete
        Stock currentStock = db.selectStockById(stockId);
        BankAccount securityAccount = getBankAccount(userId);
        if (inputCheck(amount, currentStock, securityAccount)) return false;

        //get user stocks
        List<StockUserDTO> stockDTOList = db.getStockDTOList(userId, securityAccount.getAccountID());
        StockUserDTO stockDTO = null;
        for (StockUserDTO stockUserDTO : stockDTOList) {
            if (stockUserDTO.getStockId() == stockId) {
                //already created just update.
                stockDTO = stockUserDTO;
                break;
            }
        }
        if (stockDTO == null) {
            JOptionPane.showMessageDialog(null,"No related data on Stock_user table","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //if selling more than amount hold
        if (stockDTO.getAmountHold() < amount) {
            JOptionPane.showMessageDialog(null,"You dont have enough stocks to sell","Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (stockDTO.getAmountHold() == amount){
            //if amount is equal user will no longer hold this stock
            if (!db.deleteStockUser(stockDTO.getId())) {
                System.err.println("delete stock user fail");
                return false;
            }
        } else {
            //if amount is less than user hold, update it
            if(!db.updateStockUser(stockDTO.getId(), stockDTO.getAmountHold() - amount)) {
                System.err.println("update stock user fail");
                return false;
            }
        }
        double realizedProfit = amount*(currentStock.getCurrentPrice()-stockDTO.getAvgPrice());
        db.updateAccount(securityAccount.getAccountID(),securityAccount.getBalance() + amount*currentStock.getCurrentPrice());
        return db.updateUserProfitTable(stockDTO.getAccountId(), realizedProfit);
    }

    private BankAccount getBankAccount(int userId) {
        List<BankAccount> bankAccounts = db.getAccounts(userId);
        //get the only security Account
        BankAccount securityAccount = null;
        List<BankAccount> collect = bankAccounts.stream().filter(o -> o.getAccountType().equals(Constants.ACCOUNT_TYPE_SECURITY))
                .collect(Collectors.toList());
        if (!collect.isEmpty()) {
            securityAccount = collect.get(0);
        }
        return securityAccount;
    }

    //check if the user has security account or not. True is already have one
    public boolean haveSecurityAccount(int userId) {
        List<BankAccount> accounts = db.getAccounts(userId);
        for (BankAccount account : accounts) {
            if (account instanceof SecurityAccount) {
                return true;
            }
        }
        return false;
    }

    //get the security account with a specific user id
    public SecurityAccount getSecurityAccount(int userId) {
        List<BankAccount> accounts = db.getAccounts(userId);
        for (BankAccount account : accounts) {
            if (account instanceof SecurityAccount) {
                return (SecurityAccount) account;
            }
        }
        return null;
    }

    public SavingAccount getUsdSavingAccount() {
        int userId = this.getUser().getUID();
        List<BankAccount> accounts = db.getAccounts(userId);
        for (BankAccount account : accounts) {
            if (account.getCurrency().getCode().equals(Constants.CURRENCY_CODE[0]) &&
                    account.getAccountType().equals(Constants.ACCOUNT_TYPE_SAVING)) {
                return (SavingAccount) account;
            }
        }
        return null;
    }

    public void logout() { login(); }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
