package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by Dell on 10/13/2017.
 */

public class Registration {

    private String name1,name3,name4;
    Double name2;
    Registration(String name1,Double name2,String name3,String name4)
    {
        this.name1 = name1;
        this.name2 = name2;
        this.name3=name3;
        this.name4=name4;
    }

    public String getname1()
    {
        return name1;
    }
    public Double getname2()
    {
        return name2;
    }
    public String getname3()
    {
        return name3;
    }
    public String getname4()
    {
        return name4;
    }

}



