package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crom.encuesta.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class CaracteristicaHogarFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public CaracteristicaHogarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle(getActivity().getString(R.string.capHogarA));
        view = inflater.inflate(R.layout.fragment_caracterisitca_hogar, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_vivienda_btn);
        init();
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new MiembroHogarFragment()).commit();
            }
        });
    }

}
