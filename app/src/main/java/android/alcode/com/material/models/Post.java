package android.alcode.com.material.models;

/**
 * Created by MOMANI on 2016/03/22.
 * this class for items in main activity
 */
public class Post {
    private String id;
    private String title;
    private String imageUrl;
    private String Overview;

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public Post() {

    }

    public Post(String id, String title, String imageUrl) {

        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;

    }

    public Post(String id, String title, String imageUrl, String overview) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        Overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /*
    public String getOverview() {
       return Database.getInstance().getMovieDetailsFromID(id).getLongDescription();
    }
    */
/*
    public String getPostOverview(String id) {
        return Database.getInstance().getMovieDetailsFromID(id).getLongDescription();
    }

    */
}
