package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by Dell on 10/12/2017.
 */

public class Message {

    private String username;
    private String message;

    Message(String username,String message){
        this.username=username;
        this.message=message;
    }

    public String getUsername(){return  username;}
    public String getMessage() { return message;}
}
