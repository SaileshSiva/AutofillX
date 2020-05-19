
package com.example.android.autofill.service.data.source;

public interface PackageVerificationDataSource {

    /**
     * Verifies that the signatures in the passed {@code Context} match what is currently in
     * storage. If there are no current signatures in storage for this packageName, it will store
     * the signatures from the passed {@code Context}.
     *
     * @return {@code true} if signatures for this packageName are not currently in storage
     * or if the signatures in the passed {@code Context} match what is currently in storage;
     * {@code false} if the signatures in the passed {@code Context} do not match what is
     * currently in storage or if an {@code Exception} was thrown while generating the signatures.
     */
    boolean putPackageSignatures(String packageName);

    /**
     * Clears all signature data currently in storage.
     */
    void clear();
}
