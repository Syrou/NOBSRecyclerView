package eu.syrou.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import eu.syrou.example.R;
import eu.syrou.nobsrecyclerview.DummyFragment;
import eu.syrou.nobsrecyclerview.NOBSReyclerView;
import eu.syrou.nobsrecyclerview.NOBSTabSelected;


public class MainActivity extends AppCompatActivity {

    RelativeLayout content;
    NOBSReyclerView nobsReyclerView;
    ViewPager contentViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Nobsreyclerview");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        contentViewPager = (ViewPager) LayoutInflater.from(this).inflate(R.layout.content_viewpager, null, false);
        nobsReyclerView = (NOBSReyclerView) findViewById(R.id.nobsrecyclerview);
        //nobsReyclerView.inflateView();
        nobsReyclerView.setupViewPager(getSupportFragmentManager(), contentViewPager);

        HeaderViewPager headerViewPager = new HeaderViewPager(this);
        headerViewPager.init(getSupportFragmentManager());

        nobsReyclerView.addHeader(headerViewPager);


        ArrayList<String> data1 = new ArrayList<>();
        data1.add("One");
        data1.add("two");
        data1.add("three");
        data1.add("four");
        data1.add("five");

        nobsReyclerView.addFragmentToReyclerView(new DummyFragment(getResources().getColor(R.color.accent_material_light), data1), "ONE", new NOBSTabSelected() {
            @Override
            public void OnTabSelected(final TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        nobsReyclerView.addFragmentToReyclerView(new DummyFragment(getResources().getColor(R.color.ripple_material_light),data1), "TWO", new NOBSTabSelected() {
            @Override
            public void OnTabSelected(final TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        nobsReyclerView.addFragmentToReyclerView(new DummyFragment(getResources().getColor(R.color.button_material_dark),data1), "THREE",new NOBSTabSelected() {
            @Override
            public void OnTabSelected(final TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //content.addView(nobsReyclerView);

    }

}
