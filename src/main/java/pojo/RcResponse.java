package pojo;

import java.util.List;

public class RcResponse {

    private List<Topics> topics;
    private SearchResults searchResults;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }
}
