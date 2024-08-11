class Student {
    private int stdId;
    private String stdName;
    private int age;
    private String email;
    Course course;
    private int cId;

    Student(String stdName, int age, String email, int cId){
        this.stdName = stdName;
        this.age = age;
        this.email = email;
        this.cId = cId;
    }
    
    public int getStdId(){
        return stdId;
    }
    public String getStdName(){
        return stdName;
    }
    public void setStdName(){
        this.stdName = stdName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }
    public int getCourseId(){
        return cId;
    }

}