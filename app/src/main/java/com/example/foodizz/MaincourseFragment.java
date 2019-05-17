package com.example.foodizz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubePlayerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaincourseFragment extends Fragment implements View.OnClickListener{
    private CardView nasiGorengPattaya;


    public MaincourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maincourse, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView nasiGorengPattaya = view.findViewById(R.id.nasigorengpattaya);
        nasiGorengPattaya.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.nasigorengpattaya){
            /*FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null) {
                StepsFragment mStepsFragment = new StepsFragment();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.home_fragment, mStepsFragment, StepsFragment.class.getSimpleName());
                mFragmentTransaction.commit();
            }*/
            Intent intent = new Intent(getActivity(), PattayaActivity.class);
            startActivity(intent);




        }
    }


}
