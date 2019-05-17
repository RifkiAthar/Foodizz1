package com.example.foodizz;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class PattayaActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private AppBarLayout appBarLayout ;
    private ViewPager viewPager ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattaya);
        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById (R.id.appbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new StepsFragment(), "Steps");
        adapter.AddFragment(new IngredientFragment(), "Ingredients");
        adapter.AddFragment(new OutletFragment(), "Outlets");
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
    }

    public class AppCompatActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
        public static final String DEVELOPER_KEY = "AIzaSyA-np7T6j7rzcGyWHdS4yqqSUDeZOenZFk";
        public static final String VIDEO_ID = "WeWOJzbS_3g";
        public static final int RECOVERY_DIALOG_REQUEST = 1;

        YouTubePlayerFragment myYouTubePlayerFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_video_pattaya);

            myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeplayerfragment);
            myYouTubePlayerFragment.initialize(DEVELOPER_KEY, this);
        }

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            if(!wasRestored){
                youTubePlayer.cueVideo(VIDEO_ID);
            }

        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
            if(errorReason.isUserRecoverableError()){
                errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
            } else {
                String errorMessage = String.format(
                        "There was an error initializing the YoutubePlayer (%1$s)", errorReason.toString());
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if(requestCode == RECOVERY_DIALOG_REQUEST){
                getYouTubePlayerProvider().initialize(DEVELOPER_KEY,this);
            }

        }

        protected YouTubePlayer.Provider getYouTubePlayerProvider(){
            return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
        }
    }
}
