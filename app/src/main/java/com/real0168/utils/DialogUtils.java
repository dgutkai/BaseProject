package com.real0168.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.real0168.baseproject.R;

public class DialogUtils {

    public static interface CommonDialogListener{
        public void onOk();
        public void onCancel();
    }

    public static interface InputDialogListener{
        public void onOk(String value);
        public void onCancel();
    }


    private static Dialog lastDialog;
    public static Dialog messageDialog(Activity mActivity, String title, String message, final CommonDialogListener listener){

        if (lastDialog != null){
            if (lastDialog.isShowing()) {
                lastDialog.dismiss();
                lastDialog = null;
            }
        }
        View view = View.inflate(mActivity, R.layout.dialog_common, null);
        // 设置自定义对话框的布局
        final Dialog mdialog = new Dialog(mActivity, R.style.MyDialog);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mdialog.setContentView(view, params);
        final TextView dialogTitle = view.findViewById(R.id.title_text);
        dialogTitle.setText(title);
        final TextView messageText = view.findViewById(R.id.msg_text);
        if (message == null){
            messageText.setVisibility(View.GONE);
        }else{
            messageText.setVisibility(View.VISIBLE);
            messageText.setText(message);
        }
        final TextView saveBtn = view.findViewById(R.id.ok_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdialog.dismiss();
                if (listener != null){
                    listener.onOk();
                }

            }
        });
        WindowManager.LayoutParams windowParams = mdialog.getWindow().getAttributes();
        windowParams.width = (int) (mActivity.getWindowManager().getDefaultDisplay().getWidth()*0.7f);//设置dialog宽为屏幕的80%
        mdialog.getWindow().setAttributes(windowParams);
//        mdialog.setCancelable(false); // 点击对话框外部和返回键都无效
//        mdialog.setCanceledOnTouchOutside(false); // 点击对话框外部有效，点击返回键无效
        lastDialog = mdialog;
        return mdialog;
    }


}
