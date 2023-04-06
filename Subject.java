public class Subject{
  private String subjectName;
  private String code;
  private int creditHours;

  public Subject(String subjectName, String code, int creditHours){
    this.subjectName = subjectName;
    this.code = code;
    this.creditHours = creditHours;
  }
  
  public String getSubjectName(){
    return subjectName;
  }
  
  public String getCode(){
    return code;
  }

  public int getCreditHours(){
    return creditHours;
  }
}