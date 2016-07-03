package com.crom.encuesta.view_controller.fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
            public void onItemSelected(AdapterView<?> adapter, View v,int position, long id) {
                if(position==1){ Spinner indepedientes_2 = (Spinner) view.findViewById(R.id.independientes_2_Spinner);
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.GONE);
                }else if (position==7) {
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.VISIBLE);
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.VISIBLE);
                    otro_1.setVisibility(View.GONE);
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
        final Calendar myCalendar = Calendar.getInstance();
        EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_3_editText);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker v, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                ((EditText) view.findViewById(R.id.independientes_3_editText)).setText(sdf.format(myCalendar.getTime()));
            }
        };
        ((ImageButton) view.findViewById(R.id.calendar_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
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
