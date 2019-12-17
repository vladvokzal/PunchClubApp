package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

import android.os.Handler;

public class UseCaseThreadPoolScheduler implements IUseCaseScheduler {
    @Override
    public void execute(Runnable runnable) {
        
    }

    @Override
    public <T extends UseCase.ResponseValues> void onResponse(final T response, final IUseCaseCallback<T> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response);
            }
        });
    }

    @Override
    public <T extends UseCase.ResponseValues> void onError(final IUseCaseCallback<T> callback) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }

    private final Handler handler = new Handler();
}
