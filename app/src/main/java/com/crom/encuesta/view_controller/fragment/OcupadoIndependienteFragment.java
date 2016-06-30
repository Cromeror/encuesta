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
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadoIndependienteFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;


    public OcupadoIndependienteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupados_indepedente, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE3));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {

        vivienda = ((MainActivity) getActivity()).getVivienda();
        final EditText otro_1 = (EditText) view.findViewById(R.id.otro_editText_1);
        final EditText otro_6 = (EditText) view.findViewById(R.id.otro_editText_6);
        otro_1.setVisibility(View.GONE);
        otro_6.setVisibility(View.GONE);

        Spinner independientes_1 = (Spinner) view.findViewById(R.id.independientes_1_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.independientes_1, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_1.setAdapter(spinner_adapter_1);
        independientes_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("Trabajó por honorarios o prestación de servicios")) {
                    Spinner indepedientes_2 = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
                    TextView independientes_2_text = (TextView) view.findViewById(R.id.independientes_2_textView);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);

                    indepedientes_2.setVisibility(View.GONE);
                    independientes_2_text.setVisibility(View.GONE);
                    independientes_3.setVisibility(View.GONE);
                    independientes_3_text.setVisibility(View.GONE);
                }
                if (scountry.equalsIgnoreCase("Otro")) {
                    Spinner indepedientes_2 = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
                    TextView independientes_2_text = (TextView) view.findViewById(R.id.independientes_2_textView);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);

                    indepedientes_2.setVisibility(View.GONE);
                    independientes_2_text.setVisibility(View.GONE);
                    independientes_3.setVisibility(View.GONE);
                    independientes_3_text.setVisibility(View.GONE);

                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    Spinner indepedientes_2 = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
                    TextView independientes_2_text = (TextView) view.findViewById(R.id.independientes_2_textView);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);

                    indepedientes_2.setVisibility(View.VISIBLE);
                    independientes_2_text.setVisibility(View.VISIBLE);
                    independientes_3.setVisibility(View.VISIBLE);
                    independientes_3_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner independientes_2 = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
        ArrayAdapter<CharSequence> spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_2.setAdapter(spinner_adapter_2);
        independientes_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);
                    independientes_3.setVisibility(View.GONE);
                    independientes_3_text.setVisibility(View.GONE);
                } else {
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);
                    independientes_3.setVisibility(View.VISIBLE);
                    independientes_3_text.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner independientes_6 = (Spinner) view.findViewById(R.id.independientes_6_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.independientes_6, android.R.layout.simple_spinner_item);
        spinner_adapter_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_6.setAdapter(spinner_adapter_6);
        independientes_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_6.setVisibility(View.VISIBLE);
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
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
            }
        });
    }

    private void save() {
        String dato = "";
        Spinner independientes_spinner = (Spinner) view.findViewById(R.id.independientes_1_spinner);
        if (!independientes_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = independientes_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro_editText_1);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 24);
        independientes_spinner = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
        dato = independientes_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 25);
        EditText idependientes_editText = (EditText) view.findViewById(R.id.independientes_3_editText);
        dato = idependientes_editText.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 26);
        idependientes_editText = (EditText) view.findViewById(R.id.independientes_4_editText);
        dato = idependientes_editText.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 27);
        idependientes_editText = (EditText) view.findViewById(R.id.independientes_5_editText);
        dato = idependientes_editText.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 28);
        independientes_spinner = (Spinner) view.findViewById(R.id.independientes_6_spinner);
        if (!independientes_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = independientes_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro_editText_6);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 29);
    }

}
