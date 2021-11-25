package com.example.demo2.classes;

public class Soldat extends Humain {
    private int pv;
    private String grade;

    public Soldat(String nom, int pv, String grade) {
        super(nom);
        this.pv = pv;
        this.grade = grade;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Soldat{" +
                "pv=" + pv +
                ", grade='" + grade + '\'' +
                '}';
    }
}
