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
public class OcupadosAsalariadosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;


    public OcupadosAsalariadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupado, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capEOcupado));

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();

        Spinner asalariados_1 = (Spinner) view.findViewById(R.id.asalariado_1);
        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_1, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariados_1.setAdapter(spinner_adapter_1);

        ArrayAdapter<CharSequence> spinner_adapter_si_no_noSabe = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no_noSabe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> spinner_adapter_si_no = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner asalariados_4 = (Spinner) view.findViewById(R.id.asalariado_4);
        asalariados_4.setAdapter(spinner_adapter_si_no_noSabe);

        Spinner asalariados_5 = (Spinner) view.findViewById(R.id.asalariado_5);
        asalariados_5.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView asalariado_5_text = (TextView) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_5_text.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_6 = (Spinner) view.findViewById(R.id.asalariado_6);
        asalariados_6.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView asalariado_6_text = (TextView) view.findViewById(R.id.asalariado_6_editText);
                    asalariado_6_text.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_7 = (Spinner) view.findViewById(R.id.asalariado_7);
        asalariados_7.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView asalariado_7_text = (TextView) view.findViewById(R.id.asalariado_7_editText);
                    asalariado_7_text.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_8 = (Spinner) view.findViewById(R.id.asalariado_8);
        asalariados_8.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView asalariado_8_text = (TextView) view.findViewById(R.id.asalariado_8_editText);
                    asalariado_8_text.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner alimentacion = (Spinner) view.findViewById(R.id.alimentacion_spinner);
        alimentacion.setAdapter(spinner_adapter_si_no);
        alimentacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView alimentacion_editText = (TextView) view.findViewById(R.id.alimentacion_editText);
                    alimentacion_editText.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner transporte = (Spinner) view.findViewById(R.id.trasnporte_spinner);
        transporte.setAdapter(spinner_adapter_si_no);
        transporte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView transporte_editText = (TextView) view.findViewById(R.id.transporte_editText);
                    transporte_editText.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner familiar = (Spinner) view.findViewById(R.id.familiar_spinner);
        familiar.setAdapter(spinner_adapter_si_no);
        familiar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView familiar_editText = (TextView) view.findViewById(R.id.familiar_editText);
                    familiar_editText.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner educativo = (Spinner) view.findViewById(R.id.educativo_spinner);
        educativo.setAdapter(spinner_adapter_si_no);
        educativo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.educativo_editText);
                    educativo_editText.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Switch alimentacion_switch = (Switch) view.findViewById(R.id.alimentacion_switch);
        alimentacion_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    alimentacion.setVisibility(View.VISIBLE);
                    TextView alimentacion_textView = (TextView) view.findViewById(R.id.alimentacion_textView);
                    alimentacion_textView.setVisibility(View.VISIBLE);
                    EditText alimantacion_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
                    alimantacion_editText.setVisibility(View.VISIBLE);
                }
            }
        });

        Switch trasnporte_switch = (Switch) view.findViewById(R.id.trasnporte_switch);
        trasnporte_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    transporte.setVisibility(View.VISIBLE);
                    TextView transporte_textView = (TextView) view.findViewById(R.id.transporte_textView);
                    transporte_textView.setVisibility(View.VISIBLE);
                    EditText transporte_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
                    transporte_editText.setVisibility(View.VISIBLE);
                }
            }
        });

        Switch educativo_switch = (Switch) view.findViewById(R.id.educativo_switch);
        educativo_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    educativo.setVisibility(View.VISIBLE);
                    TextView educativo_textView = (TextView) view.findViewById(R.id.educativo_textView);
                    educativo_textView.setVisibility(View.VISIBLE);
                    EditText educativo_editText = (EditText) view.findViewById(R.id.educativo_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }
        });

        Switch familiar_switch = (Switch) view.findViewById(R.id.familiar_switch);
        familiar_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    familiar.setVisibility(View.VISIBLE);
                    TextView familiar_textView = (TextView) view.findViewById(R.id.familiar_textView);
                    familiar_textView.setVisibility(View.VISIBLE);
                    EditText familiar_editText = (EditText) view.findViewById(R.id.familiar_editText);
                    familiar_editText.setVisibility(View.VISIBLE);
                }
            }
        });


        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosFragment()).commit();
            }
        });
    }

}
