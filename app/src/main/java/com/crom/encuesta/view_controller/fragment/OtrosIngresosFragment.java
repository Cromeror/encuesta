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
import android.widget.EditText;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.model.OtroIngreso;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtrosIngresosFragment extends Fragment {

    private Button next;
    private FragmentTransaction transaction;

    private EditText t_otros2a;
    private EditText t_otros2b;
    private EditText t_otros2c;
    private Spinner otros2a;
    private Spinner otros1;
    private Spinner otros2c;
    private Spinner otros2b;

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

    public void init() {
        t_otros2a = (EditText) view.findViewById(R.id.otros_text2a);
        t_otros2b = (EditText) view.findViewById(R.id.otros_text2b);
        t_otros2c = (EditText) view.findViewById(R.id.otros_text2c);
        otros2a = (Spinner) view.findViewById(R.id.otros_ingresos2a);
        otros1 = (Spinner) view.findViewById(R.id.otros_ingresos1);
        otros2c = (Spinner) view.findViewById(R.id.otros_ingresos2c);
        otros2b = (Spinner) view.findViewById(R.id.otros_ingresos2b);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        otros1.setAdapter(adapter);
        otros2a.setAdapter(adapter);
        otros2b.setAdapter(adapter);
        otros2c.setAdapter(adapter);

        otros2a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    t_otros2a.setVisibility(View.VISIBLE);
                } else {
                    t_otros2a.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        otros2b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    t_otros2b.setVisibility(View.VISIBLE);
                } else {
                    t_otros2b.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        otros2c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    t_otros2c.setVisibility(View.VISIBLE);
                } else {
                    t_otros2c.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())
                transaction.replace(R.id.contenedor, new TicsFragment()).commit();
            }
        });
    }

    OtroIngreso otroIngreso = new OtroIngreso();

    private boolean save() {
        if (!Validador.isEmptySpinners(otros1, otros2a, otros2b, otros2c)) {
            otroIngreso.setH(otros1.getSelectedItem().toString(), 0);
            if (otros2a.getSelectedItemPosition() == 1)
                otroIngreso.setH(t_otros2a.getText().toString(), 1);
            else otroIngreso.setH(otros2a.getSelectedItem().toString(), 1);
            if (otros2b.getSelectedItemPosition() == 1)
                otroIngreso.setH(t_otros2b.getText().toString(), 2);
            else otroIngreso.setH(otros2b.getSelectedItem().toString(), 2);
            if (otros2c.getSelectedItemPosition() == 1)
                otroIngreso.setH(t_otros2c.getText().toString(), 3);
            else otroIngreso.setH(otros2c.getSelectedItem().toString(), 3);
            otroIngreso.setMiembroId(((MainActivity)getActivity()).getMiembro().getId());
            ((MainActivity)getActivity()).getMiembro().setOtroIngreso(otroIngreso);
            Log.i("Otros Ingresos", otroIngreso.toString());
        } else {
            DialogBuilder builder = new DialogBuilder();
            builder.dialogIncompleteField(getActivity(), getString(R.string.incomplete));
            return false;
        }
        return true;
    }

}