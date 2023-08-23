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

public class MainMenuMypageFragment extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private EditText usernameTextView;
    private EditText ageTextView;
    private EditText nicknameTextView;
    private EditText idTextView;
    private EditText phonenumberTextView;
    private EditText addressTextView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_mypage, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        usernameTextView = rootView.findViewById(R.id.username);
        ageTextView = rootView.findViewById(R.id.age);
        nicknameTextView = rootView.findViewById(R.id.nickname);
        idTextView = rootView.findViewById(R.id.id_1);
        phonenumberTextView = rootView.findViewById(R.id.phone_number_1);
        addressTextView = rootView.findViewById(R.id.address_1);

        // 현재 로그인된 유저의 UID를 가져옴
        String currentUserUid = mAuth.getCurrentUser().getUid();

        // Firestore에서 유저 이름 가져오기
        db.collection("users")
                .document(currentUserUid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                String username = document.getString("name"); // "name"은 해당 필드의 이름
                                usernameTextView.setText(username);
                                long ageL = document.getLong("age");
                                int age = (int) ageL;
                                ageTextView.setText(String.valueOf(age));
                                String nickname = document.getString("nickname");
                                nicknameTextView.setText(nickname);
                                String phone = document.getString("phoneNumber");
                                phonenumberTextView.setText(phone);
                                String address = document.getString("address");
                                addressTextView.setText(address);



                            }
                        }
                    }
                });
        addressTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String newAddress = addressTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("address", newAddress)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "주소 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "주소 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });

        phonenumberTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String phoneNumber =  phonenumberTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("phoneNumber", phoneNumber)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "전화번호 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "전화번호 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });



       idTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String id =  idTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("email", id)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "이메일,아이디 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "이메일,아이디 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });

        ageTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String age =  ageTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("age", age)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "나이 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "나이 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });

        usernameTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String username =  usernameTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("name", username)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "이름 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "이름 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });

        nicknameTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // 엔터 키를 눌렀을 때 파이어베이스 정보 수정
                    String nickname =  nicknameTextView.getText().toString();
                    db.collection("users")
                            .document(currentUserUid)
                            .update("nickname", nickname)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "별명 정보가 업데이트되었습니다.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(), "별명 정보 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                    return true;
                }
                return false;
            }
        });














        return rootView;
    }
}
