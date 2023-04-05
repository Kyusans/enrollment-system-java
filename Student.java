// import java.util.ArrayList;

class Student {
  private String firstName;
  private String lastName;
  private String email;
  private String middleName;

//   private ArrayList<Subject> enrolledCourses;
  public Student(String firstName, String lastName, String middleName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.middleName = middleName;
    // this.enrolledCourses = new ArrayList<Subject>();
  } 

  public String getFirstName(){
    return firstName;
  }

  public String getLastName(){
    return lastName;
  }

  public String getEmail(){
    return email;
  }

  public String getMiddleName(){ 
    return middleName;
  }

//   public ArrayList<Subject> getEnrolledCourses() {
//       return enrolledCourses;
//   }

//   public boolean isEnrolled(Subject course) {
//       return enrolledCourses.contains(course);
//   }

//   public int getTotalCreditHours() {
//       int total = 0;
//       for (Subject course : enrolledCourses) {
//           total += course.getCreditHours();
//       }
//       return total;
//   }

//   public void enroll(Subject course) {
//       enrolledCourses.add(course);
//   }

}