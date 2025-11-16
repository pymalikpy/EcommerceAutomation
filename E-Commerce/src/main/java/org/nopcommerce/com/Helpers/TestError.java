package org.nopcommerce.com.Helpers;

import org.bouncycastle.util.test.Test;

public class TestError extends RuntimeException {
    public TestError(String s){
        super(s);
    }
}
