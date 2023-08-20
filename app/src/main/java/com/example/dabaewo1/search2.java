package com.example.dabaewo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dabaewo1.fragment.MainMenuActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class search2 extends AppCompatActivity {

    //로그 남길 때 태그
    private static final String TAG = "serach2Activity";
    //파이어베이스 인증 권한 선언인듯
    private FirebaseAuth mAuth;
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    TextView textShowItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        // 권한 가져오기
        mAuth = FirebaseAuth.getInstance();
        //loginButton의 clicklistener 설정
        findViewById(R.id.loginButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        //clicklistener 선언

        @Override
        public void onClick(View view) {
            //누른 아이템의 id 가져오기
            int id = view.getId();
            if(id == R.id.loginButton){ // loginButton을 누른 경우
                login();
            }
        }
    };
    //home화면으로 이동하는 함수
    private void startLoginActicity(){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
//    //회원가입으로 이동하는 함수
//    private void startRegisterActicity(){
//        Intent intent = new Intent(this, com.example.dabaewo1.login2.class);
//        startActivity(intent);
//    }

    public void onTextView7Clicked(View view) {
        // 다른 화면으로 이동하는 코드 작성
        Intent intent = new Intent(this, com.example.dabaewo1.login2.class);
        startActivity(intent);
    }
    private void login(){
        String email = ((TextInputLayout)findViewById(R.id.textField)).getEditText().getText().toString();
        String password = ((TextInputLayout)findViewById(R.id.textField2)).getEditText().getText().toString();


        if(email.length() > 0 && password.length() > 0){ // 이메일 비번 안적었을 때
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인 성공");
                                startLoginActicity();
                            } else {
                                if (task.getException() != null) {
                                    // 실패한 예외를 로그로 출력합니다.
                                    Log.e("LoginActivity", "로그인 실패: " + task.getException().getMessage());
                                    startToast("이메일이나 패스워드가 틀렸습니다.");
                                }
                            }
                        }
                    });
        }
        else{
            startToast("이메일과 패스워드를 입력하세요.");
        }
    }

    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
