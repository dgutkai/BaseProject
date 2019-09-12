package com.real0168.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by lanmi on 2018/8/16.
 */

public abstract class BaseActivity extends PermissionsActivity {

    public abstract int getLayoutID();

    protected Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mHandler = new MyHandler(this);
    }

    abstract public void handlerManager(Message msg);

    protected class MyHandler extends Handler {
        private WeakReference<BaseActivity> mActivity;

        public MyHandler(BaseActivity activity) {
            this.mActivity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mActivity != null && mActivity.get() != null) {
                mActivity.get().handlerManager(msg);
            }
        }
    }

    public void startActivity(Class activityclass){
        Intent intent = new Intent(this, activityclass);
        startActivity(intent);

    }
}
