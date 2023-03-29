import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentSystem {
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("John", "Doe", "johndoe@example.com"));
		students.add(new Student("Jane", "Doe", "janedoe@example.com"));
		students.add(new Student("Bob", "Smith", "bobsmith@example.com"));

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		boolean isValidLevel = false;
		String level = "";

		while (!exit) {
			System.out.println("\n1. Enroll");
			System.out.println("2. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					while(true){
						System.out.print("\nEnter your name: ");
						String firstName = scanner.nextLine();
						System.out.print("Enter your last name: ");
						String lastName = scanner.nextLine();
						System.out.print("Enter your email: ");
						String email = scanner.nextLine();
						while(true){
							System.out.print("\nWhat year do you want to enroll? \n"
							+ "(1) 1st year\n"
							+ "(2) 2nd year\n"
							+ "(3) 3rd year\n"
							+ "(4) 4th year\n"
							+ "Enter your choice: ");
							level = scanner.nextLine();
							switch(level){
								case "1":
									subject.add(new Subject("Math", "IT100", 3));
									subject.add(new Subject("English", "IT110", 3));
									subject.add(new Subject("Science", "IT120", 4));
									subject.add(new Subject("History", "IT130", 3));
									isValidLevel = true;
									break;
								case "2":
									subject.add(new Subject("Math", "MTH101", 3));
									subject.add(new Subject("English", "ENG101", 3));
									subject.add(new Subject("Science", "SCI101", 4));
									subject.add(new Subject("History", "HIS101", 3));
									isValidLevel = true;
									break;
								case "3":
									subject.add(new Subject("Math", "MTH101", 3));
									subject.add(new Subject("English", "ENG101", 3));
									subject.add(new Subject("Science", "SCI101", 4));
									subject.add(new Subject("History", "HIS101", 3));
									isValidLevel = true;
									break;
								case "4":
									subject.add(new Subject("Math", "MTH101", 3));
									subject.add(new Subject("English", "ENG101", 3));
									subject.add(new Subject("Science", "SCI101", 4));
									subject.add(new Subject("History", "HIS101", 3));	
									isValidLevel = true;
									break;
								default:
									System.out.println("\nPlease enter valid number\n");
									break;
							}
							if(isValidLevel){
								break;
							}else{
								continue;
							}
						}
						System.out.print("\nPlease confirm if you want to proceed with the following information: \n\n" 
						+ "Full Name: " + firstName + " " + lastName 
						+ "\nEmail: " + email
						+ "\nYear level: " + level
						+ "\n\nType Y to confirm or type any other key to make any changes: ");
						
						String confirm = scanner.nextLine();

						if(confirm.equalsIgnoreCase("y")){
							students.add(new Student(firstName, lastName, email));
							System.out.println("\nYour subjects: \n");
							System.out.printf("%-45s%-15s%-10s\n", "Subject", "Code", "Credit");
							for (Subject s : subject) {
								System.out.printf("%-45s%-15s%-10d\n", s.getName(), s.getCode(), s.getCreditHours());
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

}

            
