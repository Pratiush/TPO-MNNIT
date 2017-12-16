package com.wix.traitsoft.tpo_mnnit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


public class Fragment_Academics extends Fragment {

    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__academics, container, false);
        listView = (ListView)view.findViewById(R.id.list1);



        JsonFetch jsonFetch = new JsonFetch(getActivity(),"https://one-eyed-rewards.000webhostapp.com/fetch_academic.php");
        jsonFetch.execute();

        Log.d("JSON","HERE");

        Thread th = new Thread(new Runnable()
        {
            String json;
            int count = 0;
            public void run()
            {
                while(true)
                {
                    json = JsonFetch.json1;
                    if(!json.equals(""))
                        break;

                    count++;
                    if(count == 1000000000)
                    {
                        Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String json = JsonFetch.json1;
        Log.d("JSON1","Printing"+json);

        Toast.makeText(getContext(),json,Toast.LENGTH_LONG).show();
        ViewAdapter va =new ViewAdapter(getContext(),json,"academic");
        JsonFetch.json1 = "";
        listView.setAdapter(va);

        return view;

    }

}
