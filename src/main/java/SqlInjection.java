import java.sql.*;
import javax.servlet.http.HttpServletRequest;

public class SqlInjection {
    public static ResultSet doQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }

    /* for demo, rename function 
    public static ResultSet doQuery_demo_02132025(HttpServletRequest request, Connection connection) throws SQLException {
        //change var "customerName" on next two lines, declaration and in query statement below
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }
    */
    public static ResultSet doQuery_demo_0219(HttpServletRequest request, Connection connection) throws SQLException {
    String customerName_0219 = request.getParameter("customerName");
    String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName_0219;
    Statement statement = connection.createStatement();
    ResultSet results = statement.executeQuery(query);
    return(results);
    }
}
