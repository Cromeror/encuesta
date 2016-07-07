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

import com.crom.encuesta.R;
import com.crom.encuesta.model.Miembro;
import com.crom.encuesta.persistence.MiembroDAO;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

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
        generales1.setSelection(3);
        final Spinner generales5 = (Spinner) view.findViewById(R.id.generales5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity(), R.array.generales5, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generales5.setAdapter(adapter5);
        generales5.setSelection(8);
        final Spinner generales6 = (Spinner) view.findViewById(R.id.generales6);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(), R.array.generales6, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generales6.setAdapter(adapter6);
        generales6.setSelection(6);
        final TextView textView = (TextView) view.findViewById(R.id.generales2);
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
                textView.setText(sdf.format(myCalendar.getTime()));
                if (calcularEdad(textView.getText().toString()) > 0) {
                    editTextEdad.setText(calcularEdad(textView.getText().toString()) + "");
                    isMayor(Integer.parseInt(editTextEdad.getText().toString()));
                } else {
                    editTextEdad.setText("0");
                }
            }
        };
        textView.setOnClickListener(new View.OnClickListener() {
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
                    textView.setText(calcularNacimiento(Integer.parseInt(editTextEdad.getText().toString())));
                    isMayor(Integer.parseInt(editTextEdad.getText().toString()));
                }
            }
        });

        final EditText nacimiento = (EditText) view.findViewById(R.id.generales4);

        editTextEdad.setText("");
        Button next = (Button) view.findViewById(R.id.next_gnrl_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).isActivado()){
                    if (Validador.validarSpinner(generales1, generales5)
                            || Validador.isEmptyEditText(editTextEdad,nacimiento)
                            || textView.getText().toString().equals(getString(R.string.touch_me))) {
                        (new DialogBuilder()).dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                    } else {
                        if (Integer.parseInt(editTextEdad.getText().toString()) < 10) {
                            Miembro miembro = new Miembro();
                            ((MainActivity) getActivity()).getVivienda().getLastHogar().getMiembros().add(miembro);
                            miembro.setSexo(generales1.getSelectedItem().toString());
                            miembro.setParentesco(generales5.getSelectedItem().toString());
                            miembro.setLugarNacimiento(((EditText) view.findViewById(R.id.generales4)).getText().toString());
                            miembro.setEdad(editTextEdad.getText().toString());
                            miembro.setNacimiento(textView.getText().toString());
                            MiembroDAO.getInstance().insert(miembro, ((MainActivity)getActivity()).getDb());
                            Log.i("Vivienda toString", ((MainActivity)getActivity()).toString());
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new SaludFragment()).commit();
                        }else {
                            if(!Validador.validarSpinner(generales6)){
                                Miembro miembro = new Miembro();
                                ((MainActivity) getActivity()).getVivienda().getLastHogar().getMiembros().add(miembro);
                                miembro.setSexo(generales1.getSelectedItem().toString());
                                miembro.setParentesco(generales5.getSelectedItem().toString());
                                miembro.setEstadoCivil(generales6.getSelectedItem().toString());
                                miembro.setLugarNacimiento(((EditText) view.findViewById(R.id.generales4)).getText().toString());
                                miembro.setEdad(editTextEdad.getText().toString());
                                miembro.setNacimiento(textView.getText().toString());
                                ((MainActivity)getActivity()).setMiembro(miembro);
                                miembro.setHogarId(((MainActivity)getActivity()).getHogar().getId());
                                MiembroDAO.getInstance().insert(miembro, ((MainActivity)getActivity()).getDb());
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new SaludFragment()).commit();
                            }else
                                (new DialogBuilder()).dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                        }
                    }
                }else {
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
        }else {
            ((LinearLayout) view.findViewById(R.id.mayor)).setVisibility(View.GONE);
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