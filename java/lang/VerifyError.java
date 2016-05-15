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
 * 当“校验器”检测到一个类文件格式正确，但包含一些内部一致性问题或安全问题时抛出。
 * 
 * @author  unascribed
 * @since   JDK1.0
 */
public
class VerifyError extends LinkageError {
    private static final long serialVersionUID = 7001962396098498785L;

    /**
     * 构造一个无参（详细消息）的 <code>VerifyError</code>。
     */
    public VerifyError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>VerifyError</code>。
     *
     * @param   s   详细信息。
     */
    public VerifyError(String s) {
        super(s);
    }
}
