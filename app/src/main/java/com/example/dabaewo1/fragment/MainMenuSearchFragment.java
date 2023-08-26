package com.example.dabaewo1.fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dabaewo1.fragment.*;
import com.example.dabaewo1.MyRecyclerAdapter;
import com.example.dabaewo1.R;
import com.example.dabaewo1.lecture;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONObject;
import org.tensorflow.lite.Interpreter;

import java.io.*;
import java.nio.ByteBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainMenuSearchFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<lecture> mLectureList = new ArrayList<>();
    private FirebaseFirestore db; // Firestore 인스턴스

    private static final String KEY_SAVED_TEXT = "saved_text"; // 텍스트를 저장할 키 이름
    private static final String PREF_NAME = "my_preferences"; // SharedPreferences 파일의 이름

    private EditText searchContext;
    private int age;
    private int gender;
    private int interest;
    private int job;
    private int purpose;
    int result[] = new int[5];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_search, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyclerview);

        searchContext = rootView.findViewById(R.id.search_context);

        searchContext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null &&
                        event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    saveTextFromEditText();
                    return true;
                }
                return false;
            }
        });



        // LinearLayoutManager 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        // 어댑터 초기화 및 RecyclerView에 설정
        mRecyclerAdapter = new MyRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);

        // Firebase Firestore 인스턴스 초기화
        db = FirebaseFirestore.getInstance();

        // Firebase 데이터 가져오기
        fetchFirebaseData();

        // book_1 이미지 버튼 클릭 이벤트 처리
        rootView.findViewById(R.id.book_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchLanguageFragment = new Search_languageFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchLanguageFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        rootView.findViewById(R.id.reading_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchlearningFragment = new Search_learningFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchlearningFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        rootView.findViewById(R.id.smart_learn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchsmartlearnFragment = new Search_smartlearnFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchsmartlearnFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        rootView.findViewById(R.id.smart_learn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchsmartlearnFragment = new Search_smartlearnFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchsmartlearnFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        rootView.findViewById(R.id.sports_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchsportsFragment = new Search_sportsFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchsportsFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        rootView.findViewById(R.id.painting_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchpaintingFragment = new Search_paintingFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchpaintingFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });


        rootView.findViewById(R.id.music_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchpmusicFragment = new Search_musicFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchpmusicFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        rootView.findViewById(R.id.job_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchpjobFragment = new Search_jobFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchpjobFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });
        rootView.findViewById(R.id.cooking_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchpcookingFragment = new Search_cookingFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchpcookingFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        rootView.findViewById(R.id.chess_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search_languageFragment로 이동하는 코드 추가
                Fragment searchhobbyFragment = new Search_hobbyFragment(); // 이동할 프래그먼트 인스턴스 생성
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.menu_frame_layout, searchhobbyFragment); // 프래그먼트 교체
                transaction.addToBackStack(null); // Back 버튼으로 이전 프래그먼트로 돌아갈 수 있도록 스택에 추가
                transaction.commit();
            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String uid = user.getUid();
            db.collection("users")
                    .document(uid)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    age = document.getLong("age").intValue(); // age 필드가 Long 타입일 경우
                                    gender = 0; // 기본값으로 설정
                                    String genderStr = document.getString("gender");
                                    if (genderStr != null) {
                                        if (genderStr.equals("man") || genderStr.equals("남")) {
                                            gender = 0; // 남성
                                        } else {
                                            gender = 1; // 여성
                                        }
                                    }
                                    interest = document.getLong("interest").intValue();
                                    job = document.getLong("job").intValue();
                                    purpose = document.getLong("purpose").intValue();
                                }
                            }
                        }
                    });
        }
        Interpreter interpreter;
        try {
            ByteBuffer modelBuffer = loadModelFile(getActivity().getAssets(), "model.tflite");
            interpreter = new Interpreter(modelBuffer);

            // 추론 실행 예시
            float[] input = {age, gender, job, interest, purpose};// 입력 데이터 생성
            float[][] output = new float[1][5]; // 모델 출력의 형태에 따라 적절한 크기로 변경
            interpreter.run(input, output);

            double[] mean = {47.28023507578101, 47.29260748530776, 47.381688833900405, 47.340241261985774, 47.28116300649552};
            double[] std = {26.081805016428966, 25.98556811786256, 26.02537672934598, 25.9913455144149, 25.97402919661105};

            // 역정규화
            double[] denormalizedOutput = new double[5];
            for (int i = 0; i < 5; i++) {
                denormalizedOutput[i] = (output[0][i] * std[i]) + mean[i];
            }


            // 역정규화된 결과 사용
            StringBuilder arrayContents = new StringBuilder();
            for (int value : result) {
                arrayContents.append(value).append(", ");
            }

            Log.d("Tag", "Denormalized array contents: " + arrayContents.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;

    }

    private ByteBuffer loadModelFile(AssetManager assetManager, String modelPath) throws IOException {
        InputStream inputStream = assetManager.open(modelPath);
        int modelFileSize = inputStream.available();
        ByteBuffer modelBuffer = ByteBuffer.allocateDirect(modelFileSize);
        byte[] buffer = new byte[modelFileSize];
        inputStream.read(buffer);
        modelBuffer.put(buffer);
        inputStream.close();
        modelBuffer.rewind();
        return modelBuffer;
    }
    public static int[] roundDecimalArray(double[] inputArray) {
        int[] roundedArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            roundedArray[i] = (int) Math.round(inputArray[i]);
        }

        while (true) {
            boolean hasDuplicates = false;

            for (int i = 0; i < roundedArray.length; i++) {
                int count = 0;
                for (int j = 0; j < roundedArray.length; j++) {
                    if (roundedArray[j] == roundedArray[i]) {
                        count++;
                    }
                }

                if (count > 1) {
                    roundedArray[i] = roundedArray[i] + 1;
                    hasDuplicates = true;
                }
            }

            if (!hasDuplicates) {
                break;
            }
        }

        return roundedArray;
    }
    public String loadJsonFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }




    private void saveTextFromEditText() {
        String abc = searchContext.getText().toString();
        saveTextToSharedPreferences(abc);
    }

    private void saveTextToSharedPreferences(String text) {
        Context context = requireContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SAVED_TEXT, text);
        editor.apply();
        Log.d("SaveTextToSharedPreferences", "Saved text: " + text); // 텍스트를 Logcat에 출력
    }

    private void fetchFirebaseData() {
        db.collection("daegu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<lecture> lectures = new ArrayList<>();
                            for (DocumentSnapshot document : task.getResult()) {
                                // 파이어베이스 문서의 문서 번호를 가져옴
                                String documentId = document.getId();

                                // result 배열에 있는 문서 번호와 같으면 해당 문서를 추출하여 lectures에 추가
                                for (int i = 0; i < result.length; i++) {
                                    if (documentId.equals(String.valueOf(result[i]))) {
                                        lecture lecture1 = document.toObject(lecture.class);
                                        lectures.add(lecture1);
                                        break; // 이미 해당 문서가 추가되었으므로 다음 문서로 넘어감
                                    }
                                }
                            }

                            // 어댑터에 데이터 설정 및 갱신
                            mLectureList.addAll(lectures);
                            mRecyclerAdapter.setFriendList(mLectureList);
                            mRecyclerAdapter.notifyDataSetChanged(); // 어댑터에 데이터가 변경되었음을 알림
                        } else {
                            // Firestore 데이터 가져오기 실패
                            Log.d("MainMenuSearchFragment", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }















}