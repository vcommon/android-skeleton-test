package com.little.resource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    private Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void clickNormalDialog(View view) {
        android.app.AlertDialog.Builder mBuilder = new AlertDialog.Builder(this)
                .setTitle("标题")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("文字")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null);

        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();
        dialog.show();
    }

    //Title居中，字体大小，Message Margin，字体颜色，确定和取消的位置，大小，背景

    /**
     * android:textColor 标题栏的字体颜色
     * android:textSize  会同时影响标题和按钮
     * 有很多参数是没办法直接通过xml去设置的
      */
    public void clickStyleDialog(View view) {
        android.app.AlertDialog.Builder mBuilder = new AlertDialog.Builder(this,R.style.StyledAlertDialog)
                .setTitle("标题")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("文字")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null);

        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();
        dialog.show();
    }

    /**
     * 这个代码的兼容性存在疑惑
     * @param view
     */
    public void clickCodeStyleDialog(View view) {
        android.app.AlertDialog.Builder mBuilder = new AlertDialog.Builder(this)
                .setTitle("标题")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("文字")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null);

        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();
        dialog.show();
        setCustomDialogStyle(dialog);
    }

    public static int dp2px(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

    public void setCustomDialogStyle(Dialog dialog){
        final Resources res = dialog.getContext().getResources();

        int topPanelId = res.getIdentifier("topPanel", "id", "android");//获取顶部
        LinearLayout topPanel = (LinearLayout) dialog.findViewById(topPanelId);
        topPanel.setBackgroundResource(R.drawable.layer_icon_right);//设置顶部背景
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, //设置顶部高度
                dp2px(dialog.getContext(), 50));
        topPanel.setLayoutParams(params);

        int dividerId = res.getIdentifier("titleDivider", "id", "android");//设置分隔线
        View divider = dialog.findViewById(dividerId);
        if(divider != null)divider.setVisibility(View.GONE);

        int titleId = res.getIdentifier("alertTitle", "id", "android");//获取标题title
        TextView title = (TextView) dialog.findViewById(titleId);//设置标题
        title.setTextColor(Color.WHITE);//标题文字颜色
        title.setTextSize(18);//文字大小
        title.setGravity(Gravity.CENTER);//文字位置

        int customPanelId = res.getIdentifier("customPanel", "id", "android");//设置内容
        FrameLayout customPanel = (FrameLayout) dialog.findViewById(customPanelId);
        customPanel.setBackgroundColor(Color.TRANSPARENT);//背景透明
        customPanel.getChildAt(0).setBackgroundColor(Color.WHITE);
        customPanel.setPadding(dp2px(this, 8), 0, dp2px(this, 8), 0);//设置padding
        int buttonPanelId = res.getIdentifier("buttonPanel", "id", "android");//获取底部
        LinearLayout buttonPanel = (LinearLayout) dialog.findViewById(buttonPanelId);
        buttonPanel.setBackgroundResource(R.drawable.layer_icon_right);//设置底部背景
        buttonPanel.setPadding(dp2px(this, 8), 1, dp2px(this, 8), 0);

        Button button1 = (Button) dialog.findViewById(android.R.id.button1);//设置底部Button
        button1.setTextColor(Color.WHITE);//文字颜色
        button1.setTextSize(18);//文字大小
        button1.setBackgroundResource(R.drawable.btn_primary);//Button圆形背景框

        Button button2 = (Button) dialog.findViewById(android.R.id.button2);
        button2.setTextColor(Color.WHITE);
        button2.setTextSize(18);
        button2.setBackgroundResource(R.drawable.btn_primary);

        Button button3 = (Button) dialog.findViewById(android.R.id.button3);
        button3.setTextColor(Color.WHITE);
        button3.setTextSize(18);
        button3.setBackgroundResource(R.drawable.btn_primary);

        LinearLayout.LayoutParams lp1 = (LinearLayout.LayoutParams)button1.getLayoutParams();
        lp1.weight = 99999;lp1.leftMargin=0;lp1.rightMargin=0;
        LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams)button2.getLayoutParams();
        lp2.weight = 99999;lp2.leftMargin=0;lp2.rightMargin=0;
        LinearLayout.LayoutParams lp3 = (LinearLayout.LayoutParams)button3.getLayoutParams();
        lp3.weight = 99999;lp3.leftMargin=0;lp3.rightMargin=0;

        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = 500;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
    }

    public void clickCustomerDialog(View view) {
        View contentView = View.inflate(this,R.layout.dialog_customer,null);
        android.app.AlertDialog.Builder mBuilder = new AlertDialog.Builder(this)
                .setView(contentView);

        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();
        dialog.show();
    }
}
