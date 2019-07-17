package com.mycode.jpmc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mycode.jpmc.R;
import com.mycode.jpmc.entity.HighSchools;
import com.mycode.jpmc.entity.SATResults;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    private Context context;
    private OnItemClickListener listener;
    private List<HighSchools> highSchools;
    public RecyclerViewAdapter(Context context, List<HighSchools> highSchools){
        this.context = context;
        this.highSchools = highSchools;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rowlayout, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, int position) {
        HighSchools highSchool = highSchools.get(position);
        holder.name.setText(highSchool.getName());

    }

    @Override
    public int getItemCount() {
        return highSchools.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener != null){
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION){
                    listener.itemClick(position);
                }
            }
        }
    }
    public interface OnItemClickListener{
        void itemClick (int position); // regular clicks
    }

    //method is used to set activity as a listener for the interface
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener= listener;
    }
}
