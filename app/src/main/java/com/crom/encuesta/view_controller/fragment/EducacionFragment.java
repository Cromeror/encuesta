package com.crom.encuesta.view_controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * Created by Katherine Buelvas on 15/04/16.
 */
public class EducacionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_educacion, container, false);

        Spinner nivelEducativo = (Spinner) view.findViewById(R.id.nivel_educativo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);

        Spinner tituloMayor = (Spinner) view.findViewById(R.id.mayor_titulo_obtenido);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.titulo_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tituloMayor.setAdapter(adapter2);

        return view;
    }
}
