package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicsFragment extends Fragment {
    public View view;
    private FragmentTransaction transaction;

    public TicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tics, container, false);
        getActivity().setTitle(getString(R.string.capMHogarI));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        init();

        return view;
    }

    private void init() {
        Spinner tics_1 = (Spinner) view.findViewById(R.id.spiner_tic_1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_1_2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_1.setAdapter(adapter1);

        Spinner tics_2 = (Spinner) view.findViewById(R.id.spiner_tic_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_1_2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_2.setAdapter(adapter2);
        final LinearLayout ocultar = (LinearLayout) view.findViewById(R.id.tic_ocultar);
        tics_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ocultar.setVisibility(View.VISIBLE);
                } else {
                    ocultar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner tics_5 = (Spinner) view.findViewById(R.id.spiner_tic_5);
        adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_5, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_5.setAdapter(adapter2);

        Button next = (Button) view.findViewById(R.id.next_gnrl_btn);
        Log.i("##", "Mas adelante se le presentarán las opciones que puede colocar en la barra de acciones");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new ActionFormFragment()).commit();
            }
        });
    }

}
