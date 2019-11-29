package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.base;

public interface IBaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
}
