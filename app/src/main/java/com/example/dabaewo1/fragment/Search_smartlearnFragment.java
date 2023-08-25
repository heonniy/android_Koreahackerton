package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dabaewo1.MyrecyclerAdapter_lec;
import com.example.dabaewo1.R;
import com.example.dabaewo1.lecture;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Search_smartlearnFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MyrecyclerAdapter_lec mRecyclerAdapter; // MyrecyclerAdapter_lec 어댑터 사용
    private ArrayList<lecture> mLectureList = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search_language, container, false);
        mRecyclerView = rootView.findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        // 어댑터 초기화 및 RecyclerView에 설정
        mRecyclerAdapter = new MyrecyclerAdapter_lec(); // MyrecyclerAdapter_lec 어댑터로 초기화
        mRecyclerView.setAdapter(mRecyclerAdapter);

        // Firebase Firestore 인스턴스 초기화
        db = FirebaseFirestore.getInstance();

        // Firebase 데이터 가져오기
        fetchFirebaseData();
        return rootView;
    }

    private void fetchFirebaseData() {
        db.collection("daegu")
                .whereEqualTo("lecture_category", "스마트 교실") // 카테고리가 "어학 교실"인 항목만 가져오도록 필터링
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<lecture> lectures = new ArrayList<>();
                            for (DocumentSnapshot document : task.getResult()) {
                                lecture lecture1 = document.toObject(lecture.class);
                                lectures.add(lecture1);
                            }

                            // 어댑터에 데이터 설정 및 갱신
                            mLectureList.addAll(lectures);
                            mRecyclerAdapter.setFriendList(mLectureList);
                            mRecyclerAdapter.notifyDataSetChanged(); // 어댑터에 데이터가 변경되었음을 알림
                        } else {
                            // Firestore 데이터 가져오기 실패
                            Log.d("Search_languageFragment", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
