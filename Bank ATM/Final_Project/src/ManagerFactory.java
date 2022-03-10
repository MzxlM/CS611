/**
*@ClassName:ManagerFactory
*@Description:A ManagerFactory object. It encapsulates the creation of Manager.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class ManagerFactory {

    public Manager GetManager(int UID, String name, String userName, String password){
        return new Manager(UID, name, userName, password);
    }
}
