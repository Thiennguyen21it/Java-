package ConnectDB;

import java.sql.*;
class ResultSetMetaDataDemo
{
    public static void main( String args[] )
    {
        try
        {
            /*Nạp driver */
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*Kết nối đến cơ sở dữ liệu */
            Connection conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root", "athienpro8zz321zz654");
                            /* Tạo đối tượng Statement để gửi các câu lệnh SQL*/
                            Statement sm = conn.createStatement();
            /*Truy vấn thông tin từ bảng students */
            ResultSet rs=sm.executeQuery("Select * from students");
            /*Tạo ResultSetMetaData để lấy thông tin của ResultSet*/
            ResultSetMetaData rsm= rs.getMetaData();
            /*Lấy thông tin số cột của bảng students từ đối tượng rsm*/
            int col_num = rsm.getColumnCount();
            /*Lấy tên cột của bảng students từ đối tượng rsm*/
            for (int i=1;i<=col_num;i++)
                System.out.print(rsm.getColumnLabel(i)+ " ");
        } catch( Exception e )
        {
            System.out.println( e ) ;

        }
    }
}
