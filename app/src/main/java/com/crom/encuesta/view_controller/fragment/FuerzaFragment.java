package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuerzaFragment extends Fragment {
    private static final String PARAM_EDAD = "Edad";
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public FuerzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fuerza, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarD));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();

        Spinner fuerza_1 = (Spinner) view.findViewById(R.id.fuerza_1);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.actividad_ocupo_mayor_tiempo_mayo, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_1.setAdapter(spinner_adapter);
        fuerza_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("trabajando")) {
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }
                if (scountry.equalsIgnoreCase("incapacitado permanentemente para trabajar")) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner fuerza_6 = (Spinner) view.findViewById(R.id.fuerza_6);
        ArrayAdapter spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fuerza_6, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_6.setAdapter(spinner_adapter_6);
        fuerza_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Pidió ayuda a familia, amigos, colegas\n")) {

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner fuerza_8 = (Spinner) view.findViewById(R.id.fuerza_8);
        ArrayAdapter spinner_adapter_8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fuerza_8, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_8.setAdapter(spinner_adapter_8);
        fuerza_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Ya encontré trabajo")) {

                }
                if (scountry.equalsIgnoreCase("Ud. se considera muy joven o muy viejo")) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Switch fuerza_3 = (Switch) view.findViewById(R.id.fuerza_3);
        fuerza_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        Switch fuerza_2 = (Switch) view.findViewById(R.id.fuerza_2);
        fuerza_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        Switch fuerza_4 = (Switch) view.findViewById(R.id.fuerza_4);
        fuerza_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        Switch fuerza_7 = (Switch) view.findViewById(R.id.fuerza_7);
        fuerza_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }
        });
        Switch fuerza_10 = (Switch) view.findViewById(R.id.fuerza_10);
        fuerza_10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        Switch fuerza_11 = (Switch) view.findViewById(R.id.fuerza_11);
        fuerza_11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        Switch fuerza_13 = (Switch) view.findViewById(R.id.fuerza_13);
        fuerza_13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    transaction.replace(R.id.contenedor, new DesocupadosFragment()).commit();
                else {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }
        });


        return view;


    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transaction.replace(R.id.contenedor, SaludFragment.newInstance(edad)).commit();
                /*Intent i = new Intent(v.getContext(),FamilyActivity.class);
                startActivity(i);*/

                transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
            }
        });


    }

}
