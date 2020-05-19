
package com.example.android.autofill.service.data;

import com.example.android.autofill.service.model.DatasetWithFilledAutofillFields;

import java.util.List;

public interface AutofillDataBuilder {
    List<DatasetWithFilledAutofillFields> buildDatasetsByPartition(int datasetNumber);
}
