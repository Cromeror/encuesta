package com.crom.encuesta.view_controller.subFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta2OtroFragment;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta2_1;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta3;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta4;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta5;
import com.crom.encuesta.view_controller.fragment.form_vivienda.Pregunta6a8Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta2SubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta2SubFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SELECTED = "param1";

    // TODO: Rename and change types of parameters
    private int selected;


    public Pregunta2SubFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Pregunta2SubFragment newInstance(int selected) {
        Pregunta2SubFragment fragment = new Pregunta2SubFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED, selected);;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selected = getArguments().getInt(ARG_SELECTED);
            init();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.subfragment_pregunta2, container, false);
    }
    private void init(){
        switch (selected){
            case 0:
                getFragmentManager().beginTransaction().replace(R.id.pregunta3,new Pregunta3()).commit();
                getFragmentManager().beginTransaction().replace(R.id.pregunta4, new Pregunta4()).commit();
                break;
            case 1:
                getFragmentManager().beginTransaction().replace(R.id.pregunta2_5, new Pregunta2_1()).commit();
                getFragmentManager().beginTransaction().replace(R.id.pregunta3,new Pregunta3()).commit();
                getFragmentManager().beginTransaction().replace(R.id.pregunta4, new Pregunta4()).commit();
                break;
            case 2:
                getFragmentManager().beginTransaction().replace(R.id.pregunta5, new Pregunta5()).commit();
                break;
            case 3:
                getFragmentManager().beginTransaction().replace(R.id.pregunta4, new Pregunta4()).commit();
                break;
            case 4:
                getFragmentManager().beginTransaction().replace(R.id.pregunta4, new Pregunta4()).commit();
                break;
            case 5:
                getFragmentManager().beginTransaction().replace(R.id.pregunta2_otro, new Pregunta2OtroFragment()).commit();
                break;
        }
        getFragmentManager().beginTransaction().replace(R.id.pregunta6a8, new Pregunta6a8Fragment()).commit();
    }

}
