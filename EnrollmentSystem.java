import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;
import java.util.Date;

public class EnrollmentSystem {
	// nag initialize ta diri og global array og variables para ma access sa tanan method (main method, getORF method, og ang addSubject method)
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static String fullName = "", section, email, birthday, gender;
	// kani kay para makuha nato ang year karun og next year
	public static int currentYear = Year.now().getValue();
	public static int nextYear = currentYear + 1;
	/* kaning %d-%d ma replace sa currentYear og nextYear para mahimong 2023-2024
	 nganong %d? kay int man ang currentYear og nextYear pero kung String, gamiton nato kay %s. kung formatting atong gamiton
	 basta %d is int, tapos ang %s kay String (for format, og katong printF) */												
	public static String schoolYear = String.format("%d-%d", currentYear, nextYear);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
 		String firstName, lastName, middleName;
		boolean validForm = false, exit = false, enrolled = false;
		int sectionAEnrolled = 0, sectionBEnrolled = 0;
		// remember nga kaning \n kay pang break og line para spacing. og kaning %s kay ma replace sa schoolYear nga variable
		System.out.printf("\n\nWelcome to Enrollment System for School year %s!\n", schoolYear);
		while (!exit) {
			System.out.print("\n1. Enroll\n2. Exit\nEnter your choice: ");
			String choice = scanner.nextLine();
			switch(choice){
				case "1":
					System.out.println("\n-------------Enter personal information-------------\n");
						do{
							System.out.print("Enter your first name: ");
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
								// gi set nato ang fullName diri para ma gamit tani sa ORF sa student
								fullName = lastName + ", " + firstName + " " + middleName; 
								// gi set nato ang validForm to true para mo hawa ta ani nga do while loop
								validForm = true;
							}
						}while(!validForm);
							do{
								System.out.print("Enter your birthday (in the format MM/DD/YYYY): ");
								birthday = scanner.nextLine();
								// Kini nga code kay ga check kung ang birthday variable kay nag-match sa usa ka specific nga pattern. sa atoa kay "d{2} 'meaning dapat duha ka number' / d{2} / d{4} 'meaning dapat upat ka number' "
								if(birthday.matches("\\d{2}/\\d{2}/\\d{4}")){
									break;
								}else{
									System.out.println("\nInvalid input. Please enter your birthday in the format MM/DD/YYYY");
								}
							}while(true);
							do{
								System.out.print("Enter your gender (M/F): ");
								// toUpperCase() para pang capitalize lang sa String. bahalag "m" lang iyang gi input, "M" ang ma butang.
								gender = scanner.nextLine().toUpperCase();
								if(gender.equals("M") || gender.equals("F")){
									break;				
								}else{
									System.out.println("\nInvalid input. Please enter M or F for gender.");
								}
							}while(true);

						//confirmation diri if okay naba ang gi input ni user
						System.out.print("\nPlease confirm if you want to proceed with the following information: \n\n"+ "Full Name: " + fullName.toUpperCase() + "\nEmail: " + email + "\nBirthday: " + birthday + "\nGender: " + gender + "\n\nType Y to confirm or type any other key to make any changes: ");
						String confirm = scanner.nextLine();
						// validation diri if puno naba ang section A og B
						if(confirm.equalsIgnoreCase("y")){
							// if less than 10 pa gani ang section A, section A mabutang ang student. Else if kay sa section B, else kay FULL na ang section
							if(sectionAEnrolled < 10){
								sectionAEnrolled++;
								section = "A";
								enrolled = true;
							}else if(sectionBEnrolled < 10){
								sectionBEnrolled++;
								section = "B";
								enrolled = true;
							}

							// kaning if(enrolled), meaning enrolled kay true murag " enrolled = true . kung mag himo kag false, mag butang kag " ! " for example, if(!enrolled) - meaning enrolled = false 
							if(enrolled){
								// gi tawag nato ang gi himo nato nga methods
								addSubject();
								// gi pasa nato ang firstName,lastname ni user kay ang getORF() kailangan siyag ing ani getORF(String firstName, String lastName, String middleName, String email, String section) meaning naa tay eh pasa
								getORF();
							}else{
								System.out.println("\n\nUnfortunately, all sections are currently full. We regret to inform you that we cannot enroll the student at this time.");
							}
							// gi clear nato tong gi addSubject() para di mag duplicate pag mag enroll napud og bag o
							subject.clear();
							break;
						}else{
							continue;
						}
				case "2":
					System.out.println("\nExiting program...");
					//System.exit(0); kay pang stop sa program
					System.exit(0);
					scanner.close();
					break;
				default:
					System.out.println("\nInvalid input!");
			}
		}
	}

	// kani nga method kay pang display lang sa ORF sa student.
	public static void getORF(){
		Date date = new Date();
		System.out.println("\n\n\n\nStudent Name: " + fullName.toUpperCase()+ "\nSection: " + section+ "\nSchool Year: " + schoolYear + "\nDate of enrollment: " + date + "\n"+"----------------------------------------------------------------------");
		System.out.printf("%-25s%-30s%-20s\n", "Subject", "Code", "Time");
		// kani, gi kuha nato tanan subjects sa "subject" nga arrayList nga gi initialize nato sa taas
		// murag sa python last sem ba nga - for every subjects in subject
		for (Subject subjects : subject) {
			System.out.printf("%-25s%-23s%-20s\n", subjects.getSubjectName(), subjects.getSubjectCode(), subjects.getSubjectTime());
		}
		System.out.print("----------------------------------------------------------------------\n");
	}

	// kani nga method kay pang add lang og subject
	public static void addSubject(){
		// kaning Subject() bitaw kay naa sa Subject.java og ang purpose ani kay mag himo tag bag o nga subject so ang sulod ani kay Subject(subjectName, subjectCode, subjectTime)
		subject.add(new Subject("Math", "MATH", "8:30 AM - 9:15 AM"));
		subject.add(new Subject("Filipino", "FIL", "9:15 AM - 10:00 AM"));
		subject.add(new Subject("English", "ENG", "10:30 AM - 11:15 AM"));
		subject.add(new Subject("Science", "SCI", "11:15 AM - 12:00 PM"));
		subject.add(new Subject("Social Studies", "SS", "1:00 PM - 1:45 PM"));
		subject.add(new Subject("Music, Arts, and PE", "MAPE", "1:45 PM - 2:30 PM"));
	} 
}