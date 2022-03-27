package com.alphasense.rc.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Statements {

    private String accessionNumber;
    private List<String> collapsedStatements;
    private String content;
    private Boolean context;
    private Integer page;
    private Boolean recurring;
    private Integer snippetCount;
    private Integer snippetOffset;
    private String statementId;
    private Integer statementIndex;
    private Integer statementIndexOffset;
}
