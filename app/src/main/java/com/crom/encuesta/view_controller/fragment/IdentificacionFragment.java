package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdentificacionFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.a_fragment_identificacion, container, false);
        vivienda = ((MainActivity) getActivity()).getVivienda();
        getActivity().setTitle(getActivity().getString(R.string.capA));

        Spinner zona = (Spinner) view.findViewById(R.id.spiner_zona);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.zona_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zona.setAdapter(adapter);
        final EditText numHogares = (EditText) view.findViewById(R.id.editText_num_hogares);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_identificacion_btn);
        init();
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        vivienda.setDepartamento(getString(R.string.dpt_value));
        vivienda.setMunicipio(getString(R.string.municipio_value));
        vivienda.setZona(((Spinner)view.findViewById(R.id.spiner_zona)).getSelectedItem().toString());
        String barrio = ((EditText) view.findViewById(R.id.identi_barrio_corregimiento)).getText().toString();
        String sector = ((EditText) view.findViewById(R.id.identi_sector_vereda)).getText().toString();
        String direccion = ((EditText) view.findViewById(R.id.identi_direccion)).getText().toString();

        if(!barrio.equals("") && !sector.equals("")  && !direccion.equals("")){
            vivienda.setBarrio(barrio);
            vivienda.setSector(sector);
            vivienda.setDireccion(direccion);
            transaction.replace(R.id.contenedor, new ViviendaHogarFragment()).commit();
        }else {
            ((MainActivity) getActivity()).dialogIncompleteField();
        }
        Log.i("####SAVE####", vivienda.toString());
    }

}