package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

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

        Switch otros1 = (Switch) view.findViewById(R.id.otros_ingresos1);
        Switch otros2a = (Switch) view.findViewById(R.id.otros_ingresos2a);
        Switch otros2b = (Switch) view.findViewById(R.id.otros_ingresos2b);
        Switch otros2c = (Switch) view.findViewById(R.id.otros_ingresos2c);

        final TextView Totros2a = (TextView) view.findViewById(R.id.otros_text2a);
        final TextView Totros2b = (TextView) view.findViewById(R.id.otros_text2b);
        final TextView Totros2c = (TextView) view.findViewById(R.id.otros_text2c);


        otros2a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2a.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2a.setVisibility(View.GONE);
                }
            }
        });

        otros2b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2b.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2b.setVisibility(View.GONE);
                }
            }
        });
        otros2c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2c.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2c.setVisibility(View.GONE);
                }
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
