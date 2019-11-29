package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.feed;

import java.util.List;

import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;
import punchclub.lightweight.nsu.ru.android.punchclubapp.modules.base.IBaseView;

interface IFeedView extends IBaseView<IFeedPresenter> {

    void showArticles(List<Post> postList);

    void openArticleDetailScreen(String artickleId);

}