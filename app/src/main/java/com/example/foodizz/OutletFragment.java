package com.example.foodizz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OutletFragment extends Fragment implements View.OnClickListener{
    Button shopHere;


    public OutletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outlet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button shopHere = view.findViewById(R.id.shop_here);
        shopHere.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.shop_here){
            Intent intent = new Intent(getActivity(), BeliActivity.class);
            startActivity(intent);
        }
    }
}
