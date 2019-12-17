package punchclub.lightweight.nsu.ru.android.punchclubapp.data.profile;

import punchclub.lightweight.nsu.ru.android.punchclubapp.model.Profile;

public interface IProfileDataSource {

    interface ILoadProfileCallback{
        void onProfileLoaded(Profile profile);
    }

    void getProfile(String name, ILoadProfileCallback callback);
}
