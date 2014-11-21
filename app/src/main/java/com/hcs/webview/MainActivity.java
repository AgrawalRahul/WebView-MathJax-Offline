package com.hcs.webview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
        webView.addJavascriptInterface(new myJsInterface(this), "Android");
    }

    public class myJsInterface {

        private Context con;

        public myJsInterface(Context con) {
            this.con = con;
        }

        public void showToast(String mssg) {
            AlertDialog alert = new AlertDialog.Builder(con)
                    .create();
            alert.setTitle("My Js Alert");
            alert.setMessage(mssg);
            alert.setButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

        }
    }

}
