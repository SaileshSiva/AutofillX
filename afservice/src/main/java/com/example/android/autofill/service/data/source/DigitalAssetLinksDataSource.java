
package com.example.android.autofill.service.data.source;

import com.example.android.autofill.service.data.DataCallback;
import com.example.android.autofill.service.model.DalCheck;
import com.example.android.autofill.service.model.DalInfo;

import static com.example.android.autofill.service.util.Util.DalCheckRequirement;

/**
 * Data source for
 * <a href="https://developers.google.com/digital-asset-links/">Digital Asset Links</a>.
 */
public interface DigitalAssetLinksDataSource {

    /**
     * Checks if the association between a web domain and a package is valid.
     */
    void checkValid(DalCheckRequirement dalCheckRequirement, DalInfo dalInfo,
            DataCallback<DalCheck> dalCheckCallback);

    /**
     * Clears all cached data.
     */
    void clear();
}
