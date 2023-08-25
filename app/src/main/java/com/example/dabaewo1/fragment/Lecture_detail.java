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

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private TextView usernameTextView;
    private TextView lecture_day;
    private TextView start_day;
    private TextView end_day;
    private TextView where_1;
    private TextView howmuch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_lecture_detail, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        usernameTextView = rootView.findViewById(R.id.real_term_1);
        lecture_day = rootView.findViewById(R.id.real_term_2);
        start_day = rootView.findViewById(R.id.real_term_3);
        end_day = rootView.findViewById(R.id.real_term_7);
        where_1 = rootView.findViewById(R.id.real_term_4);
        howmuch = rootView.findViewById(R.id.real_term_5);


        int a=101;


        if(a>=100)
        {
            db.collection("ulsan")
                    .document(String.valueOf(a))
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    String username = document.getString("lecture_submitenddate"); // "name"은 해당 필드의 이름
                                    usernameTextView.setText(username);
                                    String nickname = document.getString("lecture_day");
                                    lecture_day.setText(nickname);
                                    String phone = document.getString("lecture_starttime");
                                    start_day.setText(phone);
                                    String phone1 = document.getString("lecture_endtime");
                                    end_day.setText(phone1);
                                    String address = document.getString("lecture_address");
                                    where_1.setText(address);
                                    long feeL = document.getLong("lecture_fee");
                                    int fee = (int) feeL;
                                    howmuch.setText(String.valueOf(fee));




                                }
                            }
                        }
                    });
        }
        else {
            db.collection("daegu")
                    .document(String.valueOf(a))
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    String username = document.getString("lecture_submitenddate"); // "name"은 해당 필드의 이름
                                    usernameTextView.setText(username);
                                    String nickname = document.getString("lecture_day");
                                    lecture_day.setText(nickname);
                                    String phone = document.getString("lecture_starttime");
                                    start_day.setText(phone);
                                    String phone1 = document.getString("lecture_endtime");
                                    end_day.setText(phone1);
                                    String address = document.getString("lecture_address");
                                    where_1.setText(address);
                                    long feeL = document.getLong("lecture_fee");
                                    int fee = (int) feeL;
                                    howmuch.setText(String.valueOf(fee));





                                }
                            }
                        }
                    });
        }



        return rootView;




    }
}