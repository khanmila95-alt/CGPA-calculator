import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student ID and number of courses
        System.out.print("Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("No. of Courses: ");
        int numCourses = sc.nextInt();

        float totalCredits = 0;
        float totalGradePoints = 0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("Course " + i + ":");

            System.out.print("Credit (Max 3): ");
            int credit = sc.nextInt();

            System.out.print("CT (Max 30): ");
            int ct = sc.nextInt();

            System.out.print("AT (Max 10): ");
            int at = sc.nextInt();

            System.out.print("FE (Max 60): ");
            int fe = sc.nextInt();

            int totalMarks = ct + at + fe;
            float gradePoint = calculateGradePoint(totalMarks);

            totalCredits += credit;
            totalGradePoints += gradePoint * credit;
        }

        float cgpa = totalGradePoints / totalCredits;
        String grade = calculateGrade(cgpa);

        // Output
        System.out.println("\nStudent ID: " + studentID);
        System.out.println("Credit Taken: " + (int) totalCredits);
        System.out.println("Credit Earned: " + (int) totalCredits); // Assuming all passed
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + grade);
    }

    // Convert total marks to grade point
    public static float calculateGradePoint(int marks) {
        if (marks >= 80) return 4.0f;
        else if (marks >= 75) return 3.75f;
        else if (marks >= 70) return 3.5f;
        else if (marks >= 65) return 3.25f;
        else if (marks >= 60) return 3.0f;
        else if (marks >= 55) return 2.75f;
        else if (marks >= 50) return 2.5f;
        else if (marks >= 45) return 2.25f;
        else if (marks >= 40) return 2.0f;
        else return 0.0f;
    }

    // Convert CGPA to letter grade
    public static String calculateGrade(float cgpa) {
        if (cgpa == 4.0f) return "A+";
        else if (cgpa >= 3.75f) return "A";
        else if (cgpa >= 3.5f) return "A-";
        else if (cgpa >= 3.25f) return "B+";
        else if (cgpa >= 3.0f) return "B";
        else if (cgpa >= 2.75f) return "B-";
        else if (cgpa >= 2.5f) return "C+";
        else if (cgpa >= 2.25f) return "C";
        else if (cgpa >= 2.0f) return "D";
        else return "F";
    }
}
