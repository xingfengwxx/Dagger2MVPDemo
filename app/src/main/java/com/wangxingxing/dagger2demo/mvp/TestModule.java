package com.wangxingxing.dagger2demo.mvp;

import com.wangxingxing.dagger2demo.bean.Phone;
import com.wangxingxing.dagger2demo.mvp.contract.TestContract;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private final TestContract.View mView;

    public TestModule(TestContract.View view) {
        mView = view;
    }

    @Provides
    TestContract.View provideTestView() {
        return mView;
    }

    @Provides
    Phone providePhone() {
        return new Phone();
    }
}
