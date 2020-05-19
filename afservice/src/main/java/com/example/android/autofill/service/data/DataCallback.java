

package com.example.android.autofill.service.data;

public interface DataCallback<T> {
    void onLoaded(T object);

    void onDataNotAvailable(String msg, Object... params);
}
