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
 * 当程序由于递归过深产生堆栈溢出时抛出。
 *
 * @author unascribed
 * @since   JDK1.0
 */
public
class StackOverflowError extends VirtualMachineError {
    private static final long serialVersionUID = 8609175038441759607L;

    /**
     * 构造一个无参（详细消息）的 <code>StackOverflowError</code>。
     */
    public StackOverflowError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>StackOverflowError</code>。
     *
     * @param   s   详细信息。
     */
    public StackOverflowError(String s) {
        super(s);
    }
}
