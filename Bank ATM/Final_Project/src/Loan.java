/**
*@ClassName:Loan
*@Description:A Loan object. It contains specific details on a single Loan.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Loan {
        private int id;
        private int UID;
        private Currency currency;
        private double amount;
        private String collateral;

        //constructors.
        public Loan(int id, int UID, Currency currency, double amount, String collateral) {
                this.id = id;
                this.UID = UID;
                this.currency = currency;
                this.amount = amount;
                this.collateral = collateral;
        }

        //getters and setters.
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getUID() {
                return UID;
        }

        public void setUID(int UID) {
                this.UID = UID;
        }

        public Currency getCurrency() {
                return currency;
        }

        public void setCurrency(Currency currency) {
                this.currency = currency;
        }

        public double getAmount() {
                return amount;
        }

        public void setAmount(double amount) {
                this.amount = amount;
        }

        public String getCollateral() {
                return collateral;
        }

        public void setCollateral(String collateral) {
                this.collateral = collateral;
        }
}
