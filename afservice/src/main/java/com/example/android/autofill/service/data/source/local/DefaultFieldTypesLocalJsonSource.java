
package com.example.android.autofill.service.data.source.local;

import android.content.res.Resources;

import com.example.android.autofill.service.R;
import com.example.android.autofill.service.data.source.DefaultFieldTypesSource;
import com.example.android.autofill.service.model.DefaultFieldTypeWithHints;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import static com.example.android.autofill.service.util.Util.loge;

public class DefaultFieldTypesLocalJsonSource implements DefaultFieldTypesSource {
    private static DefaultFieldTypesLocalJsonSource sInstance;

    private final Resources mResources;
    private final Gson mGson;

    private DefaultFieldTypesLocalJsonSource(Resources resources, Gson gson) {
        mResources = resources;
        mGson = gson;
    }

    public static DefaultFieldTypesLocalJsonSource getInstance(Resources resources, Gson gson) {
        if (sInstance == null) {
            sInstance = new DefaultFieldTypesLocalJsonSource(resources, gson);
        }
        return sInstance;
    }

    @Override
    public List<DefaultFieldTypeWithHints> getDefaultFieldTypes() {
        Type fieldTypeListType =  TypeToken.getParameterized(List.class,
                DefaultFieldTypeWithHints.class).getType();
        InputStream is = mResources.openRawResource(R.raw.default_field_types);
        List<DefaultFieldTypeWithHints> fieldTypes = null;
        try(Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            fieldTypes = mGson.fromJson(reader, fieldTypeListType);
        } catch (IOException e) {
            loge(e, "Exception during deserialization of FieldTypes.");
        }
        return fieldTypes;
    }
}
