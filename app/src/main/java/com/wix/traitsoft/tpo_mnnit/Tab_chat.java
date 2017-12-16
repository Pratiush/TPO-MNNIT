package com.wix.traitsoft.tpo_mnnit;

/**
 * Created by Asus on 05-09-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Tab_chat extends Fragment {

    Button chatButton;
    EditText chatText;
    TextView chatView;

    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_chat, container, false);

        chatButton = (Button) view.findViewById(R.id.chatButton);
        chatText = (EditText) view.findViewById(R.id.chatText);
        chatView = (TextView) view.findViewById(R.id.chatView);


        String json = exec();
        Log.d("JSON1","Printing"+json);

        fetch(json);

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = chatText.getText().toString();
                SendMessage sendMessage = new SendMessage(getContext());
                Session session = new Session(getContext());
                String username = session.getUsername();
                sendMessage.execute(username,str);
                String json = exec();
                fetch(json);
            }
        });

        return view;

    }

    private void fetch(String json)
    {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                String username = obj.getString("username");
                String message = obj.getString("message");
                chatView.setText(username +" : "+message+"\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String exec()
    {
        JsonFetch jsonFetch = new JsonFetch(getActivity(),"https://one-eyed-rewards.000webhostapp.com/chat.php");
        JsonFetch.json1 = "";
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
        return json;
    }

}
