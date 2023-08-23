package com.example.dabaewo1.fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.dabaewo1.R;
import com.example.dabaewo1.fragment.*;
import com.example.dabaewo1.lecture;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainMenuHomeFragment extends Fragment {

    private FragmentManager fragmentManager;
    private FirebaseFirestore db;
    private WebView webView;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private String dataToSend;

//    private TextView name1;
    private TextView recom1View;
    private TextView recom1Viewtop;
    private TextView reason1View;
    private TextView recom2View;
    private TextView recom2Viewtop;
    private TextView reason2View;
    private TextView recom3View;
    private TextView recom3Viewtop;
    private TextView reason3View;

    private TextView imogi1;
    private TextView imogi2;
    private TextView imogi3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Firestore 인스턴스 초기화
        db = FirebaseFirestore.getInstance();

        // Firestore 데이터 가져오기 메서드 호출
        fetchDataFromFirestore();
    }

    private void fetchDataFromFirestore() {
        db.collection("daegu")
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
                            for (lecture lecture : lectures) {
                                Log.d("Lecture", "Lecture: " + lecture.getLectureName());
                            }

                            // 가져온 데이터를 활용하여 원하는 처리를 수행할 수 있습니다.
                        } else {
                            // Firestore 데이터 가져오기 실패
                        }
                    }
                });
    }

    private ImageView topImage1;
    private ImageView topImage2;
    private ImageView topImage3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_home, container, false);

        fragmentManager = requireActivity().getSupportFragmentManager();
        topImage1 = rootView.findViewById(R.id.top_image1);
        topImage2 = rootView.findViewById(R.id.top_image2);
        topImage3 = rootView.findViewById(R.id.top_image3);

     /*   rootView.findViewById(R.id.btn_gpt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.menu_frame_layout, new MainMenuGptFragment()).commit();
            }
        });

*/
//        mAuth = FirebaseAuth.getInstance();
//        db = FirebaseFirestore.getInstance();
//        name1 = rootView.findViewById(R.id.name1);
//        String currentUserUid = mAuth.getCurrentUser().getUid();
//
//        db.collection("users")
//                .document(currentUserUid)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if (task.isSuccessful()) {
//                            DocumentSnapshot document = task.getResult();
//                            if (document.exists()) {
//                                String username = document.getString("name"); // "name"은 해당 필드의 이름
//                                name1.setText(username);
//
//                            }
//                        }
//                    }
//                });


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dataToSend = user.getUid(); // user uid 가져오기

        recom1Viewtop = rootView.findViewById(R.id.result_text_top1);
        recom1View = rootView.findViewById(R.id.result_text_inbox_top1);
        reason1View = rootView.findViewById(R.id.result_text_inbox_top1_explain);
        recom2Viewtop = rootView.findViewById(R.id.result_text_top2);
        recom2View = rootView.findViewById(R.id.result_text_inbox_top2);
        reason2View = rootView.findViewById(R.id.result_text_inbox_top2_explain);
        recom3Viewtop = rootView.findViewById(R.id.result_text_top3);
        recom3View = rootView.findViewById(R.id.result_text_inbox_top3);
        reason3View = rootView.findViewById(R.id.result_text_inbox_top3_explain);

        imogi1 = rootView.findViewById(R.id.top_imogi1);
        imogi2 = rootView.findViewById(R.id.top_imogi2);
        imogi3 = rootView.findViewById(R.id.top_imogi3);

        webView = rootView.findViewById(R.id.HomewebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        // 웹 페이지 로드
        webView.loadUrl("https://hackerton-f6788.web.app/chatGPT");
        webView.setVisibility(webView.GONE);

        // 웹 뷰와 네이티브 앱 간 데이터 통신을 위한 인터페이스 설정
        webView.addJavascriptInterface(new AppInterface(), "dabae");
        return rootView;
    }

    public class AppInterface {
        @JavascriptInterface
        public String DataToWeb() {
            // 네이티브 앱에서 생성한 데이터
            return dataToSend;
        }

        @JavascriptInterface
        public void dataToApp(String data) {
            updateGPT(data);
        }

    }

    private void updateGPT(String data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String[] segments = data.split("\n");




                recom1Viewtop.setText(segments[0].split(":")[0].replaceAll("[0-9. -]", ""));
                recom1View.setText(segments[0].split(":")[0].replaceAll("[0-9. -]", ""));
                reason1View.setText(segments[0].split(":")[1].trim());

                recom2Viewtop.setText(segments[1].split(":")[0].replaceAll("[0-9. -]", ""));
                recom2View.setText(segments[1].split(":")[0].replaceAll("[0-9. -]", ""));
                reason2View.setText(segments[1].split(":")[1].trim());

                recom3Viewtop.setText(segments[2].split(":")[0].replaceAll("[0-9. -]", ""));
                recom3View.setText(segments[2].split(":")[0].replaceAll("[0-9. -]", ""));
                reason3View.setText(segments[2].split(":")[1].trim());

                if (recom1Viewtop.getText().toString().equals("어학교실")) {
                    topImage1.setImageResource(R.drawable.top_langu);
                    imogi1.setText("✏️");
                } else if (recom1Viewtop.getText().toString().equals("인문학교실")) {
                    topImage1.setImageResource(R.drawable.top_lec);
                    imogi1.setText("📖");
                } else if (recom1Viewtop.getText().toString().equals("스마트교실")) {
                    topImage1.setImageResource(R.drawable.top_smart);
                    imogi1.setText("🖥️");
                } else if (recom1Viewtop.getText().toString().equals("스포츠교실")) {
                    topImage1.setImageResource(R.drawable.top_sport);
                    imogi1.setText("🥍");
                } else if (recom1Viewtop.getText().toString().equals("미술교실")) {
                    topImage1.setImageResource(R.drawable.tope_paint);
                    imogi1.setText("🖌️");
                } else if (recom1Viewtop.getText().toString().equals("음악교실")) {
                    topImage1.setImageResource(R.drawable.top_music);
                    imogi1.setText("🎹");

                } else if (recom1Viewtop.getText().toString().equals("직업교실")) {
                    topImage1.setImageResource(R.drawable.top_job);
                    imogi1.setText("👮🏻");
                } else if (recom1Viewtop.getText().toString().equals("요리교실")) {
                    topImage1.setImageResource(R.drawable.top_cook);
                    imogi1.setText("🍳");
                } else if (recom1Viewtop.getText().toString().equals("취미교실")) {
                    topImage1.setImageResource(R.drawable.top_hobb);
                    imogi1.setText("🎮");
                }

                if (recom2Viewtop.getText().toString().equals("어학교실")) {
                    topImage2.setImageResource(R.drawable.top_langu);
                    imogi2.setText("✏️");
                } else if (recom2Viewtop.getText().toString().equals("인문학교실")) {
                    topImage2.setImageResource(R.drawable.top_lec);
                    imogi2.setText("📖");
                } else if (recom2Viewtop.getText().toString().equals("스마트교실")) {
                    topImage2.setImageResource(R.drawable.top_smart);
                    imogi2.setText("🖥️");
                } else if (recom2Viewtop.getText().toString().equals("스포츠교실")) {
                    topImage2.setImageResource(R.drawable.top_sport);
                    imogi2.setText("🥍");
                } else if (recom2Viewtop.getText().toString().equals("미술교실")) {
                    topImage2.setImageResource(R.drawable.tope_paint);
                    imogi2.setText("🖌️");
                } else if (recom2Viewtop.getText().toString().equals("음악교실")) {
                    topImage2.setImageResource(R.drawable.top_music);
                    imogi2.setText("🎹");
                } else if (recom2Viewtop.getText().toString().equals("직업교실")) {
                    topImage2.setImageResource(R.drawable.top_job);
                    imogi2.setText("👮🏻");
                } else if (recom2Viewtop.getText().toString().equals("요리교실")) {
                    topImage2.setImageResource(R.drawable.top_cook);
                    imogi2.setText("🍳");
                } else if (recom2Viewtop.getText().toString().equals("취미교실")) {
                    topImage2.setImageResource(R.drawable.top_hobb);
                    imogi2.setText("🎮");
                }


                if (recom3Viewtop.getText().toString().equals("어학교실")) {
                    topImage3.setImageResource(R.drawable.top_langu);
                    imogi3.setText("✏️");
                } else if (recom3Viewtop.getText().toString().equals("인문학교실")) {
                    topImage3.setImageResource(R.drawable.top_lec);
                    imogi3.setText("📖");
                } else if (recom3Viewtop.getText().toString().equals("스마트교실")) {
                    topImage3.setImageResource(R.drawable.top_smart);
                    imogi3.setText("🖥️");
                } else if (recom3Viewtop.getText().toString().equals("스포츠교실")) {
                    topImage3.setImageResource(R.drawable.top_sport);
                    imogi3.setText("🥍");
                } else if (recom3Viewtop.getText().toString().equals("미술교실")) {
                    topImage3.setImageResource(R.drawable.tope_paint);
                    imogi3.setText("🖌️");
                } else if (recom3Viewtop.getText().toString().equals("음악교실")) {
                    topImage3.setImageResource(R.drawable.top_music);
                    imogi3.setText("🎹");
                } else if (recom3Viewtop.getText().toString().equals("직업교실")) {
                    topImage3.setImageResource(R.drawable.top_job);
                    imogi3.setText("👮🏻");
                } else if (recom3Viewtop.getText().toString().equals("요리교실")) {
                    topImage3.setImageResource(R.drawable.top_cook);
                    imogi3.setText("🍳");
                } else if (recom3Viewtop.getText().toString().equals("취미교실")) {
                    topImage3.setImageResource(R.drawable.top_hobb);
                    imogi3.setText("🎮");
                }
            }
        });
    }
}
