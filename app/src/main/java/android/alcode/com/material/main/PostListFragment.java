package android.alcode.com.material.main;

import android.alcode.com.material.R;
import android.alcode.com.material.models.Constants;
import android.alcode.com.material.models.PostDetails;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.firebase.client.Query;

/**
 * Created by MOMANI on 2016/03/22.
 */

public class PostListFragment extends Fragment {

    RecyclerView mRecyclerView;
    private int gridColumns;
    private SwipeRefreshLayout mSwip;
    PostAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        gridColumns = getResources().getInteger(R.integer.grid_columns);
        View v =  inflater.inflate(
                R.layout.fragment_post_list, container, false);
        mSwip = (SwipeRefreshLayout) v.findViewById(R.id.swipeRefreshLayout);

        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                mSwip.setRefreshing(false);
            }
        });
        mRecyclerView= (RecyclerView) v.findViewById(R.id.recyclerview);

        setupRecyclerView(mRecyclerView);
        return v;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), gridColumns);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if ((position + 1) % 3 == 0)
                    return gridColumns;
                else
                    return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());






        Firebase mRef=new Firebase(Constants.mRef);
        Query query=mRef.limitToFirst(12);



            adapter = new PostAdapter(PostDetails.class, R.layout.layout_holder_movie_small, RecyclerView.ViewHolder.class, query, getActivity());
            recyclerView.setAdapter(adapter);



    }




}
