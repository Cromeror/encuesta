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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OcupadoFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;

    public OcupadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ocupado, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        vivienda = ((MainActivity) getActivity()).getVivienda();

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        Spinner ocupado_4 = (Spinner) view.findViewById(R.id.ocupado_4);
        ArrayAdapter<CharSequence> spinner_adapter_4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_4.setAdapter(spinner_adapter_4);
        ocupado_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    Spinner ocupado_5 = (Spinner) view.findViewById(R.id.ocupado_5);
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
                    Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
                    EditText ocupado_9 = (EditText) view.findViewById(R.id.ocupado_9);
                    Switch ocupado_10 = (Switch) view.findViewById(R.id.ocupado_10);
                    CheckBox ocupado_11_a = (CheckBox) view.findViewById(R.id.ocupado_11_a);
                    CheckBox ocupado_11_b = (CheckBox) view.findViewById(R.id.ocupado_11_b);
                    CheckBox ocupado_11_c = (CheckBox) view.findViewById(R.id.ocupado_11_c);
                    TextView ocupado_5_text = (TextView) view.findViewById(R.id.ocupado_5_texto);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    TextView ocupado_7_text = (TextView) view.findViewById(R.id.ocupado_7_texto);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    TextView ocupado_9_text = (TextView) view.findViewById(R.id.ocupado_9_texto);
                    TextView ocupado_11_text = (TextView) view.findViewById(R.id.ocupado_11_texto);


                    ocupado_5.setVisibility(View.GONE);
                    ocupado_6.setVisibility(View.GONE);
                    ocupado_7.setVisibility(View.GONE);
                    ocupado_8.setVisibility(View.GONE);
                    ocupado_9.setVisibility(View.GONE);
                    ocupado_10.setVisibility(View.GONE);
                    ocupado_11_a.setVisibility(View.GONE);
                    ocupado_11_b.setVisibility(View.GONE);
                    ocupado_11_c.setVisibility(View.GONE);
                    ocupado_5_text.setVisibility(View.GONE);
                    ocupado_6_text.setVisibility(View.GONE);
                    ocupado_7_text.setVisibility(View.GONE);
                    ocupado_8_text.setVisibility(View.GONE);
                    ocupado_9_text.setVisibility(View.GONE);
                    ocupado_11_text.setVisibility(View.GONE);

                } else {
                    Spinner ocupado_5 = (Spinner) view.findViewById(R.id.ocupado_5);
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
                    Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
                    EditText ocupado_9 = (EditText) view.findViewById(R.id.ocupado_9);
                    Switch ocupado_10 = (Switch) view.findViewById(R.id.ocupado_10);
                    CheckBox ocupado_11_a = (CheckBox) view.findViewById(R.id.ocupado_11_a);
                    CheckBox ocupado_11_b = (CheckBox) view.findViewById(R.id.ocupado_11_b);
                    CheckBox ocupado_11_c = (CheckBox) view.findViewById(R.id.ocupado_11_c);
                    TextView ocupado_5_text = (TextView) view.findViewById(R.id.ocupado_5_texto);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    TextView ocupado_7_text = (TextView) view.findViewById(R.id.ocupado_7_texto);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    TextView ocupado_9_text = (TextView) view.findViewById(R.id.ocupado_9_texto);
                    TextView ocupado_11_text = (TextView) view.findViewById(R.id.ocupado_11_texto);


                    ocupado_5.setVisibility(View.VISIBLE);
                    ocupado_6.setVisibility(View.VISIBLE);
                    ocupado_7.setVisibility(View.VISIBLE);
                    ocupado_8.setVisibility(View.VISIBLE);
                    ocupado_9.setVisibility(View.VISIBLE);
                    ocupado_10.setVisibility(View.VISIBLE);
                    ocupado_11_a.setVisibility(View.VISIBLE);
                    ocupado_11_b.setVisibility(View.VISIBLE);
                    ocupado_11_c.setVisibility(View.VISIBLE);
                    ocupado_5_text.setVisibility(View.VISIBLE);
                    ocupado_6_text.setVisibility(View.VISIBLE);
                    ocupado_7_text.setVisibility(View.VISIBLE);
                    ocupado_8_text.setVisibility(View.VISIBLE);
                    ocupado_9_text.setVisibility(View.VISIBLE);
                    ocupado_11_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
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

        Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
        ArrayAdapter spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_6, android.R.layout.simple_spinner_item);
        spinner_adapter_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_6.setAdapter(spinner_adapter_6);

        Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
        ArrayAdapter spinner_adapter_8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_8, android.R.layout.simple_spinner_item);
        spinner_adapter_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_8.setAdapter(spinner_adapter_8);

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
                } else {
                    Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_8);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    ocupado_8.setVisibility(View.VISIBLE);
                    ocupado_8_text.setVisibility(View.VISIBLE);
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
                    save();
                    transaction.replace(R.id.contenedor, new OcupadoIndependienteFragment()).commit();
                }
                if (scountry.equalsIgnoreCase("Trabajador familiar sin remuneración")) {
                    save();
                    transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                save();
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosFragment()).commit();
            }
        });
    }

    private void save() {
        EditText ocupado = (EditText) view.findViewById(R.id.que_hace_trabajo);
        String dato = ocupado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 1);
        ocupado = (EditText) view.findViewById(R.id.nombre_empresa_negocio);
        dato = ocupado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 2);
        ocupado = (EditText) view.findViewById(R.id.serivios_empresa_dedica);
        dato = ocupado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 3);
        Spinner ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_4);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 4);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_4);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 4);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_5);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 5);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_6);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 6);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_7);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 7);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_8);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 8);
        ocupado = (EditText) view.findViewById(R.id.ocupado_9);
        dato = ocupado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 9);
        Switch ocupado_switch = (Switch) view.findViewById(R.id.ocupado_10);
        if (ocupado_switch.isChecked()) dato = "si";
        else dato = "no";
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 10);
        dato = "";
        CheckBox checkBox1 = (CheckBox) view.findViewById(R.id.ocupado_11_a);
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.ocupado_11_b);
        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.ocupado_11_c);
        if (checkBox1.isChecked())
            dato = checkBox1.getText().toString();
        else if (checkBox2.isChecked())
            dato = dato + "," + checkBox2.getText().toString();
        else if (checkBox3.isChecked()) dato = dato + "," + checkBox3.getText().toString();
        if (",".equalsIgnoreCase(String.valueOf(dato.charAt(0)))) dato = dato.substring(1);
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 11);
        ocupado = (EditText) view.findViewById(R.id.tiempo_enla_empresa);
        dato = ocupado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 12);
        ocupado_spinner = (Spinner) view.findViewById(R.id.ocupado_12);
        dato = ocupado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 13);
    }


}
