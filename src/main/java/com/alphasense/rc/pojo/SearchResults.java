package com.alphasense.rc.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SearchResults {

    private String cursorToken;
    private Integer originalStatementCount;
    private List<Statements> statements;
}
