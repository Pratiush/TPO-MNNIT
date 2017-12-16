package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by Asus on 05-09-2017.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;


public class Tab_open extends Fragment {
    String json;
    View view;
    /*TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Button bt;*/
    ArrayList<TextView> tv1List,tv2List,tv3List,tv4List;
    ArrayList<Button> bList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_opening, container, false);

        JsonFetch jsonFetch = new JsonFetch(getActivity(), "https://one-eyed-rewards.000webhostapp.com/fetch_company.php");
        JsonFetch.json1="";
        jsonFetch.execute();

        Thread t = new Thread(new Runnable()
        {
            String json;
            public void run()
            {
                while(true)
                {
                    json = JsonFetch.json1;
                    if(!json.equals(""))
                        break;

                }
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        json = JsonFetch.json1;
        Log.i("check",json);
        Toast.makeText(getContext(),json,Toast.LENGTH_LONG).show();
        JsonFetch.json1="";

       /* Button bproject=(Button)view.findViewById(R.id.register_company);
        bproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data=new ArrayList<String>();
                for(EditText et:etList)
                {
                    data.add(et.getText().toString());
                }
                Session session = new Session(getContext());
                BackgroundTask backgroundTask=new BackgroundTask(getContext());
                backgroundTask.execute("projectupload",session.getUsername(),data.get(0),data.get(1),data.get(2),data.get(3),data.get(4));
            }
        });*/



        init(view);
        // Inflate the layout for this fragment
        return view;


    }

    void init(View view)
    {

        tv1List=new ArrayList<TextView>();
        tv2List=new ArrayList<TextView>();
        tv3List=new ArrayList<TextView>();
        tv4List=new ArrayList<TextView>();
        bList=new ArrayList<Button>();
        TableLayout ll = (TableLayout) view.findViewById(R.id.table_view);
        ViewAdapter va=new ViewAdapter(getContext(),json,"company");
        ArrayList<Registration> projectdata=va.dataList;
        Log.i("check2",projectdata.get(0).getname1());
        for (int i = 0; i <projectdata.size(); i++) {

            TableRow row= new TableRow(getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView tv1=new TextView(getContext());
            TextView tv2=new TextView(getContext());
            TextView tv3=new TextView(getContext());
            TextView tv4=new TextView(getContext());
            Button bt=new Button(getContext());


            tv1.setText(projectdata.get(i).getname1());

            tv2.setText(projectdata.get(i).getname2().toString());
            tv3.setText(projectdata.get(i).getname3());
            tv4.setText(projectdata.get(i).getname4());
            bt.setText("REGISTER");
//            bt.setText(projectdata.get(i).getLabel().toString());
            //final Button finalBt = bt;

            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);
            row.addView(tv4);
            row.addView(bt);
            ll.addView(row,i);
            tv1List.add(tv1);
            tv2List.add(tv1);
            tv3List.add(tv1);
            tv4List.add(tv1);
            bList.add(bt);
        }
    }
}
