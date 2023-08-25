package com.example.dabaewo1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lecture_image = itemView.findViewById(R.id.lecture_image);
            name = itemView.findViewById(R.id.lecture_name);
            location = itemView.findViewById(R.id.lecture_location);
            recommend = itemView.findViewById(R.id.lecture_recommend_text); // 수정
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

        }
    }
}