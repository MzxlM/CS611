//a data object for database represents data from form stocks_user
/**
*@ClassName:StockUserDTO
*@Description:A StockUserDTO object. It contains specific info for a stock which a user has bought.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class StockUserDTO {
    private int id;
    private int userId;
    private int accountId;
    private int stockId;
    private double avgPrice;
    private String currency;
    private int amountHold;

    public StockUserDTO(int id, int userId, int accountId, int stockId, double avgPrice, String currency, int amountHold) {
        this.id = id;
        this.userId = userId;
        this.accountId = accountId;
        this.stockId = stockId;
        this.avgPrice = avgPrice;
        this.currency = currency;
        this.amountHold = amountHold;
    }

    public String getStockName(){
        DBSystem db = new DBSystem();
        Stock stock = db.selectStockById(stockId);
        return stock.getName();
    }

    public String getStockTicker(){
        DBSystem db = new DBSystem();
        Stock stock = db.selectStockById(stockId);
        return stock.getTicker();
    }

    public double getStockPrice(){
        DBSystem db = new DBSystem();
        Stock stock = db.selectStockById(stockId);
        return stock.getCurrentPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmountHold() {
        return amountHold;
    }

    public void setAmountHold(int amountHold) {
        this.amountHold = amountHold;
    }
}
