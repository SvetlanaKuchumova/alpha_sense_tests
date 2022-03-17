package pojo;

public class Topics {

    private String solrTopicTag;
    private String topicLabelUI;
    private Integer pos;
    private Integer length;

    public String getSolrTopicTag() {
        return solrTopicTag;
    }

    public void setSolrTopicTag(String solrTopicTag) {
        this.solrTopicTag = solrTopicTag;
    }

    public String getTopicLabelUI() {
        return topicLabelUI;
    }

    public void setTopicLabelUI(String topicLabelUI) {
        this.topicLabelUI = topicLabelUI;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
