package android.alcode.com.material.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MOMANI on 2016/03/23.
 * this class for detail Activity
 */
public class PostDetails implements Parcelable {
    public static final Parcelable.Creator<PostDetails> CREATOR = new Parcelable.Creator<PostDetails>() {
        public PostDetails createFromParcel(Parcel in) {
            return new PostDetails(in);
        }

        public PostDetails[] newArray(int size) {
            return new PostDetails[size];
        }
    };
    private String id, imageUrl, posterUrl, title, subtitle, longDescription, fees, likes, category, subCategory, location, date, ownerId;

    public PostDetails() {
    }

    public PostDetails(String id, String imageUrl, String posterUrl, String title, String subtitle, String longDescription, String fees, String likes, String category, String subCategory, String location, String date, String ownerId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.posterUrl = posterUrl;
        this.title = title;
        this.subtitle = subtitle;
        this.longDescription = longDescription;
        this.fees = fees;
        this.likes = likes;
        this.category = category;
        this.subCategory = subCategory;
        this.location = location;
        this.date = date;
        this.ownerId = ownerId;
    }

    public PostDetails(Parcel in) {
        id = in.readString();
        imageUrl = in.readString();
        posterUrl = in.readString();
        title = in.readString();
        subtitle = in.readString();
        longDescription = in.readString();
        fees = in.readString();
        likes = in.readString();
        category = in.readString();
        subCategory = in.readString();
        location = in.readString();
        date = in.readString();
        ownerId = in.readString();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(imageUrl);
        dest.writeString(posterUrl);
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(longDescription);
        dest.writeString(fees);
        dest.writeString(likes);
        dest.writeString(category);
        dest.writeString(subCategory);
        dest.writeString(location);
        dest.writeString(date);
        dest.writeString(ownerId);
    }
}



