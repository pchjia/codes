import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.lang.ClassNotFoundException;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test", "pchjia", "jia9692");
            Statement stmt = con.createStatement();
            // select
            ResultSet res = stmt.executeQuery("select * from goods");
            while (res.next()) {
                int goods_id = res.getInt(1);
                String goods_name = res.getString(2);
                int cat_id = res.getInt(3);
                int shop_price = res.getInt(7);
                int market_price = res.getInt(8);

                System.out.println(goods_id + "\t" + goods_name + "\t" + cat_id
                        + "\t" + shop_price + "\t" + market_price);
            }

            stmt.executeUpdate("drop table if exists student");
            stmt.executeUpdate("create table student (id int not null auto_increment, name varchar(20) not null default 'name', math int not null default 60, primary key (id) ); ");
            stmt.executeUpdate("insert into student values(1, 'a', 100)");
            stmt.executeUpdate("insert into student values(2, 'b', 99)");
            stmt.executeUpdate("insert into student values(3, 'c', 98)");

            ResultSet resUsers = stmt.executeQuery("select * from student");
            while (resUsers.next()) {
                System.out.println(resUsers.getString(1) + "\t"
                        + resUsers.getString(2) + "\t" + resUsers.getString(3));
            }

            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("not exits jdbc driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("sql syntax error");
            e.printStackTrace();
        }
    }
}

