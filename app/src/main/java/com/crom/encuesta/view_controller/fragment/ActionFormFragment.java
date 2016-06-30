package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActionFormFragment extends Fragment {
    private Button next, hogar, miembro;
    private View view;
    private FragmentTransaction transaction;

    public ActionFormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_action_form, container, false);
        next = (Button) view.findViewById(R.id.finish_btn);
        miembro = (Button) view.findViewById(R.id.miembro_btn);
        hogar = (Button) view.findViewById(R.id.hogar_btn);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        init();
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new ViviendaHogarFragment()).commit();
            }
        });
        miembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new MiembroHogarFragment()).commit();
            }
        });
        hogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new IdentificacionFragment()).commit();
            }
        });
    }

}