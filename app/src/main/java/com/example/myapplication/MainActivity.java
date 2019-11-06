package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.bean.ArticleBean;
import com.example.myapplication.bean.BaseBean;
import com.example.myapplication.bean.DatasBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RetrofitHelper.getServer().mainList(0).enqueue(new Callback<BaseBean<ArticleBean<DatasBean>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseBean<ArticleBean<DatasBean>>> call, @NonNull Response<BaseBean<ArticleBean<DatasBean>>> response) {
                if (response.body() != null) {
                    tv.setText(response.body().getData().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseBean<ArticleBean<DatasBean>>> call, @NonNull Throwable t) {

            }
        });
    }
}
