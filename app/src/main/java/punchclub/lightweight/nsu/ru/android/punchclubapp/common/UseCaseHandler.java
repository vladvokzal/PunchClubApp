package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

public class UseCaseHandler {

    private UseCaseHandler(IUseCaseScheduler scheduler) {
        this.useCaseScheduler = scheduler;
    }

    public static UseCaseHandler getInstance(){
        if (instance == null){
            //create executor and pass it to constructor
            instance = new UseCaseHandler(null);
        }
        return instance;
    }

    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValues>
    void execute(final UseCase<T, R> useCase, T requestValues, IUseCaseCallback<R> callback){
        useCase.setRequestValues(requestValues);
        useCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    <T extends UseCase.ResponseValues> void notifyResponse(T response, IUseCaseCallback<T> useCaseCallback){
        useCaseScheduler.onResponse(response, useCaseCallback);
    }

    <T extends UseCase.ResponseValues> void notifyError(IUseCaseCallback<T> useCaseCallback){
        useCaseScheduler.onError(useCaseCallback);
    }

    private static UseCaseHandler instance;
    private final IUseCaseScheduler useCaseScheduler;
}
