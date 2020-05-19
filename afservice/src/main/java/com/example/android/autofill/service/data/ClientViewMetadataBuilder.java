
package com.example.android.autofill.service.data;


import android.app.assist.AssistStructure;
import android.util.MutableInt;
import android.view.autofill.AutofillId;

import com.example.android.autofill.service.ClientParser;
import com.example.android.autofill.service.model.FieldType;
import com.example.android.autofill.service.model.FieldTypeWithHeuristics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.android.autofill.service.util.Util.logd;

public class ClientViewMetadataBuilder {
    private ClientParser mClientParser;
    private HashMap<String, FieldTypeWithHeuristics> mFieldTypesByAutofillHint;

    public ClientViewMetadataBuilder(ClientParser parser,
            HashMap<String, FieldTypeWithHeuristics> fieldTypesByAutofillHint) {
        mClientParser = parser;
        mFieldTypesByAutofillHint = fieldTypesByAutofillHint;
    }

    public ClientViewMetadata buildClientViewMetadata() {
        List<String> allHints = new ArrayList<>();
        MutableInt saveType = new MutableInt(0);
        List<AutofillId> autofillIds = new ArrayList<>();
        StringBuilder webDomainBuilder = new StringBuilder();
        List<AutofillId> focusedAutofillIds = new ArrayList<>();
        mClientParser.parse((node) -> parseNode(node, allHints, saveType, autofillIds, focusedAutofillIds));
        mClientParser.parse((node) -> parseWebDomain(node, webDomainBuilder));
        String webDomain = webDomainBuilder.toString();
        AutofillId[] autofillIdsArray = autofillIds.toArray(new AutofillId[autofillIds.size()]);
        AutofillId[] focusedIds = focusedAutofillIds.toArray(new AutofillId[focusedAutofillIds.size()]);
        return new ClientViewMetadata(allHints, saveType.value, autofillIdsArray, focusedIds, webDomain);
    }

    private void parseWebDomain(AssistStructure.ViewNode viewNode, StringBuilder validWebDomain) {
        String webDomain = viewNode.getWebDomain();
        if (webDomain != null) {
            logd("child web domain: %s", webDomain);
            if (validWebDomain.length() > 0) {
                if (!webDomain.equals(validWebDomain.toString())) {
                    throw new SecurityException("Found multiple web domains: valid= "
                            + validWebDomain + ", child=" + webDomain);
                }
            } else {
                validWebDomain.append(webDomain);
            }
        }
    }

    private void parseNode(AssistStructure.ViewNode root, List<String> allHints,
            MutableInt autofillSaveType, List<AutofillId> autofillIds,
            List<AutofillId> focusedAutofillIds) {
        String[] hints = root.getAutofillHints();
        if (hints != null) {
            for (String hint : hints) {
                FieldTypeWithHeuristics fieldTypeWithHints = mFieldTypesByAutofillHint.get(hint);
                if (fieldTypeWithHints != null && fieldTypeWithHints.fieldType != null) {
                    allHints.add(hint);
                    autofillSaveType.value |= fieldTypeWithHints.fieldType.getSaveInfo();
                    autofillIds.add(root.getAutofillId());
                }
            }
        }
        if (root.isFocused()) {
            focusedAutofillIds.add(root.getAutofillId());
        }
    }
}
