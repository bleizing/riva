package bleizing.riva.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import bleizing.riva.R;
import bleizing.riva.fragment.ArticleFragment;
import bleizing.riva.fragment.BookingFragment;
import bleizing.riva.fragment.EdukasiFragment;
import bleizing.riva.fragment.HomecareFragment;

public class HomecareActivity extends AppCompatActivity {
    private static final String TAG = "HomecareActivity";

    private static final String FRAGMENT_BOOKING_TAG = "BookingFragment";
    private static final String FRAGMENT_DETAIL_ARTICLE_TAG = "DetailArticleFragment";
    private static final String FRAGMENT_LUKA_TAG = "LukaFragment";
    private static final String FRAGMENT_DETAIL_LUKA_TAG = "DetailLukaFragment";
    private static final String FRAGMENT_KAKI_TAG = "KakiFragment";
    private static final String FRAGMENT_DETAIL_KAKI_TAG = "DetailKakiFragment";

    private String last_title;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecare);

        last_title = "";

        toolbar = (Toolbar) findViewById(R.id.toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_biru_biru));
//        actionBar.setTitle(getResources().getString(R.string.homecare));
//        actionBar.setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);
        setTitle(getResources().getString(R.string.homecare));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_biru_biru));

        if (savedInstanceState == null) {
            HomecareFragment homecareFragment = new HomecareFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homecareFragment, TAG).commit();
        }
    }

    public void setActionBarTitle(String title) {
        toolbar.setTitle(title);
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
        super.onBackPressed();
        goBack();
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

    public void changeToBookingFragment() {
        last_title = toolbar.getTitle().toString();

        BookingFragment bookingFragment = new BookingFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, bookingFragment, FRAGMENT_BOOKING_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
