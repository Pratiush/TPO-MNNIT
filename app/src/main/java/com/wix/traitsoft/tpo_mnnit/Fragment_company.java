package com.wix.traitsoft.tpo_mnnit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment_company extends Fragment {

    Button b1,b2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_company, container, false);

        b1=(Button)view.findViewById(R.id.current);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Tab_open()).commit();
            }
        });

        b2=(Button)view.findViewById(R.id.registered);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Fragment_registered()).commit();


            }
        });

        return  view;
    }


}
