package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalidadEmpleoFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;

    public CalidadEmpleoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calidad_empleo, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        vivienda = ((MainActivity) getActivity()).getVivienda();

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();

        Spinner empl_57a = (Spinner) view.findViewById(R.id.empleo_57a);
        Spinner empl_57b = (Spinner) view.findViewById(R.id.empleo_57b);
        Spinner empl_57c = (Spinner) view.findViewById(R.id.empleo_57c);
        Spinner empl_57d = (Spinner) view.findViewById(R.id.empleo_57d);
        Spinner empl_57e = (Spinner) view.findViewById(R.id.empleo_57e);
        Spinner empl_57f = (Spinner) view.findViewById(R.id.empleo_57f);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_57, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_57a.setAdapter(adapter);
        empl_57b.setAdapter(adapter);
        empl_57c.setAdapter(adapter);
        empl_57d.setAdapter(adapter);
        empl_57e.setAdapter(adapter);
        empl_57f.setAdapter(adapter);

        Spinner empl_59 = (Spinner) view.findViewById(R.id.empleo_59);
        ArrayAdapter<CharSequence> adapter59 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_59, android.R.layout.simple_spinner_item);
        adapter59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_59.setAdapter(adapter59);

        Spinner empl_60 = (Spinner) view.findViewById(R.id.empleo_60);
        ArrayAdapter<CharSequence> adapter60 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_60, android.R.layout.simple_spinner_item);
        adapter60.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_60.setAdapter(adapter60);

        Spinner empl_61 = (Spinner) view.findViewById(R.id.empleo_61);
        ArrayAdapter<CharSequence> adapter61 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_61, android.R.layout.simple_spinner_item);
        adapter61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_61.setAdapter(adapter61);

        final EditText ed61 = (EditText) view.findViewById(R.id.otro_61);
        empl_61.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==9){
                    ed61.setVisibility(View.VISIBLE);
                }
                else{
                    ed61.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                transaction.replace(R.id.contenedor, new CalidadEmpleoFragment()).commit();
            }
        });
    }

    private void save() {
        String dato = "a.";
        Spinner calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57a);
        dato = dato + calidad_spinner.getSelectedItem().toString();
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57b);
        dato = dato + ",b." + calidad_spinner.getSelectedItem().toString();
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57c);
        dato = dato + ",c." + calidad_spinner.getSelectedItem().toString();
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57d);
        dato = dato + ",d." + calidad_spinner.getSelectedItem().toString();
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57e);
        dato = dato + ",e." + calidad_spinner.getSelectedItem().toString();
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_57f);
        dato = dato + ",f." + calidad_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 57);
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_59);
        dato = calidad_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 59);
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_60);
        dato = calidad_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 60);
        calidad_spinner = (Spinner) view.findViewById(R.id.empleo_61);
        dato = calidad_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 61);
        Switch asalariado_switch = (Switch) view.findViewById(R.id.alimentacion_switch);
        if (asalariado_switch.isChecked()) {
            vivienda.getLastHogar().getLastMiembro().getOcupado().setE("si", 58);
        } else vivienda.getLastHogar().getLastMiembro().getOcupado().setE("no", 58);
    }

}
