
package com.example.android.autofill.service.data.source;

import com.example.android.autofill.service.data.DataCallback;
import com.example.android.autofill.service.model.DatasetWithFilledAutofillFields;
import com.example.android.autofill.service.model.FieldType;
import com.example.android.autofill.service.model.FieldTypeWithHeuristics;
import com.example.android.autofill.service.model.FilledAutofillField;
import com.example.android.autofill.service.model.ResourceIdHeuristic;

import java.util.HashMap;
import java.util.List;

public interface AutofillDataSource {

    /**
     * Asynchronously gets saved list of {@link DatasetWithFilledAutofillFields} that contains some
     * objects that can autofill fields with these {@code autofillHints}.
     */
    void getAutofillDatasets(List<String> allAutofillHints,
            DataCallback<List<DatasetWithFilledAutofillFields>> datasetsCallback);

    void getAllAutofillDatasets(
            DataCallback<List<DatasetWithFilledAutofillFields>> datasetsCallback);

    /**
     * Asynchronously gets a saved {@link DatasetWithFilledAutofillFields} for a specific
     * {@code datasetName} that contains some objects that can autofill fields with these
     * {@code autofillHints}.
     */
    void getAutofillDataset(List<String> allAutofillHints,
            String datasetName, DataCallback<DatasetWithFilledAutofillFields> datasetsCallback);

    /**
     * Stores a collection of Autofill fields.
     */
    void saveAutofillDatasets(List<DatasetWithFilledAutofillFields>
            datasetsWithFilledAutofillFields);

    void saveResourceIdHeuristic(ResourceIdHeuristic resourceIdHeuristic);

    /**
     * Gets all autofill field types.
     */
    void getFieldTypes(DataCallback<List<FieldTypeWithHeuristics>> fieldTypesCallback);

    /**
     * Gets all autofill field types.
     */
    void getFieldType(String typeName, DataCallback<FieldType> fieldTypeCallback);

    void getFieldTypeByAutofillHints(
            DataCallback<HashMap<String, FieldTypeWithHeuristics>> fieldTypeMapCallback);

    void getFilledAutofillField(String datasetId, String fieldTypeName, DataCallback<FilledAutofillField> fieldCallback);

    /**
     * Clears all data.
     */
    void clear();
}
