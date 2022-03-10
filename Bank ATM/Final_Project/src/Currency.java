/**
*@ClassName:Currency
*@Description:A Currency object. It keeps track of exchange rate and currency code of a single currency.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Currency {
    private double exchangeRate;
    private String code; // like usd, cny

    public Currency(double exchangeRate, String code) {
        this.exchangeRate = exchangeRate;
        this.code = code;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
