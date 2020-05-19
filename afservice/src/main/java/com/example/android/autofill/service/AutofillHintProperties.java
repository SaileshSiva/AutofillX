
package com.example.android.autofill.service;

import android.view.View;

import com.example.android.autofill.service.model.FilledAutofillField;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Holds the properties associated with an autofill hint in this Autofill Service.
 */
public final class AutofillHintProperties {

    private String mAutofillHint;
    private FakeFieldGenerator mFakeFieldGenerator;
    private Set<Integer> mValidTypes;
    private int mSaveType;
    private int mPartition;

    public AutofillHintProperties(String autofillHint, int saveType, int partitionNumber,
            FakeFieldGenerator fakeFieldGenerator, Integer... validTypes) {
        mAutofillHint = autofillHint;
        mSaveType = saveType;
        mPartition = partitionNumber;
        mFakeFieldGenerator = fakeFieldGenerator;
        mValidTypes = new HashSet<>(Arrays.asList(validTypes));
    }

    /**
     * Generates dummy autofill field data that is relevant to the autofill hint.
     */
    public FilledAutofillField generateFakeField(int seed, String datasetId) {
        return mFakeFieldGenerator.generate(seed, datasetId);
    }

    /**
     * Returns autofill hint associated with these properties. If you save a field that uses a W3C
     * hint, there is a chance this will return a different but analogous hint, when applicable.
     * For example, W3C has hint 'email' and {@link android.view.View} has hint 'emailAddress', so
     * the W3C hint should map to the hint defined in {@link android.view.View} ('emailAddress').
     */
    public String getAutofillHint() {
        return mAutofillHint;
    }

    /**
     * Returns how this hint maps to a {@link android.service.autofill.SaveInfo} type.
     */
    public int getSaveType() {
        return mSaveType;
    }

    /**
     * Returns which data partition this autofill hint should be a part of. See partitions defined
     * in {@link AutofillHints}.
     */
    public int getPartition() {
        return mPartition;
    }


    /**
     * Sometimes, data for a hint should only be stored as a certain AutofillValue type. For
     * example, it is recommended that data representing a Credit Card Expiration date, annotated
     * with the hint {@link View#AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE}, should
     * only be stored as {@link View#AUTOFILL_TYPE_DATE}.
     */
    public boolean isValidType(int type) {
        return mValidTypes.contains(type);
    }

    public Set<Integer> getTypes() {
        return mValidTypes;
    }
}
