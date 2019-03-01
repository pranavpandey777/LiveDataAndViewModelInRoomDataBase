package com.example.labworkstfeb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ProjectViewHolder> {
    private Context context;
    private List<Data> itemList;

    public MyAdapter(Context context, List<Data> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Data item = itemList.get(position);
        String name=item.getName();
        String email=item.getEmail();
        String mobile=item.getMobile();
        String deg=item.getDeg();
       // Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
        holder.name.setText(name);
        holder.email.setText(email);
        holder.mobile.setText(mobile);
        holder.deg.setText(deg);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView name, email,mobile,deg;

        public ProjectViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            mobile = itemView.findViewById(R.id.mobile);
            deg = itemView.findViewById(R.id.deg);
        }
    }
}
