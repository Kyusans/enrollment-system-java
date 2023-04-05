import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class EnrollmentSystem {
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static String fullName = "";
	public static int currentYear = Year.now().getValue();
	public static int nextYear = currentYear + 1;
	public static String schoolYear = String.format("%d-%d", currentYear, nextYear);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		boolean isValidLevel = false;
		String level = "";
		int sectionAEnrolled = 0;
		int sectionBEnrolled = 0;

		System.out.println("Welcome student!");
		while (!exit) {
			System.out.println("\n1. Enroll");
			System.out.println("2. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					while(true){
						System.out.print("\nEnter your first name: ");
						String firstName = scanner.nextLine();
						System.out.print("Enter your last name: ");
						String lastName = scanner.nextLine();
						System.out.print("Enter your middle name: ");
						String middleName = scanner.nextLine();
						System.out.print("Enter your email: ");
						String email = scanner.nextLine();
						System.out.print("Enter your age: ");
						String age = scanner.nextLine();
						while(!isValidLevel){
							System.out.print("What year do you want to enroll? \n"
							+ "(1) 1st year\n"
							+ "(2) 2nd year\n"
							+ "(3) 3rd year\n"
							+ "(4) 4th year\n"
							+ "Enter your choice: ");
							level = scanner.nextLine();
							switch(level){
								case "1":
									subject.add(new Subject("Math", "IT100", "TBA", 3));
									subject.add(new Subject("English", "IT110", "TBA", 3));
									subject.add(new Subject("Science", "IT120", "TBA", 4));
									subject.add(new Subject("History", "IT130", "TBA", 3));
									isValidLevel = true;
									break;
								case "2":
									subject.add(new Subject("Math", "MTH101", "TBA", 3));
									subject.add(new Subject("English", "ENG101", "TBA", 3));
									subject.add(new Subject("Science", "SCI101", "TBA", 4));
									subject.add(new Subject("History", "HIS101", "TBA", 3));
									isValidLevel = true;
									break;
								case "3":
									subject.add(new Subject("Math", "MTH101", "TBA", 3));
									subject.add(new Subject("English", "ENG101", "TBA", 3));
									subject.add(new Subject("Science", "SCI101", "TBA", 4));
									subject.add(new Subject("History", "HIS101", "TBA", 3));
									isValidLevel = true;
									break;
								case "4":
									subject.add(new Subject("Math", "MTH101", "TBA", 3));
									subject.add(new Subject("English", "ENG101", "TBA", 3));
									subject.add(new Subject("Science", "SCI101", "TBA", 4));
									subject.add(new Subject("History", "HIS101", "TBA", 3));	
									isValidLevel = true;
									break;
								default:
									System.out.println("\nPlease enter valid number\n");
									break;
							}
							if(isValidLevel){
								isValidLevel = false;
								fullName = lastName + ", " + firstName + " " + middleName; 
								break;
							}else{
								continue;
							}
						}
						System.out.print("\nPlease confirm if you want to proceed with the following information: \n\n" 
						+ "Full Name: " + fullName
						+ "\nEmail: " + email
						+ "\nAge: " + age
						+ "\nYear level: " + level
						+ "\n\nType Y to confirm or type any other key to make any changes: ");
						String confirm = scanner.nextLine();

						if(confirm.equalsIgnoreCase("y")){
							if(sectionAEnrolled < 10){
								sectionAEnrolled++;
								getORF(firstName, lastName, middleName, email, "Section A");
							}else if(sectionBEnrolled < 10){
								sectionBEnrolled++;
								getORF(firstName, lastName, middleName, email, "Section B");
							}else{
								System.out.println("All sections are full. Cannot enroll student.");
							}
							break;
						}else{
							continue;
						}
					}
					break;
				case 2:
					System.out.println("\nExiting program...");
					System.exit(0);
					break;
				default:
					System.out.println("\nInvalid input!\n");
			}
		}
		scanner.close();
	}
	
	public static void getORF(String firstName, String lastName, String middleName, String email, String section){
		students.add(new Student(firstName, lastName, middleName, email));
		System.out.println("\n\n\n\nStudent Name: " + fullName.toUpperCase()
		+ "\nSection: " + section
		+ "\nSchool Year: " + schoolYear + "\n"
		);
		System.out.printf("%-15s%-15s%-15s%-10s\n", "Subject", "Code", "Room", "Credit");
		for (Subject subjects : subject) {
			System.out.printf("%-15s%-15s%-15s%-10d\n", subjects.getSubjectName(), subjects.getCode(), subjects.getRoom(),subjects.getCreditHours());
		}
	}
}