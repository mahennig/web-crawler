package com.markushennig.scraper.parsers;

public class StatusParser {

    public static FacebookStatus getStatus(String source) {
        return resolveStatusFromHtml(source);
    }

    private static FacebookStatus resolveStatusFromHtml(String code) {
        return FacebookStatus.OFFLINE;
    }


}
