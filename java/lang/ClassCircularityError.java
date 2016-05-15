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
 * 当JVM检测到类加载时，超类层次中存在循环调用时抛出。
 * 
 * @author     unascribed
 * @since      JDK1.0
 */
public class ClassCircularityError extends LinkageError {
    private static final long serialVersionUID = 1054362542914539689L;

    /**
     * 构造一个无参（详细消息）的 <code>ClassCircularityError</code>。
     * 
     */
    public ClassCircularityError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>ClassCircularityError</code>。
     *
     * @param  s 详细消息。
     */
    public ClassCircularityError(String s) {
        super(s);
    }
}
