package com.example.labworkstfeb;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,email,mobile,deg;
Button save,show;
    Data data;
    DataDao dataDao;
    Database database;
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      name=findViewById(R.id.name);
      email=findViewById(R.id.email);
      mobile=findViewById(R.id.mobile);
      deg=findViewById(R.id.deg);

      save=findViewById(R.id.save);
      show=findViewById(R.id.show);
        database = Database.getUserDatabaseInstance(this);
        dataDao = database.dataDao();

      save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String iname = name.getText().toString();
              String iemail = email.getText().toString();
              String imob = mobile.getText().toString();
              String ideg = deg.getText().toString();

              new Insertion().execute(iname, iemail, imob,ideg);

          }
      });
      show.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent=new Intent(MainActivity.this,Second.class);
              startActivity(intent);

          }
      });



    }
    class Insertion extends AsyncTask<String, Void, Void> {


        @Override
        protected Void doInBackground(String... strings) {
            String iname = strings[0];
            String iemail = strings[1];
            String imob = strings[2];
            String ideg = strings[3];

            data = new Data(iname, iemail, imob,ideg);
            id = dataDao.insert(data);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (id == -1) {

                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                    } else {

                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return null;
        }
    }
}
