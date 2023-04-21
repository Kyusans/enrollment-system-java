public class Student {
  private String studentName;
  private String section;

  public Student(String studentName, String section){
    this.studentName = studentName;
    this.section = section;
  }
  
  public String getSection() {
    return section;
  }

  public String getStudentName(){
    return studentName;
  }

}
