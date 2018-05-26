package com.example.stud.musicapp.topsongs;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.api.apiService;
import com.example.stud.musicapp.api.trendingList;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsActivity extends AppCompatActivity {

    RecyclerView rvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvList = findViewById(R.id.rvList);



        Call<trendingList> trendingListCall = apiService. getService ().getTrendingList( "us" ,
                "itunes" , "singles" );
        trendingListCall.enqueue( new Callback<trendingList>() {
            @Override
            public void onResponse(@NonNull Call<trendingList> call, @NonNull
                    Response<trendingList> response) {
                trendingList trendingList = response.body();
                Log. d ( "TAG" , new Gson().toJson(trendingList));
            }
            @Override
            public void onFailure( @NonNull Call<trendingList> call, Throwable t) {
                Toast. makeText (TopSongsActivity. this , "Blad pobierania danych: " +
                        t.getLocalizedMessage(), Toast. LENGTH_SHORT ).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();

        return true;
    }
}
