package com.capitole.common.handleExceptions.to;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public enum ErrorCode {
    MULTIPLERESULTS("TT-0001", "Two or more products meet the requirements");

    private static final ErrorCode[] VALUES = values();
    private final String value;
    private final String reasonPhrase;

    private ErrorCode(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public String value() {
        return this.value;
    }
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public static ErrorCode valueOf(int statusCode) {
        ErrorCode errorCode = resolve(statusCode);
        if (errorCode == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        } else {
            return errorCode;
        }
    }
    @Nullable
    public static ErrorCode resolve(int statusCode) {
        ErrorCode[] var1 = VALUES;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode status = var1[var3];
            if (status.value.equals(statusCode)) {
                return status;
            }
        }

        return null;
    }

}
