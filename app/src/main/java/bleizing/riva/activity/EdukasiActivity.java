package bleizing.riva.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import bleizing.riva.R;
import bleizing.riva.fragment.ArticleFragment;
import bleizing.riva.fragment.BonusReferensiFragment;
import bleizing.riva.fragment.DetailArticleFragment;
import bleizing.riva.fragment.EdukasiFragment;

public class EdukasiActivity extends AppCompatActivity {
    private static final String TAG = "EdukasiActivity";

    private static final String FRAGMENT_ARTICLE_TAG = "ArticleFragment";
    private static final String FRAGMENT_DETAIL_ARTICLE_TAG = "DetailArticleFragment";

    private String last_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edukasi);

        last_title = "";

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_biru_biru));
        actionBar.setTitle(getResources().getString(R.string.untuk_anda));
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            EdukasiFragment edukasiFragment = new EdukasiFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, edukasiFragment, TAG).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    public void changeToArticleFragment() {
        last_title = getSupportActionBar().getTitle().toString();

        ArticleFragment articleFragment = new ArticleFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, articleFragment, FRAGMENT_ARTICLE_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void changeToDetailArticleFragment(int article_id) {
        last_title = getSupportActionBar().getTitle().toString();

        DetailArticleFragment detailArticleFragment = new DetailArticleFragment();
        Bundle args = new Bundle();
        args.putInt("article_id", article_id);
        detailArticleFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, detailArticleFragment, FRAGMENT_DETAIL_ARTICLE_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
