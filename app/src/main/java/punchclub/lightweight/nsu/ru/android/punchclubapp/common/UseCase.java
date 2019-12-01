package punchclub.lightweight.nsu.ru.android.punchclubapp.common;

import android.util.Log;

public abstract class UseCase<RequestType extends UseCase.RequestValues,
        ResponseType extends UseCase.ResponseValues> {


    void run(){
        Log.d(Constants.STACK_TRACE_LOG_TAG, "UseCase.run");
        executeUseCase(requestValues);
    }

    protected abstract void executeUseCase(RequestType requestValues);

    public RequestType getRequestValues() {
        return requestValues;
    }

    void setRequestValues(RequestType requestValues) {
        this.requestValues = requestValues;
    }

    public IUseCaseCallback<ResponseType> getUseCaseCallback() {
        return useCaseCallback;
    }

    void setUseCaseCallback(IUseCaseCallback<ResponseType> useCaseCallback) {
        this.useCaseCallback = useCaseCallback;
    }

    public interface ResponseValues {};
    public interface RequestValues {};

    private RequestType requestValues;
    private IUseCaseCallback<ResponseType> useCaseCallback;
}
