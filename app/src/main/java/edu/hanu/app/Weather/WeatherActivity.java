package edu.hanu.app.Weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import edu.hanu.app.Weather.adapter.TempByDayAdapter;
import edu.hanu.app.Weather.adapter.TempByHoursAdapter;
import edu.hanu.app.Weather.model.Main;
import edu.hanu.app.Weather.model.MyData;
import edu.hanu.app.Weather.model.TempByDay;
import edu.hanu.app.Weather.model.TempByHours;
import edu.hanu.app.Weather.model.Weather;
import edu.hanu.mydesign.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {
    TextView tvCityName, tvCurrentTime, tvCurrentTemp, tvDescription, tvTempMaxMin, tvFeelsLike,
            tvHumidity, tvSunrise, tvSunset, tvWind;
    EditText edtSearchView;
    FloatingActionButton fab_search;
    String url = "https://api.openweathermap.org/data/2.5/weather?q=hanoi&appid=d0dd5f297c71810e52a03f1542c23fed";
    String apiKey = "d0dd5f297c71810e52a03f1542c23fed";

    RecyclerView rvDisplayTempByHour, rvDisplayTempByDay;
    TempByHoursAdapter tempByHoursAdapter;
    TempByDayAdapter tempByDayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Hanoi");
        setSupportActionBar(toolbar);

        initView();

        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy hh:mm", Locale.ENGLISH);
        String currentDate = format.format(new Date());
        tvCurrentTime.setText(currentDate);

        LinearLayoutManager displayTempByHour = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvDisplayTempByHour.setLayoutManager(displayTempByHour);
        tempByHoursAdapter = new TempByHoursAdapter();
        tempByHoursAdapter.setData(getListTempByHours());
        rvDisplayTempByHour.setAdapter(tempByHoursAdapter);

        LinearLayoutManager displayTempByDay = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvDisplayTempByDay.setLayoutManager(displayTempByDay);
        tempByDayAdapter = new TempByDayAdapter();
        tempByDayAdapter.setData(getListTempByDay());
        rvDisplayTempByDay.setAdapter(tempByDayAdapter);


        getWeather("Hanoi");

        fab_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edtSearchView.getText().toString())) {
                    edtSearchView.setError("Please enter city name");
                    return;
                }

                String cityName = edtSearchView.getText().toString().trim();
                getWeather(cityName);
            }
        });
    }

    private void initView() {
        rvDisplayTempByHour = findViewById(R.id.rvDisplayTempByHour);
        rvDisplayTempByDay = findViewById(R.id.rvDisplayTempByDay);
        tvCityName = findViewById(R.id.tvCityName);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvDescription = findViewById(R.id.tvDescription);
        tvCurrentTemp = findViewById(R.id.tvCurrentTemp);
        tvTempMaxMin = findViewById(R.id.tvTempMaxMin);
        tvFeelsLike = findViewById(R.id.tvFeelsLike);
        tvHumidity = findViewById(R.id.tvHumidity);
        tvSunrise = findViewById(R.id.tvSunrise);
        tvSunset = findViewById(R.id.tvSunset);
        tvWind = findViewById(R.id.tvWind);
        edtSearchView = findViewById(R.id.edtSearchView);
        fab_search = findViewById(R.id.fab_search);
    }

    public void getWeather(String cityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherApi api = retrofit.create(weatherApi.class);
        Call<MyData> myDataCall = api.getWeather(cityName, apiKey);
        myDataCall.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if(!(response.isSuccessful())) {
                    Toast.makeText(WeatherActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                }
                MyData myData = response.body();
                Main main = myData.getMain();
                Double temp = main.getTemp();
                Integer currentTemp = (int) (temp - 273.15);
                Integer temp_max = (int) (main.getTemp_max() - 273.15);
                Integer temp_min = (int) (main.getTemp_min() - 273.15);
                Integer feels_like = (int) (main.getFeels_like() - 273.15);
                tvCityName.setText(myData.getName());
                tvCurrentTemp.setText(currentTemp+"\u2103");
                tvHumidity.setText(main.getHumidity()+"%");
                tvTempMaxMin.setText(temp_max+"⁰/ " + temp_min+"⁰");
                tvFeelsLike.setText("Feels like " + feels_like + "⁰");

                String sunrise = new SimpleDateFormat("hh:mm a").format(myData.getSys().getSunrise() * 1000);
                tvSunrise.setText(sunrise);

                String sunset = new SimpleDateFormat("hh:mm a").format(myData.getSys().getSunset() * 1000);
                tvSunset.setText(sunset);
                tvWind.setText(myData.getWind().getSpeed()+" km/h");

                List<Weather> description = myData.getWeather();
                for(Weather data : description) {
                    tvDescription.setText(data.getDescription());
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                Toast.makeText(WeatherActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private List<TempByHours> getListTempByHours() {
        List<TempByHours> list = new ArrayList<>();

        list.add(new TempByHours("14:00", R.drawable.sunny, "34"));
        list.add(new TempByHours("15:00", R.drawable.sunny, "33"));
        list.add(new TempByHours("16:00", R.drawable.sunny, "33"));
        list.add(new TempByHours("17:00", R.drawable.sunny, "32"));
        list.add(new TempByHours("18:00", R.drawable.clouds, "32"));
        return list;
    }

    private List<TempByDay> getListTempByDay() {
        List<TempByDay> list = new ArrayList<>();

        list.add(new TempByDay("Thứ năm", 12, 35, 28));
        list.add(new TempByDay("Thứ sáu", 17, 37, 28));
        list.add(new TempByDay("Thứ bảy", 40, 37, 28));
        list.add(new TempByDay("Chủ nhật", 57, 37, 28));
        list.add(new TempByDay("Thứ hai", 52, 36, 28));
        list.add(new TempByDay("Thứ ba", 24, 36, 28));
        return list;
    }
}