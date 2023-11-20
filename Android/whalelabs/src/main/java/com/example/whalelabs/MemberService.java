package com.example.whalelabs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MemberService {
    // 리스트
    @GET("list")
    Call<List<Member>> findAll();

    // 가입
    @POST("join")
    Call<Member> save(@Body Member member);

    // 업데이트
    @PUT("update/{id}")
    Call<Void> update(@Path("id") Long id, @Body Member member);

    // 탈퇴
    @DELETE("delete/{id}")
    Call<Void> deleteById(@Path("id") Long id);

    // 로그인시 값 가져오기
    @GET("login")
    Call<Member> getMember(@Query("tel") String tel, @Query("password") String password);

}
