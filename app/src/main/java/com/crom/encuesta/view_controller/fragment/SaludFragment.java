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
public class SaludFragment extends Fragment {

    private static final String PARAM_EDAD = "Edad";
    private int edad = 0;
    private Button next ;

    private FragmentTransaction transaction;

    public SaludFragment() {
        // Required empty public constructor
    }

    public static SaludFragment newInstance(int edad) {
        SaludFragment fragment = new SaludFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_EDAD, edad);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salud, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarB));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        edad = getArguments().getInt(PARAM_EDAD);
        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();
        return view;
    }

    private void init(){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edad >= 3)
                    transaction.replace(R.id.contenedor, new EducacionFragment()).commit();
            }
        });
    }
}
