

package com.example.android.autofill.service.data.source;

import com.example.android.autofill.service.model.DalCheck;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DalService {
    @GET("/v1/assetlinks:check")
    Call<DalCheck> check(@Query("source.web.site") String webDomain,
            @Query("relation") String permission,
            @Query("target.android_app.package_name") String packageName,
            @Query("target.android_app.certificate.sha256_fingerprint") String fingerprint);
}