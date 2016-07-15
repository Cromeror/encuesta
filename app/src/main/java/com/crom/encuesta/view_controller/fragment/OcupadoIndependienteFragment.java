package com.crom.encuesta.view_controller.fragment;


import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Ocupado;
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
    private Ocupado ocupado;


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
        ocupado = ((MainActivity) getActivity()).getOcupado();
        final EditText otro_1 = (EditText) view.findViewById(R.id.idependientes_24_otro);
        final EditText otro_28 = (EditText) view.findViewById(R.id.otro_editText_28);
        otro_1.setVisibility(View.GONE);
        otro_28.setVisibility(View.GONE);

        Spinner independientes_24 = (Spinner) view.findViewById(R.id.independientes_24_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.independientes_1, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_24.setAdapter(spinner_adapter_1);
        independientes_24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                if (position == 1) {
                    Spinner indepedientes_2 = (Spinner) view.findViewById(R.id.independientes_25_spinner);
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.GONE);
                } else if (position == 7) {
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.GONE);
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l24)).setVisibility(View.VISIBLE);
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Spinner independientes_25 = (Spinner) view.findViewById(R.id.independientes_25_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_25.setAdapter(spinner_adapter_2);
        independientes_25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();
                ImageButton calendar25a = (ImageButton) view.findViewById(R.id.calendar_btn);

                if (scountry.equalsIgnoreCase("no")) {
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_25a_editText);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);
                    independientes_3.setVisibility(View.GONE);
                    independientes_3_text.setVisibility(View.GONE);
                    calendar25a.setVisibility(View.GONE);
                } else {
                    EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_25a_editText);
                    TextView independientes_3_text = (TextView) view.findViewById(R.id.independientes_3_textView);
                    independientes_3.setVisibility(View.VISIBLE);
                    independientes_3_text.setVisibility(View.VISIBLE);
                    calendar25a.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        final Calendar myCalendar = Calendar.getInstance();
        EditText independientes_3 = (EditText) view.findViewById(R.id.independientes_25a_editText);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker v, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                ((EditText) view.findViewById(R.id.independientes_25a_editText)).setText(sdf.format(myCalendar.getTime()));
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

        Spinner independientes_28 = (Spinner) view.findViewById(R.id.independientes_28_spinner);
        ArrayAdapter<CharSequence> spinner_adapter_28 = ArrayAdapter.createFromResource(getActivity(),
                R.array.independientes_6, android.R.layout.simple_spinner_item);
        spinner_adapter_28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        independientes_28.setAdapter(spinner_adapter_28);
        independientes_28.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_28.setVisibility(View.VISIBLE);
                }else
                    otro_28.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
            }
        });
    }

    private boolean save() {
        String dato = "";
        Spinner spinner = (Spinner) view.findViewById(R.id.independientes_24_spinner);
        if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro);
            dato = otro.getText().toString();
        }
        ocupado.setE24(dato);
        if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")
                && !spinner.getSelectedItem().toString().equalsIgnoreCase("Trabajó por honorarios o prestación de servicios")){
            spinner = (Spinner) view.findViewById(R.id.independientes_25_spinner);
            if (spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
                ocupado.setE25(spinner.getSelectedItem().toString());
                EditText independientes25a = (EditText) view.findViewById(R.id.independientes_25a_editText);
                ocupado.setE25a(independientes25a.getText().toString());
            } else
                ocupado.setE25(spinner.getSelectedItem().toString());
        }

        ocupado.setE26(((EditText) view.findViewById(R.id.independientes_26_editText)).getText().toString());
        ocupado.setE27(((EditText) view.findViewById(R.id.independientes_27_editText)).getText().toString());
        spinner = (Spinner) view.findViewById(R.id.independientes_28_spinner);
        if (!spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro_editText_28);
            dato = otro.getText().toString();
        }
        ocupado.setE28(dato);
        ocupado.setMiembroId(((MainActivity)getActivity()).getOcupado().getId());
        Log.i("Ocupado Independiente", ocupado.toString());
        return true;
    }

}
