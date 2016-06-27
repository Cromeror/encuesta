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

import org.w3c.dom.Text;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadosAsalariadosIndependientesFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;


    public OcupadosAsalariadosIndependientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        EditText otro_14 = (EditText) view.findViewById(R.id.asalariados_independientes_14_editText);
        otro_14.setVisibility(View.GONE);
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupados_asalariados_independientes, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capEOcupado));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        vivienda = ((MainActivity) getActivity()).getVivienda();

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();

        Spinner asalariado_independiente_3 = (Spinner) view.findViewById(R.id.asalariado_independiente_3_spinner);
        ArrayAdapter spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_3, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_3.setAdapter(spinner_adapter_1);
        asalariado_independiente_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.asalariado_independiente_3_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Spinner asalariado_independiente_5 = (Spinner) view.findViewById(R.id.asalariado_independiente_5_spinner);
        ArrayAdapter spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_5, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_5.setAdapter(spinner_adapter_2);

        Spinner asalariado_independiente_7 = (Spinner) view.findViewById(R.id.asalariado_independiente_7_spinner);
        spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_7, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_7.setAdapter(spinner_adapter_2);

        Spinner asalariado_independiente_8 = (Spinner) view.findViewById(R.id.asalariado_independiente_8_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_8, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_8.setAdapter(spinner_adapter_1);
        asalariado_independiente_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.asalariado_independiente_8_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner asalariado_independiente_9 = (Spinner) view.findViewById(R.id.asalariados_independientes_9_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_9, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_9.setAdapter(spinner_adapter_1);
        asalariado_independiente_9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.asalariados_independientes_9_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner asalariado_independiente_10 = (Spinner) view.findViewById(R.id.asalariados_independientes_10_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_10, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_10.setAdapter(spinner_adapter_1);
        asalariado_independiente_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item


                if (scountry.equalsIgnoreCase("No")) {
                    hide_38();
                }
                if (scountry.equalsIgnoreCase("Ya es pensionado")) {
                    hide_38();
                    CheckBox a = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_a);
                    CheckBox b = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_b);
                    CheckBox c = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_c);
                    CheckBox d = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_d);
                    CheckBox e = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_e);
                    CheckBox f = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_f);
                    CheckBox g = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_g);
                    CheckBox h = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_h);
                    EditText asalariado_independiente_14_editText = (EditText) view.findViewById(R.id.asalariados_independientes_14_editText);
                    TextView asalariado_independiente_14_textView = (TextView) view.findViewById(R.id.asalariados_independientes_14_textView);

                    asalariado_independiente_14_editText.setVisibility(View.GONE);
                    asalariado_independiente_14_textView.setVisibility(View.GONE);
                    a.setVisibility(View.GONE);
                    b.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    d.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    h.setVisibility(View.GONE);
                    g.setVisibility(View.GONE);
                }
                if (scountry.equalsIgnoreCase("Si")) {
                    show_38();
                    CheckBox a = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_a);
                    CheckBox b = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_b);
                    CheckBox c = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_c);
                    CheckBox d = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_d);
                    CheckBox e = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_e);
                    CheckBox f = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_f);
                    CheckBox g = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_g);
                    CheckBox h = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_h);
                    EditText asalariado_independiente_14_editText = (EditText) view.findViewById(R.id.asalariados_independientes_14_editText);
                    TextView asalariado_independiente_14_textView = (TextView) view.findViewById(R.id.asalariados_independientes_14_textView);

                    asalariado_independiente_14_editText.setVisibility(View.VISIBLE);
                    asalariado_independiente_14_textView.setVisibility(View.VISIBLE);
                    a.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    d.setVisibility(View.VISIBLE);
                    e.setVisibility(View.VISIBLE);
                    f.setVisibility(View.VISIBLE);
                    h.setVisibility(View.VISIBLE);
                    g.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner asalariado_independiente_11 = (Spinner) view.findViewById(R.id.asalariados_independientes_11_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_11, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_11.setAdapter(spinner_adapter_1);

        Spinner asalariado_independiente_12 = (Spinner) view.findViewById(R.id.asalariados_independientes_12_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_12, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_12.setAdapter(spinner_adapter_1);

        final CheckBox asalariados_independientes_14_otro = (CheckBox) view.findViewById(R.id.asalariados_independientes_14_g);
        asalariados_independientes_14_otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (asalariados_independientes_14_otro.isChecked()) {
                    EditText otro_14 = (EditText) view.findViewById(R.id.asalariados_independientes_14_editText);
                    otro_14.setVisibility(View.VISIBLE);
                } else {
                    EditText otro_14 = (EditText) view.findViewById(R.id.asalariados_independientes_14_editText);
                    otro_14.setVisibility(View.GONE);
                }
            }
        });

        Spinner asalariado_independiente_15 = (Spinner) view.findViewById(R.id.asalariados_independientes_15_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_15.setAdapter(spinner_adapter_1);

        Spinner asalariado_independiente_16 = (Spinner) view.findViewById(R.id.asalariados_independientes_16_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_16.setAdapter(spinner_adapter_1);


        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new OcupadoTrabajoSecundarioFragment()).commit();
            }
        });
    }

    private void hide_38() {
        EditText a = (EditText) view.findViewById(R.id.asalariados_independientes_13_editText);
        Spinner b = (Spinner) view.findViewById(R.id.asalariados_independientes_11_spinner);
        Spinner c = (Spinner) view.findViewById(R.id.asalariados_independientes_12_spinner);
        TextView d = (TextView) view.findViewById(R.id.asalariados_independientes_13_textView);
        TextView e = (TextView) view.findViewById(R.id.asalariados_independientes_11_textView);
        TextView f = (TextView) view.findViewById(R.id.asalariados_independientes_12_textView);

        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
        d.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        f.setVisibility(View.GONE);
    }

    private void show_38() {
        EditText a = (EditText) view.findViewById(R.id.asalariados_independientes_13_editText);
        Spinner b = (Spinner) view.findViewById(R.id.asalariados_independientes_11_spinner);
        Spinner c = (Spinner) view.findViewById(R.id.asalariados_independientes_12_spinner);
        TextView d = (TextView) view.findViewById(R.id.asalariados_independientes_13_textView);
        TextView e = (TextView) view.findViewById(R.id.asalariados_independientes_11_textView);
        TextView f = (TextView) view.findViewById(R.id.asalariados_independientes_12_textView);

        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);
        d.setVisibility(View.VISIBLE);
        e.setVisibility(View.VISIBLE);
        f.setVisibility(View.VISIBLE);
    }

    private void save() {

    }

}
