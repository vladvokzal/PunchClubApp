package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.feed;

import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;
import punchclub.lightweight.nsu.ru.android.punchclubapp.modules.base.IBasePresenter;

interface IFeedPresenter extends IBasePresenter {
    void tapOnArticle(Post post);
}
