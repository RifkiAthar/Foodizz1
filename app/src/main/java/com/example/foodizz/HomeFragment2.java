package com.example.foodizz;


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
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment2 extends Fragment implements View.OnClickListener{
    private CardView  desserts, beverages, ingredients;
    private CarouselView trendingItem;
    private ImageView mainCourse;


    public HomeFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mainCourse = view.findViewById(R.id.main_course);
        CarouselView trendingItem = view.findViewById(R.id.trending_item);
        CardView dessert = view.findViewById(R.id.dessert);
        CardView beverages = view.findViewById(R.id.beverages);
        CardView ingredient = view.findViewById(R.id.ingredients);
        mainCourse.setOnClickListener(this);
        trendingItem.setOnClickListener(this);
        dessert.setOnClickListener(this);
        beverages.setOnClickListener(this);
        ingredient.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager mFragmentManager = getFragmentManager();
        switch (view.getId()){
            case R.id.main_course:
                if (mFragmentManager != null) {
                    MaincourseFragment mMainCourseFragment = new MaincourseFragment();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.home_fragment, mMainCourseFragment, MaincourseFragment.class.getSimpleName());
                    mFragmentTransaction.commit();
                }
                break;
            case R.id.trending_item:
                if (mFragmentManager != null) {
                    TrendingFragment mTrendingItemFragment = new TrendingFragment();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.home_fragment, mTrendingItemFragment, TrendingFragment.class.getSimpleName());
                    mFragmentTransaction.commit();
                }
                break;
            case R.id.dessert:
                if (mFragmentManager != null) {
                    DessertFragment mDessertFragment = new DessertFragment();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.home_fragment, mDessertFragment, DessertFragment.class.getSimpleName());
                    mFragmentTransaction.commit();
                }
                break;
            case R.id.beverages:
                if (mFragmentManager != null) {
                    BeveragesFragment mBeveragesFragment = new BeveragesFragment();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.home_fragment, mBeveragesFragment, BeveragesFragment.class.getSimpleName());
                    mFragmentTransaction.commit();
                }
                break;
            case R.id.ingredients:
                if (mFragmentManager != null) {
                    IngredientFragment mIngredientFragment = new IngredientFragment();
                    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.home_fragment, mIngredientFragment, IngredientFragment.class.getSimpleName());
                    mFragmentTransaction.commit();
                }
                break;
        }

    }
}
