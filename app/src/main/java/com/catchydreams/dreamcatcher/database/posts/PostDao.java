package com.catchydreams.dreamcatcher.database.posts;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PostDao {
    @Query("Select * from posts")
    List<PostsEntity> getAllPosts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void post(PostsEntity post);

    @Query("DELETE FROM posts")
    void deleteAllPosts();

    @Update
    void updatePost(PostsEntity post);

}
