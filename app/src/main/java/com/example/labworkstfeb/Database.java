package com.example.labworkstfeb;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {Data.class}, version = 50)
public abstract class Database extends RoomDatabase {
    public static final String DatabaseName = "MyDatabase2";
    public static Database DATABASE;

    abstract DataDao dataDao();

    public static Database getUserDatabaseInstance(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class,
                    DatabaseName).build();
        }
        return DATABASE;
    }

}
