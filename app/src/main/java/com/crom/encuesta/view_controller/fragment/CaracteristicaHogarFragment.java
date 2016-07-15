package com.crom.encuesta.view_controller.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Hogar;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class CaracteristicaHogarFragment extends Fragment {
    private View view;
    private FragmentTransaction transaction;
    private Hogar hogar;

    public CaracteristicaHogarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(getActivity().getString(R.string.capHogarA));
        view = inflater.inflate(R.layout.fragment_caracterisitca_hogar, container, false);
        hogar = new Hogar();
        ((MainActivity) getActivity()).getVivienda().getHogares().add(hogar);
        ((MainActivity) getActivity()).setHogar(hogar);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        init();
        return view;
    }

    private void init() {
        ((MainActivity) getActivity()).getVivienda().getHogares().add(hogar);
        EditText editText1 = (EditText) view.findViewById(R.id.cuantos_miembros);
        final TextView textView2 = (TextView) view.findViewById(R.id.servicios_bienes_hogar);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBuilder builder = new DialogBuilder();
                builder.MultipleChoiceList(CaracteristicaHogarFragment.class, textView2,  getActivity(), "Servicios y bienes", R.array.servicios_bienes_hogar_array);
            }
        });
        textView2.setBackgroundColor(Color.RED);
        final Spinner spinner3 = (Spinner) view.findViewById(R.id.agua_consumo);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.agua_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setSelection(10);
        final Spinner spinner4 = (Spinner) view.findViewById(R.id.agua_otras_actividades);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.agua_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setSelection(10);
        final Spinner spinner5 = (Spinner) view.findViewById(R.id.como_eliminan_basura);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity(),
                R.array.como_eliminan_basura_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setSelection(5);
        final Spinner spinner6 = (Spinner) view.findViewById(R.id.servicio_sanitario_hogar);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.servicio_sanitario_hogar_array, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);
        spinner6.setSelection(6);
        final Spinner spinner7 = (Spinner) view.findViewById(R.id.servicio_sanitario_viviendas);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.servicio_sanitario_viviendas_array, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);
        spinner7.setSelection(2);
        final Spinner spinner8 = (Spinner) view.findViewById(R.id.energia_cocinan);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.energia_cocina_array, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);
        spinner8.setSelection(8);
        textView2.setText(getString(R.string.touch_me));
        Button next = (Button) view.findViewById(R.id.next_vivienda_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity)getActivity()).isActivado()){
                    if (!Validador.isEmptySpinners(spinner3, spinner4, spinner5, spinner6,  spinner7 , spinner8)
                            && !Validador.isEmptyMultiChoice(textView2)) {
                        hogar.setAguaConsumo(spinner3.getSelectedItem().toString());
                        hogar.setAguaOtroUso(spinner4.getSelectedItem().toString());
                        hogar.setBasura(spinner5.getSelectedItem().toString());
                        hogar.setSanitarioHogar(spinner6.getSelectedItem().toString());
                        hogar.setSanitarioVivienda(spinner7.getSelectedItem().toString());
                        hogar.setEnergiaCocinan(spinner8.getSelectedItem().toString());
                        hogar.setViviendaId(((MainActivity)getActivity()).getVivienda().getId());
//                        HogarDAO.getInstance().insert(hogar,((MainActivity)getActivity()).getDb());
                        ((MainActivity)getActivity()).setHogar(hogar);
                        transaction.replace(R.id.contenedor, new MiembroHogarFragment()).commit();
                    }else{
                        DialogBuilder builder = new DialogBuilder();
                        builder.dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                    }
                }else {
                    transaction.replace(R.id.contenedor, new MiembroHogarFragment()).commit();
                }
            }
        });
    }
}
