package com.wangxingxing.dagger2demo.bean;

import javax.inject.Inject;

public class Phone {

    @Inject
    public Phone() {
    }

    public String getModel() {
        return "小米Note";
    }
}
