package bleizing.riva.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import bleizing.riva.R;
import bleizing.riva.fragment.DetailRumatFragment;
import bleizing.riva.fragment.EdukasiFragment;
import bleizing.riva.fragment.KakiFragment;
import bleizing.riva.fragment.RegistrasiFragment;
import bleizing.riva.fragment.RumatFragment;

public class RumatActivity extends AppCompatActivity {
    private static final String TAG = "RumatActivity";

    private static final String FRAGMENT_DETAIL_RUMAT_TAG = "DetailRumatFragment";
    private static final String FRAGMENT_REGISTRASI_TAG = "RegistrasiFragment";

    private String last_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumat);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_biru_biru));
        actionBar.setTitle("LOKASI");
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            RumatFragment rumatFragment = new RumatFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, rumatFragment, TAG).commit();
        }

//        String url_article_rumat = "https://www.rumat-indonesia.com/menu/JABODETABEK.html";
//
//        WebView webView = (WebView) findViewById(R.id.webview);
//
//        WebSettings webSettings = webView.getSettings();
//
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.clearCache(true);
//        webView.clearHistory();
//        webView.loadUrl(url_article_rumat);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                goBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void goBack() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            setActionBarTitle(last_title);
        } else {
            // app icon in action bar clicked; go home
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void changeToDetailRumatFragment() {
        last_title = getSupportActionBar().getTitle().toString();

        DetailRumatFragment detailRumatFragment = new DetailRumatFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailRumatFragment, FRAGMENT_DETAIL_RUMAT_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void changeToRegistrasiFragment(View view) {
        last_title = getSupportActionBar().getTitle().toString();

        RegistrasiFragment registrasiFragment = new RegistrasiFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, registrasiFragment, FRAGMENT_REGISTRASI_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
