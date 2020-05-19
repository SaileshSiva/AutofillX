
package com.example.android.autofill.service.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"id"})
public class AutofillDataset {
    @NonNull
    @ColumnInfo(name = "id")
    private final String mId;

    @NonNull
    @ColumnInfo(name = "datasetName")
    private final String mDatasetName;

    @NonNull
    @ColumnInfo(name = "packageName")
    private final String mPackageName;

    public AutofillDataset(@NonNull String id, @NonNull String datasetName,
                           @NonNull String packageName) {
        mId = id;
        mDatasetName = datasetName;
        mPackageName = packageName;
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @NonNull
    public String getDatasetName() {
        return mDatasetName;
    }

    @NonNull
    public String getPackageName() {
        return mPackageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutofillDataset that = (AutofillDataset) o;

        if (!mId.equals(that.mId)) return false;
        if (!mDatasetName.equals(that.mDatasetName)) return false;
        return mPackageName.equals(that.mPackageName);
    }

    @Override
    public int hashCode() {
        int result = mId.hashCode();
        result = 31 * result + mDatasetName.hashCode();
        result = 31 * result + mPackageName.hashCode();
        return result;
    }
}
