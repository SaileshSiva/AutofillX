
package com.example.android.autofill.service.data.source.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.android.autofill.service.data.source.PackageVerificationDataSource;
import com.example.android.autofill.service.util.SecurityHelper;

import static com.example.android.autofill.service.util.Util.logd;
import static com.example.android.autofill.service.util.Util.logw;

public class SharedPrefsPackageVerificationRepository implements PackageVerificationDataSource {

    private static final String SHARED_PREF_KEY = "com.example.android.autofill.service"
            + ".datasource.PackageVerificationDataSource";
    private static PackageVerificationDataSource sInstance;

    private final SharedPreferences mSharedPrefs;
    private final Context mContext;

    private SharedPrefsPackageVerificationRepository(Context context) {
        mSharedPrefs = context.getApplicationContext()
                .getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        mContext = context.getApplicationContext();
    }

    public static PackageVerificationDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPrefsPackageVerificationRepository(
                    context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void clear() {
        mSharedPrefs.edit().clear().apply();
    }

    @Override
    public boolean putPackageSignatures(String packageName) {
        String hash;
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            hash = SecurityHelper.getFingerprint(packageInfo, packageName);
            logd("Hash for %s: %s", packageName, hash);
        } catch (Exception e) {
            logw(e, "Error getting hash for %s.", packageName);
            return false;
        }

        if (!containsSignatureForPackage(packageName)) {
            // Storage does not yet contain signature for this package name.
            mSharedPrefs.edit().putString(packageName, hash).apply();
            return true;
        }
        return containsMatchingSignatureForPackage(packageName, hash);
    }

    private boolean containsSignatureForPackage(String packageName) {
        return mSharedPrefs.contains(packageName);
    }

    private boolean containsMatchingSignatureForPackage(String packageName,
            String hash) {
        return hash.equals(mSharedPrefs.getString(packageName, null));
    }
}
