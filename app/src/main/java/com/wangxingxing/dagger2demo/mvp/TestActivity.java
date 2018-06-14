package com.wangxingxing.dagger2demo.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wangxingxing.dagger2demo.R;
import com.wangxingxing.dagger2demo.mvp.contract.TestContract;
import com.wangxingxing.dagger2demo.mvp.presenter.TestPresenter;

import javax.inject.Inject;

public class TestActivity extends AppCompatActivity implements TestContract.View {

    @Inject
    TestPresenter mPresenter;

    private TextView textView2;
    private ProgressBar progressBar2;
    private Button button;

    public static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Dagger注入
        DaggerTestComponent.builder().testModule(new TestModule(this)).build().inject(this);

        textView2 = findViewById(R.id.textView2);
        progressBar2 = findViewById(R.id.progressBar2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
                mPresenter.loadData();
            }
        });
    }

    @Override
    public void updateUI(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView2.setText("获取数据成功:" + msg);
            }
        });
    }

    @Override
    public void showProgressBar() {
        Log.i(TAG, "showProgressBar()");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar2.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void hideProgressBar() {
        Log.i(TAG, "hideProgressBar()");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar2.setVisibility(View.GONE);
            }
        });
    }
}
