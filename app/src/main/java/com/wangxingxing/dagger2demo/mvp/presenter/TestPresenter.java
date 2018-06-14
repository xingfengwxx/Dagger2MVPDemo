package com.wangxingxing.dagger2demo.mvp.presenter;

import android.util.Log;

import com.wangxingxing.dagger2demo.mvp.contract.TestContract;
import com.wangxingxing.dagger2demo.mvp.model.TestModel;

import javax.inject.Inject;

public class TestPresenter implements TestContract.Presenter, TestContract.Model.IListener {

    public static final String TAG = "TestPresenter";

    private TestContract.View mView;
    private TestContract.Model mModel;

    @Inject
    TestPresenter(TestContract.View view, TestContract.Model model) {
        mView = view;
        mModel = new TestModel(this);
    }

    @Override
    public void loadData() {
        mView.showProgressBar();
        Log.i(TAG, "loadData()");
        mModel.getHttpData();
    }

    @Override
    public void onSuccess(String msg) {
        mView.hideProgressBar();
        Log.i(TAG, "onSuccess()");
        mView.updateUI(msg);
    }
}
