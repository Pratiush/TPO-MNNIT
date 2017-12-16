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


public class Fragment_Project extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__project, container, false);
        listView = (ListView)view.findViewById(R.id.list2);

        JsonFetch jsonFetch = new JsonFetch(getActivity(),"https://one-eyed-rewards.000webhostapp.com/fetch_project.php");
        jsonFetch.execute();

        Thread t = new Thread(new Runnable()
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

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String json = JsonFetch.json1;

        // loadingDialog.dismiss();

        Log.d("Abc","CMS");
        Log.d("cms",json);
        Toast.makeText(getContext(),json,Toast.LENGTH_LONG).show();
        ViewAdapter va =new ViewAdapter(getContext(),json,"project");
        listView.setAdapter(va);
        JsonFetch.json1 = "";

        // Inflate the layout for this fragment
        return view;


    }


}
