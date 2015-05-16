package it.moondroid.fragmenttransactiontest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;

import com.desarrollodroide.libraryfragmenttransactionextended.FragmentTransactionExtended;

/**
 * Created by Marco on 16/05/2015.
 */
public class MyFragmentTransactionExtended extends FragmentTransactionExtended {


    public static final int ZOOM = 23;
    public static final int SLIDE_UP = 24;

    private FragmentTransaction mFragmentTransaction;
    private Context mContext;
    private Fragment mFirstFragment, mSecondFragment;
    private int mContainerID;
    private int mTransitionType;

    public MyFragmentTransactionExtended(Context context, FragmentTransaction fragmentTransaction, Fragment firstFragment, Fragment secondFragment, int containerID) {
        super(context, fragmentTransaction, firstFragment, secondFragment, containerID);

        this.mFragmentTransaction = fragmentTransaction;
        this.mContext = context;
        this.mFirstFragment = firstFragment;
        this.mSecondFragment = secondFragment;
        this.mContainerID = containerID;
    }

    @Override
    public void addTransition(int transitionType) {

        switch (transitionType) {
            case ZOOM:
                transitionZoom();
                mFragmentTransaction.add(mContainerID, mSecondFragment);
                break;
            case SLIDE_UP:
                transitionSlideUp();
                mFragmentTransaction.add(mContainerID, mSecondFragment);
                break;
            default:
                super.addTransition(transitionType);
        }

    }

    private void transitionZoom() {

        mFragmentTransaction.setCustomAnimations(R.animator.zoom_enter, 0, 0, R.animator.zoom_exit);

    }

    private void transitionSlideUp() {

        mFragmentTransaction.setCustomAnimations(R.animator.slideup_enter, 0, 0, R.animator.slideup_exit);

    }

}
