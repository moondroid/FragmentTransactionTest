package it.moondroid.fragmenttransactiontest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;


public class MainActivity extends AppCompatActivity
    implements FirstFragment.OnFirstFragmentListener,
        SecondFragment.OnSecondFragmentListener {

    private Fragment mFirstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            mFirstFragment = new FirstFragment();
            ft.replace(R.id.container, mFirstFragment);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onFirstFragmentInteraction(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.container, new SecondFragment());
//        ft.addToBackStack(null);
//        ft.commit();
        MyFragmentTransactionExtended fragmentTransactionExtended =
                new MyFragmentTransactionExtended(this, ft, mFirstFragment, new SecondFragment(), R.id.container);
        fragmentTransactionExtended.addTransition(MyFragmentTransactionExtended.ZOOM);
        fragmentTransactionExtended.commit();
    }

    @Override
    public void onSecondFragmentInteraction(View view) {
        getFragmentManager().popBackStack();
    }
}
