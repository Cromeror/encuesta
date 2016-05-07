package com.crom.encuesta.view_controller;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.fragment.EducacionFragment;
import com.crom.encuesta.view_controller.fragment.FuerzaFragment;

public class FamilyActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private boolean isPageScrolled = false;
    private int previousPage = -1, selectedPage = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
    public void setPositionPager(int position){
        if(position>=0 && position<mSectionsPagerAdapter.getCount())
        mViewPager.setCurrentItem(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_family, menu);
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private ViewGroup mContainer;
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                return new EducacionFragment();
                case 1:
                    return new FuerzaFragment();
            }
            return  new EducacionFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.capE);
                case 1:
                    return getString(R.string.capF);
                case 2:
                    return "SECTION 3";
            }
            return null;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            selectedPage = position;
            if (position == 0 && isPageScrolled == true) {
                isPageScrolled = false;
                dialog();
            }else if (position > 0){
                isPageScrolled=true;
                if(previousPage != selectedPage){
                    previousPage =selectedPage;
                }
            }
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
        public void dialog(){
            AlertDialog.Builder  alertDialogBuilder = new AlertDialog.Builder(FamilyActivity.this);
            alertDialogBuilder.setTitle("Cuidado");
            alertDialogBuilder
                    .setMessage("Si vuelve al formulario "+getString(R.string.capE)+" se borrarán los cambios realizados en "
                            +getString(R.string.capF)+". \n ¿Desea volver?")
                    .setCancelable(false)
                    .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            // FamilyActivity.this.finish();
                            isPageScrolled = false;
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            isPageScrolled = false;
                            if(previousPage>=0)
                                Log.i("##############","Posicion: "+previousPage);
                                mViewPager.setCurrentItem(previousPage);
                                //setPositionPager(previousPage);
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }
}
