package com.xyc.medusa.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyc.medusa.R;
import com.xyc.medusa.adapter.FirstFragmentAdapter;
import com.xyc.medusa.model.FirstFragmentModel;

import java.util.ArrayList;

public class FirstFragment extends Fragment{
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<String> listData;
    private FirstFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first,container,false);

        recyclerView = view.findViewById(R.id.first_fragment_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        listData = new ArrayList<>();
        for(int i=0;i<20;i++){
            listData.add("item"+i);
        }

        adapter = new FirstFragmentAdapter(R.layout.item_fragment_first,listData);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
