package com.lambdaschool.intermediatejavasprintchallenge;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is where the double-click logic will reside.
 */
public class DoubleClickHandler implements DoubleClickInterface {
    private DoubleClickListener doubleClickListener;
    private static AtomicBoolean processClick = new AtomicBoolean(true);
    private static AtomicBoolean waitingForSecondClick = new AtomicBoolean(true);

    public DoubleClickHandler(View view) {

    }

    @Override
    public void setOnClickListener(final View view) {
        final Context context = view.getContext();

        //final TextView multiTextView = view.findViewById(R.id.multi_text_view);
        if (waitingForSecondClick.get()) {
            waitingForSecondClick.set(false);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(1000);
                        if (!waitingForSecondClick.get()) {
                            waitingForSecondClick.set(true);

                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(context, "Single Click", Toast.LENGTH_SHORT).show();
                                    MainActivity.multiTextView.setText("Single Click\n" + MainActivity.multiTextView.getText());
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        } else {
            waitingForSecondClick.set(true);
            //Toast.makeText(context, "DOUBLE Click!", Toast.LENGTH_SHORT).show();
            MainActivity.multiTextView.setText("DOUBLE Click\n" + MainActivity.multiTextView.getText());
        }

    }
}
