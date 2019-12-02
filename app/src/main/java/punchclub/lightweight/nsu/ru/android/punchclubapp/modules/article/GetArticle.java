package punchclub.lightweight.nsu.ru.android.punchclubapp.modules.article;

import android.util.Log;

import java.util.UUID;

import punchclub.lightweight.nsu.ru.android.punchclubapp.common.Constants;
import punchclub.lightweight.nsu.ru.android.punchclubapp.common.UseCase;
import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Post;

public class GetArticle extends UseCase<GetArticle.RequestValues, GetArticle.ResponseValues>{

        GetArticle(){
            Log.d(Constants.STACK_TRACE_LOG_TAG, "GetArticles.init");

        }

        @Override
        protected void executeUseCase(RequestValues requestValues) {
            Log.d(Constants.STACK_TRACE_LOG_TAG, "GetArticles.executeUseCase");

            UUID articleId = requestValues.getArticleId();
            //get article from repository and create event onSuccess
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

