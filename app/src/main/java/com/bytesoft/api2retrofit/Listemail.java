package com.bytesoft.api2retrofit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytesoft.api2retrofit.Model;
import com.bytesoft.api2retrofit.R;

import java.util.ArrayList;
import java.util.List;

class Listmail extends RecyclerView.Adapter<Listmail.ViewHolders> {

    List<Model.data> data = new ArrayList<>();

    public Listmail(List<Model.data> data) {
        this.data = data;
        Log.e("coverragearea", "adaptar");
    }


    @Override
    public Listmail.ViewHolders onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_sample_design, parent, false);

        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder( Listmail.ViewHolders holder, int i) {
        holder.email.setText(String.valueOf(data.get(i).getEmail()));


        //Log.e("datata", String.valueOf(coverarealist.get(i).getCoverageArea()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {

        TextView email;

        public ViewHolders( View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);



        }
    }
}
