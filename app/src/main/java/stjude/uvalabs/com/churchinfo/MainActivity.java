package stjude.uvalabs.com.churchinfo;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import stjude.uvalabs.com.churchinfo.fragment.AboutFragment;
import stjude.uvalabs.com.churchinfo.fragment.CommitteeFragment;
import stjude.uvalabs.com.churchinfo.fragment.GalleryFragment;
import stjude.uvalabs.com.churchinfo.fragment.HistoryFragment;
import stjude.uvalabs.com.churchinfo.fragment.LiveVdoFragment;
import stjude.uvalabs.com.churchinfo.fragment.NoticeFragment;
import stjude.uvalabs.com.churchinfo.fragment.PrayersFragment;
import stjude.uvalabs.com.churchinfo.fragment.SermonsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_history);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_history) {
////            Intent intent = new Intent(this, HistoryActivity.class);
////            startActivity(intent);
//
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_prayers) {
//
//        } else if (id == R.id.nav_liveVdo) {
//
//        } else if (id == R.id.nav_sermons) {
//
//        } else if (id == R.id.nav_notice) {
//
//        }else if (id == R.id.nav_other) {
//
//        }else if (id == R.id.nav_about) {
//
//        }else if (id == R.id.nav_commitee) {
//
//        }else if (id == R.id.nav_feedback) {
//
//        }else if (id == R.id.nav_share) {
//
//        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);

        displaySelectedScreen(item.getItemId());
        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_history:
                fragment = new HistoryFragment();
                break;
            case R.id.nav_gallery:
                fragment = new GalleryFragment();
                break;
            case R.id.nav_prayers:
                fragment = new PrayersFragment();
                break;
            case R.id.nav_liveVdo:
                fragment = new LiveVdoFragment();
                break;
            case R.id.nav_sermons:
                fragment = new SermonsFragment();
                break;
            case R.id.nav_notice:
                fragment = new NoticeFragment();
                break;
            case R.id.nav_commitee:
                fragment = new CommitteeFragment();
                break;
            case R.id.nav_about:
                fragment = new AboutFragment();
                break;

            
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
