package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

public class UseCaseThreadPoolScheduler implements IUseCaseScheduler {
    @Override
    public void execute(Runnable runnable) {
        
    }

    @Override
    public <T extends UseCase.ResponseValues> void onResponse(T response, IUseCaseCallback<T> callback) {

    }

    @Override
    public <T extends UseCase.ResponseValues> void onError(IUseCaseCallback<T> callback) {

    }
}
