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
 * 抛出以表明某些有序对象（比如数组，字符串，或者向量）越界。
 * <p>
 * 应用程序可以为这个类创建子类，以表明相似的异常。
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */
public
class IndexOutOfBoundsException extends RuntimeException {
    private static final long serialVersionUID = 234122996006267687L;

    /**
     * 构造一个无参的<code>IndexOutOfBoundsException</code>。
     */
    public IndexOutOfBoundsException() {
        super();
    }

    /**
     * 构造一个具有指定详细信息的<code>IndexOutOfBoundsException</code>。
     *
     * @param   s   详细信息。
     */
    public IndexOutOfBoundsException(String s) {
        super(s);
    }
}
