package com.igeek.pojo;

import java.util.Objects;

/**
 * @author 86183
 * @ClassName: IntelliJ IDEA
 * @Description:
 * @date 2021/3/1 11:01
 */
public class Student_Node {

    private int id;
    private String name;
    private String major;
    private double math_grade;
    private double english_grade;
    private double java_grade;
    private double cpp_grade;
    private double all_grade;
    private int sort;

    public Student_Node() {
    }

    public Student_Node(int id, String name, String major, double math_grade,
                        double english_grade, double java_grade, double cpp_grade,
                        double all_grade, int sort) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.math_grade = math_grade;
        this.english_grade = english_grade;
        this.java_grade = java_grade;
        this.cpp_grade = cpp_grade;
        this.all_grade = all_grade;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getMath_grade() {
        return math_grade;
    }

    public void setMath_grade(double math_grade) {
        this.math_grade = math_grade;
    }

    public double getEnglish_grade() {
        return english_grade;
    }

    public void setEnglish_grade(double english_grade) {
        this.english_grade = english_grade;
    }

    public double getJava_grade() {
        return java_grade;
    }

    public void setJava_grade(double java_grade) {
        this.java_grade = java_grade;
    }

    public double getCpp_grade() {
        return cpp_grade;
    }

    public void setCpp_grade(double cpp_grade) {
        this.cpp_grade = cpp_grade;
    }

    public void setAll_grade() {
        this.all_grade = this.math_grade + this.english_grade + this.java_grade + this.cpp_grade;
    }

    public double getAll_grade() {
        return all_grade;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student_Node that = (Student_Node) o;
        return id == that.id &&
                Double.compare(that.math_grade, math_grade) == 0 &&
                Double.compare(that.english_grade, english_grade) == 0 &&
                Double.compare(that.java_grade, java_grade) == 0 &&
                Double.compare(that.cpp_grade, cpp_grade) == 0 &&
                Double.compare(that.all_grade, all_grade) == 0 &&
                Double.compare(that.sort, sort) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(major, that.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, major, math_grade, english_grade,
                java_grade, cpp_grade, all_grade, sort);
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + major + "\t" + math_grade + "\t" + english_grade + "\t" +
                java_grade + "\t" + cpp_grade + "\t" + all_grade + "\t" + sort;
    }
}
