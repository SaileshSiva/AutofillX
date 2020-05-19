
package com.example.android.autofill.service;

import com.example.android.autofill.service.model.FilledAutofillField;

interface FakeFieldGenerator {
    FilledAutofillField generate(int seed, String datasetId);
}
