package android.alcode.com.material.detail;

import android.alcode.com.material.R;
import android.alcode.com.material.models.PostDetails;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by MOMANI on 2016/03/23.
 */
public class PostDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private PostDetails postDetails;
    private Activity mAct;
    private LayoutInflater mInflater;
    private int mDefaultColor;

    public PostDetailsAdapter(PostDetails postDetails, Activity activity) {
        this.postDetails = postDetails;
        this.mAct = activity;
        mDefaultColor = ContextCompat.getColor(mAct, (R.color.colorPrimary));
        mInflater = (LayoutInflater) mAct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = mInflater.inflate(R.layout.layout_holder_details, parent, false);
        vh = new ViewHolderDetails(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

/*
        try {
            Glide.with(mAct)
                    .load(postDetails.getPosterUrl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(((ViewHolderDetails) holder).getImageView());

            Bitmap posterBitmap = ((BitmapDrawable) ((ViewHolderDetails) holder).getImageView().getDrawable()).getBitmap();
            Palette.from(posterBitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                    ((ViewHolderDetails) holder).getRatingsBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                    ((ViewHolderDetails) holder).getGenreBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                    ((ViewHolderDetails) holder).getPopBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                    ((ViewHolderDetails) holder).getLangBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);

                }
            });

        }
        catch (Exception e)
        {
            Log.d("Brie",e.toString());
        }
*/


        Glide.with(mAct).load(postDetails.getPosterUrl()).into(((ViewHolderDetails) holder).getImageView());
        Glide.with(mAct)
                .load(postDetails.getPosterUrl())
                .asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new BitmapImageViewTarget(((ViewHolderDetails) holder).getImageView()) {
                    @Override
                    protected void setResource(Bitmap resource) {
//                        Bitmap posterBitmap = ((BitmapDrawable) ((ViewHolderDetails) holder).getImageView().getDrawable()).getBitmap();
                        ((ViewHolderDetails) holder).getImageView().setImageBitmap(resource);
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                                ((ViewHolderDetails) holder).getRatingsBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getGenreBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getPopBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getLangBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);

                            }
                        });
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {


                    }
                });

     /*   Picasso.with(mAct).load(postDetails.getPosterUrl())
                .into(((ViewHolderDetails) holder).getImageView(), new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap posterBitmap = ((BitmapDrawable) ((ViewHolderDetails) holder).getImageView().getDrawable()).getBitmap();
                        Palette.from(posterBitmap).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                //container.setBackgroundColor(ColorUtils.setAlphaComponent(palette.getMutedColor(mDefaultColor), 190)); //Opacity
                                ((ViewHolderDetails) holder).getRatingsBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getGenreBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getPopBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);
                                ((ViewHolderDetails) holder).getLangBackground().getDrawable().setColorFilter(palette.getVibrantColor(mDefaultColor), PorterDuff.Mode.MULTIPLY);

                            }
                        });
                    }

                    @Override
                    public void onError() {

                    }
                });
       */
        ((ViewHolderDetails) holder).getTitleView().setText(postDetails.getTitle());
        ((ViewHolderDetails) holder).getTaglineView().setText(postDetails.getSubtitle());
        ((ViewHolderDetails) holder).getDurationView().setText(postDetails.getFees());
        ((ViewHolderDetails) holder).getDateStatusView().setText(postDetails.getDate());

        ((ViewHolderDetails) holder).getGenreView().setText(postDetails.getCategory());
        ((ViewHolderDetails) holder).getPopularityView().setText(postDetails.getSubCategory());
        ((ViewHolderDetails) holder).getLanguageView().setText(postDetails.getLocation());
        ((ViewHolderDetails) holder).getVoteCountView().setText(postDetails.getLikes() + " Votes");

        ((ViewHolderDetails) holder).getOverviewView().setText(postDetails.getLongDescription());


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolderDetails extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleView, taglineView, dateStatusView, durationView,
                ratingView, genreView, popularityView, languageView, overviewView, voteCountView;
        private ImageView ratingsBackground, genreBackground, popBackground, langBackground;

        public ViewHolderDetails(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.image);
            titleView = (TextView) v.findViewById(R.id.title);
            taglineView = (TextView) v.findViewById(R.id.tagline);
            dateStatusView = (TextView) v.findViewById(R.id.date_status);
            durationView = (TextView) v.findViewById(R.id.duration);
            ratingView = (TextView) v.findViewById(R.id.rating);
            genreView = (TextView) v.findViewById(R.id.genre);
            popularityView = (TextView) v.findViewById(R.id.popularity);
            languageView = (TextView) v.findViewById(R.id.language);
            overviewView = (TextView) v.findViewById(R.id.overview);
            ratingsBackground = (ImageView) v.findViewById(R.id.ratings_background);
            voteCountView = (TextView) v.findViewById(R.id.vote_count);
            genreBackground = (ImageView) v.findViewById(R.id.genre_background);
            popBackground = (ImageView) v.findViewById(R.id.pop_background);
            langBackground = (ImageView) v.findViewById(R.id.lang_background);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTitleView() {
            return titleView;
        }

        public TextView getTaglineView() {
            return taglineView;
        }

        public TextView getDateStatusView() {
            return dateStatusView;
        }

        public TextView getDurationView() {
            return durationView;
        }

        public TextView getRatingView() {
            return ratingView;
        }

        public TextView getGenreView() {
            return genreView;
        }

        public TextView getPopularityView() {
            return popularityView;
        }

        public TextView getLanguageView() {
            return languageView;
        }

        public TextView getOverviewView() {
            return overviewView;
        }

        public ImageView getRatingsBackground() {
            return ratingsBackground;
        }

        public TextView getVoteCountView() {
            return voteCountView;
        }

        public ImageView getGenreBackground() {
            return genreBackground;
        }

        public ImageView getPopBackground() {
            return popBackground;
        }

        public ImageView getLangBackground() {
            return langBackground;
        }
    }

}
