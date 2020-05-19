

package com.example.android.autofill.service.data.source;

import com.example.android.autofill.service.model.DefaultFieldTypeWithHints;

import java.util.List;

public interface DefaultFieldTypesSource {
    List<DefaultFieldTypeWithHints> getDefaultFieldTypes();
}
