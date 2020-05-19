
package com.example.android.autofill.service.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class DatasetWithFilledAutofillFields {
    @Embedded
    public AutofillDataset autofillDataset;

    @Relation(parentColumn = "id", entityColumn = "datasetId", entity = FilledAutofillField.class)
    public List<FilledAutofillField> filledAutofillFields;

    public void add(FilledAutofillField filledAutofillField) {
        if (filledAutofillFields == null) {
            this.filledAutofillFields = new ArrayList<>();
        }
        this.filledAutofillFields.add(filledAutofillField);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatasetWithFilledAutofillFields that = (DatasetWithFilledAutofillFields) o;

        if (autofillDataset != null ? !autofillDataset.equals(that.autofillDataset) :
                that.autofillDataset != null)
            return false;
        return filledAutofillFields != null ?
                filledAutofillFields.equals(that.filledAutofillFields) :
                that.filledAutofillFields == null;
    }

    @Override
    public int hashCode() {
        int result = autofillDataset != null ? autofillDataset.hashCode() : 0;
        result = 31 * result + (filledAutofillFields != null ? filledAutofillFields.hashCode() : 0);
        return result;
    }
}
