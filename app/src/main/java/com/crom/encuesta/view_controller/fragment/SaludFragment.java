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
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

import java.util.ArrayList;

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
        /*if (edad < 3) {
            transaction.add(R.id.content_btn, new ActionFormFragment()).commit();
        }*/
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
                if (position == 1) {
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
                if (position == 1) {
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
                if (save(spinner1, spinner2, spinner3, spinner4)) {
                    transaction.replace(R.id.contenedor, new EducacionFragment()).commit();
                } else {
                    if (edad < 3) {
                        transaction.add(R.id.contenedor, new TicsFragment()).commit();
                    } else {
                        DialogBuilder builder = new DialogBuilder();
                        builder.dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                    }
                }
            }
        });
    }

    private boolean save(Spinner... spinners) {
        if (!Validador.validarSpinner(spinners[0])) {
            salud.setAfiliado(spinners[0].getSelectedItem().toString());
            if (spinners[0].getSelectedItem().toString().equals("Si")) {
                if (Validador.validarSpinner(spinners[1])) {
                    return false;
                }
                salud.setRegimenAfiliado(spinners[1].getSelectedItem().toString());
            }
        }else {
            return false;
        }

        if (!Validador.validarSpinner(spinners[2])) {
            salud.setAtencionESE(spinners[2].getSelectedItem().toString());
            if (spinners[2].getSelectedItem().toString().equals("Si")) {
                if (Validador.validarSpinner(spinners[3])) {
                    return false;
                }
                salud.setComentarioAtencionESE(spinners[3].getSelectedItem().toString());
            }
        }else {
            return false;
        }
        return true;
    }
}
