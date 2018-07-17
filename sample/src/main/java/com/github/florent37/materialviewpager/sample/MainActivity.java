package com.github.florent37.materialviewpager.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.sample.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends DrawerActivity {

  @BindView(R.id.materialViewPager)
  MaterialViewPager mViewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setTitle("");
    ButterKnife.bind(this);

    final Toolbar toolbar = mViewPager.getToolbar();
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }

    mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

      @Override
      public Fragment getItem(int position) {
        switch (position % 6) {
          //case 0:
          //    return RecyclerViewFragment.newInstance();
          //case 1:
          //    return RecyclerViewFragment.newInstance();
          //case 2:
          //    return WebViewFragment.newInstance();
          default:
            return RecyclerViewFragment.newInstance();
        }
      }

      @Override
      public int getCount() {
        return 7;
      }

      @Override
      public CharSequence getPageTitle(int position) {
        switch (position % 4) {
          case 0:
            return "نظامی گنجوی";
          case 1:
            return "سعدی شیرازی";
          case 2:
            return "حافظ شیرازی";
          case 3:
            return "جامی";
          case 4:
            return "فردوسی طوسی";
          case 5:
            return "باباطار عریان";
          case 6:
            return "سهراب سپهری";
        }
        return "";
      }
    });

    mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
      @Override
      public HeaderDesign getHeaderDesign(int page) {
        switch (page) {
          case 0:
            return HeaderDesign.fromColorResAndUrl(
              R.color.green,
              "");
          case 1:
            return HeaderDesign.fromColorResAndUrl(
              R.color.blue,
              "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
          case 2:
            return HeaderDesign.fromColorResAndUrl(
              R.color.cyan,
              "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
          case 3:
            return HeaderDesign.fromColorResAndUrl(
              R.color.red,
              "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
          case 4:
            return HeaderDesign.fromColorResAndUrl(
              R.color.red,
              "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
          case 5:
            return HeaderDesign.fromColorResAndUrl(
              R.color.red,
              "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
          case 6:
            return HeaderDesign.fromColorResAndUrl(
              R.color.red,
              "");
        }

        //execute others actions if needed (ex : modify your header logo)

        return null;
      }
    });

    mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
    mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

    final View logo = findViewById(R.id.logo_white);
    if (logo != null) {
      logo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mViewPager.notifyHeaderChanged();
          Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
        }
      });
    }
  }
}
