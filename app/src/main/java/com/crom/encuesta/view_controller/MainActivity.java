package com.crom.encuesta.view_controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.persistence.SQLiteHelper;
import com.crom.encuesta.persistence.ViviendaDAO;
import com.crom.encuesta.view_controller.fragment.BookmarkFragmento;
import com.crom.encuesta.view_controller.fragment.IdentificacionFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final Vivienda vivienda = new Vivienda();
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private boolean activado = true;
    ViviendaDAO viviendaDAO= new ViviendaDAO();
    private SQLite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLiteHelper helper =
                new SQLiteHelper(this, "EncuestaBD", null, 1);

        SQLiteDatabase db = helper.getWritableDatabase();
        if(db != null)
        {
            vivienda.setDepartamento("Prieba");
            vivienda.setMunicipio("Pozon");
            vivienda.setMaterialParedesExteriores("sdsdasdad");
            ViviendaDAO v= new ViviendaDAO();
            v.insert(vivienda,db);
            Cursor c = v.read(db,1);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String codigo= c.getString(0);
                    String nombre = c.getString(1);
                    Log.i("#######",codigo+"-"+nombre);
                } while(c.moveToNext());
            }
        }


        //Log.i("Prueba SQL", viviendaDAO.read(sqlite.db, 1).toString());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();

        if (id == R.id.nav_bookmark) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new BookmarkFragmento()).commit();
        } else if (id == R.id.nav_encuestar) {
            if (!activado) {
                activado = true;
                fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            } else {
                Toast.makeText(this, "Encuesta en curso", Toast.LENGTH_SHORT).show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

}