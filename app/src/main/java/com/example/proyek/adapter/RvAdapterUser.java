package com.example.proyek.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyek.R;
import com.example.proyek.settergetter.Sayur;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RvAdapterUser extends FirebaseRecyclerAdapter<Sayur, RvAdapterUser.myViewHolder> {

    public RvAdapterUser(@NonNull FirebaseRecyclerOptions<Sayur> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i, @NonNull Sayur sayur) {
        myViewHolder.tvName.setText(sayur.getName());
        myViewHolder.tvHarga.setText(sayur.getHarga());
        Glide.with(myViewHolder.img.getContext()).load(sayur.getUrl()).into(myViewHolder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designrvuser, parent, false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvName, tvHarga;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.photoSayur);
            tvName = itemView.findViewById(R.id.tvJudulSayur);
            tvHarga = itemView.findViewById(R.id.tvHargaSayur);
        }
    }
}
