package com.example.labworkstfeb;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class Second extends AppCompatActivity {
    RecyclerView rv;
    Data data;
    DataDao dataDao;

    MyViewModel viewModel;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        viewModel.getUserList().observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(@Nullable List<Data> users) {
                MyAdapter myAdapter = new MyAdapter(Second.this, users);
                rv.setAdapter(myAdapter);
            }
        });

    }


}
