package javaTester.javaOOP;

public class Topic_01_Student {
    private int studentID;
    private String studentName;
    private double knowledgePoint1;
    private double practicePoint;

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public void setKnowledgePoint1(double knowledgePoint1){
        this.knowledgePoint1 = knowledgePoint1;
    }

    public double getKnowledgePoint1(){
        return this.knowledgePoint1;
    }

    public void setPracticePoint(double practicePoint){
        this.practicePoint = practicePoint;
    }

    public double getPracticePoint(){
        return this.practicePoint;
    }

    public double getTotalPoint(){
        return this.knowledgePoint1 + this.practicePoint;
    }

}
