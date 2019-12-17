package punchclub.lightweight.nsu.ru.android.punchclubapp.data;

import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;

import java.util.List;
import java.util.UUID;

public interface IPostDataSource {

    interface ILoadArticlesCallback{
        void onArticlesLoaded(List<Post> posts);
    }

    interface ILoadArticleCallback{
        void onArticleLoaded(Post post);
    }

    void getArticles(ILoadArticlesCallback callback);

    void getArticle(UUID articleId, ILoadArticleCallback callback);
}
