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
 * 在应用程序试图调用类（无论是静态类还是类的实例）中一个未定义的方法时抛出。
 * <p>
 * 通常，该错误由编译器捕获； 这个错误
 * 只发生在运行时，原因是类的新老代码不兼容。
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class NoSuchMethodError extends IncompatibleClassChangeError {
    private static final long serialVersionUID = -3765521442372831335L;

    /**
     * 构造一个无参（详细消息）的 <code>NoSuchMethodError</code>。
     */
    public NoSuchMethodError() {
        super();
    }

    /**
     * 构造一个带参数（指定详细消息）的 <code>NoSuchMethodError</code>。
     *
     * @param   s   详细消息.
     */
    public NoSuchMethodError(String s) {
        super(s);
    }
}
