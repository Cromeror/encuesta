package com.crom.encuesta.view_controller.fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiembroHogarFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_miembro_hogar, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarA));

        final Spinner generales1 = (Spinner) view.findViewById(R.id.generales1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.generales1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generales1.setAdapter(adapter1);

        final Spinner generales5 = (Spinner) view.findViewById(R.id.generales5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity(), R.array.generales5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generales5.setAdapter(adapter5);

        final Spinner generales6 = (Spinner) view.findViewById(R.id.generales6);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(), R.array.generales6, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generales6.setAdapter(adapter6);
        final TextView edittext = (TextView) view.findViewById(R.id.generales2);
        final EditText editTextEdad = (EditText) view.findViewById(R.id.edad_gnrl);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                edittext.setText(sdf.format(myCalendar.getTime()));
                if (calcularEdad(edittext.getText().toString()) > 0) {
                    editTextEdad.setText(calcularEdad(edittext.getText().toString()) + "");
                    isMayor(Integer.parseInt(editTextEdad.getText().toString()));
                } else {
                    editTextEdad.setText("0");
                }
            }
        };
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        editTextEdad.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus && !editTextEdad.getText().toString().equals("")) {
                    edittext.setText(calcularNacimiento(Integer.parseInt(editTextEdad.getText().toString())));
                    isMayor(Integer.parseInt(editTextEdad.getText().toString()));
                }
            }
        });

        Button next = (Button) view.findViewById(R.id.next_gnrl_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Miembro miembro = new Miembro();
                ((MainActivity) getActivity()).getVivienda().getLastHogar().getMiembros().add(miembro);
                miembro.setSexo(generales1.getSelectedItem().toString());miembro.setParentesco(generales5.getSelectedItem().toString());
                miembro.setEstadoCivil(generales6.getSelectedItem().toString());
                miembro.setLugarNacimiento(((EditText) view.findViewById(R.id.generales4)).getText().toString());
                if (edittext.getText().toString().equals("")&&editTextEdad.getText().toString().equals("")) {
                    (new DialogBuilder()).dialogIncompleteField(getActivity(), "Digite la edad o seleccione la fecha de nacimiento");
                } else {
                    miembro.setEdad(editTextEdad.getText().toString());
                    miembro.setNacimiento(edittext.getText().toString());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new SaludFragment()).commit();
                }
            }
        });
        return view;
    }

    public int calcularEdad(String nacimiento) {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String[] dat1 = nacimiento.split("/");
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            anos = anos - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                anos = anos - 1;
            }
        }
        return anos;
    }

    public void isMayor(int edad) {
        if (edad >= 10) {
            ((LinearLayout) view.findViewById(R.id.mayor)).setVisibility(View.VISIBLE);
        }
    }

    public String calcularNacimiento(int edad) {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - edad;
        int mes = Integer.parseInt(dat2[1]);
        int dia = Integer.parseInt(dat2[0]);
        return dia + "/" + mes + "/" + anos;
    }
}