package com.wangxingxing.dagger2demo.mvp.contract;

public interface TestContract {
    interface Model {
        void getHttpData();
        interface IListener{
            void onSuccess(String msg);
        }
    }

    interface View {
        void updateUI(String msg);
        void showProgressBar();
        void hideProgressBar();
    }

    interface Presenter {
        void loadData();
    }
}
