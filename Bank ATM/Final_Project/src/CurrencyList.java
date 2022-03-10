import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
*@ClassName:CurrencyList
*@Description:A CurrencyList object. It keeps all the currency codes and exchange rates.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class CurrencyList {
    private List<Currency> currencies = new ArrayList<>();
    private List<String> codes = new ArrayList<>();
    private List<Double> exchangeRate = new ArrayList<>();

    //get currency based on which currency to decide the exchange rate
    public CurrencyList(String code) {
        initializeCurrencyList();
        fixExchangeRate(code);
    }

    //get currency based on GBP
    public CurrencyList() {
        initializeCurrencyList();
    }

    //get currency based on selected currency
    private void fixExchangeRate(String code) {
        double exchangeRate = 1;
        for (Currency currency : getCurrencies()) {
            if (currency.getCode().equals(code)) {
                exchangeRate = currency.getExchangeRate();
            }
        }

        List<Double> exchangeRates = this.getExchangeRate();
        List<Double> newExchangeRate = new ArrayList<>();
        for (Double rate : exchangeRates) {
            rate /= exchangeRate;
            newExchangeRate.add(rate);
        }
        setExchangeRate(newExchangeRate);

    }

    //read the data from constant and setup lists.
    private void initializeCurrencyList(){
        String[] currencyCode = Constants.CURRENCY_CODE;
        Double[] currencyExchangeRate = Constants.EXCHANGE_RATE;

        List<String> codes = Arrays.stream(currencyCode).collect(Collectors.toList());
        List<Double> exchangeRate = Arrays.stream(currencyExchangeRate).collect(Collectors.toList());

        List<Currency> currencies = new ArrayList<>();
        for (int i = 0; i < codes.size(); i++) {
            Currency currency = new Currency(exchangeRate.get(i),codes.get(i));
            currencies.add(currency);
        }

        setCurrencies(currencies);
        setCodes(codes);
        setExchangeRate(exchangeRate);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public List<Double> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(List<Double> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
