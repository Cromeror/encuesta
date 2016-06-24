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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InactivosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    EditText otro3,otro7,dinero;

    public InactivosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inactivos, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();

        otro3 = (EditText) view.findViewById(R.id.etext_inactivos_3);
        otro7 = (EditText) view.findViewById(R.id.etext_inactivos_7);
        dinero = (EditText) view.findViewById(R.id.etext_inactivos_10);
        final LinearLayout oculto1 = (LinearLayout) view.findViewById(R.id.inactivos_saltar1);

        Switch swt1 = (Switch) view.findViewById(R.id.switch_inactivos_1);
        final Switch swt5 = (Switch) view.findViewById(R.id.switch_inactivos_5);



        swt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    oculto1.setVisibility(View.VISIBLE);
                    swt5.setVisibility(View.GONE);
                }
                else{
                    oculto1.setVisibility(View.GONE);
                    swt5.setVisibility(View.VISIBLE);
                }
            }
        });

        final Spinner sp6 = (Spinner) view.findViewById(R.id.spiner_inactivos_6);
        final Spinner sp7 = (Spinner) view.findViewById(R.id.spiner_inactivos_7);

        Switch swt4 = (Switch) view.findViewById(R.id.switch_inactivos_4);
        swt4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    sp6.setVisibility(View.VISIBLE);
                }
                else{
                    sp6.setVisibility(View.GONE);
                }
            }
        });

        swt5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    sp6.setVisibility(View.VISIBLE);
                    sp7.setVisibility(View.VISIBLE);
                }
                else{
                    sp6.setVisibility(View.GONE);
                    sp7.setVisibility(View.GONE);
                }
            }
        });

        Switch swt8 = (Switch) view.findViewById(R.id.switch_inactivos_8);
        final Spinner sp9 = (Spinner) view.findViewById(R.id.spiner_inactivos_9);
        final TextView txv = (TextView) view.findViewById(R.id.txv_inactivos_9);
        swt8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    txv.setVisibility(View.VISIBLE);
                    sp9.setVisibility(View.VISIBLE);
                }
                else{
                    txv.setVisibility(View.GONE);
                    sp9.setVisibility(View.GONE);
                }
            }
        });

        Switch swt10 = (Switch) view.findViewById(R.id.switch_inactivos_10);
        swt10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dinero.setVisibility(View.VISIBLE);
                }
                else{
                    dinero.setVisibility(View.GONE);
                }
            }
        });

        Spinner ina_2 = (Spinner) view.findViewById(R.id.spiner_inactivos_2);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.trabajo_ultima_vez_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ina_2.setAdapter(adapter2);

        Spinner ina_3 = (Spinner) view.findViewById(R.id.spiner_inactivos_3);
            ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.porque_dejo_trabajo_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ina_3.setAdapter(adapter3);

            ina_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if(position==8)
                        otro3.setVisibility(View.VISIBLE);
                    else
                        otro3.setVisibility(View.GONE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        Spinner ina_6 = (Spinner) view.findViewById(R.id.spiner_inactivos_6);
            ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.trabajo_ultima_vez_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ina_6.setAdapter(adapter6);

        Spinner ina_7 = (Spinner) view.findViewById(R.id.spiner_inactivos_7);
            ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.razon_dejo_buscar_trabajo_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ina_7.setAdapter(adapter7);

            ina_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(position==11)
                        otro7.setVisibility(View.VISIBLE);
                    else
                        otro7.setVisibility(View.GONE);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        Spinner ina_9 = (Spinner) view.findViewById(R.id.spiner_inactivos_9);
            ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.fondos_afiliados_actualmente_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ina_9.setAdapter(adapter9);

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
