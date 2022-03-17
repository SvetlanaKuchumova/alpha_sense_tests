package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Documents {

    ALPHA_SENSE_DOC("doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743");

    @Getter
    private String value;
}
