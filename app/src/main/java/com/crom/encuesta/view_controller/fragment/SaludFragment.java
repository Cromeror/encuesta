package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.model.Salud;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaludFragment extends Fragment {

    private static final String PARAM_EDAD = "Edad";
    private View view;
    private int edad = 0;
    private Button next;
    private Salud salud;

    private FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_salud, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarB));
        Miembro miembro = ((MainActivity) getActivity()).getVivienda().getLastHogar().getLastMiembro();
        salud = new Salud();
        miembro.setSalud(salud);
        edad = Integer.parseInt(miembro.getEdad());
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();
        return view;
    }

    private void init() {
        final Spinner spinner1 = (Spinner) view.findViewById(R.id.afiliacion);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_nosabe_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        final Spinner spinner2 = (Spinner) view.findViewById(R.id.regimen_afiliado);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.salud2_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        final Spinner spinner3 = (Spinner) view.findViewById(R.id.recibio_atencion_hospital_sanjose);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_nosabe_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        final Spinner spinner4 = (Spinner) view.findViewById(R.id.atencion_hospital_sanjose);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.atencion_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    ((LinearLayout) view.findViewById(R.id.salud2)).setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.salud2)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    ((LinearLayout) view.findViewById(R.id.salud4)).setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.salud4)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner[] spinners = {spinner1, spinner2, spinner3, spinner4};
                salud.setAfiliado(spinner1.getSelectedItem().toString());
                for (int i = 0; i < spinners.length; i++) {
                    if (spinners[i].getVisibility() == View.VISIBLE) {
                        switch (i) {
                            case 0:
                                salud.setAfiliado(spinner1.getSelectedItem().toString());
                                break;
                            case 1:
                                salud.setRegimenAfiliado(spinner2.getSelectedItem().toString());
                                break;
                            case 2:
                                salud.setAtencionESE(spinner3.getSelectedItem().toString());
                                break;
                            case 3:
                                salud.setComentarioAtencionESE(spinner4.getSelectedItem().toString());
                                break;
                        }
                    }
                }
                if (edad >= 3) {
                    Log.i("INPUT", ((MainActivity) getActivity()).getVivienda().toString());
                    transaction.replace(R.id.contenedor, new EducacionFragment()).commit();
                }else {
                    Log.i("INPUT", ((MainActivity) getActivity()).getVivienda().toString());
                    transaction.replace(R.id.contenedor, new ActionFormFragment()).commit();
                }
            }
        });
    }
}
