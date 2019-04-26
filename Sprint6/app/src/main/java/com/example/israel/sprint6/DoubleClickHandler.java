package com.example.israel.sprint6;

import android.view.View;

public class DoubleClickHandler implements DoubleClickInterface {

    // FIXME make this settable
    public static final long DOUBLE_CLICK_INTERVAL = 500;

    private OnDoubleClickListener onDoubleClickListener;
    private long lastClickTime;

    public void click(View v) {
        if (onDoubleClickListener == null) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        long elapsedTimeSinceLastClick = currentTime - lastClickTime;
        if (elapsedTimeSinceLastClick > DOUBLE_CLICK_INTERVAL) {
            lastClickTime = currentTime;
            return;
        }

        onDoubleClickListener.onDoubleClick(v);
        lastClickTime = 0; // reset

    }

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        lastClickTime = 0; // reset // TODO test
        onDoubleClickListener = l;
    }

}
