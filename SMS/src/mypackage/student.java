package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class student {


    private Connection connection;
    private Scanner scanner;

    public student(Connection connection, Scanner scanner){

        this.connection = connection;
        this.scanner = scanner;


    }

    public void addStudent(){

        System.out.println("Enter Student Name : ");
        String name = scanner.next();

        System.out.println("Enter Student Roll Number : ");
        String rollno = scanner.next();

        System.out.println("Enter Student Enroll Course : ");
        String course = scanner.next();

        System.out.println("Enter Student Year : ");
        int year = scanner.nextInt();

        try {

            String query = "INSERT into student(name,rollno,course,year) VALUES (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, rollno);
            stm.setString(3, course);
            stm.setInt(4,year);
            int ar = stm.executeUpdate();

            if(ar>0){

                System.out.println("Student Added Successfully...");
            }

            else{

                System.out.println("Failed to add Student!!!!!!!!!!!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }




    }


    public void viewStudent(){

        try {

        String query = "SELECT * from student";
        PreparedStatement stm = connection.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        System.out.println("| Students |");
        System.out.println("+---------------------+--------------------+----------+--------+");
        System.out.println("| Student Name        | Roll Number        | Course   | Year   |");
        System.out.println("+---------------------+--------------------+----------+--------+");

        while(rs.next()){

            String name = rs.getString("name");
            String rollno = rs.getString("rollno");
            String course = rs.getString("course");
            int year = rs.getInt("year");
            System.out.printf("| %-17s | %-19s | %-11s | %-4s |\n",name,rollno,course,year);
            System.out.println("+---------------------+--------------------+----------+--------+");


        }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
