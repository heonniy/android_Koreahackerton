package com.example.dabaewo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyrecyclerAdapter_lec extends RecyclerView.Adapter<MyrecyclerAdapter_lec.ViewHolder> {

    private ArrayList<lecture> mFriendList = new ArrayList<>(); // 초기화 추가

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false); // 수정: item layout 설정
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

        int picture;

        int newarr[] = new int[10];





        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lecture_image = itemView.findViewById(R.id.lecture_image);
            name = itemView.findViewById(R.id.lecture_name);
            location = itemView.findViewById(R.id.lecture_location);
            recommend = itemView.findViewById(R.id.lecture_recommend_text); // 수정
            keyword1 = itemView.findViewById(R.id.keyword_top1);
            keyword2 = itemView.findViewById(R.id.keyword_top2);
            keyword3 = itemView.findViewById(R.id.keyword_top3);

        }
        void onBind(lecture item){


           int picture = item.getPictureNumber();
           String category = item.getLectureCategory();
            if (category != null) {
                if (category.equals("어학 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }

                } else if (category.equals("인문학 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("스마트 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("스포츠교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("미술 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("음악 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("직업 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
                } else if (category.equals("요리 교실")) {
                    switch(picture){
                        case 1:
                            lecture_image.setImageResource(R.drawable.lan_1);
                            break;
                        case 2:
                            lecture_image.setImageResource(R.drawable.lan_2);
                            break;
                        case 3:
                            lecture_image.setImageResource(R.drawable.lan_3);
                            break;
                        case 4:
                            lecture_image.setImageResource(R.drawable.lan_4);
                            break;
                        case 5:
                            lecture_image.setImageResource(R.drawable.lan_5);
                            break;

                    }
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