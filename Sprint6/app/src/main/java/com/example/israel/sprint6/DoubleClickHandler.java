package com.example.israel.sprint6;

public class DoubleClickHandler implements DoubleClickInterface {

    // FIXME make this settable
    public static final long DOUBLE_CLICK_INTERVAL = 500;

    private OnDoubleClickListener onDoubleClickListener;
    private long lastClickTime;

    public void click() {
        long currentTime = System.currentTimeMillis();
        long elapsedTimeSinceLastClick = currentTime - lastClickTime;
        if (elapsedTimeSinceLastClick < DOUBLE_CLICK_INTERVAL) {
            lastClickTime = currentTime;
            return;
        }
    }

    @Override
    public void SetOnDoubleClickListener(OnDoubleClickListener l) {
        lastClickTime = 0; // TODO test
        onDoubleClickListener = l;
    }

}
