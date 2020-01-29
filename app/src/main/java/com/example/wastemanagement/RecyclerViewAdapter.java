package com.example.wastemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> ind_name = new ArrayList<>();
    private ArrayList<Integer> ind_logo = new ArrayList<>();
    private ArrayList<String> need_list = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> ind_name, ArrayList<String> need_list , ArrayList<Integer> ind_logo, Context context ){
        this.ind_logo = ind_logo;
        this.ind_name = ind_name;
        this.need_list = need_list;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {

            holder.name.setText(ind_name.get(position));
            holder.logo.setImageResource(ind_logo.get(position));
            holder.sub_line.setText(need_list.get(position));
            holder.check_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,ind_name.get(position),Toast.LENGTH_LONG).show();
                }
            });



    }

    @Override
    public int getItemCount() {
        return ind_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView sub_line;
        ImageView logo;
        Button check_button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.industry_name);
            sub_line=itemView.findViewById(R.id.need_list);
            logo = itemView.findViewById(R.id.logo_image);
            check_button = itemView.findViewById(R.id.check_button);

        }



    }
}
