import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
*@ClassName:Transaction
*@Description:A Transaction object. It contains all the info about a specific transaction.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Transaction {

    private int id;
    private int AID;
    private int TargetAID;
    private String currency;
    private double amount;
    private String type;
    private String createdTime;

    public Transaction(int id, int AID, int targetAID, String currency, double amount, String type, String createdTime) {
        this.id = id;
        this.AID = AID;
        TargetAID = targetAID;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.createdTime = createdTime;
    }

    //getters and setters
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getTargetAID() {
        return TargetAID;
    }

    public void setTargetAID(int targetAID) {
        TargetAID = targetAID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
