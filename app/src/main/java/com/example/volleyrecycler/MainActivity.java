package com.example.volleyrecycler;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.Response;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Filter;

public class MainActivity extends AppCompatActivity {


    List<PostModel> postList = new ArrayList<>();
    String url = "https://bsgi.org.bd/api/member_search";
    PostAdapter adapder;
    List<PostModel> filterList = new ArrayList<>();


    RecyclerView recyclerView;
    EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        search = findViewById(R.id.search);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filterList.clear();

                if (s.toString().isEmpty()) {

                    recyclerView.setAdapter(new PostAdapter(getApplicationContext(), postList));
                    adapder.notifyDataSetChanged();

                } else {

                    Filter(s.toString());

                }


            }
        });

        GetData();
    }

    private void Filter(String text) {

        for (PostModel post : postList) {
            if (Integer.toString(post.getId()).contains(text)
                    || (post.getName().toLowerCase()).contains(text.toLowerCase()) ||
                    (post.getMember_type().toLowerCase()).contains(text.toLowerCase())
            ) {
                filterList.add(post);
            }

        }

        recyclerView.setAdapter(new PostAdapter(getApplicationContext(), filterList));
        adapder.notifyDataSetChanged();


    }

    private void GetData() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //   JSONArray jsonArray = new JSONArray(Request.Method.GET, url,null  )


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i <= response.length(); i++) {

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        postList.add(new PostModel(
                                jsonObject.getInt("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("email"),
                                jsonObject.getString("mobile_number"),
                                jsonObject.getString("father_name"),
                                jsonObject.getString("mother_name"),
                                jsonObject.getString("blood_group"),
                                jsonObject.getString("nationality"),
                                jsonObject.getString("orga"),
                                jsonObject.getString("present_address"),
                                jsonObject.getString("member_type"),
                                jsonObject.getString("designation")


                        ));

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                    adapder = new PostAdapter(getApplicationContext(), postList);
                    recyclerView.setAdapter(adapder);
                    adapder.notifyDataSetChanged();


                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "error.getMessage", Toast.LENGTH_SHORT).show();

                    }
                });

        requestQueue.add(jsonArrayRequest);


    }


}