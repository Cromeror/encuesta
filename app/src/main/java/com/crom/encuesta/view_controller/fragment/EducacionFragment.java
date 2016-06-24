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
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;

/**
 * Created by Katherine Buelvas on 15/04/16.
 */
public class EducacionFragment extends Fragment {
    private Button next;
    private FragmentTransaction transaction;
    private Spinner nivelEducativo, estudia, leerEscribir, spinnerEstablecimiento;
    private Spinner tituloMayor;
private LinearLayout contentEstablecimiento;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_educacion, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarC));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();
        contentEstablecimiento = ((LinearLayout) view.findViewById(R.id.content_establecimiento));
        leerEscribir = (Spinner) view.findViewById(R.id.leer_escribir);
        ArrayAdapter<CharSequence> adapterLeer = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapterLeer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leerEscribir.setAdapter(adapterLeer);
        estudia = (Spinner) view.findViewById(R.id.estudia);
        ArrayAdapter<CharSequence> adapterEstudia = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapterEstudia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estudia.setAdapter(adapterEstudia);
        estudia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean isChecked = false;

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 1:
                        if (isChecked == false) {
                            contentEstablecimiento.setVisibility(View.VISIBLE);
                            isChecked = true;
                        }
                        break;
                    case 2:
                        if (isChecked == true) {
                            contentEstablecimiento.setVisibility(View.GONE);
                            isChecked = false;
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        tituloMayor = (Spinner) view.findViewById(R.id.mayor_titulo_obtenido);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.titulo_educativo_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tituloMayor.setAdapter(adapter2);

        spinnerEstablecimiento = (Spinner) view.findViewById(R.id.establecimiento_educativo);
        ArrayAdapter<CharSequence> adapterEstablecimiento = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapterEstablecimiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstablecimiento.setAdapter(adapterEstablecimiento);
        nivelEducativo = (Spinner) view.findViewById(R.id.nivel_educativo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);
        nivelEducativo.setSelection(4);
        nivelEducativo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position >= 6) {
                    if (save(false)){
                        transaction.replace(R.id.contenedor, new FuerzaFragment()).commit();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        return view;
    }

    private boolean save(boolean b) {

        if (nivelEducativo.getSelectedItemPosition() == 0
                || leerEscribir.getSelectedItemPosition() == 0 || estudia.getSelectedItemPosition() == 0) {
            (new DialogBuilder()).dialogIncompleteField(getActivity(), getString(R.string.incomplete));
            return false;
        } else {
            if(b && tituloMayor.getSelectedItemPosition() == 0){
                (new DialogBuilder()).dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                return false;
            }
            if(contentEstablecimiento.getVisibility() == View.VISIBLE && spinnerEstablecimiento.getSelectedItemPosition() == 0){
               (new DialogBuilder()).dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                return false;
            }else {
                Log.i("INPUT", ((MainActivity) getActivity()).getVivienda().toString());
            }
        }
        return true;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save(true)) {
                    transaction.replace(R.id.contenedor, new FuerzaFragment()).commit();
                }
            }
        });
    }
}
