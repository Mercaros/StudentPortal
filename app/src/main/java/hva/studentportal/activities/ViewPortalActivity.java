package hva.studentportal.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import hva.studentportal.R;
import hva.studentportal.models.Portal;

/**
 * Created by khaled on 06-10-18.
 */

public class ViewPortalActivity extends AppCompatActivity {
    private WebView webView;
    private Portal portal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_portal);
        //Init values
        webView = findViewById(R.id.webView);
        getPortal();
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(portal.getUrlLink());
    }

    private Portal getPortal() {
        Intent intent = getIntent();
        portal = intent.getParcelableExtra(MainActivity.TAGTWO);
        return portal;
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
