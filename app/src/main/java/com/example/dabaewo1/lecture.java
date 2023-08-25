package com.example.dabaewo1;

import com.google.firebase.firestore.PropertyName;

public class lecture {
    @PropertyName("everage_score")
    public int everageScore;
    public int k1, k10, k2, k3, k4, k5, k6, k7, k8, k9;
    @PropertyName("lecture_address")
    public String lectureAddress;
    @PropertyName("lecture_category")
    public String lectureCategory;
    @PropertyName("lecture_day")
    public String lectureDay;
    @PropertyName("lecture_enddate")
    public String lectureEndDate;
    @PropertyName("lecture_endtime")
    public String lectureEndTime;
    @PropertyName("lecture_fee")
    public int lectureFee;
    @PropertyName("lecture_inpeople")
    public int lectureInPeople;
    @PropertyName("lecture_location")
    public String lectureLocation;
    @PropertyName("lecture_name")
    public String lectureName;
    @PropertyName("lecture_peoplelimit")
    public int lecturePeopleLimit;
    @PropertyName("lecture_recommendcount")
    public int lectureRecommendCount;
    @PropertyName("lecture_reviewcount")
    public int lectureReviewCount;
    @PropertyName("lecture_startdate")
    public String lectureStartDate;
    @PropertyName("lecture_starttime")
    public String lectureStartTime;
    @PropertyName("lecture_submitenddate")
    public String lectureSubmitEndDate;
    @PropertyName("lecture_telephone")
    public String lectureTelephone;
    @PropertyName("teacher_name")
    public String teacherName;

    @PropertyName("picture_num")
    public int pictureNumber;

    public lecture() {
        // 기본 생성자
    }public lecture(String lectureName, String lectureLocation, String lectureCategory, int lectureReco) {
        // 기본 생성자
    }

    // Getter와 Setter 메서드를 정의합니다.
    public int getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(int pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public int getEverageScore() {
        return everageScore;
    }

    public void setEverageScore(int everageScore) {
        this.everageScore = everageScore;
    }

    public int getK1() {
        return k1;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public int getK10() {
        return k10;
    }

    public void setK10(int k10) {
        this.k10 = k10;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public int getK3() {
        return k3;
    }

    public void setK3(int k3) {
        this.k3 = k3;
    }

    public int getK4() {
        return k4;
    }

    public void setK4(int k4) {
        this.k4 = k4;
    }

    public int getK5() {
        return k5;
    }

    public void setK5(int k5) {
        this.k5 = k5;
    }

    public int getK6() {
        return k6;
    }

    public void setK6(int k6) {
        this.k6 = k6;
    }

    public int getK7() {
        return k7;
    }

    public void setK7(int k7) {
        this.k7 = k7;
    }

    public int getK8() {
        return k8;
    }

    public void setK8(int k8) {
        this.k8 = k8;
    }

    public int getK9() {
        return k9;
    }

    public void setK9(int k9) {
        this.k9 = k9;
    }

    public String getLectureAddress() {
        return lectureAddress;
    }

    public void setLectureAddress(String lectureAddress) {
        this.lectureAddress = lectureAddress;
    }

    public String getLectureCategory() {
        return lectureCategory;
    }

    public void setLectureCategory(String lectureCategory) {
        this.lectureCategory = lectureCategory;
    }

    public String getLectureDay() {
        return lectureDay;
    }

    public void setLectureDay(String lectureDay) {
        this.lectureDay = lectureDay;
    }

    public String getLectureEndDate() {
        return lectureEndDate;
    }

    public void setLectureEndDate(String lectureEndDate) {
        this.lectureEndDate = lectureEndDate;
    }

    public String getLectureEndTime() {
        return lectureEndTime;
    }

    public void setLectureEndTime(String lectureEndTime) {
        this.lectureEndTime = lectureEndTime;
    }

    public int getLectureFee() {
        return lectureFee;
    }

    public void setLectureFee(int lectureFee) {
        this.lectureFee = lectureFee;
    }

    public int getLectureInPeople() {
        return lectureInPeople;
    }

    public void setLectureInPeople(int lectureInPeople) {
        this.lectureInPeople = lectureInPeople;
    }

    public String getLectureLocation() {
        return lectureLocation;
    }

    public void setLectureLocation(String lectureLocation) {
        this.lectureLocation = lectureLocation;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public int getLecturePeopleLimit() {
        return lecturePeopleLimit;
    }

    public void setLecturePeopleLimit(int lecturePeopleLimit) {
        this.lecturePeopleLimit = lecturePeopleLimit;
    }

    public int getLectureRecommendCount() {
        return lectureRecommendCount;
    }

    public void setLectureRecommendCount(int lectureRecommendCount) {
        this.lectureRecommendCount = lectureRecommendCount;
    }

    public int getLectureReviewCount() {
        return lectureReviewCount;
    }

    public void setLectureReviewCount(int lectureReviewCount) {
        this.lectureReviewCount = lectureReviewCount;
    }

    public String getLectureStartDate() {
        return lectureStartDate;
    }

    public void setLectureStartDate(String lectureStartDate) {
        this.lectureStartDate = lectureStartDate;
    }

    public String getLectureStartTime() {
        return lectureStartTime;
    }

    public void setLectureStartTime(String lectureStartTime) {
        this.lectureStartTime = lectureStartTime;
    }

    public String getLectureSubmitEndDate() {
        return lectureSubmitEndDate;
    }

    public void setLectureSubmitEndDate(String lectureSubmitEndDate) {
        this.lectureSubmitEndDate = lectureSubmitEndDate;
    }

    public String getLectureTelephone() {
        return lectureTelephone;
    }

    public void setLectureTelephone(String lectureTelephone) {
        this.lectureTelephone = lectureTelephone;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
