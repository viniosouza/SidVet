package br.senai.sp.informatica.sidvet.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.senai.sp.informatica.sidvet.fragment.ClienteFragment;
import br.senai.sp.informatica.sidvet.fragment.PetFragment;
import br.senai.sp.informatica.sidvet.fragment.SobreFragment;

public class PagerAdaptador extends FragmentPagerAdapter {

    int numOfTabs;

    public PagerAdaptador(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ClienteFragment clienteFragment = new ClienteFragment();

                return  clienteFragment;
            case 1:
                PetFragment petFragment = new PetFragment();
                return petFragment;
            case 2:
                SobreFragment sobreFragment = new SobreFragment();
                return sobreFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs != 0 ? numOfTabs : 0;
    }
}
