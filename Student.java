class Student {
    private int stdId;
    private String stdName;
    private int age;
    private String email;
    Course course;
    private int cId;

    Student(String stdName, int age, String email, int cId) {
        setStdName(stdName);
        setAge(age);
        setEmail(email);
        setCourseId(cId);
    }

    Student(int stdId) {
        setStdId(stdId);
    }
    // Getters and settrs

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseId() {
        return cId;
    }

    public void setCourseId(int cId) {
        this.cId = cId;
    }

}