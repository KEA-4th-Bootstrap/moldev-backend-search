package org.bootstrap.search.utils;

import org.bootstrap.search.common.error.EnumTypeException;
import org.bootstrap.search.document.CategoryType;

import static org.bootstrap.search.common.error.GlobalErrorCode.INVALID_ENUM_CODE;

public class PostCategoryConverter {
    public static CategoryType convertCodeToDesc(Integer code) {
        if (code == null) {
            return null;
        }
        for (CategoryType type : CategoryType.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new EnumTypeException(INVALID_ENUM_CODE);
    }

}
