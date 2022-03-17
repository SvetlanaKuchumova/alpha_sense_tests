package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Documents {

    ALPHA_SENSE_DOC_UI("doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743"),
    ALPHA_SENSE_DOC_API("/PR-386ea743f2a90399fb0e4300ddf37d0697abc743/keyword-search/");

    @Getter
    private String value;
}
