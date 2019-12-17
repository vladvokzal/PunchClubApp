package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

import android.os.Handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseCaseThreadPoolScheduler implements IUseCaseScheduler {

    UseCaseThreadPoolScheduler() {
        this.threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIME_OUT, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(POOL_SIZE));
    }

    @Override
    public void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
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

    private static final int POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 2;
    private static final int TIME_OUT = 2;

    private final ThreadPoolExecutor threadPoolExecutor;

    private final Handler handler = new Handler();
}
