import java.util.ArrayList;
import java.util.List;
/**
*@ClassName:StockOfUser
*@Description:A StockOfUser object. It contains info for all the stocks that a user has bought.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class StockOfUser {
    private List<StockUserDTO> stock;
    private double realizedProfit;
    private double unrealizedProfit;

    public StockOfUser(List<StockUserDTO> stock, double realizedProfit, double unrealizedProfit) {
        this.stock = stock;
        this.realizedProfit = realizedProfit;
        this.unrealizedProfit = unrealizedProfit;
    }
    public StockOfUser() {
        this.stock = new ArrayList<>();
        this.realizedProfit = 0;
        this.unrealizedProfit = 0;
    }

    public void updateStockOfUser(int userId, int accountId){
        DBSystem db = new DBSystem();
        //update info
        List<StockUserDTO> stockDTOList = db.getStockDTOList(userId, accountId);
        setStock(stockDTOList);

        Double aDouble = db.selectRealizedProfitById(accountId);
        setRealizedProfit(aDouble);

        List<Stock> stocks = db.getStocks();
        double unrealizedProfit = 0;
        for (StockUserDTO stockUserDTO : stockDTOList) {
            for (Stock stock1 : stocks) {
                if (stock1.getId() == stockUserDTO.getStockId()) {
                    unrealizedProfit += (stock1.getCurrentPrice() - stockUserDTO.getAvgPrice()) * stockUserDTO.getAmountHold();
                }
            }
        }
        setUnrealizedProfit(unrealizedProfit);
    }

    public List<StockUserDTO> getStock() {
        return stock;
    }

    public void setStock(List<StockUserDTO> stock) {
        this.stock = stock;
    }

    public double getRealizedProfit() {
        return realizedProfit;
    }

    public void setRealizedProfit(double realizedProfit) {
        this.realizedProfit = realizedProfit;
    }

    public double getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(double unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }
}
