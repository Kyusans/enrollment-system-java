import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;
import java.util.Date;

public class EnrollmentSystem {
	public static ArrayList<Subject> subject = new ArrayList<Subject>();
	public static ArrayList<Student> student = new ArrayList<Student>();
	public static String fullName = "", email, birthday, gender;
	public static int currentYear = Year.now().getValue();
	public static int nextYear = currentYear + 1;									
	public static String schoolYear = String.format("%d-%d", currentYear, nextYear);
	public static int section = 1, sectionCount = 0;
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
 		String firstName, lastName, middleName;
		boolean validForm = false, exit = false, confirmed = false;
		System.out.printf("\n\nWelcome to Enrollment System for School year %s!\n", schoolYear);
		while (!exit) {
			confirmed = false;
			System.out.print("\n1. Enroll\n2. Exit\n3. See all students enrolled\nEnter your choice: ");
			String choice = scanner.nextLine();
			switch(choice){
				case "1":
					while(!confirmed){
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
							if(firstName.equals("") || lastName.equals("") || middleName.equals("") || email.equals("")){
								System.out.println("\nThere was an empty input please try again.");
							}else{
								fullName = lastName + ", " + firstName + " " + middleName; 
								validForm = true;
							}
						}while(!validForm);
							do{
								System.out.print("Enter your birthday (in the format MM/DD/YYYY): ");
								birthday = scanner.nextLine();
								if(birthday.matches("\\d{2}/\\d{2}/\\d{4}")){
									break;
								}else{
									System.out.println("\nInvalid input. Please enter your birthday in the format MM/DD/YYYY");
								}
							}while(true);
							do{
								System.out.print("Enter your gender (M/F): ");
								gender = scanner.nextLine().toUpperCase();
								if(gender.equals("M") || gender.equals("F")){
									break;				
								}else{
									System.out.println("\nInvalid input. Please enter M or F for gender.");
								}
							}while(true);
						System.out.print("\nPlease confirm if you want to proceed with the following information: \n\n"+ "Full Name: " + fullName.toUpperCase() + "\nEmail: " + email + "\nBirthday: " + birthday + "\nGender: " + gender + "\n\nType Y to confirm or type any other key to make any changes: ");
						String confirm = scanner.nextLine();
						if(confirm.equalsIgnoreCase("y")){
							if(sectionCount < 10){
								sectionCount++;
								student.add(new Student(fullName , Integer.toString(section)));
								addSubject();
								getORF();
							}else{
								section++;
								student.add(new Student(fullName , Integer.toString(section)));
                addSubject();
								getORF();
								sectionCount = 0;
							}
							subject.clear();
							confirmed = true;
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
					case "3":
						ArrayList<String> sections = new ArrayList<String>();
						for (Student s : student) {
							if (!sections.contains(s.getSection())) {
								sections.add(s.getSection());
							}
						}
						for (String section : sections) {
							System.out.println("\nSection " + section + ":");
							ArrayList<Student> studentsInSection = getStudentsInSection(section);
							for (int i = 0; i < studentsInSection.size(); i++) {
								System.out.println((i + 1) + ". " + studentsInSection.get(i).getStudentName());
							}
							System.out.println();
						}
						break;
				default:
					System.out.println("\nInvalid input!");
			}
		}
	}
	public static void getORF(){
		Date date = new Date();
		System.out.println("\n\n\nStudent Name: " + fullName.toUpperCase()+ "\nSection: " + section + "\nSchool Year: " + schoolYear + "\nDate of enrollment: " + date + "\n"+"----------------------------------------------------------------------");
		System.out.printf("%-25s%-30s%-20s\n", "Subject", "Code", "Time");
		for (Subject subjects : subject) {
			System.out.printf("%-25s%-23s%-20s\n", subjects.getSubjectName(), subjects.getSubjectCode(), subjects.getSubjectTime());
		}
		System.out.print("----------------------------------------------------------------------\n");
	}
	public static void addSubject(){
		subject.add(new Subject("Math", "MATH", "8:30 AM - 9:15 AM"));
		subject.add(new Subject("Filipino", "FIL", "9:15 AM - 10:00 AM"));
		subject.add(new Subject("English", "ENG", "10:30 AM - 11:15 AM"));
		subject.add(new Subject("Science", "SCI", "11:15 AM - 12:00 PM"));
		subject.add(new Subject("Social Studies", "SS", "1:00 PM - 1:45 PM"));
		subject.add(new Subject("Music, Arts, and PE", "MAPE", "1:45 PM - 2:30 PM"));
	} 

	public static ArrayList<Student> getStudentsInSection(String section) {
    ArrayList<Student> studentsInSection = new ArrayList<Student>();
    for(Student students : student){
			if(students.getSection().equals(section)){
				studentsInSection.add(students);
			}
    }
    return studentsInSection;
	}

}