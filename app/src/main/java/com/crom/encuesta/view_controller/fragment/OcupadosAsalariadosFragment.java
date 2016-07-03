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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Vivienda;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OcupadosAsalariadosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Vivienda vivienda;


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

        final EditText otro_1 = (EditText) view.findViewById(R.id.otro_1);
        otro_1.setVisibility(View.GONE);

        hide_alimentacion();
        hide_educacion();
        hide_transporte();
        hide_familiar();

        Spinner asalariados_1 = (Spinner) view.findViewById(R.id.asalariado_1);
        ArrayAdapter<CharSequence> spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_1, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariados_1.setAdapter(spinner_adapter_1);
        asalariados_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("Otro mdeio")) {

                    otro_1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        ArrayAdapter<CharSequence> spinner_adapter_si_no_noSabe = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_7, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no_noSabe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> spinner_adapter_si_no = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no, android.R.layout.simple_spinner_item);
        spinner_adapter_si_no.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner asalariados_4 = (Spinner) view.findViewById(R.id.asalariado_4);
        asalariados_4.setAdapter(spinner_adapter_si_no_noSabe);

        Spinner asalariados_5 = (Spinner) view.findViewById(R.id.asalariado_5);
        asalariados_5.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_5_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_5_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_6 = (Spinner) view.findViewById(R.id.asalariado_6);
        asalariados_6.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_6_text = (EditText) view.findViewById(R.id.asalariado_6_editText);
                    asalariado_6_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_6_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_6_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_7 = (Spinner) view.findViewById(R.id.asalariado_7);
        asalariados_7.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_7_text = (EditText) view.findViewById(R.id.asalariado_7_editText);
                    asalariado_7_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_7_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_7_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Spinner asalariados_8 = (Spinner) view.findViewById(R.id.asalariado_8);
        asalariados_8.setAdapter(spinner_adapter_si_no_noSabe);
        asalariados_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText asalariado_8_text = (EditText) view.findViewById(R.id.asalariado_8_editText);
                    asalariado_8_text.setVisibility(View.GONE);
                } else {
                    EditText asalariado_8_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_8_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner alimentacion = (Spinner) view.findViewById(R.id.alimentacion_spinner);
        alimentacion.setVisibility(View.GONE);
        alimentacion.setAdapter(spinner_adapter_si_no);
        alimentacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText alimentacion_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
                    alimentacion_editText.setVisibility(View.GONE);
                } else {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariado_5_editText);
                    asalariado_5_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner transporte = (Spinner) view.findViewById(R.id.trasnporte_spinner);
        transporte.setVisibility(View.GONE);
        transporte.setAdapter(spinner_adapter_si_no);
        transporte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText transporte_editText = (EditText) view.findViewById(R.id.transporte_editText);
                    transporte_editText.setVisibility(View.GONE);
                } else {
                    EditText transporte_editText = (EditText) view.findViewById(R.id.transporte_editText);
                    transporte_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner familiar = (Spinner) view.findViewById(R.id.familiar_spinner);
        familiar.setVisibility(View.GONE);
        familiar.setAdapter(spinner_adapter_si_no);
        familiar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView familiar_editText = (TextView) view.findViewById(R.id.familiar_editText);
                    familiar_editText.setVisibility(View.GONE);
                } else {
                    TextView familiar_editText = (TextView) view.findViewById(R.id.familiar_editText);
                    familiar_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner educativo = (Spinner) view.findViewById(R.id.educativo_spinner);
        educativo.setVisibility(View.GONE);
        educativo.setAdapter(spinner_adapter_si_no);
        educativo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.educativo_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.educativo_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Switch alimentacion_switch = (Switch) view.findViewById(R.id.alimentacion_switch);
        alimentacion_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    alimentacion.setVisibility(View.VISIBLE);
                    TextView alimentacion_textView = (TextView) view.findViewById(R.id.alimentacion_textView);
                    alimentacion_textView.setVisibility(View.VISIBLE);
                    EditText alimantacion_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
                    alimantacion_editText.setVisibility(View.VISIBLE);
                } else hide_alimentacion();
            }
        });


        Switch trasnporte_switch = (Switch) view.findViewById(R.id.trasnporte_switch);
        trasnporte_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    transporte.setVisibility(View.VISIBLE);
                    TextView transporte_textView = (TextView) view.findViewById(R.id.transporte_textView);
                    transporte_textView.setVisibility(View.VISIBLE);
                    EditText transporte_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
                    transporte_editText.setVisibility(View.VISIBLE);
                } else hide_transporte();
            }
        });

        Switch educativo_switch = (Switch) view.findViewById(R.id.educativo_switch);
        educativo_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    educativo.setVisibility(View.VISIBLE);
                    TextView educativo_textView = (TextView) view.findViewById(R.id.educativo_textView);
                    educativo_textView.setVisibility(View.VISIBLE);
                    EditText educativo_editText = (EditText) view.findViewById(R.id.educativo_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                } else hide_educacion();
            }
        });

        Switch familiar_switch = (Switch) view.findViewById(R.id.familiar_switch);
        familiar_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    familiar.setVisibility(View.VISIBLE);
                    TextView familiar_textView = (TextView) view.findViewById(R.id.familiar_textView);
                    familiar_textView.setVisibility(View.VISIBLE);
                    EditText familiar_editText = (EditText) view.findViewById(R.id.familiar_editText);
                    familiar_editText.setVisibility(View.VISIBLE);
                } else hide_familiar();
            }
        });
        final Spinner prima = (Spinner) view.findViewById(R.id.asalariado_21_a_spinner);
        prima.setVisibility(View.GONE);
        prima.setAdapter(spinner_adapter_si_no_noSabe);
        prima.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText alimentacion_editText = (EditText) view.findViewById(R.id.asalariados_21_a_editText);
                    alimentacion_editText.setVisibility(View.GONE);
                } else {
                    EditText asalariado_5_text = (EditText) view.findViewById(R.id.asalariados_21_a_editText);
                    asalariado_5_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner bonificacion = (Spinner) view.findViewById(R.id.asalariado_21_b_spinner);
        bonificacion.setVisibility(View.GONE);
        bonificacion.setAdapter(spinner_adapter_si_no);
        bonificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    EditText transporte_editText = (EditText) view.findViewById(R.id.asalariados_21_b_editText);
                    transporte_editText.setVisibility(View.GONE);
                } else {
                    EditText transporte_editText = (EditText) view.findViewById(R.id.asalariados_21_b_editText);
                    transporte_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        Switch asalariado_21_a_switch = (Switch) view.findViewById(R.id.asalariado_21_a_switch);
        asalariado_21_a_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    prima.setVisibility(View.VISIBLE);
                    TextView alimentacion_textView = (TextView) view.findViewById(R.id.asalariados_21_a_textView);
                    alimentacion_textView.setVisibility(View.VISIBLE);
                    EditText alimantacion_editText = (EditText) view.findViewById(R.id.asalariados_21_a_editText);
                    alimantacion_editText.setVisibility(View.VISIBLE);
                } else hide_alimentacion();
            }
        });


        Switch asalariado_21_b_switch = (Switch) view.findViewById(R.id.asalariado_21_b_switch);
        asalariado_21_b_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {

                    bonificacion.setVisibility(View.VISIBLE);
                    TextView transporte_textView = (TextView) view.findViewById(R.id.asalariados_21_b_textView);
                    transporte_textView.setVisibility(View.VISIBLE);
                    EditText transporte_editText = (EditText) view.findViewById(R.id.asalariados_21_b_editText);
                    transporte_editText.setVisibility(View.VISIBLE);
                } else hide_transporte();
            }
        });
        final Spinner asalariado_22_a = (Spinner) view.findViewById(R.id.asalariados_22_a_spinner);
        asalariado_22_a.setVisibility(View.GONE);
        asalariado_22_a.setAdapter(spinner_adapter_si_no);
        asalariado_22_a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_a_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_a_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final Spinner asalariados_22_b = (Spinner) view.findViewById(R.id.asalariados_22_b_spinner);
        asalariados_22_b.setVisibility(View.GONE);
        asalariados_22_b.setAdapter(spinner_adapter_si_no);
        asalariados_22_b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_b_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_b_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final Spinner asalariados_22_c = (Spinner) view.findViewById(R.id.asalariados_22_c_spinner);
        asalariados_22_c.setVisibility(View.GONE);
        asalariados_22_c.setAdapter(spinner_adapter_si_no);
        asalariados_22_c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_c_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_c_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final Spinner asalariados_22_d = (Spinner) view.findViewById(R.id.asalariados_22_d_spinner);
        asalariados_22_d.setVisibility(View.GONE);
        asalariados_22_d.setAdapter(spinner_adapter_si_no);
        asalariados_22_d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_d_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_d_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final Spinner asalariados_22_e = (Spinner) view.findViewById(R.id.asalariados_22_e_spinner);
        asalariados_22_e.setVisibility(View.GONE);
        asalariados_22_e.setAdapter(spinner_adapter_si_no);
        asalariados_22_e.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_e_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_22_e_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final Spinner asalariados_23 = (Spinner) view.findViewById(R.id.asalariados_23_spinner);
        asalariados_23.setVisibility(View.GONE);
        asalariados_23.setAdapter(spinner_adapter_si_no);
        asalariados_23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (!scountry.equalsIgnoreCase("si")) {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_23_editText);
                    educativo_editText.setVisibility(View.GONE);
                } else {
                    TextView educativo_editText = (TextView) view.findViewById(R.id.asalariados_23_editText);
                    educativo_editText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        vivienda = ((MainActivity) getActivity()).getVivienda();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save();
                transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
            }
        });
    }

    private void hide_alimentacion() {
        Spinner alimentacion = (Spinner) view.findViewById(R.id.alimentacion_spinner);
        alimentacion.setVisibility(View.GONE);
        TextView alimentacion_textView = (TextView) view.findViewById(R.id.alimentacion_textView);
        alimentacion_textView.setVisibility(View.GONE);
        EditText alimantacion_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
        alimantacion_editText.setVisibility(View.GONE);
    }

    private void hide_transporte() {
        Spinner transporte = (Spinner) view.findViewById(R.id.trasnporte_spinner);
        transporte.setVisibility(View.GONE);
        TextView transporte_textView = (TextView) view.findViewById(R.id.transporte_textView);
        transporte_textView.setVisibility(View.GONE);
        EditText transporte_editText = (EditText) view.findViewById(R.id.alimentacion_editText);
        transporte_editText.setVisibility(View.GONE);
    }

    private void hide_familiar() {
        Spinner familiar = (Spinner) view.findViewById(R.id.familiar_spinner);
        familiar.setVisibility(View.GONE);
        TextView familiar_textView = (TextView) view.findViewById(R.id.familiar_textView);
        familiar_textView.setVisibility(View.GONE);
        EditText familiar_editText = (EditText) view.findViewById(R.id.familiar_editText);
        familiar_editText.setVisibility(View.GONE);
    }

    private void hide_educacion() {
        Spinner educativo = (Spinner) view.findViewById(R.id.educativo_spinner);
        educativo.setVisibility(View.GONE);
        TextView educativo_textView = (TextView) view.findViewById(R.id.educativo_textView);
        educativo_textView.setVisibility(View.GONE);
        EditText educativo_editText = (EditText) view.findViewById(R.id.educativo_editText);
        educativo_editText.setVisibility(View.GONE);
    }

    private void save() {
        String dato = "";
        Spinner asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_1);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.otro_1);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 13);
        EditText asalariado = (EditText) view.findViewById(R.id.asalariado_2);
        dato = asalariado.getText().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 14);
        asalariado = (EditText) view.findViewById(R.id.asalariado_3);
        dato = asalariado.getText().toString();

        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_4);
        dato = dato + "," + asalariado_spinner.getSelectedItem().toString();
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 15);
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_5);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariado_5_editText);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 16);
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_6);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariado_6_editText);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 17);
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_7);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariado_7_editText);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 18);
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariado_8);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariado_8_editText);
            dato = otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 19);
        dato = "";
        Switch asalariado_switch = (Switch) view.findViewById(R.id.alimentacion_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.alimentacion_editText);
            dato = dato + "si," + alimentacion.getText().toString();
        }
        asalariado_switch = (Switch) view.findViewById(R.id.trasnporte_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.transporte_editText);
            dato = dato + "si," + alimentacion.getText().toString();
        }
        asalariado_switch = (Switch) view.findViewById(R.id.familiar_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.familiar_editText);
            dato = dato + "si," + alimentacion.getText().toString();
        }
        asalariado_switch = (Switch) view.findViewById(R.id.educativo_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.educativo_editText);
            dato = dato + "si," + alimentacion.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 20);
        dato = "";
        asalariado_switch = (Switch) view.findViewById(R.id.asalariado_21_a_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.asalariados_21_a_editText);
            dato = dato + "si," + alimentacion.getText().toString();
        }
        asalariado_switch = (Switch) view.findViewById(R.id.asalariado_21_b_switch);
        if (asalariado_switch.isChecked()) {
            EditText alimentacion = (EditText) view.findViewById(R.id.asalariados_21_b_editText);
            dato = dato + "si" + alimentacion.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 21);
        dato = "";
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_22_a_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = dato + asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_22_a_editText);
            dato = dato + "si," + otro.getText().toString();
        }
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_22_b_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = dato + "," + asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_22_b_editText);
            dato = dato + ",si," + otro.getText().toString();
        }
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_22_c_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = dato + "," + asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_22_c_editText);
            dato = dato + ",si," + otro.getText().toString();
        }
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_22_d_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = dato + "," + asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_22_d_editText);
            dato = dato + ",si," + otro.getText().toString();
        }
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_22_e_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = dato + "," + asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_22_e_editText);
            dato = dato + ",si," + otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 22);
        dato = "";
        asalariado_spinner = (Spinner) view.findViewById(R.id.asalariados_23_spinner);
        if (!asalariado_spinner.getSelectedItem().toString().equalsIgnoreCase("si")) {
            dato = asalariado_spinner.getSelectedItem().toString();
        } else {
            EditText otro = (EditText) view.findViewById(R.id.asalariados_23_editText);
            dato = "si," + otro.getText().toString();
        }
        vivienda.getLastHogar().getLastMiembro().getOcupado().setE(dato, 23);
    }

}
