package com.padc.batch9.assignment7.util;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

public class FunUtils {

    public static String convertListToString(List<String> list) {
        return TextUtils.join(", ", list);
    }

    public static void setStatusBarColor(Activity context, int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = context.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            context.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(context.getResources().getColor(color));
        }
    }
}
