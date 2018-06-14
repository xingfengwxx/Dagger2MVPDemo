package com.wangxingxing.dagger2demo.mvp.model;

import android.util.Log;

import com.wangxingxing.dagger2demo.bean.Phone;
import com.wangxingxing.dagger2demo.mvp.contract.TestContract;

import javax.inject.Inject;

public class TestModel implements TestContract.Model {

    @Inject
    Phone phone;

    private TestContract.Model.IListener listener;
    public static final String TAG = "TestModel";

    public TestModel(IListener listener) {
        this.listener = listener;
    }

    @Override
    public void getHttpData() {
        Log.i(TAG, "模拟网络请求...");
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    listener.onSuccess("test data:");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
