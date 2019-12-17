package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

public final class UseCaseCallbackWrapper<T extends UseCase.ResponseValues> implements IUseCaseCallback<T> {
    @Override
    public void onSuccess(T response) {
        useCaseHandler.notifyResponse(response, callback);
    }

    @Override
    public void onError() {
        useCaseHandler.notifyError(callback);
    }

    UseCaseCallbackWrapper(IUseCaseCallback<T> callback, UseCaseHandler useCaseHandler){
        this.callback = callback;
        this.useCaseHandler = useCaseHandler;
    }

    private final IUseCaseCallback<T> callback;
    private final UseCaseHandler useCaseHandler;
}
