package br.senai.sp.informatica.sidvet.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import br.senai.sp.informatica.sidvet.R;
import br.senai.sp.informatica.sidvet.adapter.PagerAdaptador;

public class HomeActivity extends BaseActivity{

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarComponnetes();
        setupToolbar();
    }

    @Override
    protected void inicializarComponnetes() {
        setupTab();
        setupViewPager();
    }

    private void setupTab(){
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.perfil)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.pets)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.sobre)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(onTabSelected());
    }

    private TabLayout.OnTabSelectedListener onTabSelected(){
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        };
    }

    private void setupViewPager(){
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setAdapter(new PagerAdaptador(getSupportFragmentManager(), tabLayout.getTabCount()));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
