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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OcupadoFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public OcupadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Switch ocupado_4 = (Switch) view.findViewById(R.id.ocupado_4);
        ocupado_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == false) {
                    Spinner ocupado_5 = (Spinner) view.findViewById(R.id.ocupado_5);
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
                    Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
                    EditText ocupado_9 = (EditText) view.findViewById(R.id.ocupado_9);
                    Switch ocupado_10 = (Switch) view.findViewById(R.id.ocupado_10);
                    TextView ocupado_5_text = (TextView) view.findViewById(R.id.ocupado_5_texto);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    TextView ocupado_7_text = (TextView) view.findViewById(R.id.ocupado_7_texto);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    TextView ocupado_9_text = (TextView) view.findViewById(R.id.ocupado_9_texto);


                    ocupado_5.setVisibility(View.GONE);
                    ocupado_6.setVisibility(View.GONE);
                    ocupado_7.setVisibility(View.GONE);
                    ocupado_8.setVisibility(View.GONE);
                    ocupado_9.setVisibility(View.GONE);
                    ocupado_10.setVisibility(View.GONE);
                    ocupado_5_text.setVisibility(View.GONE);
                    ocupado_6_text.setVisibility(View.GONE);
                    ocupado_7_text.setVisibility(View.GONE);
                    ocupado_8_text.setVisibility(View.GONE);
                    ocupado_9_text.setVisibility(View.GONE);

                }
            }
        });
        Spinner ocupado_5 = (Spinner) view.findViewById(R.id.ocupado_5);
        ArrayAdapter spinner_adapter_5 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_5, android.R.layout.simple_spinner_item);
        spinner_adapter_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_5.setAdapter(spinner_adapter_5);
        ocupado_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Verbal") || scountry.equalsIgnoreCase("No sabe, no informa")) {
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    ocupado_6.setVisibility(View.GONE);
                    ocupado_6_text.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
        ArrayAdapter spinner_adapter_7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_7, android.R.layout.simple_spinner_item);
        spinner_adapter_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_7.setAdapter(spinner_adapter_7);
        ocupado_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Si") || scountry.equalsIgnoreCase("No sabe, no informa")) {
                    Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    ocupado_8.setVisibility(View.GONE);
                    ocupado_8_text.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner ocupado_12 = (Spinner) view.findViewById(R.id.ocupado_12);
        ArrayAdapter spinner_adapter_12 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_12, android.R.layout.simple_spinner_item);
        spinner_adapter_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_12.setAdapter(spinner_adapter_12);
        ocupado_12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Trabajador por cuenta propia") || scountry.equalsIgnoreCase("Otro")) {
                    transaction.replace(R.id.contenedor, new OcupadoIndependienteFragment()).commit();
                }
                if (scountry.equalsIgnoreCase("Trabajador familiar sin remuneración")) {
                    transaction.replace(R.id.contenedor, new OcupadosAsalariadosFragment()).commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ocupado, container, false);
    }


}
