package com.example.dabaewo1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;


import com.example.dabaewo1.fragment.Lecture_detail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ArrayList<lecture> mFriendList = new ArrayList<>(); // 초기화 추가

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false); // 수정: item layout 설정
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(mFriendList.get(position));
    }

    public void setFriendList(ArrayList<lecture> list){
        this.mFriendList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView lecture_image;
        TextView name;
        TextView location;
        TextView recommend;

       TextView keyword1;
        TextView keyword2;
        TextView keyword3;

        int picuture;

        int newarr[] = new int[10];





        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lecture_image = itemView.findViewById(R.id.lecture_image);
            name = itemView.findViewById(R.id.lecture_name);
            location = itemView.findViewById(R.id.lecture_location);
            recommend = itemView.findViewById(R.id.lecture_recommend_text);
            keyword1 = itemView.findViewById(R.id.keyword_top1);
            keyword2 = itemView.findViewById(R.id.keyword_top2);
            keyword3 = itemView.findViewById(R.id.keyword_top3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        lecture clickedLecture = mFriendList.get(position);

                        Bundle bundle = new Bundle();
                        bundle.putString("lectureName", clickedLecture.getLectureName());
                        bundle.putString("lectureWant", clickedLecture.getLectureSubmitEndDate());
                        bundle.putString("lectureAddress", clickedLecture.getLectureAddress());
                        bundle.putString("lectureDay", clickedLecture.getLectureDay());
                        bundle.putString("lectureStartTime", clickedLecture.getLectureStartTime());
                        bundle.putString("lectureEndTime", clickedLecture.getLectureEndTime());
                        bundle.putInt("lectureFee", clickedLecture.getLectureFee());
                        bundle.putString("lectureCa", clickedLecture.getLectureCategory());

                        FragmentManager fragmentManager = ((AppCompatActivity) itemView.getContext()).getSupportFragmentManager();
                        Lecture_detail lectureDetailFragment = new Lecture_detail();
                        lectureDetailFragment.setArguments(bundle);

                        fragmentManager.beginTransaction()
                                .replace(R.id.menu_frame_layout, lectureDetailFragment) // R.id.fragment_container는 강좌 상세 프래그먼트를 표시할 프래그먼트 컨테이너 뷰의 ID입니다.
                                .addToBackStack(null)
                                .commit();
                    }
                }
            });
        }


        void onBind(lecture item){

            String category = item.getLectureCategory();
            if (category != null) {
                if (category.equals("어학 교실")) {
                    lecture_image.setImageResource(R.drawable.lan_list);
                } else if (category.equals("인문학 교실")) {
                    lecture_image.setImageResource(R.drawable.lec_list);
                } else if (category.equals("스마트 교실")) {
                    lecture_image.setImageResource(R.drawable.smart_list);
                } else if (category.equals("스포츠교실")) {
                    lecture_image.setImageResource(R.drawable.sport_list);
                } else if (category.equals("미술 교실")) {
                    lecture_image.setImageResource(R.drawable.picture_list);
                } else if (category.equals("음악 교실")) {
                    lecture_image.setImageResource(R.drawable.music_list);
                } else if (category.equals("직업 교실")) {
                    lecture_image.setImageResource(R.drawable.job_list);
                } else if (category.equals("요리 교실")) {
                    lecture_image.setImageResource(R.drawable.cook_list);
                } else if (category.equals("취미 교실")) {
                    lecture_image.setImageResource(R.drawable.hobb_list);
                }
            }
            name.setText(item.getLectureName());
            location.setText(item.getLectureLocation());
            recommend.setText(String.valueOf(item.getLectureRecommendCount()));
            newarr[0] = item.getK1();
            newarr[1] = item.getK2();
            newarr[2] = item.getK3();
            newarr[3] = item.getK4();
            newarr[4] = item.getK5();
            newarr[5] = item.getK6();
            newarr[6] = item.getK7();
            newarr[7] = item.getK8();
            newarr[8] = item.getK9();
            newarr[9] = item.getK10();

            Integer[] indices = new Integer[newarr.length];
            for (int i = 0; i < newarr.length; i++) {
                indices[i] = i;
            }

            Arrays.sort(indices, new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return Integer.compare(newarr[i2], newarr[i1]);
                }
            });

            switch (indices[0]) {
                case 0:
                    keyword1.setText(itemView.getResources().getString(R.string.num1));
                    break;
                case 1:
                    keyword1.setText(itemView.getResources().getString(R.string.num2));
                    break;
                case 2:
                    keyword1.setText(itemView.getResources().getString(R.string.num3));
                    break;
                case 3:
                    keyword1.setText(itemView.getResources().getString(R.string.num4));
                    break;
                case 4:
                    keyword1.setText(itemView.getResources().getString(R.string.num5));
                    break;
                case 5:
                    keyword1.setText(itemView.getResources().getString(R.string.num6));
                    break;
                case 6:
                    keyword1.setText(itemView.getResources().getString(R.string.num7));
                    break;
                case 7:
                    keyword1.setText(itemView.getResources().getString(R.string.num8));
                    break;
                case 8:
                    keyword1.setText(itemView.getResources().getString(R.string.num9));
                    break;
                case 9:
                    keyword1.setText(itemView.getResources().getString(R.string.num10));
                    break;
            }

            switch (indices[1]) {
                case 0:
                    keyword2.setText(itemView.getResources().getString(R.string.num1));
                    break;
                case 1:
                    keyword2.setText(itemView.getResources().getString(R.string.num2));
                    break;
                case 2:
                    keyword2.setText(itemView.getResources().getString(R.string.num3));
                    break;
                case 3:
                    keyword2.setText(itemView.getResources().getString(R.string.num4));
                    break;
                case 4:
                    keyword2.setText(itemView.getResources().getString(R.string.num5));
                    break;
                case 5:
                    keyword2.setText(itemView.getResources().getString(R.string.num6));
                    break;
                case 6:
                    keyword2.setText(itemView.getResources().getString(R.string.num7));
                    break;
                case 7:
                    keyword2.setText(itemView.getResources().getString(R.string.num8));
                    break;
                case 8:
                    keyword2.setText(itemView.getResources().getString(R.string.num9));
                    break;
                case 9:
                    keyword2.setText(itemView.getResources().getString(R.string.num10));
                    break;
            }

            switch (indices[2]) {
                case 0:
                    keyword3.setText(itemView.getResources().getString(R.string.num1));
                    break;
                case 1:
                    keyword3.setText(itemView.getResources().getString(R.string.num2));
                    break;
                case 2:
                    keyword3.setText(itemView.getResources().getString(R.string.num3));
                    break;
                case 3:
                    keyword3.setText(itemView.getResources().getString(R.string.num4));
                    break;
                case 4:
                    keyword3.setText(itemView.getResources().getString(R.string.num5));
                    break;
                case 5:
                    keyword3.setText(itemView.getResources().getString(R.string.num6));
                    break;
                case 6:
                    keyword3.setText(itemView.getResources().getString(R.string.num7));
                    break;
                case 7:
                    keyword3.setText(itemView.getResources().getString(R.string.num8));
                    break;
                case 8:
                    keyword3.setText(itemView.getResources().getString(R.string.num9));
                    break;
                case 9:
                    keyword3.setText(itemView.getResources().getString(R.string.num10));
                    break;
            }


        }
    }
}