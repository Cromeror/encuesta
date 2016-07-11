package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadoinsuficienfiaHorasFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Ocupado ocupado;

    public OcupadoinsuficienfiaHorasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ocupados_insuficiencia_horas, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE6));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {
        ocupado = ((MainActivity) getActivity()).getOcupado();
        final EditText otro = (EditText) view.findViewById(R.id.otro);
        otro.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> spinner_adapter_si_no = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> spinner_adapter_si_no_nosabe = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no_nosabe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner insuficiencia_1 = (Spinner) view.findViewById(R.id.insuficiencia_1);
        final Spinner insuficiencia_2 = (Spinner) view.findViewById(R.id.insuficiencia_8_spinner);
        final Spinner insuficiencia_3 = (Spinner) view.findViewById(R.id.insuficiencia_3_spinner);
        final Spinner insuficiencia_4 = (Spinner) view.findViewById(R.id.insuficiencia_4_spinner);
        Spinner insuficiencia_6 = (Spinner) view.findViewById(R.id.insuficiencia_6_spinner);
        Spinner insuficiencia_7 = (Spinner) view.findViewById(R.id.insuficiencia_7_spinner);


        insuficiencia_1.setAdapter(spinner_adapter_si_no);
        insuficiencia_2.setAdapter(spinner_adapter_si_no);
        insuficiencia_3.setAdapter(spinner_adapter_si_no);
        insuficiencia_4.setAdapter(spinner_adapter_si_no);
        insuficiencia_6.setAdapter(spinner_adapter_si_no);
        insuficiencia_7.setAdapter(spinner_adapter_si_no_nosabe);

        insuficiencia_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    insuficiencia_2.setVisibility(View.GONE);
                    insuficiencia_3.setVisibility(View.GONE);


                    TextView insuficiencia_8_textView = (TextView) view.findViewById(R.id.insuficiencia_8_textView);
                    TextView insuficiencia_2_textView = (TextView) view.findViewById(R.id.insuficiencia_2_textView);
                    TextView insuficiencia_3_textView = (TextView) view.findViewById(R.id.insuficiencia_3_textView);

                    EditText insucifiencia_2_editText = (EditText) view.findViewById(R.id.insuficiencia_2_editText);

                    insucifiencia_2_editText.setVisibility(View.GONE);
                    insuficiencia_2_textView.setVisibility(View.GONE);
                    insuficiencia_3_textView.setVisibility(View.GONE);
                    insuficiencia_8_textView.setVisibility(View.GONE);


                } else {
                    insuficiencia_2.setVisibility(View.VISIBLE);
                    insuficiencia_3.setVisibility(View.VISIBLE);


                    TextView insuficiencia_8_textView = (TextView) view.findViewById(R.id.insuficiencia_8_textView);
                    TextView insuficiencia_2_textView = (TextView) view.findViewById(R.id.insuficiencia_2_textView);
                    TextView insuficiencia_3_textView = (TextView) view.findViewById(R.id.insuficiencia_3_textView);


                    EditText insucifiencia_2_editText = (EditText) view.findViewById(R.id.insuficiencia_2_editText);

                    insucifiencia_2_editText.setVisibility(View.VISIBLE);
                    insuficiencia_2_textView.setVisibility(View.VISIBLE);
                    insuficiencia_3_textView.setVisibility(View.VISIBLE);
                    insuficiencia_8_textView.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        insuficiencia_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    transaction.replace(R.id.contenedor, new CalidadEmpleoFragment()).commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save()) {
                    Log.i("Insuficiencia Horas", ocupado.toString());
                    transaction.replace(R.id.contenedor, new CalidadEmpleoFragment()).commit();
                }
            }
        });
    }


    private boolean save() {
        String dato = "";
        Spinner spinner = (Spinner) view.findViewById(R.id.insuficiencia_1);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE49(dato);
        if (dato.equalsIgnoreCase("no"))
            return save53();
        ocupado.setE50(((EditText) view.findViewById(R.id.insuficiencia_2_editText)).getText().toString());
        spinner = (Spinner) view.findViewById(R.id.insuficiencia_8_spinner);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE51(dato);
        spinner = (Spinner) view.findViewById(R.id.insuficiencia_3_spinner);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE52(dato);
        return save53();
    }

    public boolean save53() {
        String dato = "";
        Spinner spinner = (Spinner) view.findViewById(R.id.insuficiencia_4_spinner);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE53(dato);
        if (dato.equalsIgnoreCase("no")) {
            return true;
        }
        ArrayList<String> list54 = new ArrayList<>();
        CheckBox checkBox1 = (CheckBox) view.findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.checkBox4);
        CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.checkBox5);
        CheckBox checkBox6 = (CheckBox) view.findViewById(R.id.checkBox6);
        CheckBox checkBox7 = (CheckBox) view.findViewById(R.id.checkBox7);
        CheckBox checkBox8 = (CheckBox) view.findViewById(R.id.checkBox8);
        CheckBox checkBox9 = (CheckBox) view.findViewById(R.id.checkBox9);
        // CheckBox checkBox9 = (CheckBox) view.findViewById(R.id.che);
        if (checkBox1.isChecked())
            list54.add(checkBox1.getText().toString());
        if (checkBox2.isChecked())
            list54.add(checkBox2.getText().toString());
        if (checkBox3.isChecked())
            list54.add(checkBox3.getText().toString());
        if (checkBox4.isChecked())
            list54.add(checkBox4.getText().toString());
        if (checkBox5.isChecked())
            list54.add(checkBox5.getText().toString());
        if (checkBox6.isChecked())
            list54.add(checkBox6.getText().toString());
        if (checkBox7.isChecked())
            list54.add(checkBox7.getText().toString());
        if (checkBox8.isChecked())
            list54.add(checkBox8.getText().toString());
        if (checkBox9.isChecked())
            list54.add(((EditText) view.findViewById(R.id.otro)).getText().toString());
        ocupado.setE54(list54);
        spinner = (Spinner) view.findViewById(R.id.insuficiencia_6_spinner);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE55(dato);
        spinner = (Spinner) view.findViewById(R.id.insuficiencia_7_spinner);
        dato = spinner.getSelectedItem().toString();
        ocupado.setE56(dato);
        return true;
    }
}
