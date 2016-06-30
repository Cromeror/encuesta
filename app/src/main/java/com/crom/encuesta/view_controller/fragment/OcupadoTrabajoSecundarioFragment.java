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
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadoTrabajoSecundarioFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;

    public OcupadoTrabajoSecundarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupados_trabajo_secundario, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE5));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();


        return view;
    }

    private void init() {
        vivienda = ((MainActivity) getActivity()).getVivienda();
        final EditText otro = (EditText) view.findViewById(R.id.otro);
        otro.setVisibility(View.GONE);
        Spinner secundario_1 = (Spinner) view.findViewById(R.id.secundario_1_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secundario_1.setAdapter(spinner_adapter_1);
        secundario_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    save();
                    transaction.replace(R.id.contenedor, new OcupadoinsuficienfiaHorasFragment()).commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner secundario_3 = (Spinner) view.findViewById(R.id.secundario_3_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.secundario_3, android.R.layout.simple_spinner_item);
        spinner_adapter_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secundario_3.setAdapter(spinner_adapter_3);
        secundario_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save();
                transaction.replace(R.id.contenedor, new OcupadoinsuficienfiaHorasFragment()).commit();
            }
        });
    }

    private void save() {
        String dato = "";
        Spinner secundario_spinner = (Spinner) view.findViewById(R.id.secundario_1_spinner);
        dato = secundario_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 45);
        EditText secundario_editText = (EditText) view.findViewById(R.id.secundario_2_editText);
        dato = secundario_editText.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 46);
        secundario_spinner = (Spinner) view.findViewById(R.id.secundario_3_spinner);
        if (!secundario_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = secundario_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 47);
        secundario_editText = (EditText) view.findViewById(R.id.secundario_4_editText);
        dato = secundario_editText.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 48);

    }

}
