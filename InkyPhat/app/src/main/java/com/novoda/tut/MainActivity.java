package com.novoda.tut;

import android.app.Activity;
import android.os.Bundle;

import com.novoda.inkyphat.InkyPhat;

public class MainActivity extends Activity {

    private static final String INKY_PHAT_DISPLAY = "SPI0.0";
    private static final String COMMAND_PIN = "BCM22";
    private static final String RESET_PIN = "BCM27";
    private static final String BUSY_PIN = "BCM17";

    private InkyPhat inkyPhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inkyPhat = InkyPhat.Factory.create(INKY_PHAT_DISPLAY, BUSY_PIN, RESET_PIN, COMMAND_PIN, InkyPhat.Orientation.PORTRAIT);
//        Tests.drawTwoSquares(inkyPhat);
        Tests.drawSmiley(inkyPhat);
//        Tests.drawImage(inkyPhat, getResources());
        inkyPhat.refresh();
    }

    @Override
    protected void onDestroy() {
        inkyPhat.close();
        super.onDestroy();
    }
}
