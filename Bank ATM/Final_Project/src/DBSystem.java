import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
*@ClassName:DBSystem
*@Description:A DBSystem object. It provides database support for the ATM program. Any changes made by users are reflected on the database.
 * Therefore, everything is traceable and well recorded for ATM project.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class DBSystem {
    private Connection c = null;
    private CustomerFactory customerFactory = new CustomerFactory();
    private ManagerFactory managerFactory = new ManagerFactory();

    private final Helper helper = new Helper();
    //bankDB object creates connection to database
    public DBSystem() {
        try {
            Class.forName("org.sqlite.JDBC");
            //read the file location
            String file = System.getProperty("user.dir") + "/src/";
            String url = "jdbc:sqlite:" + file + "database/Bank.db";
            //System.out.println(url);
            
            //create connection to database
            c = DriverManager.getConnection(url);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void initialize() {
        dropTables();
        createTables();
    }

    //create tables that are needed.
    public boolean createTables(){
        Statement stmt;
        try {
            //connecting to DB
            stmt = c.createStatement();
            //create tables user, account, transaction, loan, stock, stock_user
            stmt.execute(Constants.CREATE_TABLES_USER);
            stmt.execute(Constants.CREATE_TABLES_ACCOUNT);
            stmt.execute(Constants.CREATE_TABLES_TRANSACTION);
            stmt.execute(Constants.CREATE_TABLES_LOAN);
            stmt.execute(Constants.CREATE_TABLES_STOCK);
            stmt.execute(Constants.CREATE_TABLES_STOCK_USER);
            stmt.execute(Constants.CREATE_TABLES_STOCK_PROFIT);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        // add default admin user to the user table
        addAdmin();
        return true;
    }

    //drop all tables
    public boolean dropTables(){
        Statement stmt;
        try {
            //connecting to DB
            stmt = c.createStatement();
            //drop tables user, account, transaction, loan, stock, stock_user
            stmt.execute(Constants.DROP_TABLES_USER);
            stmt.execute(Constants.DROP_TABLES_ACCOUNT);
            stmt.execute(Constants.DROP_TABLES_TRANSACTION);
            stmt.execute(Constants.DROP_TABLES_LOAN);
            stmt.execute(Constants.DROP_TABLES_STOCK);
            stmt.execute(Constants.DROP_TABLES_STOCK_USER);
            stmt.execute(Constants.DROP_TABLES_USER_PROFIT);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addAdmin(){
        Statement stmt;
        try {
            //connecting to DB
            stmt = c.createStatement();
            //add admin to user table
            stmt.execute(Constants.ADD_ADMIN);
            //add admin which is bank account;
            stmt.execute(Constants.ADD_ADMIN_ACCOUNT);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //check if the username on database is unique. True means username is available
    public boolean usernameCheck (String username){
        //sql command
        String sql = "SELECT COUNT(id) FROM users WHERE user_name = ? AND enable = 1";

        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setString(1, username);
            //do the query
            ResultSet rs = pstmt.executeQuery();
            int counts = rs.getInt(1);
            if (counts < 1) {
                pstmt.close();
                rs.close();
                return true;
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    //add a new user to the DB.
    public User addUser(String name, String username, String pass, int isAdmin) {
        //sql command
        String sql = "INSERT INTO users(name, user_name, password, admin) VALUES (?,?,?,?)";
        User newUser;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, pass);
            pstmt.setInt(4, isAdmin);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = 0;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = (int) generatedKeys.getLong(1);
                }
                else {
                    System.out.println("Creating user failed, no ID obtained.");
//                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            pstmt.close();
            if (isAdmin == 1) {
//                newUser = new Manager(i,name,username,pass);
                newUser = managerFactory.GetManager(id,name,username,pass);
            } else {
//                newUser = new Customer(i,name,username,pass);
                newUser = customerFactory.GetCustomer(id,name,username,pass);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return newUser;
    }

    //check the username and password
    public User login(String username, String password) {
        //sql command
        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ? AND enable = 1;";
        User user;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs    = pstmt.executeQuery();

            int id = rs.getInt(1);
            pstmt.close();
            rs.close();

            if (id == 0) return null;
            //create the user object
            user = selectUserById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    //select the user info by userid.
    public User selectUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ? AND enable = 1;";
        User user;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            //store info
            String name = rs.getString(2);
            String username = rs.getString(3);
            String password = rs.getString(4);
            int isAdmin = rs.getInt(5);

            if (isAdmin == 1) {
//                user = new Manager(id,name,username,password);
                user = managerFactory.GetManager(id,name,username,password);
            } else {
                //user = new Object.Customer(id,name,username,password);
                user = customerFactory.GetCustomer(id,name,username,password);
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    //add a new account to DB
    public BankAccount createAccount (int userId, String accountType, double initialAmount, Currency currency){
        //sql command
        String sql = "INSERT INTO accounts(user_id, type, amount, currency) VALUES (?,?,?,?)";
        BankAccount newBankAccount;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setInt(1, userId);
            pstmt.setString(2, accountType);
            pstmt.setDouble(3, initialAmount);
            pstmt.setString(4, currency.getCode());
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = 0;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = (int) generatedKeys.getLong(1);
                }
                else {
                    System.out.println("Creating account failed, no ID obtained.");
                }
            }
            pstmt.close();
            newBankAccount = helper.createAccountObject(id, userId, accountType, initialAmount, currency);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return newBankAccount;

    }

    //select the user info by userid.
    public BankAccount selectAccountById(int id) {
        String sql = "SELECT * FROM accounts WHERE id = ? AND enable = 1;";
        BankAccount bankAccount;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            //store info
            int userId = rs.getInt("user_id");
            String accountType = rs.getString("type");
            double balance = rs.getDouble("amount");
            String currency = rs.getString("currency");
            pstmt.close();
            rs.close();
            bankAccount = helper.createAccountObject(id, userId, accountType, balance, helper.convertCurrencyFromString(currency));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bankAccount;
    }

    //get all accounts from this user from DB
    public List<BankAccount> getAccounts (int userId){
        //sql command
        String sql = "SELECT * FROM accounts WHERE user_id = ? AND enable = 1;";
        List<BankAccount> newBankAccounts = new ArrayList<>();
        PreparedStatement pstmt;
        try {
            if (userId != Constants.SELECT_ALL_ACCOUNTS) {
                //connecting to DB
                pstmt = c.prepareStatement(sql);
                //set parameters
                pstmt.setInt(1, userId);

            } else {
                sql = "SELECT * FROM accounts WHERE enable = 1";
                //connecting to DB
                pstmt = c.prepareStatement(sql);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int user_id = rs.getInt("user_id");
                String type = rs.getString("type");
                double amount = rs.getDouble("amount");
                String currency = rs.getString("currency");

                //create account object
                BankAccount accountObject = helper.createAccountObject(id, user_id, type, amount, helper.convertCurrencyFromString(currency));
                if (accountObject != null) {
                    newBankAccounts.add(accountObject);
                }
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return newBankAccounts;

    }

    //update the balance of selected account.
    public boolean updateAccount (int accountId, double balance) {
        //sql command
        String sql = "UPDATE accounts SET amount = ? WHERE id = ? AND enable = 1;";

        return updateLoan(accountId, balance, sql);

    }

    //let user close their account by entering id
    public boolean deleteAccount(int id) {
        String sql = "UPDATE accounts SET enable = 0 WHERE id = ? AND enable = 1";

        //cant close admin account
        if (id == 1) {
            System.out.println("admin account cant be closed");
            return false;
        }

        //set enable false
        return !deleteById(id, sql);
    }

    //add a new Transaction to DB
    public Transaction createTransaction(int accountId, int targetAccountId, String currency, double amount, String type){
        //sql command
        String sql = "INSERT INTO transactions ( account_id, target_account_id, currency, amount, type ) VALUES ( ?, ?, ?, ?, ?)";
        Transaction transaction;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setInt(1, accountId);
            pstmt.setInt(2, targetAccountId);
            pstmt.setString(3, currency);
            pstmt.setDouble(4, amount);
            pstmt.setString(5, type);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = 0;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = (int) generatedKeys.getLong(1);
                }
                else {
                    System.out.println("Creating transactions failed, no ID obtained.");
                }
            }
            pstmt.close();

            //create
            transaction = selectTransactionById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return transaction;

    }

    //select the user info by userid.
    public Transaction selectTransactionById(int id) {
        String sql = "SELECT * FROM transactions WHERE id = ? AND enable = 1;";
        Transaction transaction;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            //store info
            int accountId = rs.getInt(2);
            int targetAccountId = rs.getInt(3);
            String currency = rs.getString(4);
            double amount = rs.getDouble(5);
            String type = rs.getString(6);
            String timestamp = rs.getString(7);

            pstmt.close();
            rs.close();
            transaction = new Transaction(id, accountId, targetAccountId, currency, amount, type, timestamp);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return transaction;
    }

    //get all accounts from this user from DB
    public List<Transaction> getTrans (int userId){
        //sql command
        String sql = "SELECT a.id, a.account_id, a.target_account_id, a.currency, a.amount, a.type, a.enable, a.create_time FROM transactions as a INNER JOIN accounts as b ON a.account_id=b.id WHERE b.user_id = ? AND a.enable = 1 AND b.enable = 1;";
        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement pstmt;
        try {
            if (userId != Constants.SELECT_ALL_ACCOUNTS) {
                //connecting to DB
                pstmt = c.prepareStatement(sql);
                //set parameters
                pstmt.setInt(1, userId);

            } else {
                sql = "SELECT * FROM transactions WHERE enable = 1";
                //connecting to DB
                pstmt = c.prepareStatement(sql);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int accountId = rs.getInt("account_id");
                int targetAccountId = rs.getInt("target_account_id");
                String currency = rs.getString("currency");
                double amount = rs.getDouble("amount");
                String type = rs.getString("type");
                String createTime = rs.getString("create_time");
                //create account object
                Transaction transaction = new Transaction(id, accountId, targetAccountId, currency, amount, type, createTime);
                transactions.add(transaction);
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return transactions;

    }

    //add a new loan to DB
    public Loan createLoan(int userId, String currency, double amount, String collateral){
        //sql command
        String sql = "INSERT INTO loans ( user_id, currency, amount, collateral ) VALUES (?, ?, ?, ?)";
        Loan newLoan;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setInt(1, userId);
            pstmt.setString(2, currency);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, collateral);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = 0;
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = (int) generatedKeys.getLong(1);
                }
                else {
                    System.out.println("Creating loan failed, no ID obtained.");
                }
            }
            pstmt.close();

            //create loan
            newLoan = selectLoanById(id);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return newLoan;

    }

    //select the user info by userid.
    public Loan selectLoanById(int id) {
        String sql = "SELECT * FROM loans WHERE id = ? AND enable = 1;";
        Loan loan;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            //store info
            int userId = rs.getInt(2);
            String currency = rs.getString(3);
            double amount = rs.getDouble(4);
            String collateral = rs.getString(5);
            pstmt.close();
            rs.close();
            loan = new Loan(id, userId, helper.convertCurrencyFromString(currency), amount, collateral);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return loan;
    }

    //update the balance of selected loan.
    public boolean updateLoan (int loanId, double balance) {
        //sql command
        String sql = "UPDATE loans SET amount = ? WHERE id = ? AND enable = 1;";

        return updateLoan(loanId, balance, sql);

    }

    private boolean updateLoan(int loanId, double balance, String sql) {
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setDouble(1, balance);
            pstmt.setInt(2, loanId);
            // update
            int i = pstmt.executeUpdate();

            if (i == 0) {
                pstmt.close();
                return false;
            }
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //let user close their account by entering id
    public boolean deleteLoan(int id) {
        String sql = "UPDATE loans SET enable = 0 WHERE id = ? AND enable = 1";
        //set enable false
        return !deleteById(id, sql);
    }


    //get all accounts from this user from DB
    public List<Loan> getLoans (int userId){
        //sql command
        String sql = "SELECT * FROM loans WHERE user_id = ? AND enable = 1;";
        List<Loan> loans = new ArrayList<>();
        PreparedStatement pstmt;
        try {
            if (userId != Constants.SELECT_ALL_ACCOUNTS) {
                //connecting to DB
                pstmt = c.prepareStatement(sql);
                //set parameters
                pstmt.setInt(1, userId);

            } else {
                //todo see if enable needed
                sql = "SELECT * FROM loans WHERE enable = 1";
                //connecting to DB
                pstmt = c.prepareStatement(sql);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int user_id = rs.getInt("user_id");
                String currency = rs.getString("currency");
                String collateral = rs.getString("collateral");
                double amount = rs.getDouble("amount");

                //create account object
                Loan loan = new Loan(id,user_id, helper.convertCurrencyFromString(currency),amount,collateral);
                loans.add(loan);
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return loans;

    }


    //delete by id
    private boolean deleteById(int id, String sql) {
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();

            if (i == 0) {
                System.out.println("no row effect while closing");
                pstmt.close();
                return true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    //create stock on DB
    public Stock createStock(String ticker, String companyName, double currentPrice, String currency, int amountAvailable) {
        //sql command
        String sql = "INSERT INTO stocks(ticker, company_name, current_price, currency, amount_available) VALUES (?,?,?,?,?)";
        Stock stock;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setString(1, ticker);
            pstmt.setString(2, companyName);
            pstmt.setDouble(3, currentPrice);
            pstmt.setInt(5, amountAvailable);
            pstmt.setString(4, currency);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = getId(pstmt);
            pstmt.close();
            stock = new Stock(id, ticker, companyName, currentPrice, currency, amountAvailable);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return stock;
    }

    //let manager delete their stocks by entering id
    public boolean deleteStock(int stockId) {
        String sql = "UPDATE stocks SET enable = 0 WHERE id = ? AND enable = 1";

        //cant close admin account
        if (stockId <= 0) {
            System.out.println("input error");
            return false;
        }

        //set enable false
        return !deleteById(stockId, sql);
    }

    //let manager hide their stocks by entering id
    public boolean hideStock(int stockId) {
        String sql = "UPDATE stocks SET available = 0 WHERE id = ? AND enable = 1";

        //cant close admin account
        if (stockId <= 0) {
            System.out.println("input error");
            return false;
        }

        //set enable false
        return !deleteById(stockId, sql);
    }

    //update stock price by id
    public boolean updateStock (int stockId, double balance) {
        //sql command
        String sql = "UPDATE stocks SET current_price = ? WHERE id = ? AND enable = 1;";

        return updateLoan(stockId, balance, sql);

    }

    //update stock amount by id
    public boolean updateAmountAvailable(int stockId, int amountAvailable) {
        //sql command
        String sql = "UPDATE stocks SET amount_available = ? WHERE id = ? AND enable = 1;";

        return updateLoan(stockId, amountAvailable, sql);

    }

    //get all stocks from DB for admin use
    public List<Stock> getStocks (){
        //sql command
        String sql = "SELECT * FROM stocks WHERE enable = 1;";
        List<Stock> stocks = new ArrayList<>();
        if (getStocksFromDB(sql, stocks)) return new ArrayList<>();
        return stocks;

    }

    //get all stocks from DB for user browse
    public List<Stock> getStocksForUser(){
        //sql command
        String sql = "SELECT * FROM stocks WHERE enable = 1 AND available = 1;";
        List<Stock> stocks = new ArrayList<>();
        if (getStocksFromDB(sql, stocks)) return new ArrayList<>();
        return stocks;

    }

    //select the user info by userid.
    public Stock selectStockById(int id) {
        String sql = "SELECT * FROM stocks WHERE id = ? AND enable = 1 AND available = 1;";
        Stock stock;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            //store info
            String ticker = rs.getString("ticker");
            String company_name = rs.getString("company_name");
            double currentPrice = rs.getDouble("current_price");
            String currency = rs.getString("currency");
            int amount_available = rs.getInt("amount_available");
            pstmt.close();
            rs.close();
            stock = new Stock(id, ticker, company_name, currentPrice, currency, amount_available);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return stock;
    }

    private boolean getStocksFromDB(String sql, List<Stock> stocks) {
        PreparedStatement pstmt;
        try {
            pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ticker = rs.getString("ticker");
                String companyName = rs.getString("company_name");
                double currentPrice = rs.getDouble("current_price");
                int amount = rs.getInt("amount_available");
                int available = rs.getInt("available");
                String currency = rs.getString("currency");
                boolean availableB = false;
                if (available == 1) availableB = true;

                //create account object
                Stock stock = new Stock(id, ticker, companyName, currentPrice, currency, amount, availableB);
                stocks.add(stock);
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    //add a new stock_user data to DB
    public StockUserDTO createStockUserForm (int userId, int accountId, int stockId, double avgPrice, Currency currency, int amount_hold){
        //sql command
        String sql = "INSERT INTO stocks_user(user_id, account_id, stock_id, avg_price, currency, amount_hold) VALUES (?,?,?,?,?,?)";
        StockUserDTO stockUserDTO;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setInt(1, userId);
            pstmt.setInt(2, accountId);
            pstmt.setInt(3, stockId);
            pstmt.setDouble(4, avgPrice);
            pstmt.setString(5, currency.getCode());
            pstmt.setInt(6,amount_hold);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return null;
            }
            int id = getId(pstmt);
            pstmt.close();
            stockUserDTO = new StockUserDTO(id, userId, accountId, stockId, avgPrice, currency.toString(), amount_hold);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return stockUserDTO;
    }

    private int getId(PreparedStatement pstmt) throws SQLException {
        int id = 0;
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                id = (int) generatedKeys.getLong(1);
            }
            else {
                System.out.println("Creating stock failed, no ID obtained.");
            }
        }
        return id;
    }

    //update stock user hold amount by id
    public boolean updateStockUser (int stockUserId, int amountHold) {
        //sql command
        String sql = "UPDATE stocks_user SET amount_hold = ? WHERE id = ? AND enable = 1;";
        return updateLoan(stockUserId, amountHold, sql);
    }

    //update stock user hold amount by id
    public boolean updateStockUserAvgPrice (int stockUserId, double avgPrice) {
        //sql command
        String sql = "UPDATE stocks_user SET avg_price = ? WHERE id = ? AND enable = 1;";
        return updateLoan(stockUserId, avgPrice, sql);
    }

    //get all stocks for a specific user
    public List<StockUserDTO> getStockDTOList(int userId, int accountId) {
        //sql command
        String sql = "SELECT * FROM stocks_user WHERE user_id = ? AND enable = 1 AND account_id = ?;";
        List<StockUserDTO> stockUserDTOList = new ArrayList<>();
        PreparedStatement pstmt;
        try {
            //connecting to DB
            pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, userId);
            pstmt.setInt(2, accountId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int stockId = rs.getInt("stock_id");
                double avgPrice = rs.getDouble("avg_price");
                String currency = rs.getString("currency");
                int amount = rs.getInt("amount_hold");

                //create account object
                StockUserDTO stockUserDTO = new StockUserDTO(id, userId, accountId, stockId, avgPrice, currency, amount);
                stockUserDTOList.add(stockUserDTO);
            }
            pstmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return stockUserDTOList;
    }

    //delete by entering id
    public boolean deleteStockUser(int id) {
        String sql = "UPDATE stocks_user SET enable = 0 WHERE id = ? AND enable = 1";
        //set enable false
        return !deleteById(id, sql);
    }

    //delete by entering id
    public boolean deleteStockUserByStockId(int id) {
        String sql = "UPDATE stocks_user SET enable = 0 WHERE stock_id = ? AND enable = 1";
        //set enable false
        return !deleteById(id, sql);
    }

    //add a new user profit data to DB
    public boolean createUserProfitTable (int accountId){
        //sql command
        String sql = "INSERT INTO user_profit(account_id, realized_profit) VALUES (?,0)";
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //set parameters
            pstmt.setInt(1, accountId);
            int i = pstmt.executeUpdate();
            if (i == 0) {
                System.out.println("no row effected");
                pstmt.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //update the value on user profit table
    public boolean updateUserProfitTable (int accountId, double realizedProfit) {
        //sql command
        String sql = "UPDATE user_profit SET realized_profit = ? WHERE account_id = ? AND enable = 1;";
        return updateLoan(accountId, realizedProfit, sql);
    }

    //let user close their account related by entering id
    public boolean deleteUserProfitTable(int id) {
        String sql = "UPDATE user_profit SET enable = 0 WHERE id = ? AND enable = 1";
        //set enable false
        return !deleteById(id, sql);
    }

    //select realized profit.
    public Double selectRealizedProfitById(int accountId) {
        String sql = "SELECT realized_profit FROM user_profit WHERE account_id = ? AND enable = 1;";
        double result;
        try {
            //connecting to DB
            PreparedStatement pstmt = c.prepareStatement(sql);
            //set parameters
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            result = rs.getDouble("realized_profit");
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

}
