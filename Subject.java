public class Subject{
  private String subjectName;
  private String subjectCode;
  private String subjectTime;

  public Subject(String subjectName, String subjectCode, String subjectTime){
    this.subjectName = subjectName;
    this.subjectCode = subjectCode;
    this.subjectTime = subjectTime;
  }
  
  public String getSubjectName(){
    return subjectName;
  }
  
  public String getSubjectCode(){
    return subjectCode;
  }

  public String getSubjectTime(){
    return subjectTime;
  }
}