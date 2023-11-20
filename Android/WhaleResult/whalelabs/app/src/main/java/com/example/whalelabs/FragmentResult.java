package com.example.whalelabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentResult extends Fragment {

    // onCreateView 메소드에서 XML 레이아웃과 관련된 View를 생성하고 반환합니다.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // XML 레이아웃을 inflate하여 View 객체를 생성합니다.
        View rootView = inflater.inflate(R.layout.result, container, false);

        // TextView, ImageView 등 XML에서 정의한 뷰들을 findViewById를 통해 찾아서 사용할 수 있습니다.
        TextView whaleLabsTextView = rootView.findViewById(R.id.whale_labs);
        ImageView imageDiarySelectedImageView = rootView.findViewById(R.id.imageDiarySelected);
        ImageButton imgBtn = rootView.findViewById(R.id.imgBtn);

        // TextView에 텍스트 설정 예시
        whaleLabsTextView.setText(getString(R.string.whale_labs_string));

        // ImageView에 이미지 설정 예시
        imageDiarySelectedImageView.setImageResource(R.drawable.whale_labs_1); // 여기에 적절한 이미지 리소스 ID를 사용하세요.

        // 다른 View들에 대한 설정 및 이벤트 처리를 추가할 수 있습니다.
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailPage();
            }
        });

        // 이미지에 따라 텍스트를 동적으로 변경
        TextView textView1 = rootView.findViewById(R.id.textView1);

         if (imageDiarySelectedImageView.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.whale_labs_1).getConstantState())) {
            textView1.setText("Text for Default Image");

        } else if (imageDiarySelectedImageView.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.whale_labs_1).getConstantState())) {
            textView1.setText(" ");
        }
        return rootView;
    }

    private void openDetailPage() {
        // 상세 페이지로 이동하는 코드를 추가
        // 여기에서는 웹페이지를 여는 예시를 들었습니다.
        String url = "https://www.example.com"; // 상세 페이지의 URL을 적절히 변경해주세요.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
