package com.example.dabaewo1.fragment;

import android.widget.Toast;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.dabaewo1.R;
import androidx.fragment.app.Fragment;

import com.example.dabaewo1.R;

import org.w3c.dom.Text;


public class Lecture_detail extends Fragment {

    private TextView usernameTextView;
    private TextView lecture_day;
    private TextView start_day;
    private TextView end_day;
    private TextView where_1;
    private TextView howmuch;
    private TextView want_day;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lecture_detail, container, false);

        usernameTextView = rootView.findViewById(R.id.name_1);
        lecture_day = rootView.findViewById(R.id.real_term_2);
        want_day = rootView.findViewById(R.id.real_term_1);
        start_day = rootView.findViewById(R.id.real_term_3);
        end_day = rootView.findViewById(R.id.real_term_7);
        where_1 = rootView.findViewById(R.id.real_term_4);
        howmuch = rootView.findViewById(R.id.real_term_5);

        Bundle args = getArguments();
        if (args != null) {
            String lectureName = args.getString("lectureName");
            String lecturewant = args.getString("lectureWant");
            String lectureAddress = args.getString("lectureAddress");
            String lectureDay = args.getString("lectureDay");
            String lectureStartTime = args.getString("lectureStartTime");
            String lectureEndTime = args.getString("lectureEndTime");
            int lectureFee = args.getInt("lectureFee", 0);

            // 정보 설정
            usernameTextView.setText(lectureName);
            want_day.setText(lecturewant);
            lecture_day.setText(lectureDay);
            start_day.setText(lectureStartTime);
            end_day.setText(lectureEndTime);
            where_1.setText(lectureAddress);
            howmuch.setText(String.valueOf(lectureFee));
        }

        return rootView;
    }

}