package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by shiva on 25-09-2017.
 */

public class AcademicProfile  {
    private String school_10;
    private String board_10;
    private int year_10;
    private double precentahe_10;
    private String school_12;
    private String board_12;
    private int year_12;
    private double precentahe_12;
    private double Cpi;
    private double Spi;
    private double semester1;
    private double semester2;
    private double semester3;
    private double semester4;
    private double semester5;
    private double semester6;
    private double semester7;
    private double semester8;

    public boolean isComplete()
    {
        return true;
    }

    public void completeProfile()
    {

    }

    public void dispalyProfile()
    {

    }

    AcademicProfile(String school_10,String board_10,int year_10,double precentage_10,String school_12,String board_12,int year_12,double precentage_12,double sem1,double sem2,double sem3,double sem4,double sem5,double sem6,double sem7,double sem8){

        this.school_10=school_10;
        this.board_10= board_10;
        this.year_10= year_10;
        this.precentahe_10=precentage_10;
        this.school_12=school_12;
        this.board_12=board_12;
        this.year_12=year_12;
        this.precentahe_12=precentage_12;
        this.semester1=sem1;
        this.semester2=sem2;
        this.semester3=sem3;
        this.semester4=sem4;
        this.semester5=sem5;
        this.semester6=sem6;
        this.semester7=sem7;
        this.semester8=sem8;

    };

    public String getSchool_10(){return school_10 ;}
    public String getBoard_10() { return board_10 ;}
    public int getYear_10(){ return year_10 ;}
    public double getPrecentahe_10() {return precentahe_10;}
    public String getSchool_12(){ return school_12 ;}
    public String getBoard_12() {return  board_12 ;}
    public int getYear_12(){ return year_12 ;}
    public double getPrecentahe_12() { return precentahe_12;}
    public double getSemester1(){ return semester1;}
    public  double getSemester2() {return semester2 ;}
    public double getSemester3(){ return  semester3 ;}
    public double getSemester4() { return  semester4;}
    public  double getSemester5(){ return semester5;}
    public double getSemester6(){ return semester6;}
    public  double getSemester7() {return semester7 ;}
    public double getSemester8(){ return  semester8 ;}

}
