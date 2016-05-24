package com.crom.encuesta.view_controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.custom.DialogPersonasXCuarto;
import com.crom.encuesta.view_controller.fragment.CualOtroFragment;

public class ViviendaHogarActivity extends AppCompatActivity {

    CualOtroFragment otro = new CualOtroFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda_hogar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Spinners
        final Spinner tipoVivienda = (Spinner) findViewById(R.id.tipo_vivienda);
        final Spinner viviendaDondeHabita = (Spinner) findViewById(R.id.vivienda_habita_es);
        Spinner materialPiso = (Spinner) findViewById(R.id.material_pisos);
        Spinner materialExteriores = (Spinner) findViewById(R.id.material_exteriores);
        Spinner serviciosVivienda = (Spinner) findViewById(R.id.servicios_vivienda);
        Spinner aguaConsumo = (Spinner) findViewById(R.id.agua_consumo);
        Spinner aguaOtrasActividades = (Spinner) findViewById(R.id.agua_otras_actividades);
        Spinner eliminanBasuras = (Spinner) findViewById(R.id.como_eliminan_basura);
        Spinner servicioSanitarioHogar = (Spinner) findViewById(R.id.servicio_sanitario_hogar);
        Spinner sanitarioUtilizaVivienda = (Spinner) findViewById(R.id.servicio_sanitario_viviendas);
        Spinner energiaCocina = (Spinner) findViewById(R.id.energia_cocina);
        Spinner serviciosBienesHogar = (Spinner) findViewById(R.id.servicios_bienes_hogar);

        //Otros componentes
        EditText mensualidadArriendo = (EditText) findViewById(R.id.mensualidad_arriendo);
        EditText cuartosVivienda = (EditText) findViewById(R.id.cuartos_vivienda);
        TextView personasXCuarto = (TextView) findViewById(R.id.personas_cuarto_vivienda);
        //Configuraciones Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tipo_vivienda__array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.vivienda_habita_es_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.material_pisos_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,R.array.material_exteriores_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,R.array.servicios_vivienda_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,R.array.agua_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this,R.array.agua_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this,R.array.como_eliminan_basura_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this,R.array.servicio_sanitario_hogar_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this,R.array.servicio_sanitario_viviendas_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this,R.array.energia_cocina_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this,R.array.servicios_bienes_hogar_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoVivienda.setAdapter(adapter);
        viviendaDondeHabita.setAdapter(adapter2);
        materialPiso.setAdapter(adapter3);
        materialExteriores.setAdapter(adapter4);
        serviciosVivienda.setAdapter(adapter5);
        aguaConsumo.setAdapter(adapter6);
        aguaOtrasActividades.setAdapter(adapter7);
        eliminanBasuras.setAdapter(adapter8);
        servicioSanitarioHogar.setAdapter(adapter9);
        sanitarioUtilizaVivienda.setAdapter(adapter10);
        energiaCocina.setAdapter(adapter11);
        serviciosBienesHogar.setAdapter(adapter12);
        viviendaDondeHabita.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            FragmentManager fragmentManager = ViviendaHogarActivity.this.getSupportFragmentManager();
            boolean bandera = false;

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == viviendaDondeHabita.getCount() - 1) {
                    fragmentManager.beginTransaction().add(R.id.content_otro, otro).commit();
                    bandera = true;
                } else if (bandera) {
                    fragmentManager.beginTransaction().remove(otro).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        personasXCuarto.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Log.i("#################", "Focus");
                DialogPersonasXCuarto dialogPersonasXCuarto = new DialogPersonasXCuarto();
                dialogPersonasXCuarto.getDialog().show();
                return false;
            }
        });
        personasXCuarto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }
    public void next(View v){

    }
}