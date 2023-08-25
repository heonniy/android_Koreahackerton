package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.dabaewo1.R;

public class Search_languageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_search_language, container, false);



        rootView.findViewById(R.id.book_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment LectureFragment = new Lecture_detail(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, LectureFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        return rootView;
    }
}