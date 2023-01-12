package com.example.domain;

public class Student {
    private String _name;
    private String _group;
    private int _course_number;
    private double _average_score;
    private int [] _semester_grades;

    public Student() {}

    public Student(String name, String group, int course_number, int [] semester_grades) {

        this._name = name;
        this._group = group;
        this._course_number = course_number;
        this.setSemesterGrades(semester_grades);

        for (int i = 0; i < this._semester_grades.length; i++){
            this._average_score += this._semester_grades[i];
        }

        this._average_score /= this._semester_grades.length;
    }
    public String getName() {
        return _name;
    }
    public String getGroup() {
        return _group;
    }
    public int getCourseNumber() {
        return _course_number;
    }
    public double getAverageScore() {
        return _average_score;
    }

    public int [] getSemesterGrades(){
        return this._semester_grades;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setGroup(String group) {
        this._group = group;
    }

    public void setCourseNumber(int course_number) {
        this._course_number = course_number;
    }

    public void setAverageScore(int average_score) {
        this._average_score = average_score;
    }
    public void setSemesterGrades(int [] _semester_grades){
        this._semester_grades = new int[_semester_grades.length];
        for (int i = 0; i < this._semester_grades.length; i++){
            this._semester_grades[i] = _semester_grades[i];
        }
    }

    @Override
    public String toString() {
        return  " Имя: " + this.getName() + " , " +
                " Группа: " + this.getGroup() + "," +
                " Курс: " + this.getCourseNumber() + "," +
                " Средний Балл: " + this.getAverageScore();
    }

}