/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * 在未知且严重的异常发生时由JVM抛出。
 *
 * @author unascribed
 * @since   JDK1.0
 */
public
class UnknownError extends VirtualMachineError {
    private static final long serialVersionUID = 2524784860676771849L;

    /**
     * 构造一个无参（详细消息）的 <code>UnknownError</code>。
     */
    public UnknownError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>UnknownError</code>。
     *
     * @param   s   详细消息.
     */
    public UnknownError(String s) {
        super(s);
    }
}
