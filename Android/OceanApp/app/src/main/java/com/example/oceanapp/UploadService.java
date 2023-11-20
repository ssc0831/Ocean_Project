package com.example.oceanapp;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadService {
    @Multipart
    @POST("upload") // 이미지 업로드를 처리할 서버 API 엔드포인트
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part image);

    @POST("saveData") // 데이터를 DB에 저장할 서버 API 엔드포인트
    Call<ResponseBody> saveData(@Part("width") RequestBody width,
                                @Part("weight") RequestBody weight,
                                @Part("content") RequestBody content);
}