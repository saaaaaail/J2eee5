package sail.ustc.model;

import sail.ustc.dao.UserDAO;

public class UserBean {
    private String  userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    private String userName;
    private String userPass;
    public UserBean(){}
    public UserBean(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }
    public UserBean(String userId, String userName, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
    }

    public boolean signIn(String name,String password){
        UserDAO userDAO=UserDAO.getInstance();
        UserBean userBean = (UserBean) userDAO.query(name);
        if (userBean==null){
            return false;
        }else{
            if(userBean.getUserPass().equals(password)){
                return true;
            }else {
                return false;
            }
        }
    }
}
