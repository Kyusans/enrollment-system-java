public class Subject{
  private String name;
  private String code;
  private int creditHours;

  public Subject(String name, String code, int creditHours){
    this.name = name;
    this.code = code;
    this.creditHours = creditHours;
  }
  
  public String getName(){
    return name;
  }
  
  public String getCode(){
    return code;
  }

  public int getCreditHours(){
    return creditHours;
  }
}