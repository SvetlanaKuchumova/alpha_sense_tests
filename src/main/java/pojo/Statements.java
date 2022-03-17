package pojo;

import java.util.List;

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

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public List<String> getCollapsedStatements() {
        return collapsedStatements;
    }

    public void setCollapsedStatements(List<String> collapsedStatements) {
        this.collapsedStatements = collapsedStatements;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getContext() {
        return context;
    }

    public void setContext(Boolean context) {
        this.context = context;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    public Integer getSnippetCount() {
        return snippetCount;
    }

    public void setSnippetCount(Integer snippetCount) {
        this.snippetCount = snippetCount;
    }

    public Integer getSnippetOffset() {
        return snippetOffset;
    }

    public void setSnippetOffset(Integer snippetOffset) {
        this.snippetOffset = snippetOffset;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public Integer getStatementIndex() {
        return statementIndex;
    }

    public void setStatementIndex(Integer statementIndex) {
        this.statementIndex = statementIndex;
    }

    public Integer getStatementIndexOffset() {
        return statementIndexOffset;
    }

    public void setStatementIndexOffset(Integer statementIndexOffset) {
        this.statementIndexOffset = statementIndexOffset;
    }
}
