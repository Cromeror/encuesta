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
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OcupadosAsalariadosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    private Ocupado ocupado;
    private Spinner asalariados_19;
    private Spinner asalariados_18;
    private Spinner asalariados_17;
    private Spinner asalariados_16;
    private Spinner asalariados_13;
    private Spinner asalariados_20a2;
    private Spinner asalariados_20b2;
    private Spinner asalariados_20c2;
    private Spinner asalariados_20d2;
    private Spinner asalariados_21a2;
    private Spinner asalariados_21b2;


    public OcupadosAsalariadosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_ocupados_asalariados, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE2));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {
        ocupado = ((MainActivity) getActivity()).getOcupado();
        asalariados_19 = (Spinner) view.findViewById(R.id.asalariado_19);
        asalariados_18 = (Spinner) view.findViewById(R.id.asalariado_18);
        asalariados_17 = (Spinner) view.findViewById(R.id.asalariado_17);
        asalariados_16 = (Spinner) view.findViewById(R.id.asalariado_16);
        asalariados_13 = (Spinner) view.findViewById(R.id.asalariado_13);
        asalariados_20a2 = (Spinner) view.findViewById(R.id.asalariado_20a2);
        asalariados_20b2 = (Spinner) view.findViewById(R.id.asalariado_20b2);
        asalariados_20c2 = (Spinner) view.findViewById(R.id.asalariado_20c2);
        asalariados_20d2 = (Spinner) view.findViewById(R.id.asalariado_20d2);
        asalariados_21a2 = (Spinner) view.findViewById(R.id.asalariado_21a2);
        asalariados_21b2 = (Spinner) view.findViewById(R.id.asalariado_21b2);

        final EditText otro_1 = (EditText) view.findViewById(R.id.asalariado_13_edittext);

        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_13, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariados_13.setAdapter(spinner_adapter_1);
        asalariados_13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();
                if (scountry.equalsIgnoreCase("Otro medio")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else
                    otro_1.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<CharSequence> adapter_si_no_noSabe = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_7, android.R.layout.simple_spinner_item);
        adapter_si_no_noSabe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> spinner_adapter_si_no = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner asalariados_4 = (Spinner) view.findViewById(R.id.asalariado_15a);
        asalariados_4.setAdapter(adapter_si_no_noSabe);

        asalariados_16.setAdapter(adapter_si_no_noSabe);
        asalariados_16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariado_16_otros);
                    asalariado_5_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariado_16_otros);
                    asalariado_5_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        asalariados_17.setAdapter(adapter_si_no_noSabe);
        asalariados_17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_6_text = (EditText) view.findViewById(R.id.asalariado_17_otros);
                    asalariado_6_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_6_text = (EditText) view.findViewById(R.id.asalariado_17_otros);
                    asalariado_6_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        asalariados_18.setAdapter(adapter_si_no_noSabe);
        asalariados_18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_7_text = (EditText) view.findViewById(R.id.asalariado_18_otros);
                    asalariado_7_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_7_text = (EditText) view.findViewById(R.id.asalariado_18_otros);
                    asalariado_7_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        asalariados_19.setAdapter(adapter_si_no_noSabe);
        asalariados_19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_8_text = (EditText) view.findViewById(R.id.asalariado_19_otros);
                    asalariado_8_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_8_text = (EditText) view.findViewById(R.id.asalariado_19_otros);
                    asalariado_8_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        asalariados_20a2.setAdapter(spinner_adapter_si_no);
        asalariados_20b2.setAdapter(spinner_adapter_si_no);
        asalariados_20c2.setAdapter(spinner_adapter_si_no);
        asalariados_20d2.setAdapter(spinner_adapter_si_no);
        asalariados_21a2.setAdapter(spinner_adapter_si_no);
        asalariados_21b2.setAdapter(spinner_adapter_si_no);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())
                    SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
            }
        });
    }

    private boolean save() {
        if (asalariados_13.getSelectedItem().toString().equalsIgnoreCase("Otro medio")) {
            ocupado.setE13(((EditText) view.findViewById(R.id.asalariado_13_edittext)).getText().toString());
        } else
            ocupado.setE13(asalariados_13.getSelectedItem().toString());
        ocupado.setE14(((EditText) view.findViewById(R.id.asalariado_14)).getText().toString());
        ocupado.setE15(((EditText) view.findViewById(R.id.asalariado_15)).getText().toString());
        ocupado.setE15a(((Spinner) view.findViewById(R.id.asalariado_15a)).getSelectedItem().toString());
        ocupado.setE16(asalariados_16.getSelectedItem().toString());
        ocupado.setE17(asalariados_17.getSelectedItem().toString());
        ocupado.setE18(asalariados_18.getSelectedItem().toString());
        ocupado.setE19(asalariados_19.getSelectedItem().toString());
        ocupado.setE20a(((EditText) view.findViewById(R.id.asalariado_20a)).getText().toString());
        ocupado.setE20b(((EditText) view.findViewById(R.id.asalariado_20b)).getText().toString());
        ocupado.setE20c(((EditText) view.findViewById(R.id.asalariado_20c)).getText().toString());
        ocupado.setE20d(((EditText) view.findViewById(R.id.asalariado_20d)).getText().toString());
        ocupado.setE20a2(asalariados_20a2.getSelectedItem().toString());
        ocupado.setE20b2(asalariados_20b2.getSelectedItem().toString());
        ocupado.setE20c2(asalariados_20c2.getSelectedItem().toString());
        ocupado.setE20d2(asalariados_20d2.getSelectedItem().toString());
        ocupado.setE21a(((EditText) view.findViewById(R.id.asalariado_21a)).getText().toString());
        ocupado.setE21b(((EditText) view.findViewById(R.id.asalariado_21b)).getText().toString());
        ocupado.setE21a2(asalariados_21a2.getSelectedItem().toString());
        ocupado.setE21b2(asalariados_21b2.getSelectedItem().toString());
        ocupado.setE22a(((EditText) view.findViewById(R.id.asalariados_22_a_editText)).getText().toString());
        ocupado.setE22b(((EditText) view.findViewById(R.id.asalariados_22_b_editText)).getText().toString());
        ocupado.setE22c(((EditText) view.findViewById(R.id.asalariados_22_c_editText)).getText().toString());
        ocupado.setE22d(((EditText) view.findViewById(R.id.asalariados_22_d_editText)).getText().toString());
        ocupado.setE22e(((EditText) view.findViewById(R.id.asalariados_22_e_editText)).getText().toString());
        ocupado.setE23(((EditText) view.findViewById(R.id.asalariados_23_editText)).getText().toString());
        ocupado.setMiembroId(((MainActivity)getActivity()).getMiembro().getId());
        Log.i("Ocupados-Asalariados", ocupado.toString());
        return true;
    }

}
