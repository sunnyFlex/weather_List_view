package com.sunnyflex.weatherlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter extends BaseAdapter {

    //날씨 List 변수
    private List<Weather> weathersData;
    //날씨 Map자료형
    private Map<String, Integer> weatherImageMap;

    //날씨와 날씨에 맞는 이미지 매칭
    public MyFirstAdapter(List<Weather> weathersData) {
        this.weathersData = weathersData;

        //weatherImageMap을 자료형 HashMap으로 포맷정리해서 이미지랑 연결
        weatherImageMap = new HashMap<>();
        weatherImageMap.put("맑음", R.drawable.sunny);
        weatherImageMap.put("흐림", R.drawable.cloud);
        weatherImageMap.put("가끔구름", R.drawable.sunny_cloud);
        weatherImageMap.put("비", R.drawable.rain);
        weatherImageMap.put("눈", R.drawable.snow);
    }

    // List의 갯수 체크
    @Override
    public int getCount() {
        return weathersData.size();
    }

    // List Item들의 위치(position) 체크
    @Override
    public Object getItem(int position) {
        return weathersData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //viewHoler 변수 선언;
        viewHolder holder = new viewHolder();
        // **뷰가 null즉 첫번째 입력일때는 layout을 가져와야한다. 그러나 null이 아닐때 즉 재입력일때는 저장된 holer를 불러온다.**
        if (view == null){
            // *최초 입력인 경우 layout을 호출한다.
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup,false);
            // *최초 입력인 경우 소스들도 호출한다.
            ImageView weatherImage = view.findViewById(R.id.weather_image);
            TextView cityName = view.findViewById(R.id.city_name);
            TextView tempText = view.findViewById(R.id.temp_text);

            //holer에 최초호출된 리소스를 담는다.
            holder.weatherImage = weatherImage;
            holder.cityName = cityName;
            holder.tempText = tempText;

            //view에 holder를 저장한다.
            view.setTag(holder);

        }else{
            //즉 재사용할시는 view.getTag로 저장된 holder만 가져오면 된다.
            holder = (viewHolder) view.getTag();

        }


        // holder사용시 holder에 있는 데이터를 호출하면된다.
        // 만들어 놓은 Weather.java를 data의 포지션을 포함해서 weather를 정의한다.
        Weather weather = weathersData.get(position);
        // cityName  textview에 getCity() getti메소드를 가져와서 출력한다.
        holder.cityName.setText(weather.getCity());
        // tempText  textview에 getTemp() getti메소드를 가져와서 출력한다.
        holder.tempText.setText(weather.getTemp());

        // weatherImageMap view에 출력정의
        holder.weatherImage.setImageResource(weatherImageMap.get(weather.getWeather()));

        return view;
    }

    //소스도 view에 한번 불러온 소스를 다시부르지 않고 재사용하기 위해 viewholer를 사용한다.
    static class viewHolder{
        ImageView weatherImage;
        TextView cityName;
        TextView tempText;
    }
}
