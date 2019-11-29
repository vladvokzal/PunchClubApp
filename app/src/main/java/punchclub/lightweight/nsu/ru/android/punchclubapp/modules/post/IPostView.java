package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.post;

import punchclub.lightweight.nsu.ru.android.punchclubapp.modules.base.IBaseView;

interface IPostView extends IBaseView<IPostPresenter> {
    void setTitle(String title);
    void setFullText(String fullText);
}
