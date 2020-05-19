

package com.example.android.autofill.service.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class FieldTypeWithHeuristics {
    @Embedded
    public FieldType fieldType;

    @Relation(parentColumn = "typeName", entityColumn = "fieldTypeName", entity = AutofillHint.class)
    public List<AutofillHint> autofillHints;

    @Relation(parentColumn = "typeName", entityColumn = "fieldTypeName", entity = ResourceIdHeuristic.class)
    public List<ResourceIdHeuristic> resourceIdHeuristics;

    public FieldType getFieldType() {
        return fieldType;
    }

    public List<AutofillHint> getAutofillHints() {
        return autofillHints;
    }

    public List<ResourceIdHeuristic> getResourceIdHeuristics() {
        return resourceIdHeuristics;
    }
}
