package com.example.proyek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapterVegetable extends RecyclerView.Adapter<ListAdapterVegetable.ListViewHolder> {
    private ArrayList<VegetablesSetGet> listSayur;

    public ListAdapterVegetable(ArrayList<VegetablesSetGet> list){
        this.listSayur = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
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
        VegetablesSetGet vegetablesSetGet = listSayur.get(position);
//        holder.tvHarga.setText(vegetablesSetGet.getHarga());
        holder.tvHarga.setText(String.valueOf(vegetablesSetGet.getHarga()));
        holder.tvName.setText(vegetablesSetGet.getName());
        holder.imgPhoto.setImageResource(vegetablesSetGet.getPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listSayur.get(holder.getBindingAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSayur.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
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
        void onItemClicked(VegetablesSetGet data);
    }
}
