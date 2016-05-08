package com.crom.encuesta.view_controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.subFragment.ListaEdadSubFragment;

public class ViviendaHogarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda_hogar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Spinners
        Spinner tipoVivienda = (Spinner) findViewById(R.id.tipo_vivienda);
        Spinner viviendaDondeHabita = (Spinner) findViewById(R.id.vivienda_habita_es);
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
        EditText personasXCuarto = (EditText) findViewById(R.id.personas_cuarto_vivienda);
        //Configuraciones Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_vivienda__array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoVivienda.setAdapter(adapter);
       ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.vivienda_habita_es_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viviendaDondeHabita.setAdapter(adapter2);
       /* ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);
*/
    }

}
