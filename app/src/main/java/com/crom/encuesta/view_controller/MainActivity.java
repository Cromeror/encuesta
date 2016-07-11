package com.crom.encuesta.view_controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.persistence.EducacionDAO;
import com.crom.encuesta.persistence.FuerzaTrabajoDAO;
import com.crom.encuesta.persistence.HogarDAO;
import com.crom.encuesta.persistence.MiembroDAO;
import com.crom.encuesta.persistence.OcupadoDAO;
import com.crom.encuesta.persistence.OtroIngresoDAO;
import com.crom.encuesta.persistence.SQLiteHelper;
import com.crom.encuesta.persistence.SaludDAO;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.persistence.TicDAO;
import com.crom.encuesta.persistence.ViviendaDAO;
import com.crom.encuesta.view_controller.fragment.BookmarkFragmento;
import com.crom.encuesta.view_controller.fragment.IdentificacionFragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final Vivienda vivienda = new Vivienda();
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
        if (id == R.id.nav_bookmark) {
            fragmentManager.beginTransaction().replace(R.id.contenedor, new BookmarkFragmento()).commit();
        } else if (id == R.id.nav_encuestar) {
            setActivado(true);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            /*if (!activado) {
                activado = true;
                fragmentManager.beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            } else {
                Toast.makeText(this, "Encuesta en curso", Toast.LENGTH_SHORT).show();
            }*/
        } else if (id == R.id.nav_import) {
            if (isExternalStorageWritable()) {
                try {
                    File ruta_sd_global = Environment.getExternalStorageDirectory();
                    //File ruta_sd_app_musica = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
                    Calendar c = Calendar.getInstance();
                    String dia = Integer.toString(c.get(Calendar.DATE));
                    String mes = Integer.toString(c.get(Calendar.MONTH));
                    String annio = Integer.toString(c.get(Calendar.YEAR));
                    String hora = Integer.toString(c.get(Calendar.MINUTE));
                    File f = new File(ruta_sd_global.getAbsolutePath(), "import_"+hora+"_"+dia+"-"+mes+"-"+annio+")].txt");

                    OutputStreamWriter fout =
                            new OutputStreamWriter(
                                    new FileOutputStream(f));
                    for (String vivienda : SuperDAO.getInstance().read(this.getDb())) {
                        fout.write(vivienda.toString()+"");
                    }
                    fout.close();
                    Toast.makeText(MainActivity.this, "Fichero creado con éxito" + ruta_sd_global.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    Log.i("Ficheros", vivienda.toString());
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
                }
            }
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

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}