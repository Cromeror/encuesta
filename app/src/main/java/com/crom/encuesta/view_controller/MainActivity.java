package com.crom.encuesta.view_controller;

import android.content.Context;
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

import com.crom.encuesta.R;
import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.persistence.SQLiteHelper;
import com.crom.encuesta.view_controller.admin.AdminAccessFragment;
import com.crom.encuesta.view_controller.fragment.IdentificacionFragment;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Vivienda vivienda = new Vivienda();
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private boolean activado = true;
    private SQLiteDatabase db = null;
    private Hogar hogar = new Hogar();
    private Miembro miembro = new Miembro();
    private Ocupado ocupado = new Ocupado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //deleteInternal();
        miembro.setOcupado(ocupado);
        SQLiteHelper helper = new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        /*ViviendaDAO.getInstance().drop(db);
        HogarDAO.getInstance().drop(db);
        MiembroDAO.getInstance().drop(db);
        SaludDAO.getInstance().drop(db);
        EducacionDAO.getInstance().drop(db);
        OcupadoDAO.getInstance().drop(db);
        FuerzaTrabajoDAO.getInstance().drop(db);
        TicDAO.getInstance().drop(db);
        OtroIngresoDAO.getInstance().drop(db);

        ViviendaDAO.getInstance().create(db);
        HogarDAO.getInstance().create(db);
        MiembroDAO.getInstance().create(db);
        SaludDAO.getInstance().create(db);
        EducacionDAO.getInstance().create(db);
        OcupadoDAO.getInstance().create(db);
        FuerzaTrabajoDAO.getInstance().create(db);
        TicDAO.getInstance().create(db);
        OtroIngresoDAO.getInstance().create(db);*/
        //SuperDAO.getInstance().drop(db);
        //SuperDAO.getInstance().create(db);

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
        //fragmentManager.beginTransaction().replace(R.id.contenedor, new BookmarkFragmento()).commit();
        if (id == R.id.nav_encuestar) {
            setActivado(true);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            /*if (!activado) {
                activado = true;
                fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            } else {
                Toast.makeText(this, "Encuesta en curso", Toast.LENGTH_SHORT).show();
            }*/
        } else if (id == R.id.nav_admin) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new AdminAccessFragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public Hogar getHogar() {
        return hogar;
    }

    public void setHogar(Hogar hogar) {
        this.hogar = hogar;
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

    public SQLiteDatabase getDb() {
        return db;
    }

    public Ocupado getOcupado() {
        return ocupado;
    }

    public void setOcupado(Ocupado ocupado) {
        this.ocupado = ocupado;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public boolean saveInternal(String texto) {
        try {
            String t = readInternal() + "|" + texto;
            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));

            fout.write(t);
            fout.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
            return false;
        }
        return true;
    }

    public void deleteInternal() {
        deleteFile("prueba_int.txt");
    }

    public String readInternal() {
        try {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("prueba_int.txt")));
            String texto = fin.readLine();
            fin.close();
            return texto;
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
        return "";
    }
}