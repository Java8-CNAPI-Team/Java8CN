/*
 * Copyright (c) 1994, 2008, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

/**
 * 若程序试图创建大小为负的数组则抛出。
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class NegativeArraySizeException extends RuntimeException {
    private static final long serialVersionUID = -8960118058596991861L;

    /**
     * 构造一个无参（详细消息）的 <code>NegativeArraySizeException</code>。
     * 
     */
    public NegativeArraySizeException() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>NegativeArraySizeException</code>。
     * 
     *
     * @param   s   详细信息.
     */
    public NegativeArraySizeException(String s) {
        super(s);
    }
}
