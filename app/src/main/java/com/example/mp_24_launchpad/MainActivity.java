package com.example.mp_24_launchpad;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mp_24_launchpad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_guitar, R.id.navigation_drum, R.id.navigation_piano)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavDestination currentDestination = navController.getCurrentDestination();

        container = (ConstraintLayout) findViewById(R.id.container);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            int currentId = destination.getId();

            if (currentId == R.id.navigation_guitar) {
                container.setBackgroundResource(R.drawable.guitar_background);
            } else if (currentId == R.id.navigation_drum) {
                container.setBackgroundResource(R.drawable.drum_background);
            } else if (currentId == R.id.navigation_piano) {
                container.setBackgroundResource(R.color.darkblack);
            } else {
                System.out.println("알 수 없는 Fragment입니다.");
            }
        });
    }

}