package sg.edu.rp.c346.id21012519.kindergarden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvKind;
    AsyncHttpClient client;
    ArrayAdapter<Kindergarden> aaKind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvKind= findViewById(R.id.lv);
        client = new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Kindergarden> alKind = new ArrayList<Kindergarden>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=4ad866a7-c43a-4645-87fd-fc961c9de78a&limit=5", new JsonHttpResponseHandler() {

            String enrolment;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonArrItems = response.getJSONObject("result");
                    JSONArray jsonRecords = jsonArrItems.getJSONArray("records");


                    for(int i = 0; i < jsonRecords.length(); i++) {
                        JSONObject jsonKind = jsonRecords.getJSONObject(i);
                        enrolment = jsonKind.getString("enrolment");
                        year = jsonKind.getString("year");
                        Kindergarden kind = new Kindergarden(enrolment, year);
                        alKind.add(kind);
                    }
                }
                catch(JSONException e){
                }

                //POINT X – Code to display List View
                aaKind= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,alKind);
                lvKind.setAdapter(aaKind);

            }//end onSuccess
        });
    }//end onResume

}