package com.example.proyek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class AfterClickMenu extends AppCompatActivity {

    private TextView tvJudul;
    private RecyclerView rvSayur;
    private ArrayList<VegetablesSetGet> list = new ArrayList<>();
    private ArrayList<SeasoningSetGet> list2 = new ArrayList<>();
    String Judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_menu);

        tvJudul = findViewById(R.id.tvName);

        rvSayur = findViewById(R.id.rvSayur);
        RvItemSetGet rvItemSetGet = getIntent().getParcelableExtra("rv_item");

        Judul = rvItemSetGet.getName();
        tvJudul.setText(Judul);
//        tvHarga.setText(rvItemSetGet.get);
        showRecyclerView();

//        String name = getIntent().getStringExtra("judul");
//        tvJudul.setText(name);


    }

    private void showRecyclerView() {
        rvSayur.setLayoutManager(new LinearLayoutManager(AfterClickMenu.this));
        if (Judul.equals("Sayur")){
            list.addAll(VegetableData.getListData());
            ListAdapterVegetable listAdapterVegetable = new ListAdapterVegetable(list);
            rvSayur.setAdapter(listAdapterVegetable);
            listAdapterVegetable.setOnItemClickCallback(new ListAdapterVegetable.OnItemClickCallback() {
                @Override
                public void onItemClicked(VegetablesSetGet data) {
                    Intent i = new Intent(AfterClickMenu.this, Detail.class);
                    startActivity(i);
                }
            });
        }else {
            list2.addAll(SeasoningData.getListData());
            ListAdapterSeasoning listAdapterSeasoning = new ListAdapterSeasoning(list2);
            rvSayur.setAdapter(listAdapterSeasoning);

            listAdapterSeasoning.setOnItemClickCallback(new ListAdapterSeasoning.OnItemClickCallback() {
                @Override
                public void onItemClicked(SeasoningSetGet data) {
                    Intent a = new Intent(AfterClickMenu.this, Detail.class);
                    startActivity(a);
                }
            });
        }


    }
}