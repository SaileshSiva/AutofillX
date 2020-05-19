
package com.example.android.autofill.service;

import android.support.annotation.DrawableRes;
import android.widget.RemoteViews;

/**
 * This is a class containing helper methods for building Autofill Datasets and Responses.
 */
public final class RemoteViewsHelper {
    private RemoteViewsHelper() {
    }

    public static RemoteViews viewsWithAuth(String packageName, String text) {
        return simpleRemoteViews(packageName, text, R.drawable.ic_lock_black_24dp);
    }

    public static RemoteViews viewsWithNoAuth(String packageName, String text) {
        return simpleRemoteViews(packageName, text, R.drawable.ic_person_black_24dp);
    }

    private static RemoteViews simpleRemoteViews(String packageName, String remoteViewsText,
            @DrawableRes int drawableId) {
        RemoteViews presentation = new RemoteViews(packageName,
                R.layout.multidataset_service_list_item);
        presentation.setTextViewText(R.id.text, remoteViewsText);
        presentation.setImageViewResource(R.id.icon, drawableId);
        return presentation;
    }
}
