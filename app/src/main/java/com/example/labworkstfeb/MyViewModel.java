package com.example.labworkstfeb;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Dao;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;




public class MyViewModel extends ViewModel {
    private Context context;
    private DataDao userDao;
    private Database myDatabase;

    MutableLiveData<List<Data>> userList;

    public LiveData<List<Data>> getUserList() {
        if (userList == null) {
            userList = new MutableLiveData<>();
            myDatabase = Database.DATABASE;
            userDao = myDatabase.dataDao();
            new ShowTask().execute();
        }
        return userList;
    }

    class ShowTask extends AsyncTask<Void, Void, List<Data>> {
        @Override
        protected List<Data> doInBackground(Void... voids) {
            return userDao.getdata();
        }

        @Override
        protected void onPostExecute(List<Data> users) {
            super.onPostExecute(users);
            userList.setValue(users);
        }
    }

}