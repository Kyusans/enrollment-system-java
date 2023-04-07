class Student {
  private String firstName;
  private String lastName;
  private String email;
  private String middleName;
  private String section;

  public Student(String firstName, String lastName, String middleName, String email, String section) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.middleName = middleName;
    this.section = section;
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

  public String getSection(){
    return section;
  }
}