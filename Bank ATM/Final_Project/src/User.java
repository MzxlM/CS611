/**
*@ClassName:User
*@Description:A User object. It is the super class of Manager and Customer class. It contains basic info about a user.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public abstract class User {
    private int UID;
    private String name;
    private String userName;
    private String password;
    private boolean isAdmin;

    public User(int UID, String name, String userName, String password, boolean isAdmin) {
        setAdmin(isAdmin);
        setUID(UID);
        setName(name);
        setUserName(userName);
        setPassword(password);
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
