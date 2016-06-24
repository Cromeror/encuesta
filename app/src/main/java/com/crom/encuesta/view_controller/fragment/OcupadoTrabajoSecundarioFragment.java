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

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadoTrabajoSecundarioFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public OcupadoTrabajoSecundarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupados_trabajo_secundario, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capEOcupado));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();

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


        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new ActionFormFragment()).commit();
            }
        });
    }

}
