/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * {@code Void}类是无法实例化的占位符类，
 * 它持有表示 Java关键字 void的{@code Class}对象的引用。
 *
 * @author  unascribed
 * @since   JDK1.1
 */
public final
class Void {
	
    /**
     * {@code Class}对象表示对应关键字{@code void}的伪类型
     */
    @SuppressWarnings("unchecked")
    public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");

    /*
     * Void类无法被实例化
     */
    private Void() {}
}
