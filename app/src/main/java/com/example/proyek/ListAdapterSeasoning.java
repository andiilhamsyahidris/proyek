package com.example.proyek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapterSeasoning extends RecyclerView.Adapter<ListAdapterSeasoning.ListViewHolder> {
    private ArrayList<SeasoningSetGet> listBumbu;

    public ListAdapterSeasoning(ArrayList<SeasoningSetGet> list) {
        this.listBumbu = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void  setOnItemClickCallback (OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_list, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        SeasoningSetGet seasoningSetGet = listBumbu.get(position);
        holder.imgPhoto.setImageResource(seasoningSetGet.getPhoto());
        holder.tvName.setText(seasoningSetGet.getName());
        holder.tvHarga.setText(String.valueOf(seasoningSetGet.getHarga()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listBumbu.get(holder.getBindingAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return listBumbu.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvHarga;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.photoSayur);
            tvName = itemView.findViewById(R.id.tvJudulSayur);
            tvHarga = itemView.findViewById(R.id.tvHargaSayur);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(SeasoningSetGet data);
    }
}
