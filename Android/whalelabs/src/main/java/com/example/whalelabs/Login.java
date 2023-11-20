package com.example.whalelabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText enterTel = findViewById(R.id.enterTel);
        EditText enterPw = findViewById(R.id.enterPw);

        ImageButton signIn_btn = findViewById(R.id.signIn_btn);

        LinearLayout login = findViewById(R.id.loginlayout);

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterTel.getText().toString().equals("")){
                    Toast.makeText(Login.this, "전화번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    enterTel.requestFocus();
                    return;
                }
                if (enterPw.getText().toString().equals("")){
                    Toast.makeText(Login.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    enterPw.requestFocus();
                    return;
                }
                login();
            }

            private void login(){
                String tel = enterTel.getText().toString();
                String pw = enterPw.getText().toString();
                MemberService memberService = MemberClient.getInstance().getMemberService();
                Call<Member> call = memberService.getMember(tel, pw);
                call.enqueue(new Callback<Member>() {
                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        Member member = response.body();
                        if(member!=null){
                            if (member.getPassword().equals(pw)){
                                SharedPreferences pref = getSharedPreferences("save", MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putLong("id", member.getId());
                                editor.putString("name", member.getName());
                                editor.putString("email", member.getEmail());
                                editor.putString("tel", member.getTel());
                                editor.putString("password", member.getPassword());
                                editor.putString("profileImg", member.getProfileImg());
                                editor.commit();
                                Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(Login.this, "잘못된 비밀번호 입니다.", Toast.LENGTH_SHORT).show();
                                enterPw.setText("");
                                enterPw.requestFocus();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Member> call, Throwable t) {
                        Toast.makeText(Login.this, "회원이 아닙니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });
    }
    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
