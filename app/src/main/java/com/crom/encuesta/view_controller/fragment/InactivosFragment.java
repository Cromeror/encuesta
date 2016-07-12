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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Inactivo;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InactivosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;

    private Inactivo inactivo = new Inactivo();
    EditText otro3, otro7, dinero;

    public InactivosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inactivos, container, false);
        getActivity().setTitle(getString(R.string.capMHogarG));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {
        vivienda = ((MainActivity) getActivity()).getVivienda();
        otro3 = (EditText) view.findViewById(R.id.etext_inactivos_3);
        otro7 = (EditText) view.findViewById(R.id.etext_inactivos_7);
        dinero = (EditText) view.findViewById(R.id.etext_inactivos_10);
        final LinearLayout oculto1 = (LinearLayout) view.findViewById(R.id.inactivos_saltar1);
        oculto1.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner inactivos1 = (Spinner) view.findViewById(R.id.spinner_inactivos_1);
        inactivos1.setAdapter(adapter);
        inactivos1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                ((Spinner) view.findViewById(R.id.spinner_inactivos_5)).setSelection(1);
                ((LinearLayout) view.findViewById(R.id.l_6)).setVisibility(View.VISIBLE);
                ((LinearLayout) view.findViewById(R.id.l_7)).setVisibility(View.VISIBLE);
                if (position == 2) {
                    oculto1.setVisibility(View.GONE);
                    ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_5)).setVisibility(View.VISIBLE);
                } else {
                    oculto1.setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_5)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner inactivos4 = (Spinner) view.findViewById(R.id.spinner_inactivos_4);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inactivos4.setAdapter(adapter);
        inactivos4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

                if (position == 1) {
                    ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_5)).setVisibility(View.GONE);
                }

                if (position == 2) {
                    ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.GONE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_5)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner inactivos5 = (Spinner) view.findViewById(R.id.spinner_inactivos_5);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inactivos5.setAdapter(adapter);
        inactivos5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position == 2) {
                    ((LinearLayout) view.findViewById(R.id.l_6)).setVisibility(View.GONE);
                    ((LinearLayout) view.findViewById(R.id.l_7)).setVisibility(View.GONE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l_6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l_7)).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner inactivos8 = (Spinner) view.findViewById(R.id.spinner_inactivos_8);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.inactivo_8_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inactivos8.setAdapter(adapter);
        inactivos8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position != 0) {
                    ((LinearLayout) view.findViewById(R.id.l_9)).setVisibility(View.GONE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l_9)).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner inactivos10 = (Spinner) view.findViewById(R.id.spinner_inactivos_10);
        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inactivos10.setAdapter(adapter);
        inactivos10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position == 1) {
                    dinero.setVisibility(View.VISIBLE);
                } else {
                    dinero.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ina_2 = (Spinner) view.findViewById(R.id.spinner_inactivos_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.trabajo_ultima_vez_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ina_2.setAdapter(adapter2);

        Spinner ina_3 = (Spinner) view.findViewById(R.id.spinner_inactivos_3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.porque_dejo_trabajo_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ina_3.setAdapter(adapter3);

        ina_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 8)
                    otro3.setVisibility(View.VISIBLE);
                else
                    otro3.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ina_6 = (Spinner) view.findViewById(R.id.spinner_inactivos_6);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.trabajo_ultima_vez_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ina_6.setAdapter(adapter6);

        Spinner ina_7 = (Spinner) view.findViewById(R.id.spinner_inactivos_7);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.razon_dejo_buscar_trabajo_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ina_7.setAdapter(adapter7);

        ina_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 11)
                    otro7.setVisibility(View.VISIBLE);
                else
                    otro7.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ina_9 = (Spinner) view.findViewById(R.id.spinner_inactivos_9);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fondos_afiliados_actualmente_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ina_9.setAdapter(adapter9);
        ((TextView) view.findViewById(R.id.inactivos_1_textview)).requestFocus();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save()) {
                    SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());

                    transaction.replace(R.id.contenedor, new OtrosIngresosFragment()).commit();
                }else
                    Toast.makeText(getActivity(), "Error al guardar los datos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean save() {
        Spinner i1 = (Spinner) view.findViewById(R.id.spinner_inactivos_1);
        Spinner i2 = (Spinner) view.findViewById(R.id.spinner_inactivos_2);
        Spinner i3 = (Spinner) view.findViewById(R.id.spinner_inactivos_3);
        Spinner i4 = (Spinner) view.findViewById(R.id.spinner_inactivos_4);
        Spinner i5 = (Spinner) view.findViewById(R.id.spinner_inactivos_5);
        Spinner i6 = (Spinner) view.findViewById(R.id.spinner_inactivos_6);
        Spinner i7 = (Spinner) view.findViewById(R.id.spinner_inactivos_7);
        Spinner i8 = (Spinner) view.findViewById(R.id.spinner_inactivos_8);
        Spinner i9 = (Spinner) view.findViewById(R.id.spinner_inactivos_9);
        Spinner i10 = (Spinner) view.findViewById(R.id.spinner_inactivos_10);
        ((LinearLayout) view.findViewById(R.id.l_5)).setVisibility(View.VISIBLE);
        ((LinearLayout) view.findViewById(R.id.l_5_6)).setVisibility(View.VISIBLE);


        inactivo.setG(i1.getSelectedItem().toString(), 0);
        if (((LinearLayout) view.findViewById(R.id.inactivos_saltar1)).getVisibility() == View.VISIBLE) {
            inactivo.setG(i2.getSelectedItem().toString(), 1);
            if (i3.getSelectedItemPosition() == 8)
                inactivo.setG(((EditText) view.findViewById(R.id.etext_inactivos_3)).getText().toString(), 2);
            else
                inactivo.setG(i3.getSelectedItem().toString(), 2);
            inactivo.setG(i4.getSelectedItem().toString(), 3);
        } else {
            inactivo.setG(i5.getSelectedItem().toString(), 4);
        }

        if (((LinearLayout) view.findViewById(R.id.l_6)).getVisibility() == View.VISIBLE) {
            inactivo.setG(i6.getSelectedItem().toString(), 5);
        }
        if (((LinearLayout) view.findViewById(R.id.l_7)).getVisibility() == View.VISIBLE) {
            if (i7.getSelectedItemPosition() == 11)
                inactivo.setG(((EditText) view.findViewById(R.id.etext_inactivos_7)).getText().toString(), 6);
            else
                inactivo.setG(i7.getSelectedItem().toString(), 6);
        }

        inactivo.setG(i8.getSelectedItem().toString(), 7);
        //Log.i("Inactivo9", ((LinearLayout) view.findViewById(R.id.l_9)).getVisibility()+"");
        if (((LinearLayout) view.findViewById(R.id.l_9)).getVisibility() == View.GONE) {
            if (i10.getSelectedItemPosition() == 1)
                inactivo.setG(((EditText) view.findViewById(R.id.etext_inactivos_10)).getText().toString(), 9);
            else
                inactivo.setG(i10.getSelectedItem().toString(), 9);
        } else {
            inactivo.setG(i9.getSelectedItem().toString(), 8);
            if (i10.getSelectedItemPosition() == 1)
                inactivo.setG(((EditText) view.findViewById(R.id.etext_inactivos_10)).getText().toString(), 9);
            else
                inactivo.setG(i10.getSelectedItem().toString(), 9);
        }
        inactivo.setMiembroId(((MainActivity) getActivity()).getMiembro().getId());
        ((MainActivity)getActivity()).getMiembro().setInactivo(inactivo);
        Log.i("Inactivo", inactivo.toString());
        return true;
    }
}
