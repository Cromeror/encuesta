package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookmarkFragmento extends Fragment {


    public BookmarkFragmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookmark_fragmento, container, false);
        TextView textView = (TextView) view.findViewById(R.id.t1);
        return view;
    }

}
