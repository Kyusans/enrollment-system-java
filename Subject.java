public class Subject{
  private String subjectName;
  private String code;
  private String room;
  private int creditHours;

  public Subject(String subjectName, String code, String room, int creditHours){
    this.subjectName = subjectName;
    this.code = code;
    this.room = room;
    this.creditHours = creditHours;
  }
  
  public String getSubjectName(){
    return subjectName;
  }
  
  public String getCode(){
    return code;
  }

  public String getRoom(){
    return room;
  }

  public int getCreditHours(){
    return creditHours;
  }
}