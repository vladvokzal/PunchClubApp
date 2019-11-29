package punchclub.lightweight.nsu.ru.android.punchclubapp.model;

import java.util.UUID;

public class Post {

    public Post() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getFullText() {
        return fullText;
    }

    public void setChannelUuid(UUID channelUuid) {
        this.channelUuid = channelUuid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setImageLink(int imageLink) {
        this.imageLink = imageLink;
    }

    public int getImageLink() {
        return imageLink;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private UUID channelUuid;
    private UUID uuid;



    private String name;

    private String title;
    private String fullText;
    private String summary;

    private int imageLink;
}
