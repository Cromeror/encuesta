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
 * A simple {@link Fragment} subclass.
 */
public class FuerzaFragment extends Fragment {
    private static final String PARAM_EDAD = "Edad";
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public FuerzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fuerza, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();
        return view;


    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transaction.replace(R.id.contenedor, SaludFragment.newInstance(edad)).commit();
                /*Intent i = new Intent(v.getContext(),FamilyActivity.class);
                startActivity(i);*/

                transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
            }
        });
    }

}
