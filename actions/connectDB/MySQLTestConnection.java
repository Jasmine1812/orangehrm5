package connectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = MySQLTestConnection.getMyConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();

        String sql = "SELECT * FROM hs_hr_employee;";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.
            int empId = rs.getInt(2);
            String empFirstName = rs.getString(3);
            String empLastName = rs.getString(4);

            System.out.println("--------------------");
            System.out.println("Emp Id:" + empId);
            System.out.println("Emp Firstname:" + empFirstName);
            System.out.println("Emp Lastname:" + empLastName);
        }
        // Đóng kết nối
        conn.close();
//        System.out.println("---------- Closed connection ----------");
    }
}
