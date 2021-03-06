package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment1.OnDataFragment1Listener {


    // ViewBinding
    // https://developer.android.com/topic/libraries/view-binding
    protected ActivityMainBinding binding;
    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment1());
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // loadFragment(new Fragment2());
                MyDialog md = new MyDialog();
                md.show(getSupportFragmentManager(),null);
            }
        });
    }

    public void loadFragment(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();

        Bundle arg = new Bundle();
        arg.putString(KEY,"Hello from activity!");
        f.setArguments(arg);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frBody,f);
        ft.addToBackStack(null); // кладем fragmentы в стек (для хистори)
        ft.commit();

    }

    @Override
    public void onDataFragment1Listener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}