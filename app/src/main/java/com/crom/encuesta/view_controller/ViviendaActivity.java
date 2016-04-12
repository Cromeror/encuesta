package com.crom.encuesta.view_controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.enums.ViviendaArray;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta2_1;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta3;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta4;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta5;
import com.crom.encuesta.view_controller.subFragment.Pregunta2SubFragment;

public class ViviendaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner pregunta2;
    private Spinner pregunta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vivienda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pregunta1 = (Spinner) findViewById(R.id.tipo_vivienda);
        pregunta1.setAdapter(getAdapter(this,ViviendaArray.tipo_vivienda));
        pregunta2 = (Spinner) findViewById(R.id.propiedad_vivienda);
        pregunta2.setAdapter(getAdapter(this,ViviendaArray.propiedad_vivienda));
        pregunta2.setOnItemSelectedListener(this);
    }
    public static ArrayAdapter getAdapter(Context context ,ViviendaArray viviendaArray){
        ArrayAdapter<CharSequence> adapter = null;
        switch (viviendaArray){
            case tipo_vivienda:
                adapter = ArrayAdapter.createFromResource(context,R.array.tipo_vivienda, android.R.layout.simple_spinner_item);
                break;
            case propiedad_vivienda:
                adapter = ArrayAdapter.createFromResource(context,R.array.propiedad_vivienda, android.R.layout.simple_spinner_item);
                break;
            case material_piso_vivienda:
                adapter = ArrayAdapter.createFromResource(context,R.array.material_piso_vivienda, android.R.layout.simple_spinner_item);
                break;
            case material_paredes_exteriores:
                adapter = ArrayAdapter.createFromResource(context,R.array.material_paredes_exteriores, android.R.layout.simple_spinner_item);
                break;
            case servicios_vivienda:
                adapter = ArrayAdapter.createFromResource(context,R.array.servicios_vivienda, android.R.layout.simple_spinner_item);
                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return  adapter;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.propiedad_vivienda:
                filtroPropiedadVivienda(position);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void filtroPropiedadVivienda(int select){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_subfragment_pregunta2, Pregunta2SubFragment.newInstance(select)).commit();

    }
}
