package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by shiva on 29-09-2017.
 */

public class Information {
    private String label;
    private String name;
    Information(String label,String name)
    {
        this.label = label;
        this.name = name;
    }

    public String getLabel()
    {
        return label;
    }

    public String getName()
    {
        return name;
    }

}
