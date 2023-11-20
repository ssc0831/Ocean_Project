package com.example.oceanapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.MapView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Multipart;

public class FragmentA extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // fragment_a.xml 파일을 인플레이트하여 View를 생성
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // View에서 필요한 UI 요소들을 찾아와서 조작할 수 있습니다.
        TextView textView = view.findViewById(R.id.tvwhale);
        ImageView imageDiarySelected = view.findViewById(R.id.imageDiarySelected);
        MapView mapView = view.findViewById(R.id.map_view);
        EditText editText = view.findViewById(R.id.edtwidth);
        EditText editText2 = view.findViewById(R.id.edtweight);
        EditText editText3 = view.findViewById(R.id.etContent);
        ImageButton imageButton = view.findViewById(R.id.imgbtn);
        ImageButton imageButton2 = view.findViewById(R.id.imgbtn2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지 파일 업로드
                String UPLOADPATH = "C:/OceanApp/src/main/resources/UploadFile/";
                File imageFile = new File(UPLOADPATH + "img.jpg");
                RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), imageFile);
                MultipartBody.Part imagePart = MultipartBody.Part.createFormData("image", imageFile.getName(), requestBody);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:7979/")
                        .build();
                // retrofit.create(imageButton);
                UploadService uploadService = retrofit.create(UploadService.class);

                Call<ResponseBody> call = uploadService.uploadImage(imagePart);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 이미지 업로드 성공 시의 동작
                        // response.body()를 이용해 서버로부터의 응답을 처리
                        Toast.makeText(getContext(), "이미지 업로드 성공", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // 이미지 업로드 실패 시의 동작
                        Toast.makeText(getContext(), "이미지 업로드 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DB로 데이터 전송
                String widthValue = editText.getText().toString();
                String weightValue = editText2.getText().toString();
                String contentValue = editText3.getText().toString();

                RequestBody width = RequestBody.create(MediaType.parse("text/plain"), widthValue);
                RequestBody weight = RequestBody.create(MediaType.parse("text/plain"), weightValue);
                RequestBody content = RequestBody.create(MediaType.parse("text/plain"), contentValue);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost:7979/")
                        .build();

                UploadService uploadService = retrofit.create(UploadService.class);

                Call<ResponseBody> call = uploadService.saveData(width, weight, content);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 데이터 전송 성공 시의 동작
                        // response.body()를 이용해 서버로부터의 응답을 처리
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        // 데이터 전송 실패 시의 동작
                    }
                });
            }
        });
        return view;
    }
}
