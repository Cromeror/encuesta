package com.crom.encuesta.view_controller.fragment.form_vivienda;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.ViviendaActivity;
import com.crom.encuesta.view_controller.enums.ViviendaArray;


public class Pregunta6a8Fragment extends Fragment {
    private Spinner pregunta6;
    private Spinner pregunta7;
    private Spinner pregunta8;

    public Pregunta6a8Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_pregunta6a8, container, false);
        pregunta6 = (Spinner) view.findViewById(R.id.material_piso_vivienda);
        pregunta6.setAdapter(ViviendaActivity.getAdapter(view.getContext(), ViviendaArray.material_piso_vivienda));
        pregunta7 = (Spinner) view.findViewById(R.id.material_paredes_exteriores);
        pregunta7.setAdapter(ViviendaActivity.getAdapter(view.getContext(), ViviendaArray.material_paredes_exteriores));
        pregunta8 = (Spinner) view.findViewById(R.id.servicios_vivienda);
        pregunta8.setAdapter(ViviendaActivity.getAdapter(view.getContext(), ViviendaArray.servicios_vivienda));
        return view;
    }
}
