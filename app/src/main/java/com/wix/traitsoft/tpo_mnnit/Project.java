package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by shiva on 25-09-2017.
 */

public class Project  {

    private int noOfProject;
    private int noOfIntern;
    private String projectDesription[];
    private String internDesription[];


    // as in database date:10-9-17

    private String title;
    private String description;
    private int intern;
    private String organisation;
    private String description1;

    Project(int noOfProject,int noOfIntern)
    {
        this.noOfProject = noOfProject;
        this.noOfIntern = noOfIntern;
        projectDesription = new String[noOfProject];
        internDesription = new String[noOfIntern];
    }

    public void completeProfile()
    {

    }

    public void dispalyProfile()
    {

    }

    public boolean IsCompleted()
    {
        return true;
    }
    // overriding constructor
    Project ( String title ,String description, int intern , String organisation,String description1){
        this.title=title;
        this.description =description;
        this.intern =intern;
        this.organisation=organisation;
        this.description1=description1;
    }

    public String getTitle(){return title;}
    public String getDescription() {return description;}
    public String getOrganisation() { return organisation ;}
    public  int getIntern() { return intern ;}
    public String getDescription1() {return description1 ;}



}
