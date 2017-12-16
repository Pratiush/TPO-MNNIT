package com.wix.traitsoft.tpo_mnnit;

import java.util.ArrayList;


/**
 * Created by Dell on 10/9/2017.
 */

public class GetArray {

    private ArrayList <Information> arrayList;
    private ArrayList <Registration> dataList;

    public ArrayList <Information> getArray(String[] labels, Profile pr ){

        arrayList= new ArrayList<Information>();
        int idx =0;
        arrayList.add(new Information(labels[idx],pr.getName()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getCourse()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getBranch()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getDob()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getEmail()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getSkypeid()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getLinkedinid()));
        idx++;
        int gender = pr.getGender();
        if(gender == 0)
            arrayList.add(new Information(labels[idx],"Male"));
        else if(gender == 1)
            arrayList.add(new Information(labels[idx],"Female"));
        idx++;



        arrayList.add(new Information(labels[idx],pr.getCategory()));
        idx++;

        int category = pr.getPhysical();
        if(category == 0)
            arrayList.add(new Information(labels[idx],"No"));
        else
            arrayList.add(new Information(labels[idx],"Yes"));
        idx++;

        int resident = pr.getGender();
        if(resident == 0)
            arrayList.add(new Information(labels[idx],"Hosteller"));
        else
            arrayList.add(new Information(labels[idx],"Non - Hosteller"));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getGuardian()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getPresentaddress()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getPermanentaddress()));
        idx++;

        int marriage = pr.getGender();
        if(marriage == 0)
            arrayList.add(new Information(labels[idx],"Unmarried"));
        else
            arrayList.add(new Information(labels[idx],"Married"));

        idx++;
        arrayList.add(new Information(labels[idx],pr.getState()));
        idx++;
        arrayList.add(new Information(labels[idx],pr.getCountry()));
        idx++;

        return arrayList;
    }

    public ArrayList <Information> getArray(String [] labels,AcademicProfile ap){
        arrayList =new ArrayList<Information>();
        int idx=0;
        arrayList.add(new Information(labels[idx++],ap.getSchool_10()));
        arrayList.add(new Information(labels[idx++],ap.getSchool_10()));
        arrayList.add(new Information(labels[idx++],Integer.toString(ap.getYear_10())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getPrecentahe_10())));
        arrayList.add(new Information(labels[idx++],ap.getSchool_12()));
        arrayList.add(new Information(labels[idx++],ap.getBoard_12()));
        arrayList.add(new Information(labels[idx++],Integer.toString(ap.getYear_12())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getPrecentahe_12())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getSemester1())));
        arrayList.add(new Information(labels[idx++], Double.toString(ap.getSemester2())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getSemester3())));
        arrayList.add(new Information(labels[idx++], Double.toString(ap.getSemester4())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getSemester5())));
        arrayList.add(new Information(labels[idx++], Double.toString(ap.getSemester6())));
        arrayList.add(new Information(labels[idx++],Double.toString(ap.getSemester7())));
        arrayList.add(new Information(labels[idx++], Double.toString(ap.getSemester8())));
        return  arrayList;
    }

    public ArrayList<Information> getArray(String[] labels,Project p){
        arrayList =new ArrayList<Information>();
        int idx=0;
        arrayList.add(new Information(labels[idx++],p.getTitle()));
        arrayList.add(new Information(labels[idx++],p.getDescription()));
        arrayList.add(new Information(labels[idx++],Integer.toString(p.getIntern())));
        arrayList.add(new Information(labels[idx++],p.getOrganisation()));
        arrayList.add(new Information(labels[idx++],p.getDescription1()));
        return arrayList;
    }

    public ArrayList<Information> getArray(Message message){
        arrayList =new ArrayList<Information>();
        arrayList.add(new Information(message.getUsername(),message.getMessage()));
        return  arrayList;
    }
    public ArrayList<Registration> getArraydata(Registration message){
        dataList =new ArrayList<Registration>();
        dataList.add(new Registration(message.getname1(),message.getname2(),message.getname3(),message.getname4()));
        return  dataList;
    }

}
