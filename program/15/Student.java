//   javac -cp ".;C:\Program Files (x86)\MySQL\mysql-connector-j-9.1.0.jar" Student.java
import java.sql.*;
import java.util.Scanner;

public class Student {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Rudra@17";

    private Connection conn;

    public Student() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL!");
        } catch (Exception e) {
            System.out.println("Connection Failed!");
        }
    }
    public void createDatabase(String dbName) {
        try {
            Statement statement = conn.createStatement();
            statement.execute("CREATE DATABASE " + dbName);
            System.out.println("Database " + dbName + " created successfully.");
        } catch (SQLException e) {
            System.out.println("Database not created");
        }
    }
    public void createTable(String dbName) {
        String query = "CREATE TABLE Student (" + "rollno INT PRIMARY KEY, " +
                    "name VARCHAR(50), " + "age INT)";
        try {
            Statement statement = conn.createStatement();
            statement.execute("USE " + dbName);
            statement.execute(query);
            System.out.println("Table Student created successfully in " + dbName);
        } catch (Exception e) {
            System.out.println("Table not created");
        }
    }
    public void insertData(String dbName, int rollno, String name, int age) {
        String query = "INSERT INTO Student (rollno, name, age) VALUES (?, ?, ?)";
        try {
            Statement statement = conn.createStatement();
            PreparedStatement pstatement = conn.prepareStatement(query);
            statement.execute("USE " + dbName);
            pstatement.setInt(1, rollno);
            pstatement.setString(2, name);
            pstatement.setInt(3, age);
            pstatement.execute();
            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            System.out.println("Error in insertion");
        }
    }
    public void updateData(String dbName, int rollno, String name, int age) {
        String query = "UPDATE Student SET name = ?, age = ? WHERE rollno = ?";
        try {
            Statement statement = conn.createStatement();
            PreparedStatement pstatement = conn.prepareStatement(query);
            statement.execute("USE " + dbName);
            pstatement.setString(1, name);
            pstatement.setInt(2, age);
            pstatement.setInt(3, rollno);
            int rowsUpdated = pstatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully.");
            } else {
                System.out.println("Roll number not found.");
            }
        } catch (Exception e) {
            System.out.println("Error in updation");
        }
    }
    public void readTable(String dbName) {
        String query = "SELECT * FROM Student";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("USE " + dbName);
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Roll No    Name    Age");
            while (rs.next()) {
                int rollno = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                System.out.println(rollno + "    " + name + "    " + age);
            }
        } catch (Exception e) {
            System.out.println("error while retrieving data");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        String dbName = "StudentDB"; // Customize your DB name if needed
        student.createDatabase(dbName);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Update Data");
            System.out.println("4. Display Table");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    student.createTable(dbName);
                    break;
                case 2:
                    System.out.print("Enter Roll No: ");
                    int rollno = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    student.insertData(dbName, rollno, name, age);
                    break;
                case 3:
                    System.out.print("Enter Roll No to Update: ");
                    rollno = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    name = scanner.next();
                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    student.updateData(dbName, rollno, name, age);
                    break;
                case 4:
                    student.readTable(dbName);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}