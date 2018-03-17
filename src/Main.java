import java.sql.*;

public class Main
{
    // 定义连接所需的字符串
    // 192.168.0.X是本机地址(要改成自己的IP地址)，1521端口号，XE是精简版Oracle的默认数据库名
    private static String USERNAMR = "system";
    private static String PASSWORD = "z753951";
    private static String DRVIER = "oracle.jdbc.OracleDriver";

    private static String Oracle_URL = "jdbc:oracle:thin:@localhost:1521:orcl";

    public static void main(String[] args)
    {

        try
        {
            Class.forName(DRVIER);
            Connection connection = DriverManager.getConnection(Oracle_URL, USERNAMR, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ZF");
            System.out.println("记录结果是");
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
