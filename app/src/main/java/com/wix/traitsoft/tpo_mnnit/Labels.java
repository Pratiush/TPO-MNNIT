package com.wix.traitsoft.tpo_mnnit;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 10/8/2017.
 */

public class Labels {

    private String[] personal;
    private String[] academic,project,companies;

    Labels()
    {

    }



     public String[] getLabels(String label)
     {
         switch (label) {
             case "personal":
                 personal = new String[]{"Name", "Course", "Branch", "Date OF Birth", "Email", "Skypeid", "LinkedinID", "Gender", "Category", "Physically Challanged", "Resident", "Guardian",
                         "Present Address", "Permanent Address", "Marital Status", "State", "Country"};
                 return personal;
             case "academic":
                 academic = new String[]{"10th School", "10th Board", "10th Year", "10th precentage", "12th School", "12th Board", "12th Year", "12th precentage", "sem1", "sem2", "sem3", "sem4", "sem5", "sem6", "sem6", "sem7", "sem8"};
                 return academic;
             case "project":
                 project = new String[]{"Title", "Description", "Intern", "Organisation", "Description"};
                 return project;
             case "company":
                 companies = new String[]{"name", "cpi", "date_close","branch"};
                 return companies;
             default:
                 return new String[]{""};
         }
     }

     public Profile getpersonalProfile(JSONObject obj)
     {
         try {
             return new Profile(obj.getString("name"),obj.getString("course"),obj.getString("branch"),
                     obj.getString("dob"),obj.getString("email"),obj.getString("skypeid"),obj.getString("linkedinid")
                     ,obj.getInt("gender"),obj.getString("category"),obj.getInt("physical"),obj.getInt("resident"),obj.getString("guardian"),
                     obj.getString("presentaddress"),obj.getString("permanentaddress"),obj.getInt("maritalstatus"),obj.getString("state"),
                     obj.getString("country"));
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return null;
     }

     public AcademicProfile getacademicProfile(JSONObject obj){

         try {
             return new AcademicProfile(obj.getString("school10"),obj.getString("board10"),obj.getInt("year10"),obj.getDouble("marks10")
                     ,obj.getString("school12"),obj.getString("board12"),obj.getInt("year12"),obj.getDouble("marks12"),obj.getDouble("sem1"),
                     obj.getDouble("sem2"),obj.getDouble("sem3"),obj.getDouble("sem4"),obj.getDouble("sem5"),obj.getDouble("sem6"),obj.getDouble("sem7"),obj.getDouble("sem8"));
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return null;
     }
    public Registration getCompanyProfile(JSONObject obj){

        try {
            return new Registration(obj.getString("name"),obj.getDouble("cpi"),obj.getString("date_close"),obj.getString("branch"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


     public Project getProject(JSONObject obj){

         try {
             return new Project(obj.getString("title"),obj.getString("description"),obj.getInt("intern"),obj.getString("organisation"),obj.getString("description1"));
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return null;
     }

     public Message getmessage(JSONObject obj){

         try {
             return  new Message(obj.getString("username"),obj.getString("message"));
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return  null;
     }



}
