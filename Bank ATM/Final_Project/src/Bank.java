/**
*@ClassName:Bank
*@Description: A Bank object where has a Bank Database.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Bank {
    private String name;
    private DBSystem db;

    public Bank(String name) {
        this.name = name;
        this.db = new DBSystem();
    }
}
