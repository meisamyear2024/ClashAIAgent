package com.meisam.clashai;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String CLASH_PACKAGE =
            "com.supercell.clashofclans";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openClashOfClans();
    }

    private void openClashOfClans() {

        Intent launchIntent =
                getPackageManager().getLaunchIntentForPackage(CLASH_PACKAGE);

        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(launchIntent);
            finish();
            return;
        }

        Toast.makeText(
                this,
                "Clash of Clans is not installed.",
                Toast.LENGTH_LONG
        ).show();

        try {
            Intent store = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + CLASH_PACKAGE)
            );
            startActivity(store);
        } catch (Exception e) {
            Intent browser = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://play.google.com/store/apps/details?id="
                        + CLASH_PACKAGE
                    )
            );
            startActivity(browser);
        }

        finish();
    }
}
