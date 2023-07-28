
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=PRO1041_DuAn1";
    private static String user = "saa";
    private static String pass = "12345";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getDBConnect(){
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(dburl,user,pass);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Where is Driver?");
            System.out.println("Error"+e.toString());
        }catch(SQLException ex){
            //LoiKetNoi
            System.out.println("Error"+ex.toString());
        }
   return null;
    }
    /*
        Xây dựng PreparedStatement
    - @param sql là câu lệnh SQL chứa, có thể chứa tham số. Nó có thể là một lời gọi thủ tục lưu
    -@param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
    -@return PreparedStatement tạo được
    -@throws java.sql.SQLException lỗi sai cú pháp
     */
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    /*
        - Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu thao tác dữ liệu

    - @param sql là câu lệnh SQL chứa, có thể chứa tham số , nó có thể là một lời gọi thủ tục lưu
    - @param args là danh sách các giá trị đucợ cung cấp cho các  tham số trong câu lệnh sql
     */
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     - thực hiên câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy cập dữ liệu

     -@param sql là câu lệnh SQL chứa, có thể chứa tham số. nó có thể là một lời gọi của thủ tục lưu
     -@param args là danh sách các giá trị được cung cấp cho các tham số trong câu lệnh sql
     */
    public static ResultSet query(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }
}