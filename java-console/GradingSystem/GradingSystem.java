import java.io.*;

public class GradingSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String x, lastName, firstName, section;
        int attendance, quiz, recitation, project, prelimExam, midtermExam, finalExam;
        double classStanding, prelimGrade, midtermGrade, finalGrade, semGrade;
        char ans;
        
       do {
            System.out.println("************** Grading System ***************");

            System.out.print("Enter Last Name       : ");
            lastName = reader.readLine();

            System.out.print("Enter First Name      : ");
            firstName = reader.readLine();

            System.out.print("Enter Section         : ");
            section = reader.readLine();

            System.out.println("\n*********** Preliminary Grades ***********");

            System.out.print("Input Attendance      :  ");
            x = reader.readLine();
            attendance = Integer.parseInt(x);

            System.out.print("Input Quiz            :  ");
            x = reader.readLine();
            quiz = Integer.parseInt(x);

            System.out.print("Input Recitation      :  ");
            x = reader.readLine();
            recitation = Integer.parseInt(x);

            System.out.print("Input Project         :  ");
            x = reader.readLine();
            project = Integer.parseInt(x);
            
            
            classStanding=(attendance + quiz + recitation + project)/4;
            System.out.println("Classtanding		: "+ classStanding);  
            
            System.out.print("Input Prelim Exam(Score): ");
            x = reader.readLine();
            prelimExam = Integer.parseInt(x);
            
            prelimGrade= (classStanding+prelimExam)/2;
            System.out.println("Prelim Grade            : "+prelimGrade);
            
            if (prelimGrade >= 96 && prelimGrade <= 100) {
                System.out.println("Point			: 1.0");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 93 && prelimGrade <= 95.5) {
                System.out.println("Point			: 1.25");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 91 && prelimGrade <= 92.5) {
                System.out.println("Point			: 1.5");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade>= 88 && prelimGrade <= 90.5) {
                System.out.println("Point 			: 1.75");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 86 && prelimGrade <= 87.5) {
                System.out.println("Point 			: 2.00");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 84 && prelimGrade <= 85.5) {
                System.out.println("Point 			: 2.25");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade>= 80 && prelimGrade <= 83.5) {
                System.out.println("Point 			: 2.5");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 78 && prelimGrade <= 79.5) {
                System.out.println("Point 			: 2.75");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 74 && prelimGrade <= 77.5) {
                System.out.println("Point 			: 3.00");
                System.out.println("Remarks			: Passed");
                
            } else if (prelimGrade >= 70 && prelimGrade <= 73.5) {
                System.out.println("Point 			: 5.00");
                System.out.println("Remarks			: Failed");
            }
            
            System.out.println("\n*****Midterm Grades*******");

            System.out.print("Input Attendance      :  ");
            x = reader.readLine();
            attendance = Integer.parseInt(x);
            
            System.out.print("Input Quiz            :  ");
            x = reader.readLine();
            quiz = Integer.parseInt(x);

            System.out.print("Input Recitation      :  ");
            x = reader.readLine();
            recitation = Integer.parseInt(x);

            System.out.print("Input Project         :  ");
            x = reader.readLine();
            project = Integer.parseInt(x);
            
            
            classStanding=(attendance + quiz + recitation + project)/4;
            System.out.println("Classtanding	 	 : "+ classStanding);  
            
            System.out.print("Input Midterm Exam(Score): ");
            x = reader.readLine();
            midtermExam = Integer.parseInt(x);
            
            midtermGrade= (classStanding+midtermExam)/2;
            System.out.println("Midterm Grade            : "+midtermGrade);
            
            if (midtermGrade >= 96 && midtermGrade <= 100) {
                System.out.println("Point			 : 1.0");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 93 && midtermGrade <= 95.5) {
                System.out.println("Point			 : 1.25");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 91 && midtermGrade <= 92.5) {
                System.out.println("Point			 : 1.5");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade>= 88 && midtermGrade <= 90.5) {
                System.out.println("Point 			 : 1.75");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 86 && midtermGrade <= 87.5) {
                System.out.println("Point 			 : 2.00");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 84 && midtermGrade <= 85.5) {
                System.out.println("Point 			 : 2.25");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade>= 80 && midtermGrade <= 83.5) {
                System.out.println("Point 			 : 2.5");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 78 && midtermGrade <= 79.5) {
                System.out.println("Point 			 : 2.75");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 74 && midtermGrade <= 77.5) {
                System.out.println("Point 			 : 3.00");
                System.out.println("Remarks			 : Passed");
                
            } else if (midtermGrade >= 70 && midtermGrade <= 73.5) {
                System.out.println("Point 			 : 5.00");
                System.out.println("Remarks			 : Failed");
            }

            
            System.out.println("\n*********** Final Grade ***********");
            
        System.out.print("Input Attendance      :  ");
            x = reader.readLine();
            attendance = Integer.parseInt(x);

            System.out.print("Input Quiz            :  ");
            x = reader.readLine();
            quiz = Integer.parseInt(x);

            System.out.print("Input Recitation      :  ");
            x = reader.readLine();
            recitation = Integer.parseInt(x);

            System.out.print("Input Project         :  ");
            x = reader.readLine();
            project = Integer.parseInt(x);
            
            
            classStanding=(attendance + quiz + recitation + project)/4;
            System.out.println("Classtanding		: "+ classStanding);  
            
            System.out.print("Input Final Exam(Score) : ");
            x = reader.readLine();
            finalExam = Integer.parseInt(x);
            
            finalGrade= (classStanding+finalExam)/2;
            System.out.println("Final Grade             : "+finalGrade);
            
            if (finalGrade >= 96 && finalGrade <= 100) {
                System.out.println("Point			: 1.0");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 93 && finalGrade <= 95.5) {
                System.out.println("Point			: 1.25");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 91 && finalGrade <= 92.5) {
                System.out.println("Point			: 1.5");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade>= 88 && finalGrade <= 90.5) {
                System.out.println("Point 			: 1.75");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 86 && finalGrade <= 87.5) {
                System.out.println("Point 			: 2.00");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 84 && finalGrade <= 85.5) {
                System.out.println("Point 			: 2.25");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade>= 80 && finalGrade <= 83.5) {
                System.out.println("Point 			: 2.5");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 78 && finalGrade <= 79.5) {
                System.out.println("Point 			: 2.75");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 74 && finalGrade <= 77.5) {
                System.out.println("Point 			: 3.00");
                System.out.println("Remarks			: Passed");
                
            } else if (finalGrade >= 70 && finalGrade <= 73.5) {
                System.out.println("Point 			: 5.00");
                System.out.println("Remarks			: Failed");
            }

        System.out.println("\n*********** Semestral Grade ***********");

        semGrade= (prelimGrade+midtermGrade+finalGrade)/3;
            System.out.println("Semestral Grade		: "+semGrade);

        if (semGrade >= 96 && semGrade <= 100) {
                System.out.println("Point			: 1.0");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 93 && semGrade <= 95.5) {
                System.out.println("Point			: 1.25");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 91 && semGrade <= 92.5) {
                System.out.println("Point			: 1.5");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade>= 88 && semGrade <= 90.5) {
                System.out.println("Point 			: 1.75");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 86 && semGrade <= 87.5) {
                System.out.println("Point 			: 2.00");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 84 && semGrade <= 85.5) {
                System.out.println("Point 			: 2.25");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade>= 80 && semGrade <= 83.5) {
                System.out.println("Point 			: 2.5");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 78 && semGrade <= 79.5) {
                System.out.println("Point 			: 2.75");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 74 && semGrade <= 77.5) {
                System.out.println("Point 			: 3.00");
                System.out.println("Remarks			: Passed");
                
            } else if (semGrade >= 70 && semGrade <= 73.5) {
                System.out.println("Point 			: 5.00");
                System.out.println("Remarks			: Failed");
            }
            
            System.out.println("Do you want to repeat again? [y/n]");
            ans = (char)System.in.read();
            System.in.read();
        System.in.read();

        } while (ans == 'Y' || ans == 'y');
    }
}