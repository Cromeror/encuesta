package com.crom.encuesta.view_controller.fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViviendaHogarFragment extends Fragment {
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;


    private ArrayList<String> personasCuarto = new ArrayList<String>();

    private TextView textView5;
    private DialogBuilder builder = new DialogBuilder();

    public ViviendaHogarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(getActivity().getString(R.string.capB));
        view = inflater.inflate(R.layout.b_fragment_vivienda_hogar, container, false);
        vivienda = ((MainActivity) getActivity()).getVivienda();
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        init();
        return view;
    }

    private void init() {
        textView5 = (TextView) view.findViewById(R.id.personas_cuarto_vivienda);
        final Spinner spinner1 = (Spinner) view.findViewById(R.id.tipo_vivienda);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.tipo_vivienda__array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setSelection(5);
        final Spinner spinner2 = (Spinner) view.findViewById(R.id.vivienda_habita_es);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.vivienda_habita_es_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(6);
        final Spinner spinner6 = (Spinner) view.findViewById(R.id.material_pisos);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.material_pisos_array, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);
        spinner6.setSelection(5);
        final Spinner spinner7 = (Spinner) view.findViewById(R.id.material_exteriores);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.material_exteriores_array, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);
        spinner7.setSelection(9);
        final EditText editText4 = (EditText) view.findViewById(R.id.cuartos_vivienda);
        editText4.setOnKeyListener(new View.OnKeyListener() {
            boolean band = true;

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    try {
                        int numeroCuartos = Integer.parseInt(editText4.getText().toString());
                        if (band) {
                            personasCuarto.clear();
                            for (int i = 0; i < numeroCuartos; i++) {
                                getDialog();
                            }
                            if (numeroCuartos == 0)
                                vivienda.setCuartos(new ArrayList<String>());
                            else
                                textView5.setBackgroundColor(Color.WHITE);
                            band = false;
                        }
                    } catch (Exception e) {
                        Toast.makeText(view.getContext(), "Debe digitar un numero mayor que cero", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
        textView5.setBackgroundColor(Color.RED);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText4.getText().toString().equals("") && !editText4.getText().toString().equals("0")) {
                    int numeroCuartos = Integer.parseInt(editText4.getText().toString());
                    personasCuarto.clear();
                    for (int i = 0; i < numeroCuartos; i++) {
                        getDialog();
                    }
                    textView5.setBackgroundColor(Color.WHITE);
                } else {
                    builder.dialogIncompleteField(getActivity(), "Debe digitar el numero de cuartos");
                }
            }
        });
        final TextView textView8 = (TextView) view.findViewById(R.id.servicios_vivienda);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBuilder dialogBuilder = new DialogBuilder();
                dialogBuilder.MultipleChoiceList(ViviendaHogarFragment.class, textView8, getActivity(), "", R.array.servicios_vivienda_array);
            }
        });
        textView8.setBackgroundColor(Color.RED);
        textView8.setText(getString(R.string.touch_me));
        Button next = (Button) view.findViewById(R.id.next_vivienda_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).isActivado()) {
                    if (!Validador.validarSpinner(spinner1, spinner2, spinner6, spinner7) &&
                            !Validador.isEmptyEditText(editText4, ((EditText) view.findViewById(R.id.mensualidad_arriendo)))
                            && !((TextView) view.findViewById(R.id.personas_cuarto_vivienda)).equals("Informacion persona por cuarto")
                            && !Validador.isEmptyMultiChoice(textView8)) {
                        if (!editText4.getText().toString().equals(personasCuarto.size() + "")) {
                            builder.dialogIncompleteField(getActivity(), "El numero de cuartos y los datos almacenados por cuarto no concuerdan");
                        } else {
                            vivienda.setTipoVivienda(spinner1.getSelectedItem().toString());
                            vivienda.setPropiedadVivienda(spinner2.getSelectedItem().toString());
                            vivienda.setCuantoPagan(((EditText) view.findViewById(R.id.mensualidad_arriendo)).getText().toString());
                            vivienda.setCuartos(personasCuarto);
                            vivienda.setMaterialPisos(spinner6.getSelectedItem().toString());
                            vivienda.setMaterialParedesExteriores(spinner7.getSelectedItem().toString());
                            transaction.replace(R.id.contenedor, new CaracteristicaHogarFragment()).commit();
                        }
                    } else {
                        builder.dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                    }
                } else {
                    transaction.replace(R.id.contenedor, new CaracteristicaHogarFragment()).commit();
                }
            }
        });
    }

    public void getDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.b5_dialog);
        dialog.setTitle(getContext().getString(R.string.personas_cuarto_vivienda));
        Button aceptar = (Button) dialog.findViewById(R.id.dialog_btn);
        final EditText editText = (EditText) dialog.findViewById(R.id.personas_dialog);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    personasCuarto.add(editText.getText().toString());
                    textView5.setText(personasCuarto.toString());
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

}

