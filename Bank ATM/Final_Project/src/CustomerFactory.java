/**
*@ClassName:CustomerFactory
*@Description:A CustomerFactory object. It encapsulate the creation of Customer.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class CustomerFactory {

    public Customer GetCustomer(int UID, String name, String userName, String password){
        return new Customer(UID, name, userName, password);
    }
}
