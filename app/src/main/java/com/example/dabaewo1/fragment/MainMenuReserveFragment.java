package com.example.dabaewo1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dabaewo1.R;

public class MainMenuReserveFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main_menu_reserve, container, false);

        Button reserveNextButton = rootView.findViewById(R.id.reserve_next);
        reserveNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reserve_next 버튼이 클릭되었을 때의 동작을 여기에 작성
                // 예를 들어, 다음 Fragment로 전환하는 코드를 작성

                Fragment finishedLectureFragment = new finishied_lectureFragment(); // 새 Fragment 인스턴스 생성
                FragmentManager fragmentManager = getParentFragmentManager(); // 현재 Fragment의 FragmentManager 가져오기
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.menu_frame_layout, finishedLectureFragment); // fragment_container 영역에 새 Fragment로 교체
                fragmentTransaction.addToBackStack(null); // 뒤로 가기 버튼을 눌렀을 때 이전 Fragment로 돌아가기 위해 back stack에 추가
                fragmentTransaction.commit(); // Fragment 전환을 커밋하여 적용
            }
        });

        return rootView;
    }
}