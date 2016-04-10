package android.alcode.com.material.detail;

import android.alcode.com.material.R;
import android.alcode.com.material.models.PostDetails;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by MOMANI on 2016/03/23.
 */
public class PostDetailFragment extends Fragment {

    private String id;
    private PostDetails mPostDetails;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ImageView mBackdrop;

    private FloatingActionButton fab;
    private ShareActionProvider mShareActionProvider;


    public PostDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post_detail, container, false);

        //grab any data from other Activity
      //  id = getActivity().getIntent().getStringExtra("id");
        mPostDetails = (PostDetails)(getActivity().getIntent().getParcelableExtra("id"));

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_movie_details);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) v.findViewById(R.id.toolbar);
        mBackdrop = (ImageView) v.findViewById(R.id.backdrop);


        fab = (FloatingActionButton) v.findViewById(R.id.fab);


        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getContext(), R.color.transparent));
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(getContext(), R.color.transparent));

        //((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(R.string.subtitle);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_detail, menu);
        // Retrieve the share menu item
        MenuItem menuItem = menu.findItem(R.id.action_share);

        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if (mPostDetails != null) {
            String[] data = {PostDetailFragment.this.mPostDetails.getTitle()};
            mShareActionProvider.setShareIntent(shareIntent((data[0])));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:
                openShareIntent(PostDetailFragment.this.mPostDetails.getTitle());
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openShareIntent(String s) {
        if (s != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.post_extra_subject));
            intent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(Intent.createChooser(intent, getActivity().getString(R.string.share)));
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

       // if (null != mPostDetails)

/*
        try {
            Glide.with(getActivity())
                    .load(mPostDetails.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mBackdrop);

            Bitmap posterBitmap = ((BitmapDrawable) mBackdrop.getDrawable()).getBitmap();
            Palette.from(posterBitmap).

                    generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                int colorTransparent = ContextCompat.getColor(getContext(), (R.color.transparent));
                                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                getActivity().getWindow().setStatusBarColor(colorTransparent);
                                //fab.setBackgroundTintList(ColorStateList.valueOf(colorDark));

                            }
                            mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getContext(), (R.color.colorPrimaryTransparent)));
                        }
                    });
        }
        catch (Exception e)
        {
            Log.d("bitttt",e.toString());
        }
*/
/*
        Glide.with(getActivity())
                .load(mPostDetails.getImageUrl())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                           Bitmap posterBitmap = BitmapFactory.decodeResource(getActivity().getResources(),
                                  );

                        return false;
                    }
                })
                .into(mBackdrop);
*/

       // Glide.with(getActivity()).load(mPostDetails.getImageUrl()).into(mBackdrop);
        Glide.with(getActivity())
                .load(mPostDetails.getImageUrl())
                .asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new BitmapImageViewTarget(mBackdrop) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //    Bitmap posterBitmap = ((BitmapDrawable) mBackdrop.getDrawable()).getBitmap();
                        mBackdrop.setImageBitmap(resource);
                        Palette.from(resource).

                                generate(new Palette.PaletteAsyncListener() {
                                    @Override
                                    public void onGenerated(Palette palette) {
                                        //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            int colorTransparent = ContextCompat.getColor(getContext(), (R.color.transparent));
                                            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                            getActivity().getWindow().setStatusBarColor(colorTransparent);
                                            //fab.setBackgroundTintList(ColorStateList.valueOf(colorDark));

                                        }
                                        mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getContext(), (R.color.colorPrimaryTransparent)));
                                    }
                                });
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {


                    }
                });


      /*      Picasso.with(getContext()).load(mPostDetails.getImageUrl())
                    .into(mBackdrop, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap posterBitmap = ((BitmapDrawable) mBackdrop.getDrawable()).getBitmap();
                            Palette.from(posterBitmap).generate(new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                        int colorTransparent = ContextCompat.getColor(getContext(), (R.color.transparent));
                                        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                                        getActivity().getWindow().setStatusBarColor(colorTransparent);
                                        //fab.setBackgroundTintList(ColorStateList.valueOf(colorDark));

                                    }
                                    mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getContext(), (R.color.colorPrimaryTransparent)));
                                }
                            });
                        }

                        @Override
                        public void onError() {

                        }
                    });
*/
                        mCollapsingToolbarLayout.setTitle(mPostDetails.getTitle());

                        mLayoutManager = new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        if (null != mPostDetails) {
                            mAdapter = new PostDetailsAdapter(mPostDetails, getActivity());
                            mRecyclerView.setAdapter(mAdapter);
                        }

                        //register our review content listener
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                addToFavorites(v);
                            }
                        });

                        super.onActivityCreated(savedInstanceState);
                    }


                    private void addToFavorites(View v) {
                        Snackbar.make(mCollapsingToolbarLayout, "add to favorite code", Snackbar.LENGTH_LONG)
                                .show();
                    }

                    public Intent shareIntent(String data) {
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.post_extra_subject));
                        sharingIntent.putExtra(Intent.EXTRA_TEXT, data);
                        return sharingIntent;
                    }
                }