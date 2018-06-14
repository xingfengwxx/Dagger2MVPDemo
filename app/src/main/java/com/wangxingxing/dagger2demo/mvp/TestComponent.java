package com.wangxingxing.dagger2demo.mvp;

import dagger.Component;

@Component(modules = TestModule.class)
public interface TestComponent {
    void inject(TestActivity activity);
}
