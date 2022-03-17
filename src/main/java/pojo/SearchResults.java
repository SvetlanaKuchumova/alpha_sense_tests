package pojo;

import java.util.List;

public class SearchResults {

    private String cursorToken;
    private Integer originalStatementCount;
    private List<Statements> statements;

    public String getCursorToken() {
        return cursorToken;
    }

    public void setCursorToken(String cursorToken) {
        this.cursorToken = cursorToken;
    }

    public Integer getOriginalStatementCount() {
        return originalStatementCount;
    }

    public void setOriginalStatementCount(Integer originalStatementCount) {
        this.originalStatementCount = originalStatementCount;
    }

    public List<Statements> getStatements() {
        return statements;
    }

    public void setStatements(List<Statements> statements) {
        this.statements = statements;
    }
}
