
package com.example.android.autofill.service.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import static com.example.android.autofill.service.data.source.local.db.Converters.IntList;

@Entity(primaryKeys = {"typeName"})
public class FieldType {
    @NonNull
    @ColumnInfo(name = "typeName")
    private final String mTypeName;

    @NonNull
    @ColumnInfo(name = "autofillTypes")
    private final IntList mAutofillTypes;

    @NonNull
    @ColumnInfo(name = "saveInfo")
    private final Integer mSaveInfo;

    @NonNull
    @ColumnInfo(name = "partition")
    private final Integer mPartition;

    @NonNull
    @Embedded
    private final FakeData mFakeData;

    public FieldType(@NonNull String typeName, @NonNull IntList autofillTypes,
            @NonNull Integer saveInfo, @NonNull Integer partition, @NonNull FakeData fakeData) {
        mTypeName = typeName;
        mAutofillTypes = autofillTypes;
        mSaveInfo = saveInfo;
        mPartition = partition;
        mFakeData = fakeData;
    }

    @NonNull
    public String getTypeName() {
        return mTypeName;
    }

    @NonNull
    public IntList getAutofillTypes() {
        return mAutofillTypes;
    }

    @NonNull
    public Integer getSaveInfo() {
        return mSaveInfo;
    }

    @NonNull
    public Integer getPartition() {
        return mPartition;
    }

    @NonNull
    public FakeData getFakeData() {
        return mFakeData;
    }
}