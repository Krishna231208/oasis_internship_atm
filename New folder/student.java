import java.sql.*;

import java.util.*;

public class student {

    static Scanner sc = new Scanner(System.in);

    public static void creatdatabase() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Krishna#123");
            Statement stm = con.createStatement();
            System.out.println("enter database name to create database");
            String db = sc.nextLine();
            String query = "create database " + db;
            stm.execute(query);
            System.out.println("connection is successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void creatTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/histo", "root", "Krishna#123");
            Statement stm = con.createStatement();

            String query = "CREATE TABLE student (" +
                    "date TIMESTAMP(3)," +
                    "method_to_withdraw VARCHAR(50)," +
                    "amount INT(10)" +
                    ")";

            stm.execute(query);
            System.out.println("table created successfully ");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int createData(int sw) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/histo", "root", "Krishna#123");
            String query = "INSERT INTO student (date,method_to_withdraw ,amount) VALUES (NOW(), ?,?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, "withdrawed");

            statement.setInt(2, sw);
            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int createDatat(int sw) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/histo", "root", "Krishna#123");
            String query = "INSERT INTO student (date,method_to_withdraw ,amount) VALUES (NOW(), ?,?)";
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, "Deposited");

            statement.setInt(2, sw);
            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void readData() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/histo", "root", "Krishna#123");
            String query = "select * from student";
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Date " + rs.getDate(1));
                System.out.println(rs.getString(2));
                System.out.println("Amount=" + rs.getInt(3));
            }

            // System.out.println("reading is successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KK", "root", "Krishna#123");
            String query = "UPDATE student set sid=? where sname=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, 12);
            statement.setString(2, "John");

            statement.executeUpdate();

            System.out.println("dataupdation is successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletedata() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KK", "root", "Krishna#123");
            System.out.println("enter student id to be delete");
            int b = sc.nextInt();
            String query = "delete from student where sid=" + b;
            PreparedStatement statement = con.prepareStatement(query);
            // statement.setInt(1, 123);
            // statement.setString(2, "John");
            // statement.setString(3, "john@example.com");
            statement.executeUpdate();

            System.out.println("datainsersion is successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletdatabase() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Krishna#123");
            Statement stm = con.createStatement();
            System.out.println("Enter the Database name to delete");
            String ndb = sc.nextLine();
            String query = "DROP DATABASE " + ndb;
            stm.execute(query);
            System.out.println("Deleted database");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
