package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

public interface IUseCaseCallback<T> {
    void onSuccess(T response);
    void onError();
}
