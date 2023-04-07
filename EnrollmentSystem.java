import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class EnrollmentSystem {
	public static ArrayList<Student> student = new ArrayList<Student>();
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static String fullName = "", section;
	public static int age;
	public static int currentYear = Year.now().getValue();
	public static int nextYear = currentYear + 1;
	public static String schoolYear = String.format("%d-%d", currentYear, nextYear);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String level = "", firstName, lastName, middleName, email;
		boolean validForm = false, exit = false, isValidLevel = false, validAge = false, enrolled = false;
		int section1AEnrolled = 0, section1BEnrolled = 0;
		int section2AEnrolled = 0, section2BEnrolled = 0;
		int section3AEnrolled = 0, section3BEnrolled = 0;
		int section4AEnrolled = 0, section4BEnrolled = 0;
		int section5AEnrolled = 0, section5BEnrolled = 0;
		int section6AEnrolled = 0, section6BEnrolled = 0;

		System.out.println("\n\nWelcome!");
		while (!exit) {
			System.out.println("\n1. Enroll");
			System.out.println("2. Exit");
			System.out.print("Enter your choice: ");
			String choice = scanner.nextLine();
			switch(choice){
				case "1":
					while(true){
						do {
							try {
								System.out.print("Enter your age: ");
								String ageStr = scanner.nextLine();
								age = Integer.parseInt(ageStr);
								if(age < 1){
									System.out.println("\nPlease enter a valid age\n");
								}else{
									validAge = true;
								}
							} catch (NumberFormatException e) {
								System.out.println("\nPlease enter a valid age\n");
							}
						} while (!validAge);
						do{
							System.out.print("\nEnter your first name: ");
							firstName = scanner.nextLine();
							System.out.print("Enter your last name: ");
							lastName = scanner.nextLine();
							System.out.print("Enter your middle name: ");
							middleName = scanner.nextLine();
							System.out.print("Enter your email: ");
							email = scanner.nextLine();
							if(firstName.equals("") || lastName.equals("") || middleName.equals("") || email.equals("")){
								System.out.println("\nThere was an empty input please try again.");
							}else{
								validForm = true;
							}
						}while(!validForm);

						while(!isValidLevel){
							System.out.print("What year do you want to enroll? \n"
							+ "(1) Grade 1\n"
							+ "(2) Grade 2\n"
							+ "(3) Grade 3\n"
							+ "(4) Grade 4\n"
							+ "(5) Grade 5\n"
							+ "(6) Grade 6\n"
							+ "Enter your choice: ");
							level = scanner.nextLine();
							switch(level){
								case "1":
									addSubject(level);
									isValidLevel = true;
									break;
								case "2":
									addSubject(level);
									isValidLevel = true;
									break;
								case "3":	
									addSubject(level);
									isValidLevel = true;
									break;
								case "4":
									addSubject(level);
									isValidLevel = true;
									break;
								case "5":
									addSubject(level);
									isValidLevel = true;
									break;
								case "6":
									addSubject(level);
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
						+ "\nGrade level: " + level
						+ "\n\nType Y to confirm or type any other key to make any changes: ");
						String confirm = scanner.nextLine();

						if(confirm.equalsIgnoreCase("y")){
							switch(level){
								case "1":
									if(section1AEnrolled < 10){
										section1AEnrolled++;
										section = "1-A";
										enrolled = true;
									}else if(section1BEnrolled < 10){
										section1BEnrolled++;
										section = "1-B";
										enrolled = true;
									}
									break;
								case "2":
									if(section2AEnrolled < 10){
										section2AEnrolled++;
										section = "2-A";
										enrolled = true;
									}else if(section2BEnrolled < 10){
										section2BEnrolled++;
										section = "2-B";
										enrolled = true;
									}
									break;
								case "3":
									if(section3AEnrolled < 10){
										section3AEnrolled++;
										section = "3-A";
										enrolled = true;
									}else if(section3BEnrolled < 10){
										section3BEnrolled++;
										section = "3-B";
										enrolled = true;
									}
									break;
								case "4":
									if(section4AEnrolled < 10){
										section4AEnrolled++;
										section = "4-A";
										enrolled = true;
									}else if(section4BEnrolled < 10){
										section4BEnrolled++;
										section = "4-B";
										enrolled = true;
									}
									break;
								case "5":
									if(section5AEnrolled < 10){
										section5AEnrolled++;
										section = "5-A";
										enrolled = true;
									}else if(section5BEnrolled < 10){
										section5BEnrolled++;
										section = "5-B";
										enrolled = true;
									}
									break;
								case "6":
									if(section6AEnrolled < 10){
										section6AEnrolled++;
										section = "6-A";
										enrolled = true;
									}else if(section6BEnrolled < 10){
										section6BEnrolled++;
										section = "6-B";
										enrolled = true;
									}
									break;
							}
							if(enrolled){
								getORF(firstName, lastName, middleName, email, section);
							}else{
								System.out.println("\n\nUnfortunately, all sections in this grade level are currently full. We regret to inform you that we cannot enroll the student at this time.");
							}
							subject.clear();
							break;
						}else{
							continue;
						}
					}
					break;
				case "2":
					System.out.println("\nExiting program...");
					System.exit(0);
					break;
				default:
					System.out.println("\nInvalid input!");
			}
		}
		scanner.close();
	}
	
	public static void getORF(String firstName, String lastName, String middleName, String email, String section){
		student.add(new Student(firstName, lastName, middleName, email, section));
		System.out.println("\n\n\n\nStudent Name: " + fullName.toUpperCase()
		+ "\nSection: " + section
		+ "\nSchool Year: " + schoolYear + "\n"
		+ "---------------------------------------------------"
		);
		System.out.printf("%-20s%-20s%-20s\n", "Subject", "Code", "Credit");
		for (Subject subjects : subject) {
			System.out.printf("%-20s%-20s%-20d\n", subjects.getSubjectName(), subjects.getCode(),subjects.getCreditHours());
		}

	}

	public static void addSubject(String gradeLevel){
		subject.add(new Subject("Math", "MTH10" + gradeLevel, 3));
		subject.add(new Subject("English", "ENG10" + gradeLevel, 3));
		subject.add(new Subject("Science", "SCI10" + gradeLevel, 4));
		subject.add(new Subject("Social Studies", "SS10" + gradeLevel, 3));
		subject.add(new Subject("MAPEH", "MAPEH10" + gradeLevel, 2));
		subject.add(new Subject("TLE", "TLE10" + gradeLevel, 2));
		subject.add(new Subject("Values Education", "VAL10" + gradeLevel, 2));
	} 
}