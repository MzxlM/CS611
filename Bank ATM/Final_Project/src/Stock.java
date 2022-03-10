/**
*@ClassName:Stock
*@Description:A Stock object. It contains all the info about a specific stock.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Stock {

    private int id;
    private String ticker;
    private String name;
    private double currentPrice;
    private String currency;
    private Integer availableAmount;
    private boolean isAvailable;

    public Stock(int id, String ticker, String name, double currentPrice, String currency, int availableAmount) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.currentPrice = currentPrice;
        this.currency = currency;
        this.availableAmount = availableAmount;
        this.isAvailable = true;
    }
    public Stock(int id, String ticker, String name, double currentPrice, String currency, int availableAmount, boolean isAvailable) {
        this(id, ticker, name, currentPrice, currency, availableAmount);
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }
}
