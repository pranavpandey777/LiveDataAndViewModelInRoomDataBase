package com.example.labworkstfeb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Data {
    @PrimaryKey(autoGenerate = true)
    private int id;
@ColumnInfo(name="name")
    String name;
    @ColumnInfo(name="email")
    String email;
    @ColumnInfo(name="mobile")
    String mobile;
    @ColumnInfo(name="deg")
    String deg;

    public Data( String name, String email, String mobile, String deg) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.deg = deg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDeg() {
        return deg;
    }

    public void setId(int id) {
        this.id = id;
    }
}
