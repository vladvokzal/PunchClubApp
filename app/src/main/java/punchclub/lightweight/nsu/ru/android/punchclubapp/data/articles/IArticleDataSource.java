package punchclub.lightweight.nsu.ru.android.punchclubapp.data.articles;

import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;

import java.util.List;
import java.util.UUID;

public interface IArticleDataSource {

    interface ILoadArticlesCallback{
        void onArticlesLoaded(List<Post> posts);
    }

    interface ILoadArticleCallback{
        void onArticleLoaded(Post post);
    }

    void getArticles(ILoadArticlesCallback callback);

    void getArticle(UUID articleId, ILoadArticleCallback callback);
}
