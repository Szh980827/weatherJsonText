package com.example.sdbi.weatherjsontext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {


	private Button butTitleBack;  // 标题栏返回按钮
	/*
	 * 对应页面第一行 今日天气
	 */
	private TextView tvCity;    //城市
	private TextView tvData;    //日期
	private TextView tvWeek;    //星期几？
	private TextView tvWendu;    //温度
	private TextView tvWeatherType;        //天气类型文字
	private ImageView ivWeatherType;    //天气类型图片
	/*
	 * 对应第一个表格
	 */
	/*
	第一行 日期
	 */
	private TextView tvDay1;
	private TextView tvDay2;
	private TextView tvDay3;
	private TextView tvDay4;
	private TextView tvDay5;
	private TextView tvDay6;
	/*
	第二行 星期几？
	 */
	private TextView tvWeek1;
	private TextView tvWeek2;
	private TextView tvWeek3;
	private TextView tvWeek4;
	private TextView tvWeek5;
	private TextView tvWeek6;
	/*
	第三行 天气类型 文字
	*/
	private TextView tvWeatherType1;
	private TextView tvWeatherType2;
	private TextView tvWeatherType3;
	private TextView tvWeatherType4;
	private TextView tvWeatherType5;
	private TextView tvWeatherType6;
	/*
	第四行  天气类型 图片
	*/
	private ImageView imgWeatherType1;
	private ImageView imgWeatherType2;
	private ImageView imgWeatherType3;
	private ImageView imgWeatherType4;
	private ImageView imgWeatherType5;
	private ImageView imgWeatherType6;
	/*
	 * 折线图
	 */
	private LineChart lineChart;
	private LineDataSet set;
	private LineDataSet set2;
	private ArrayList<Entry> list = new ArrayList<>();  //数据集合
	private ArrayList<Entry> list2 = new ArrayList<>();

	/*
	 * 第二个表格
	 */
	/*
	第二行 各生活指数 数字
	*/
	private TextView tvUvIndex;
	private TextView tvAirIndex;
	private TextView tvSportIndex;
	private TextView tvClothingIndex;
	private TextView tvFluIndex;
	private TextView tvCarIndex;
	/*
	第三行 各生活指数 类型
	*/
	private TextView tvUvType;
	private TextView tvAirType;
	private TextView tvSportType;
	private TextView tvClothingType;
	private TextView tvFluType;
	private TextView tvCarType;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);
		initView();
		butTitleBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		setData();


	}
	private void setData(){
		ArrayList<String> xValues1 = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			xValues1.add(i+"");
		}
		list.add(new Entry(28,0));
		list.add(new Entry(22,1));
		list.add(new Entry(20,2));
		list.add(new Entry(22,3));
		list.add(new Entry(25,4));
		list.add(new Entry(29,5));
		set = new LineDataSet(list,"weatherHigh");
		ArrayList<String> xValues2 = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			xValues2.add(i+"");
		}
		list2.add(new Entry(14,0));
		list2.add(new Entry(10,1));
		list2.add(new Entry(12,2));
		list2.add(new Entry(13,3));
		list2.add(new Entry(16,4));
		list2.add(new Entry(18,5));
		set2 = new LineDataSet(list2,"weatherLow");
		setLine(set,set2);
		yingcang();
		ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
		dataSets.add(set);
		dataSets.add(set2);
		LineData lineData=new LineData(xValues1,dataSets);
		lineChart.setData(lineData);

	}
	private void setLine(LineDataSet set,LineDataSet set2){
		set.setColor(Color.YELLOW); //设置线条颜色
		set.setCircleColor(Color.YELLOW); //设置小圆点颜色
		set2.setColor(Color.BLUE);
		set2.setCircleColor(Color.BLUE);

	}
	private void yingcang() {
		//关闭边框矩形
		lineChart.setDrawBorders(false);
		//不绘制y轴左边的线
		lineChart.getAxisLeft().setDrawAxisLine(false);
		//不绘制y轴右边的线
        lineChart.getAxisRight().setDrawAxisLine(false);
		//禁用图表右边y轴
		lineChart.getAxisRight().setEnabled(false);
		//禁用x轴
		lineChart.getXAxis().setEnabled(false);
		//隐藏图表左边y轴标签
		lineChart.getAxisLeft().setDrawLabels(false);
		//关闭x轴网格线./即竖线
        lineChart.getXAxis().setDrawGridLines(false);

        //隐藏网格线
        lineChart.setDrawGridBackground(false);
        //关闭缩放x和y
		lineChart.setScaleEnabled(false);
		//隐藏图例
		Legend legend = lineChart.getLegend();
		legend.setEnabled(false);
		//隐藏描述


	}
	/*
	 * 初始化控件
	 */
	private void initView() {
		butTitleBack = findViewById(R.id.title_back);
		lineChart = findViewById(R.id.chart_weather);
		tvCity = findViewById(R.id.tv_city);  //城市
		tvData = findViewById(R.id.tv_data);  //日期
		tvWeek = findViewById(R.id.tv_week);  //星期几？
		tvWendu = findViewById(R.id.tv_wendu); //温度
		tvWeatherType = findViewById(R.id.tv_weather_type);  //天气类型文字
		ivWeatherType = findViewById(R.id.img_weather_type);  //天气类型图片
		tvDay1 = findViewById(R.id.tv_day1);
		tvDay2 = findViewById(R.id.tv_day2);
		tvDay3 = findViewById(R.id.tv_day3);
		tvDay4 = findViewById(R.id.tv_day4);
		tvDay5 = findViewById(R.id.tv_day5);
		tvDay6 = findViewById(R.id.tv_day6);
		tvWeek1 = findViewById(R.id.tv_week1);
		tvWeek2 = findViewById(R.id.tv_week2);
		tvWeek3 = findViewById(R.id.tv_week3);
		tvWeek4 = findViewById(R.id.tv_week4);
		tvWeek5 = findViewById(R.id.tv_week5);
		tvWeek6 = findViewById(R.id.tv_week6);
		tvWeatherType1 = findViewById(R.id.tv_weather_type1);
		tvWeatherType2 = findViewById(R.id.tv_weather_type2);
		tvWeatherType3 = findViewById(R.id.tv_weather_type3);
		tvWeatherType4 = findViewById(R.id.tv_weather_type4);
		tvWeatherType5 = findViewById(R.id.tv_weather_type5);
		tvWeatherType6 = findViewById(R.id.tv_weather_type6);
		imgWeatherType1 = findViewById(R.id.img_weather_type1);
		imgWeatherType2 = findViewById(R.id.img_weather_type2);
		imgWeatherType3 = findViewById(R.id.img_weather_type3);
		imgWeatherType4 = findViewById(R.id.img_weather_type4);
		imgWeatherType5 = findViewById(R.id.img_weather_type5);
		imgWeatherType6 = findViewById(R.id.img_weather_type6);
		tvUvIndex = findViewById(R.id.tv_uv_index);
		tvAirIndex = findViewById(R.id.tv_air_index);
		tvSportIndex = findViewById(R.id.tv_sport_index);
		tvClothingIndex = findViewById(R.id.tv_clothing_index);
		tvFluIndex = findViewById(R.id.tv_flu_index);
		tvCarIndex = findViewById(R.id.tv_car_index);
		tvUvType = findViewById(R.id.tv_uv_type);
		tvAirType = findViewById(R.id.tv_air_type);
		tvSportType = findViewById(R.id.tv_sport_type);
		tvClothingType = findViewById(R.id.tv_clothing_type);
		tvFluType = findViewById(R.id.tv_flu_type);
		tvCarType = findViewById(R.id.tv_car_type);
	}

}
