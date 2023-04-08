import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class EnrollmentSystem {
	// nag initialize ta diri og global array og variables para ma access sa tanan method (main method, getORF method, og ang addSubject method)
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static String fullName = "", section;
	public static int age;
	public static int currentYear = Year.now().getValue();
	public static int nextYear = currentYear + 1;
	public static String schoolYear = String.format("%d-%d", currentYear, nextYear);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
 		String firstName, lastName, middleName, email;
		boolean validForm = false, exit = false, validAge = false, enrolled = false;
		int sectionAEnrolled = 10, sectionBEnrolled = 10;
		System.out.printf("\n\nWelcome to Enrollment System for School year %s!\n", schoolYear);
		while (!exit) {
			System.out.print("\n1. Enroll\n2. Exit\nEnter your choice: ");
			String choice = scanner.nextLine();
			switch(choice){
				case "1":
					System.out.println("\n-------------Enter personal information-------------\n");
					while(true){
						do {
							// try and catch like eh try sa niya ni nga code and if naay error, eh execute tanan naa sa catch{} example:  try{ eh execute tanan code diri } catch() { execute tanan code diri if naay error }
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
							// validation ni siya if naay empty input like walay gi butang si user
							if(firstName.equals("") || lastName.equals("") || middleName.equals("") || email.equals("")){
								System.out.println("\nThere was an empty input please try again.");
							}else{
								fullName = lastName + ", " + firstName + " " + middleName; 
								validForm = true;
							}
						}while(!validForm);
						System.out.print("\nPlease confirm if you want to proceed with the following information: \n\n"+ "Full Name: " + fullName.toUpperCase() + "\nEmail: " + email+ "\nAge: " + age + "\n\nType Y to confirm or type any other key to make any changes: ");
						String confirm = scanner.nextLine();
						// validation diri if puno naba ang section A og B
						if(confirm.equalsIgnoreCase("y")){
							if(sectionAEnrolled < 10){
								sectionAEnrolled++;
								section = "A";
								enrolled = true;
							}else if(sectionBEnrolled < 10){
								sectionBEnrolled++;
								section = "B";
								enrolled = true;
							}

							if(enrolled){
								// gi tawag nato ang gi himo nato nga methods
								addSubject();
								// gi pasa nato ang firstName,lastname... ni user kay ang getORF kailangan siyag ing ani getORF(String firstName, String lastName, String middleName, String email, String section) meaning naa tay eh pasa
								getORF(firstName, lastName, middleName, email, section);
							}else{
								System.out.println("\n\nUnfortunately, all sections are currently full. We regret to inform you that we cannot enroll the student at this time.");
							}
							// gi clear nato tong gi addSubject() para di mag duplicate pag mag enroll napud og bag o
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
					scanner.close();
					break;
				default:
					System.out.println("\nInvalid input!");
			}
		}
	}
	public static void getORF(String firstName, String lastName, String middleName, String email, String section){
		System.out.println("\n\n\n\nStudent Name: " + fullName.toUpperCase()+ "\nSection: " + section+ "\nSchool Year: " + schoolYear + "\n"+"----------------------------------------------------------------------");
		System.out.printf("%-25s%-30s%-20s\n", "Subject", "Code", "Time");
		for (Subject subject : subject) {
			System.out.printf("%-25s%-23s%-20s\n", subject.getSubjectName(), subject.getSubjectCode(), subject.getSubjectTime());
		}
		System.out.print("----------------------------------------------------------------------");
	}
	public static void addSubject(){
		subject.add(new Subject("Math", "MATH", "8:30 AM - 9:15 AM"));
		subject.add(new Subject("Filipino", "Fil", "9:15 AM - 10:00 AM"));
		subject.add(new Subject("English", "ENG", "10:30 AM - 11:15 AM"));
		subject.add(new Subject("Science", "SCI", "11:15 AM - 12:00 PM"));
		subject.add(new Subject("Social Studies", "SS", "1:00 PM - 1:45 PM"));
		subject.add(new Subject("Music, Arts, and PE", "MAPE", "1:45 PM - 2:30 PM"));
	} 
}