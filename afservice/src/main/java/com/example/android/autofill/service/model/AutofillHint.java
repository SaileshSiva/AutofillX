

package com.example.android.autofill.service.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"autofillHint"}, foreignKeys = @ForeignKey(
        entity = FieldType.class, parentColumns = "typeName", childColumns = "fieldTypeName",
        onDelete = ForeignKey.CASCADE))
public class AutofillHint {

    @NonNull
    @ColumnInfo(name = "autofillHint")
    public String mAutofillHint;

    @NonNull
    @ColumnInfo(name = "fieldTypeName")
    public String mFieldTypeName;

    public AutofillHint(@NonNull String autofillHint, @NonNull String fieldTypeName) {
        this.mAutofillHint = autofillHint;
        this.mFieldTypeName = fieldTypeName;
    }
}
