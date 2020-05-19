

package com.example.android.autofill.service.model;

import com.example.android.autofill.service.data.source.local.db.Converters;

public class FakeData {
    public Converters.StringList strictExampleSet;
    public String textTemplate;
    public String dateTemplate;

    public FakeData(Converters.StringList strictExampleSet, String textTemplate, String dateTemplate) {
        this.strictExampleSet = strictExampleSet;
        this.textTemplate = textTemplate;
        this.dateTemplate = dateTemplate;
    }
}