package com.example.dabaewo1.fragment;

import android.widget.ImageView;
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
    private ImageView Ca;



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
        Ca=rootView.findViewById(R.id.lecture_imagen);


        Bundle args = getArguments();
        if (args != null) {
            String lectureName = args.getString("lectureName");
            String lecturewant = args.getString("lectureWant");
            String lectureAddress = args.getString("lectureAddress");
            String lectureDay = args.getString("lectureDay");
            String lectureStartTime = args.getString("lectureStartTime");
            String lectureEndTime = args.getString("lectureEndTime");
            int lectureFee = args.getInt("lectureFee", 0);
            String lectureCa=args.getString("lectureCa");

            if ("취미 교실".equals(lectureCa)) {
                Ca.setImageResource(R.drawable.hobby_1);
            } else if ("요리 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.cooking_1);
            }
            else if("직업 교실".equals(lectureCa))
            {
                Ca.setImageResource(R.drawable.job_1);
            }
            else if ("어학 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.lan_1);
            }
            else if ("음악 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.music_1);
            }
            else if ("미술 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.picture_1);
            }
            else if ("인문학 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.book_1);
            }
            else if ("스마트 교실".equals(lectureCa)){
                Ca.setImageResource(R.drawable.smart_1);
            }
            else{
                Ca.setImageResource(R.drawable.sports_1);
            }



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