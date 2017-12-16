package com.wix.traitsoft.tpo_mnnit;

import android.app.Dialog;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import static android.R.layout.simple_list_item_1;


public class Fragment_Personal extends Fragment {
    private Dialog loadingDialog;

    ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment__personal, container, false);
        listView = (ListView)view.findViewById(R.id.list);

        JsonFetch jsonFetch = new JsonFetch(getActivity(),"https://one-eyed-rewards.000webhostapp.com/fetch_login.php");
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



        Log.d("Abc","CMS");
        Log.d("cms",json);
        ViewAdapter va =new ViewAdapter(getContext(),json,"personal");
        listView.setAdapter(va);
        JsonFetch.json1 = ""; // static member

        // Inflate the layout for this fragment
        return view;
    }




}
