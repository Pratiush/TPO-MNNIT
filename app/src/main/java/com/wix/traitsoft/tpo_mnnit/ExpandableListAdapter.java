package com.wix.traitsoft.tpo_mnnit;

import android.content.Context;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dell on 10/11/2017.
 */

public class ExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }
}
