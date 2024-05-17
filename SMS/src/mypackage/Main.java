package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String database = "studentmanagement";
    private static final String username = "root";
    private static final String password = "pass";


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection connection = DriverManager.getConnection(url+database, username, password);
            student stu = new student(connection, sc);
            attendence atd = new attendence(connection, sc);

            while (true) {

                System.out.println(" || STUDENT MANAGEMENT SYSTEM ||");
                System.out.println("1). Add Student...");
                System.out.println("2). View Student...");
                System.out.println("3). Add Attendence...");
                System.out.println("4). View Attendence...");
                System.out.println("5). Exit...");
                System.out.println("Choose the given options.....");
                int choose = sc.nextInt();

                switch (choose) {
                    case 1:
                        stu.addStudent();
                        break;

                    case 2:

                    stu.viewStudent();
                    break;

                    case 3:
                        atd.addStudent_atd();
                        break;

                    case 4:
                        atd.viewStudent_atd();
                        break;

                    case 5:
                        
                        System.out.println("THANK YOU FOR USING STUDENT ATTENDENDENCE MANAGEMENT SYSTEM....");
                        System.exit(0);
                        break;
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        sc.close();

    }
    
    
    
}
