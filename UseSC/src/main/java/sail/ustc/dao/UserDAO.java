package sail.ustc.dao;

import sail.ustc.model.UserBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends sc.ustc.dao.BaseDAO {

    private static UserDAO userDAO = new UserDAO();
    private UserDAO() {
        /*
        userPassword = "123456";
        userName = "root";
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/sc?useSSL=false&serverTimezone=UTC";
        */
        driver="org.sqlite.JDBC";
        url="jdbc:sqlite:G:\\sqliteDB\\identifier.sqlite";

        connection = openDBConnectionSQLITE();
    }

    public static UserDAO getInstance(){
        if (userDAO==null){
            userDAO=new UserDAO();
        }
        return userDAO;
    }

    @Override
    public Object query(String s) {
        String pass="";
        System.out.println(s);
        String FIELD = "password";
        String SQL_QUERY = "select "+FIELD+" from user where name = "+"'"+s+"'";
        System.out.println(SQL_QUERY);
        //String SQL_QUERY = "select "+FIELD+" from user ";
        //String SQL_QUERY = "select "+FIELD+" from user where id = 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            while (resultSet.next()){
                pass= resultSet.getString("password");
                System.out.println(pass);
            }
            UserBean userBean = new UserBean();
            userBean.setUserPass(pass);
            return userBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(String s) {
        return false;
    }

    @Override
    public boolean update(String s) {
        return false;
    }

    @Override
    public boolean dalete(String s) {
        return false;
    }
}
