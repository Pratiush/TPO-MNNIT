package com.wix.traitsoft.tpo_mnnit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by shiva on 27-09-2017.
 */

public class Fragment_Profile extends Fragment {

    Button b1,b2,b3,b4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        b1 = (Button) view.findViewById(R.id.personal);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Fragment_Personal()).addToBackStack(null).commit();
                // opens Fragment_Personal()

            }
        });

        b2 = (Button) view.findViewById(R.id.academics);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Fragment_Academics()).addToBackStack(null).commit();

            }
        });

        b3 = (Button) view.findViewById(R.id.project);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Fragment_Project()).addToBackStack(null).commit();

            }
        });

        b4 = (Button) view.findViewById(R.id.resume);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fmanager=getFragmentManager();
                fmanager.beginTransaction().replace(R.id.content,new Fragment_Resume()).addToBackStack(null).commit();

            }
        });

        return view;
    }



}
