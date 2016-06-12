/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * {@code String}类的方法抛出，表明索引为负或者超出字符串的大小。
 * 对于某些方法，比如charAt方法，该异常会在索引与字符串大小相同时抛出。
 * 
 * @author  unascribed
 * @see     java.lang.String#charAt(int)
 * @since   JDK1.0
 */
public
class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * 构造一个无参的{@code StringIndexOutOfBoundsException}。
     *
     * @since   JDK1.0.
     */
    public StringIndexOutOfBoundsException() {
        super();
    }

    /**
     * 构造一个具有指定详细信息的{@code StringIndexOutOfBoundsException}。
     *
     * @param   s   详细信息
     */
    public StringIndexOutOfBoundsException(String s) {
        super(s);
    }

    /**
     * 构造一个具有非法索引参数的{@code StringIndexOutOfBoundsException}类。
     *
     * @param   index   非法索引
     */
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }
}
