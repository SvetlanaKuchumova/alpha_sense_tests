package com.alphasense.rc.pojo;

import lombok.Data;

@Data
public class Topics {

    private String solrTopicTag;
    private String topicLabelUI;
    private Integer pos;
    private Integer length;
}
