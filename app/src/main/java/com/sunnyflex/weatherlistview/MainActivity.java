package com.sunnyflex.weatherlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // **Data만들기
        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("서울","12도","흐림"));
        data.add(new Weather("용인","15도","맑음"));
        data.add(new Weather("성남","16도","가끔구름"));
        data.add(new Weather("대구","12도","흐림"));
        data.add(new Weather("부산","12도","비"));
        data.add(new Weather("강릉","12도","눈"));
        data.add(new Weather("원산","12도","비"));
        data.add(new Weather("제주","12도","맑음"));

        // **아답터 설정
        // *생성한 아답터 java class 데이터 타입의 변수에 위에 data를 입력값으로 하여 변수 생성
        MyFirstAdapter adapter = new MyFirstAdapter(data);

        // **생성된 view에 아답터 연결하기
        GridView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // **클릭시 콜백 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });







    }


}