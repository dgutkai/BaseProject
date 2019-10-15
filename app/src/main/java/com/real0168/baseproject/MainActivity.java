package com.real0168.baseproject;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;

import com.real0168.base.BaseActivity;
import com.real0168.utils.DialogUtils;

public class MainActivity extends BaseActivity {
    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DialogUtils.messageDialog(this, "提示", "这是例示Dialog！", new DialogUtils.CommonDialogListener() {
            @Override
            public void onOk() {

            }

            @Override
            public void onCancel() {

            }
        }).show();
    }

    @Override
    public void handlerManager(Message msg) {

    }
}
