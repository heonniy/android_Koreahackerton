package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dabaewo1.MyRecyclerAdapter;
import com.example.dabaewo1.R;
import com.example.dabaewo1.smallgroups;

import java.util.ArrayList;

public class MainMenuSmallgroupFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private MyRecyclerAdapter myRecyclerAdapter;

    private ArrayList<smallgroups> mGroupsList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main_menu_smallgroup, container, false);

        return rootView;
    }

}