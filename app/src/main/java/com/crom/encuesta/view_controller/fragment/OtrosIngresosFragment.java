package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtrosIngresosFragment extends Fragment {

    private Button next;
    private FragmentTransaction transaction;

    public OtrosIngresosFragment() {
        // Required empty public constructor
    }

private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_otros_ingresos, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        getActivity().setTitle(getString(R.string.capMHogarH));
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }
    public void init(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner otros1 = (Spinner) view.findViewById(R.id.otros_ingresos1);
        otros1.setAdapter(adapter);
        Spinner otros2a = (Spinner) view.findViewById(R.id.otros_ingresos2a);
        otros2a.setAdapter(adapter);
        Spinner otros2b = (Spinner) view.findViewById(R.id.otros_ingresos2b);
        otros2b.setAdapter(adapter);
        Spinner otros2c = (Spinner) view.findViewById(R.id.otros_ingresos2c);
        otros2c.setAdapter(adapter);

        final EditText Totros2a = (EditText) view.findViewById(R.id.otros_text2a);
        final EditText Totros2b = (EditText) view.findViewById(R.id.otros_text2b);
        final EditText Totros2c = (EditText) view.findViewById(R.id.otros_text2c);


        otros2a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    Totros2a.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2a.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        otros2b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    Totros2b.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2b.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        otros2c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    Totros2c.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2c.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save();
                transaction.replace(R.id.contenedor, new TicsFragment()).commit();
            }
        });
    }

}
