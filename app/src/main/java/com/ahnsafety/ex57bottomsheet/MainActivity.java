package com.ahnsafety.ex57bottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    BottomSheetDialog bottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {
        //다이얼로그 객체 생성
        bottomDialog= new BottomSheetDialog(this);

        //다이얼로그에서 보여줄 View객체 생성
        View v= getLayoutInflater().inflate(R.layout.bottom_dialog, null);
        bottomDialog.setContentView(v);

        //아웃사이드 터치로 캔슬여부
        bottomDialog.setCanceledOnTouchOutside(false);

        //다이얼로그 보이기
        bottomDialog.show();

        //다이얼로그 안에 있는 리스트뷰 참조하기
        ListView listView= v.findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                bottomDialog.dismiss();
            }
        });

    }
}
