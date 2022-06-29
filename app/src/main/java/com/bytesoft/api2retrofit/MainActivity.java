package com.bytesoft.api2retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button getData;
    RecyclerView rclist;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please wait.....");
        setContentView(R.layout.activity_main);
        getData=findViewById(R.id.getData);
        rclist=findViewById(R.id.rclist);
        Methods methods =RetrofitClient.getRetrofitInstance().create(Methods.class);


        /*progressDialog.show();
        Call<Model> call = methods.getAllData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressDialog.dismiss();
                if(response.isSuccessful()){



                    rclist.setHasFixedSize(true);
                    rclist.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                            LinearLayoutManager.VERTICAL, false));
                    Listmail adaptar = new Listmail(response.body().getData());
                    rclist.setAdapter(adaptar);
                    Log.e(TAG,"onResponse: Code: "+ response.code() );
                    ArrayList<Model.data> data = response.body().getData();

                    for (Model.data data1 : data){
                        Toast.makeText(MainActivity.this, "emails: "+data1.getEmail(), Toast.LENGTH_SHORT).show();

                        //  Log.e(TAG,"onResponse: emails: "+data1.getEmail() );


                    }
                }else{
                    Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.getMessage() );
                progressDialog.dismiss();

            }
        });*/


        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Call<Model> call = methods.getAllData();
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        progressDialog.dismiss();
                        if(response.isSuccessful()){



                            rclist.setHasFixedSize(true);
                            rclist.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                                    LinearLayoutManager.VERTICAL, false));
                            Listmail adaptar = new Listmail(response.body().getData());
                            rclist.setAdapter(adaptar);
                            Log.e(TAG,"onResponse: Code: "+ response.code() );
                            ArrayList<Model.data> data = response.body().getData();

                            for (Model.data data1 : data){
                                Toast.makeText(MainActivity.this, "emails: "+data1.getEmail(), Toast.LENGTH_SHORT).show();

                                //  Log.e(TAG,"onResponse: emails: "+data1.getEmail() );


                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG,"onFailure"+t.getMessage() );
                        progressDialog.dismiss();

                    }
                });


            }
        });

    }

}