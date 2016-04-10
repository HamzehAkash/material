package android.alcode.com.material.databases;

import android.alcode.com.material.models.Post;
import android.alcode.com.material.models.PostDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MOMANI on 2016/03/23.
 */
public class Database {
    private static Database ourInstance = new Database();
    private static Post[] posts =
            {
                    new Post("1", "Car", "http://placeimg.com/640/480/1"),
                    new Post("2", "playstation", "https://placeimg.com/640/480/2"),
                    new Post("3", "c++ book", "https://placeimg.com/640/480/3"),
                    new Post("4", "home", "https://placeimg.com/640/480/4"),
                    new Post("5", "drill", "http://placeimg.com/640/480/5")
            };

    private static List<Post> postList = new ArrayList<Post>(Arrays.asList(posts));
    public static PostDetails[] postsDetails =
            {
                    new PostDetails("1", "https://placeimg.com/640/480/1", "https://placeimg.com/640/480/arch/1", "Tree", "Limon Tree for Rent", "if you are looking for trees we can help you", "3.0 $", "23", "bulding", "Trees", "Irbid", "2 hour ago", "101"),
                    new PostDetails("2", "https://placeimg.com/640/480/2", "https://placeimg.com/640/480/arch/2", "Tree", "Limon Tree for Rent", "if you are looking for trees we can help you", "3.0 $", "15", "Technoligy", "Labtop", "Ajlout", "yesterday", "102"),
                    new PostDetails("3", "https://placeimg.com/640/480/3", "https://placeimg.com/640/480/arch/3", "c++ book", "you you need the in this semester", "the offital book of C++ from the author mike", "0 $", "5", "Library", "Books", "JUST", "Today", "103"),
                    new PostDetails("4", "https://placeimg.com/640/480/4", "https://placeimg.com/640/480/arch/4", "home", "home for rent in south neighborhood", "the offital book of C++ from the author mike", "60 $", "100", "bulding", "Houses", "Irbid", "Today", "102"),
                    new PostDetails("5", "https://placeimg.com/640/480/5", "https://placeimg.com/640/480/arch/5", "Tree", "Limon Tree for Rent", "if you are looking for trees we can help you", "3.0 $", "78", "bulding", "Trees", "Irbid", "3/20 sunday", "101")

            };
    private static List<PostDetails> postDetailsList = new ArrayList<PostDetails>(Arrays.asList(postsDetails));

    private Database() {
    }

    public static Database getInstance() {
        return ourInstance;
    }

    public List<Post> getAllPosts() {
        return postList;
    }

    public Post getMovieDataFromID(String id) {
        for (Post o : postList) {
            if (o != null && o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }



    public PostDetails getMovieDetailsFromID(String id) {
        for (PostDetails o : postDetailsList) {
            if (o != null && o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }
}
