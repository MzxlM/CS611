import java.util.List;

/**
*@ClassName:Constants
*@Description:A Constants object. It keeps all the constant static variables in the program.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Constants {
    //Admin with default ID = 1
    public static final int ADMIN_ID = 1;
    public static final int ADMIN_ACCOUNT_ID = 1;

    public static final Double INTEREST_BALANCE = 5000.0;
    public static final Double INTEREST_RATE = 0.01;
    public static final Double LOAN_RATE = 0.1;


    //creating tables
    public static final String CREATE_TABLES_USER = "CREATE TABLE \"users\" (\n" +
            "            \t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "            \t\"name\" TEXT NOT NULL,\n" +
            "            \t\"user_name\" TEXT NOT NULL,\n" +
            "            \t\"password\" TEXT NOT NULL,\n" +
            "            \t\"admin\" INT ( 1 ) NOT NULL DEFAULT 0,\n" +
            "            \t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \tUNIQUE ( \"ID\" ASC )\n" +
            "            );";
    public static final String CREATE_TABLES_ACCOUNT = "CREATE TABLE \"accounts\" (\n" +
            "\t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"user_id\" INTEGER NOT NULL,\n" +
            "\t\"type\" TEXT NOT NULL,\n" +
            "\t\"amount\" REAL NOT NULL DEFAULT '0',\n" +
            "\t\"currency\" TEXT NOT NULL DEFAULT 'USD',\n" +
            "\t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "\t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "\t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "\tUNIQUE ( \"ID\" ASC ),\n" +
            "\tFOREIGN KEY ( user_id ) REFERENCES users ( id ) \n" +
            ");";
    public static final String CREATE_TABLES_TRANSACTION = "CREATE TABLE \"transactions\" (\n" +
            "            \t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "            \t\"account_id\" INTEGER NOT NULL,\n" +
            "            \t\"target_account_id\" INTEGER NOT NULL,\n" +
            "            \t\"currency\" TEXT NOT NULL,\n" +
            "            \t\"amount\" REAL NOT NULL,\n" +
            "            \t\"type\" TEXT NOT NULL,\n" +
            "            \t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \tUNIQUE ( \"ID\" ASC ) FOREIGN KEY ( account_id ) REFERENCES accounts ( id ),\n" +
            "            \tFOREIGN KEY ( target_account_id ) REFERENCES accounts ( id )\n" +
            "            );";
    public static final String CREATE_TABLES_LOAN = "CREATE TABLE \"loans\" (\n" +
            "            \t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "            \t\"user_id\" INTEGER NOT NULL,\n" +
            "            \t\"currency\" TEXT NOT NULL,\n" +
            "            \t\"amount\" REAL NOT NULL,\n" +
            "            \t\"collateral\" TEXT NOT NULL,\n" +
            "            \t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \tUNIQUE ( \"ID\" ASC ) FOREIGN KEY ( user_id ) REFERENCES users ( id )\n" +
            "            );";
    public static final String CREATE_TABLES_STOCK = "CREATE TABLE \"stocks\" (\n" +
            "            \t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "            \t\"ticker\" TEXT NOT NULL,\n" +
            "            \t\"company_name\" TEXT NOT NULL,\n" +
            "            \t\"current_price\" REAL NOT NULL,\n" +
            "            \t\"currency\" TEXT NOT NULL,\n" +
            "            \t\"amount_available\" INTEGER NOT NULL,\n" +
            "            \t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"available\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \tUNIQUE ( \"ID\" ASC )\n" +
            "            );";


    public static final String CREATE_TABLES_STOCK_USER = "CREATE TABLE \"stocks_user\" (\n" +
            "            \t\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "            \t\"user_id\" INTEGER NOT NULL,\n" +
            "            \t\"account_id\" INTEGER NOT NULL,\n" +
            "            \t\"stock_id\" INTEGER NOT NULL,\n" +
            "            \t\"avg_price\" REAL NOT NULL,\n" +
            "            \t\"currency\" TEXT NOT NULL,\n" +
            "            \t\"amount_hold\" INTEGER NOT NULL,\n" +
            "            \t\"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "            \t\"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \t\"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "            \tUNIQUE ( \"ID\" ASC ) FOREIGN KEY ( user_id ) REFERENCES users ( id ),\n" +
            "            FOREIGN KEY ( stock_id ) REFERENCES stocks ( id ),\n" +
            "            FOREIGN KEY ( account_id ) REFERENCES accounts ( id )" +
            "            );";

    public static final String CREATE_TABLES_STOCK_PROFIT = "CREATE TABLE \"user_profit\" (\n" +
            "  \"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "  \"account_id\" INTEGER NOT NULL,\n" +
            "  \"realized_profit\" REAL NOT NULL,\n" +
            "  \"enable\" INTEGER(1) NOT NULL DEFAULT 1,\n" +
            "  \"create_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  \"update_time\" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP\n" +
            ");";

    //drop tables
    public static final String DROP_TABLES_USER = "DROP TABLE \"users\";";
    public static final String DROP_TABLES_ACCOUNT = "DROP TABLE \"accounts\";";
    public static final String DROP_TABLES_TRANSACTION = "DROP TABLE \"transactions\";";
    public static final String DROP_TABLES_LOAN = "DROP TABLE \"loans\";";
    public static final String DROP_TABLES_STOCK = "DROP TABLE \"stocks\";";
    public static final String DROP_TABLES_STOCK_USER = "DROP TABLE \"stocks_user\";";
    public static final String DROP_TABLES_USER_PROFIT = "DROP TABLE \"user_profit\";";


    public static final String ADD_ADMIN = "INSERT OR IGNORE INTO users(id, name, user_name, password, admin) VALUES(1, 'Manager', 'admin', 'admin', 1);\n";
    public static final String ADD_ADMIN_ACCOUNT = "INSERT OR IGNORE INTO accounts(id, user_id, type, amount, currency) VALUES(1, 1, 'checking', 0, 'USD');\n";

    public static final int OpenClose_Fee = 20;
    public static final int Withdraw_Fee = 10;
    public static final int Checking_Transaction_Fee = 10;
    public static final int Loan_Interest_Percentage = 1;
    public static final int Minimum_Account_Amount = 30;
    public static final int MINIMUM_SECURITY_ACCOUNT_AMOUNT = 1000;
    public static final int MINIMUM_SECURITY_ACCOUNT_AMOUNT_REMAIN = 2500;

    public static final String ACCOUNT_TYPE_CHECKING = "checking";
    public static final int ACCOUNT_TYPE_CHECKING_INT = 0;

    public static final String ACCOUNT_TYPE_SAVING = "saving";
    public static final int ACCOUNT_TYPE_SAVING_INT = 1;

    public static final String ACCOUNT_TYPE_SECURITY = "security";
    public static final int ACCOUNT_TYPE_SECURITY_INT = 2;


    public static final String[] CURRENCY_CODE = {"USD","CNY","GBP"};
    public static final Double[] EXCHANGE_RATE = {1.32,8.41, 1.0};

    public static final int SELECT_ALL_ACCOUNTS = -10086;

}
