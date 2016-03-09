package com.android.yangjw.gewalademo.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.yangjw.gewalademo.DetailsActivity;
import com.android.yangjw.gewalademo.R;
import com.android.yangjw.gewalademo.utils.TransitionHelper;
import com.android.yangjw.gewalademo.widget.NoScrollGridView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    private List<Integer> images = new ArrayList<>();
    private ViewHolder mViewHolder;

    @ViewInject(R.id.home_listview)
    private PullToRefreshListView mRefreshListView;

    private Activity mContext;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        x.view().inject(getView());
        ListView listView = mRefreshListView.getRefreshableView();
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.home_header,null);
        mViewHolder = new ViewHolder();
        x.view().inject(mViewHolder, headerView);
        listView.addHeaderView(headerView);
        listView.setAdapter(new HomeListAdapter(getActivity()));
        setupBanner();
        mViewHolder.mticketsGridView.setAdapter(new TicketsAdapter(getActivity()));
    }

    class ViewHolder {
        @ViewInject(R.id.search_convenientBanner)
        public ConvenientBanner convenientBanner;

        @ViewInject(R.id.home_sell_tickets_gv)
        public NoScrollGridView mticketsGridView;

        @Event(value = R.id.home_sell_tickets_gv,type = AdapterView.OnItemClickListener.class)
        private void gridItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(mContext, DetailsActivity.class);
            Pair<View,String>[] pairs = TransitionHelper.createSafeTransitionParticipants(mContext, false,
                    new Pair(view, getString(R.string.home_search_transition_name)));
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, pairs);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mContext.startActivity(intent,activityOptionsCompat.toBundle());
            } else {
                mContext.startActivity(intent);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewHolder.convenientBanner.startTurning(3000);
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewHolder.convenientBanner.stopTurning();
    }

    private void setupBanner() {
        images.add(R.drawable.ic_test_0);
        images.add(R.drawable.ic_test_1);
        images.add(R.drawable.ic_test_2);
        images.add(R.drawable.ic_test_3);
        images.add(R.drawable.ic_test_4);
        mViewHolder.convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {

                return new BannerHolder();
            }
        },images)
        .setPageIndicator(new int[]{R.drawable.ic_page_indicator,R.drawable.ic_page_indicator_focused})
        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

    }

    class BannerHolder implements Holder<Integer> {

        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }


    class TicketsAdapter extends BaseAdapter {

        private Context mContext;

        public TicketsAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
               view = LayoutInflater.from(mContext).inflate(R.layout.home_grid_item,null);
            }
            return view;
        }
    }

    class HomeListAdapter extends BaseAdapter {

        private Context mContext;

        public HomeListAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = (ImageView) convertView;
            if (imageView == null) {
                imageView = new ImageView(mContext);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400);
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
            }
            return imageView;
        }
    }



}
