package com.crom.encuesta.view_controller.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class OcupadosAsalariadosIndependientesFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Ocupado ocupado;


    public OcupadosAsalariadosIndependientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ocupados_asalariados_independientes, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE4));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {
        ocupado = ((MainActivity) getActivity()).getOcupado();
        EditText otro_14 = (EditText) view.findViewById(R.id.ocupado_42_editText);
        otro_14.setVisibility(View.GONE);
        Spinner asalariado_independiente_31 = (Spinner) view.findViewById(R.id.ocupado_31_spinner);
        Spinner asalariado_independiente_33 = (Spinner) view.findViewById(R.id.ocupado_33_spinner);

        ArrayAdapter spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_3, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_31.setAdapter(spinner_adapter_1);
        asalariado_independiente_31.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.ocupado_31_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        final EditText independiente2 = (EditText) view.findViewById(R.id.ocupado_30_editText);
        independiente2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Integer.parseInt(s.toString()) >= 40) {
                        ((LinearLayout) view.findViewById(R.id.l_31)).setVisibility(View.GONE);
                    } else {
                        ((LinearLayout) view.findViewById(R.id.l_31)).setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    Log.i(OcupadosAsalariadosIndependientesFragment.class.toString(), "- parserInt: " + e);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((EditText) view.findViewById(R.id.ocupado_32_editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (Integer.parseInt(s.toString()) >= Integer.parseInt(((EditText) view.findViewById(R.id.ocupado_30_editText)).getText().toString())) {
                        ((LinearLayout) view.findViewById(R.id.l_33)).setVisibility(View.GONE);
                    } else {
                        ((LinearLayout) view.findViewById(R.id.l_33)).setVisibility(View.VISIBLE);
                    }
                } catch (Exception e) {
                    Log.i(OcupadosAsalariadosIndependientesFragment.class.toString(), "- parserInt: " + e);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        ArrayAdapter spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_5, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_33.setAdapter(spinner_adapter_2);
        asalariado_independiente_33.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int position, long l) {
                if (position == 6) {
                    ((EditText) view.findViewById(R.id.ocupado_33_editText)).setVisibility(View.VISIBLE);
                } else {
                    ((EditText) view.findViewById(R.id.ocupado_33_editText)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner asalariado_independiente_6 = (Spinner) view.findViewById(R.id.ocupado_34_spinner);
        spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_6, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_6.setAdapter(spinner_adapter_2);
        asalariado_independiente_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                if (position == 0) {
                    getDialog();
                } else {
                    ((TextView) view.findViewById(R.id.ocupado_34_textView)).setText("");
                    ((TextView) view.findViewById(R.id.ocupado_34_textView)).setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        asalariado_independiente_6.setSelection(1);
        ((TextView) view.findViewById(R.id.ocupado_34_textView)).setVisibility(View.GONE);

        Spinner asalariado_independiente_7 = (Spinner) view.findViewById(R.id.ocupado_35_spinner);
        spinner_adapter_2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_7, android.R.layout.simple_spinner_item);
        spinner_adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_7.setAdapter(spinner_adapter_2);

        Spinner asalariado_independiente_8 = (Spinner) view.findViewById(R.id.ocupado_36_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_8, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_8.setAdapter(spinner_adapter_1);
        asalariado_independiente_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.ocupado_36_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner asalariado_independiente_9 = (Spinner) view.findViewById(R.id.ocupado_37_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_9, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_9.setAdapter(spinner_adapter_1);
        asalariado_independiente_9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item

                EditText otro_1 = (EditText) view.findViewById(R.id.ocupado_37_editText);
                if (scountry.equalsIgnoreCase("Otro")) {
                    otro_1.setVisibility(View.VISIBLE);
                } else {
                    otro_1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner asalariado_independiente_10 = (Spinner) view.findViewById(R.id.ocupado_38_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_10, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_10.setAdapter(spinner_adapter_1);
        asalariado_independiente_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item


                if (scountry.equalsIgnoreCase("No")) {
                    hide_38();
                    TextView asalariado_independiente_14_textView = (TextView) view.findViewById(R.id.ocupado_42_textView);
                    asalariado_independiente_14_textView.setVisibility(View.VISIBLE);
                    CheckBox a = (CheckBox) view.findViewById(R.id.ocupado_42_a);
                    CheckBox b = (CheckBox) view.findViewById(R.id.ocupado_42_b);
                    CheckBox c = (CheckBox) view.findViewById(R.id.ocupado_42_c);
                    CheckBox d = (CheckBox) view.findViewById(R.id.ocupado_42_d);
                    CheckBox e = (CheckBox) view.findViewById(R.id.ocupado_42_e);
                    CheckBox f = (CheckBox) view.findViewById(R.id.ocupado_42_f);
                    CheckBox g = (CheckBox) view.findViewById(R.id.ocupado_42_g);
                    CheckBox h = (CheckBox) view.findViewById(R.id.ocupado_42_h);
                    a.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    d.setVisibility(View.VISIBLE);
                    e.setVisibility(View.VISIBLE);
                    f.setVisibility(View.VISIBLE);
                    h.setVisibility(View.VISIBLE);
                    g.setVisibility(View.VISIBLE);
                } else if (scountry.equalsIgnoreCase("Ya es pensionado")) {
                    hide_38();
                    CheckBox a = (CheckBox) view.findViewById(R.id.ocupado_42_a);
                    CheckBox b = (CheckBox) view.findViewById(R.id.ocupado_42_b);
                    CheckBox c = (CheckBox) view.findViewById(R.id.ocupado_42_c);
                    CheckBox d = (CheckBox) view.findViewById(R.id.ocupado_42_d);
                    CheckBox e = (CheckBox) view.findViewById(R.id.ocupado_42_e);
                    CheckBox f = (CheckBox) view.findViewById(R.id.ocupado_42_f);
                    CheckBox g = (CheckBox) view.findViewById(R.id.ocupado_42_g);
                    CheckBox h = (CheckBox) view.findViewById(R.id.ocupado_42_h);
                    EditText asalariado_independiente_14_editText = (EditText) view.findViewById(R.id.ocupado_42_editText);
                    TextView asalariado_independiente_14_textView = (TextView) view.findViewById(R.id.ocupado_42_textView);

                    asalariado_independiente_14_editText.setVisibility(View.GONE);
                    asalariado_independiente_14_textView.setVisibility(View.GONE);
                    a.setVisibility(View.GONE);
                    b.setVisibility(View.GONE);
                    c.setVisibility(View.GONE);
                    d.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    f.setVisibility(View.GONE);
                    h.setVisibility(View.GONE);
                    g.setVisibility(View.GONE);
                } else {
                    show_38();
                    CheckBox a = (CheckBox) view.findViewById(R.id.ocupado_42_a);
                    CheckBox b = (CheckBox) view.findViewById(R.id.ocupado_42_b);
                    CheckBox c = (CheckBox) view.findViewById(R.id.ocupado_42_c);
                    CheckBox d = (CheckBox) view.findViewById(R.id.ocupado_42_d);
                    CheckBox e = (CheckBox) view.findViewById(R.id.ocupado_42_e);
                    CheckBox f = (CheckBox) view.findViewById(R.id.ocupado_42_f);
                    CheckBox g = (CheckBox) view.findViewById(R.id.ocupado_42_g);
                    CheckBox h = (CheckBox) view.findViewById(R.id.ocupado_42_h);
                    TextView asalariado_independiente_14_textView = (TextView) view.findViewById(R.id.ocupado_42_textView);

                    asalariado_independiente_14_textView.setVisibility(View.VISIBLE);
                    a.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);
                    c.setVisibility(View.VISIBLE);
                    d.setVisibility(View.VISIBLE);
                    e.setVisibility(View.VISIBLE);
                    f.setVisibility(View.VISIBLE);
                    h.setVisibility(View.VISIBLE);
                    g.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner ocupado_39_spinner = (Spinner) view.findViewById(R.id.ocupado_39_spinner);
        ArrayAdapter spinner_adapter_39 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupado_39_array, android.R.layout.simple_spinner_item);
        spinner_adapter_39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_39_spinner.setAdapter(spinner_adapter_39);

        Spinner asalariado_independiente_12 = (Spinner) view.findViewById(R.id.ocupado_40_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.asalariados_independientes_12, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_12.setAdapter(spinner_adapter_1);

        final CheckBox asalariados_independientes_14_otro = (CheckBox) view.findViewById(R.id.ocupado_42_g);
        asalariados_independientes_14_otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (asalariados_independientes_14_otro.isChecked()) {
                    EditText otro_14 = (EditText) view.findViewById(R.id.ocupado_42_editText);
                    otro_14.setVisibility(View.VISIBLE);
                } else {
                    EditText otro_14 = (EditText) view.findViewById(R.id.ocupado_42_editText);
                    otro_14.setVisibility(View.GONE);
                }
            }
        });

        Spinner asalariado_independiente_15 = (Spinner) view.findViewById(R.id.ocupado_43_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_15.setAdapter(spinner_adapter_1);

        Spinner asalariado_independiente_16 = (Spinner) view.findViewById(R.id.ocupado_44_spinner);
        spinner_adapter_1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no_nosabe, android.R.layout.simple_spinner_item);
        spinner_adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asalariado_independiente_16.setAdapter(spinner_adapter_1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())                        SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());

                transaction.replace(R.id.contenedor, new OcupadoTrabajoSecundarioFragment()).commit();
            }
        });
    }

    private void hide_38() {
        EditText a = (EditText) view.findViewById(R.id.ocupado_41_editText);
        Spinner b = (Spinner) view.findViewById(R.id.ocupado_39_spinner);
        Spinner c = (Spinner) view.findViewById(R.id.ocupado_40_spinner);
        TextView d = (TextView) view.findViewById(R.id.asalariados_independientes_13_textView);
        TextView e = (TextView) view.findViewById(R.id.ocupado_39_textView);
        TextView f = (TextView) view.findViewById(R.id.asalariados_independientes_12_textView);

        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
        d.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        f.setVisibility(View.GONE);
    }

    private void show_38() {
        EditText a = (EditText) view.findViewById(R.id.ocupado_41_editText);
        Spinner b = (Spinner) view.findViewById(R.id.ocupado_39_spinner);
        Spinner c = (Spinner) view.findViewById(R.id.ocupado_40_spinner);
        TextView d = (TextView) view.findViewById(R.id.asalariados_independientes_13_textView);
        TextView e = (TextView) view.findViewById(R.id.ocupado_39_textView);
        TextView f = (TextView) view.findViewById(R.id.asalariados_independientes_12_textView);

        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);
        d.setVisibility(View.VISIBLE);
        e.setVisibility(View.VISIBLE);
        f.setVisibility(View.VISIBLE);
    }

    public void getDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_horario);
        dialog.setTitle("Digite horario");
        dialog.setCancelable(false);
        Button aceptar = (Button) dialog.findViewById(R.id.dialog_btn);
        //final EditText editText = (EditText) dialog.findViewById(R.id.personas_dialog);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String de = ((EditText) dialog.findViewById(R.id.de_horario)).getText().toString();
                String hasta = ((EditText) dialog.findViewById(R.id.hasta_horario)).getText().toString();
                if (de.length() > 2 || hasta.length() > 2
                        || de.length() == 0 || hasta.length() == 0) {
                    Toast.makeText(getContext(), "Recuerde que el formato de hora son 2 digitos", Toast.LENGTH_SHORT).show();
                } else {
                    ((TextView) view.findViewById(R.id.ocupado_34_textView)).setVisibility(View.VISIBLE);
                    ((TextView) view.findViewById(R.id.ocupado_34_textView)).setText(de + " a " + hasta);
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    private boolean save() {
        ocupado.setE29(((EditText) view.findViewById(R.id.ocupado_29_editText)).getText().toString());
        int e30 = 0;
        int e32 = 0;
        try {
            if (((EditText) view.findViewById(R.id.ocupado_30_editText)).getText().toString().equals("")) {
                e30 = 0;
            } else {
                e30 = Integer.parseInt(((EditText) view.findViewById(R.id.ocupado_30_editText)).getText().toString());
            }
            ocupado.setE30(((EditText) view.findViewById(R.id.ocupado_30_editText)).getText().toString());
            if (e30 < 40) {
                Spinner spinner = (Spinner) view.findViewById(R.id.ocupado_31_spinner);
                if (spinner.getSelectedItem().toString().equals("Otro")) {
                    ocupado.setE31(((EditText) view.findViewById(R.id.ocupado_31_editText)).getText().toString());
                } else {
                    ocupado.setE31(spinner.getSelectedItem().toString());
                }
            }
            ocupado.setE32(((EditText) view.findViewById(R.id.ocupado_32_editText)).getText().toString());
            e32 = Integer.parseInt(ocupado.getE32());
        } catch (Exception e) {
            return false;
        }
        if (e32 < e30) {
            Spinner spinner = (Spinner) view.findViewById(R.id.ocupado_33_spinner);
            if (spinner.getSelectedItem().toString().equals("Otro"))
                ocupado.setE31(((EditText) view.findViewById(R.id.ocupado_31_editText)).getText().toString());
            else
                ocupado.setE31(spinner.getSelectedItem().toString());
        }
        ocupado.setE32(((EditText) view.findViewById(R.id.ocupado_32_editText)).getText().toString());
        Spinner spinner = (Spinner) view.findViewById(R.id.ocupado_33_spinner);
        if (spinner.getSelectedItem().toString().equals("Otro"))
            ocupado.setE33(((EditText) view.findViewById(R.id.ocupado_33_editText)).getText().toString());
        else
            ocupado.setE33(spinner.getSelectedItem().toString());
        Spinner spinner1 = (Spinner) view.findViewById(R.id.ocupado_34_spinner);
        if (spinner1.getSelectedItemPosition() == 0) {
            ocupado.setE34(((TextView) view.findViewById(R.id.ocupado_34_textView)).getText().toString());
        } else
            ocupado.setE34(spinner1.getSelectedItem().toString());
        ocupado.setE35(((Spinner) view.findViewById(R.id.ocupado_35_spinner)).getSelectedItem().toString());
        Spinner spinner36 = (Spinner) view.findViewById(R.id.ocupado_36_spinner);
        if (spinner36.getSelectedItem().toString().equals("Otro"))
            ocupado.setE36(((EditText) view.findViewById(R.id.ocupado_36_editText)).getText().toString());
        else
            ocupado.setE36(spinner36.getSelectedItem().toString());
        Spinner spinner37 = (Spinner) view.findViewById(R.id.ocupado_37_spinner);
        if (spinner37.getSelectedItem().toString().equals("Otro"))
            ocupado.setE37(((EditText) view.findViewById(R.id.ocupado_37_editText)).getText().toString());
        else
            ocupado.setE37(spinner36.getSelectedItem().toString());
        Spinner spinner38 = (Spinner) view.findViewById(R.id.ocupado_38_spinner);
        ocupado.setE38(spinner38.getSelectedItem().toString());
        if (spinner38.getSelectedItemPosition() == 1) {
            ArrayList<String> list42 = new ArrayList<>();
            CheckBox a = (CheckBox) view.findViewById(R.id.ocupado_42_a);
            CheckBox b = (CheckBox) view.findViewById(R.id.ocupado_42_b);
            CheckBox c = (CheckBox) view.findViewById(R.id.ocupado_42_c);
            CheckBox d = (CheckBox) view.findViewById(R.id.ocupado_42_d);
            CheckBox e = (CheckBox) view.findViewById(R.id.ocupado_42_e);
            CheckBox f = (CheckBox) view.findViewById(R.id.ocupado_42_f);
            CheckBox g = (CheckBox) view.findViewById(R.id.ocupado_42_g);
            CheckBox h = (CheckBox) view.findViewById(R.id.ocupado_42_h);
            if (a.isChecked())
                list42.add(a.getText().toString());
            if (b.isChecked())
                list42.add(b.getText().toString());
            if (c.isChecked())
                list42.add(c.getText().toString());
            if (d.isChecked())
                list42.add(d.getText().toString());
            if (e.isChecked())
                list42.add(e.getText().toString());
            if (f.isChecked())
                list42.add(f.getText().toString());
            if (g.isChecked())
                list42.add(((EditText) view.findViewById(R.id.ocupado_42_editText)).getText().toString());
            if (h.isChecked())
                list42.add(h.getText().toString());
            ocupado.setE42(list42);
            ocupado.setE43(((Spinner) view.findViewById(R.id.ocupado_43_spinner)).getSelectedItem().toString());
            ocupado.setE44(((Spinner) view.findViewById(R.id.ocupado_44_spinner)).getSelectedItem().toString());
            return true;
        } else if (spinner38.getSelectedItemPosition() == 2) {
            ocupado.setE43(((Spinner) view.findViewById(R.id.ocupado_43_spinner)).getSelectedItem().toString());
            ocupado.setE44(((Spinner) view.findViewById(R.id.ocupado_44_spinner)).getSelectedItem().toString());
            return true;
        }
        ocupado.setE39(((Spinner) view.findViewById(R.id.ocupado_39_spinner)).getSelectedItem().toString());
        ocupado.setE40(((Spinner) view.findViewById(R.id.ocupado_40_spinner)).getSelectedItem().toString());
        ocupado.setE41(((EditText) view.findViewById(R.id.ocupado_41_editText)).getText().toString());
        ArrayList<String> list42 = new ArrayList<>();
        CheckBox a = (CheckBox) view.findViewById(R.id.ocupado_42_a);
        CheckBox b = (CheckBox) view.findViewById(R.id.ocupado_42_b);
        CheckBox c = (CheckBox) view.findViewById(R.id.ocupado_42_c);
        CheckBox d = (CheckBox) view.findViewById(R.id.ocupado_42_d);
        CheckBox e = (CheckBox) view.findViewById(R.id.ocupado_42_e);
        CheckBox f = (CheckBox) view.findViewById(R.id.ocupado_42_f);
        CheckBox g = (CheckBox) view.findViewById(R.id.ocupado_42_g);
        CheckBox h = (CheckBox) view.findViewById(R.id.ocupado_42_h);
        if (a.isChecked())
            list42.add(a.getText().toString());
        if (b.isChecked())
            list42.add(b.getText().toString());
        if (c.isChecked())
            list42.add(c.getText().toString());
        if (d.isChecked())
            list42.add(d.getText().toString());
        if (e.isChecked())
            list42.add(e.getText().toString());
        if (f.isChecked())
            list42.add(f.getText().toString());
        if (g.isChecked())
            list42.add(((EditText) view.findViewById(R.id.ocupado_42_editText)).getText().toString());
        if (h.isChecked())
            list42.add(h.getText().toString());
        ocupado.setE42(list42);
        ocupado.setE43(((Spinner) view.findViewById(R.id.ocupado_43_spinner)).getSelectedItem().toString());
        ocupado.setE44(((Spinner) view.findViewById(R.id.ocupado_44_spinner)).getSelectedItem().toString());
        Log.i("Asalariados Indepen", ocupado.toString());
        return true;
    }

}
