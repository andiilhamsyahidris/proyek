package com.example.proyek.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyek.AfterClickMenu;
import com.example.proyek.R;
import com.example.proyek.RvItem;
import com.example.proyek.RvItem2;
import com.example.proyek.adapter.ListAdapterItem;
import com.example.proyek.adapter.ListAdapterItem2;
import com.example.proyek.settergetter.RvItemSetGet;
import com.example.proyek.settergetter.RvItemSetGet2;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    View view;

    private SearchView searchView;
    private RecyclerView rvListMenu, rvListMenu2;
    private ArrayList<RvItemSetGet> list = new ArrayList<>();
    private ArrayList<RvItemSetGet2> list2 = new ArrayList<>();

    RecyclerView.LayoutManager recycleViewLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        rvListMenu = view.findViewById(R.id.rvItem);
        rvListMenu2 = view.findViewById(R.id.rvitem2);
        rvListMenu.setHasFixedSize(true);

        // Custom Hint Color in Searchview
        TextView searchHint = searchView.findViewById(R.id.svHome);
        searchHint.setHint("Hari ini kamu mau beli apa?");
        searchHint.setHintTextColor(Color.BLACK);

        showRecycleList();
        showRecycleList2();
        return view;
    }

    private void showRecycleList2() {
        list2.addAll(RvItem2.getListData());

        rvListMenu2.setLayoutManager(new LinearLayoutManager((getActivity())));
        recycleViewLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rvListMenu2.setLayoutManager(recycleViewLayoutManager);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvListMenu2.setLayoutManager(horizontalLayoutManager);
        ListAdapterItem2 listAdapterItem = new ListAdapterItem2(list2);
        rvListMenu2.setAdapter(listAdapterItem);

        listAdapterItem.setOnItemClickCallback(new ListAdapterItem2.OnItemClickCallback() {
            @Override
            public void onItemClicked(RvItemSetGet2 data) {
                Intent i = new Intent(getActivity(), AfterClickMenu.class);
                i.putExtra("rv_item", data);
                startActivity(i);
            }

        });
    }

    public void showRecycleList() {
        list.addAll(RvItem.getListData());
        rvListMenu.setLayoutManager(new LinearLayoutManager((getActivity())));
        recycleViewLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rvListMenu.setLayoutManager(recycleViewLayoutManager);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvListMenu.setLayoutManager(horizontalLayoutManager);
        ListAdapterItem listAdapterItem = new ListAdapterItem(list);
        rvListMenu.setAdapter(listAdapterItem);

        listAdapterItem.setOnItemClickCallback(new ListAdapterItem.OnItemClickCallback() {
            @Override
            public void onItemClicked(RvItemSetGet data) {
                Intent i = new Intent(getActivity(), AfterClickMenu.class);
                i.putExtra("rv_item", data);
//                i.putExtra("judul", data.getName());
                startActivity(i);
            }

        });
    }
}
