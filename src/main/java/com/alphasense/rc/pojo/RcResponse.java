package com.alphasense.rc.pojo;

import java.util.List;
import lombok.Data;

@Data
public class RcResponse {

    private List<Topics> topics;
    private SearchResults searchResults;
}
