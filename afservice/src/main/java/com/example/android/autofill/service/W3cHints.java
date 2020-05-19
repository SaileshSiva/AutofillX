
package com.example.android.autofill.service;

public final class W3cHints {
    // Optional W3C prefixes
    public static final String PREFIX_SECTION = "section-";
    public static final String SHIPPING = "shipping";
    public static final String BILLING = "billing";
    // W3C prefixes below...
    public static final String PREFIX_HOME = "home";
    public static final String PREFIX_WORK = "work";
    public static final String PREFIX_FAX = "fax";
    public static final String PREFIX_PAGER = "pager";
    // ... require those suffix
    public static final String TEL = "tel";
    public static final String TEL_COUNTRY_CODE = "tel-country-code";
    public static final String TEL_NATIONAL = "tel-national";
    public static final String TEL_AREA_CODE = "tel-area-code";
    public static final String TEL_LOCAL = "tel-local";
    public static final String TEL_LOCAL_PREFIX = "tel-local-prefix";
    public static final String TEL_LOCAL_SUFFIX = "tel-local-suffix";
    public static final String TEL_EXTENSION = "tel_extension";
    public static final String EMAIL = "email";
    public static final String IMPP = "impp";

    private W3cHints() {
    }
}