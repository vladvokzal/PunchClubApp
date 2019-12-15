package ru.nsu.lightweight.punchclub.punchlist.data;

import ru.nsu.lightweight.punchclub.punchlist.model.Post;

import java.util.List;
import java.util.UUID;

public interface IArticlesDataSource {

    interface ILoadArticlesCallback{
        void onArticlesLoaded(List<Post> posts);
    }

    interface ILoadArticleCallback{
        void onArticleLoaded(Post post);
    }

    void getArticles(ILoadArticlesCallback callback);

    void getArticle(UUID articleId, ILoadArticleCallback callback);
}
