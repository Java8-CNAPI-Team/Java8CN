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
 * 当JVM试图读取一个类文件，并确定该文件存在格式错误或不能解析为类文件时抛出。
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class ClassFormatError extends LinkageError {
    private static final long serialVersionUID = -8420114879011949195L;

    /**
     * 构造一个无参（详细消息）的 <code>ClassFormatError</code>。
     */
    public ClassFormatError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>ClassFormatError</code>。
     *
     * @param   s   详细消息。
     */
    public ClassFormatError(String s) {
        super(s);
    }
}
