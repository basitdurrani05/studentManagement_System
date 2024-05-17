package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class attendence {


    private Connection connection;
    private Scanner scanner;

    public attendence(Connection connection, Scanner scanner){

        this.connection = connection;
        this.scanner = scanner;


    }

    public void addStudent_atd(){

        System.out.println("Enter Date (YYY-MM-DD) : ");
        String date = scanner.next();
        

        System.out.println("Enter Student Name : ");
        String stu_name = scanner.next();
       

        System.out.println("Enter Student Roll Number(Last Two Digit Number) : ");
        String roll_no = scanner.nextLine();

        System.out.println("Enter Student Branch : ");
        String branch = scanner.nextLine();

        System.out.println("Enter Student Semster : ");
        int sem = scanner.nextInt();

        System.out.println("Enter Lecture Name : ");
        String lec_name = scanner.nextLine();

        System.out.println("Enter Professor Name : ");
        String teacher_name = scanner.nextLine();

        try {

            String query = "INSERT into attendence(date,stu_name,roll_no,branch,sem,lec_name,teacher_name) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, date);
            stm.setString(2, stu_name);
            stm.setString(3, roll_no);
            stm.setString(4, branch);
            stm.setInt(5,sem);
            stm.setString(6,lec_name);
            stm.setString(7, teacher_name);
            
            int ar = stm.executeUpdate();

            if(ar>0){

                System.out.println("Attendence Registered Successfully...");
            }

            else{

                System.out.println("Failed to Registered!!!!!!!!!!!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }




    }


    public void viewStudent_atd(){

        try {

        String query = "SELECT * from attendence";
        PreparedStatement stm = connection.prepareStatement(query);
        ResultSet rs = stm.executeQuery();

        System.out.println("| Students Attendence |");
        System.out.println("+-----------+---------------------+-----------------+-----------------+---------+----------------------+----------------------+");
        System.out.println("| Date      | Student Name        | Roll Number     | Branch          | Semster | Lecture Name         | Professor Name       |");
        System.out.println("+-----------+---------------------+-----------------+-----------------+---------+----------------------+----------------------+");

        while(rs.next()){

            String date = rs.getString("date");
            String stu_name = rs.getString("stu_name");
            String roll_no = rs.getString("roll_no");
            String branch = rs.getString("branch");
            int sem = rs.getInt("sem");
            String lec_name = rs.getString("lec_name");
            String teacher_name = rs.getString("teacher_name");
            System.out.printf("| %-12s %-21s %-18s %-18s %-10s %-23s %-15s |\n",date,stu_name,roll_no,branch,sem,lec_name,teacher_name);
            System.out.println("+-----------+---------------------+-----------------+-----------------+---------+----------------------+----------------------+");


        }

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
