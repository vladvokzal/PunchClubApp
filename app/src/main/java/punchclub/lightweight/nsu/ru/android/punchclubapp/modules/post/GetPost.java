package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.post;

import android.util.Log;

import java.util.UUID;

import punchclub.lightweight.nsu.ru.android.punchclubapp.common.Constants;
import punchclub.lightweight.nsu.ru.android.punchclubapp.common.UseCase;
import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;

public class GetPost extends UseCase<GetPost.RequestValues, GetPost.ResponseValues> {

    GetPost(){
        Log.d(Constants.STACK_TRACE_LOG_TAG, "GetArticles.init");
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        Log.d(Constants.STACK_TRACE_LOG_TAG, "GetArticles.executeUseCase");

        UUID articleId = requestValues.getArticleId();
        //do smth. with post repo by articleId
    }

    public static final class RequestValues implements UseCase.RequestValues{
        private UUID articleId;

        RequestValues(UUID articleId) {
            this.articleId = articleId;
        }

        public UUID getArticleId() {
            return articleId;
        }
    }

    static final class ResponseValues implements UseCase.ResponseValues{

        private final Post post;

        ResponseValues(Post post) {
            this.post = post;
        }

        Post getPost() {
            return post;
        }
    }

}