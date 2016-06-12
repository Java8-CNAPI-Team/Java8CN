/*
 * Copyright (c) 1995, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * {@code RuntimeException}是那些可能在JVM正常运行期间抛出的异常的基类。
 * 
 * <p>{@code RuntimeException}及其派生类都是<em>非受检异常</em>。
 * 如果它们在方法或构造器运行时抛出并且传递到了方法或构造器边界之外，
 * 非受检异常无需在方法或构造器的{@code throws}子句中进行声明。
 *
 *
 * @author  Frank Yellin
 * @jls 11.2 Compile-Time Checking of Exceptions
 * @since   JDK1.0
 */
public class RuntimeException extends Exception {
    static final long serialVersionUID = -7034897190745766939L;

    /** 构造一个以{@code null}作为其详细信息的运行时异常。
     * 其起因未被初始化，可在随后对{@link #initCause}调用进行初始化。
     */
    public RuntimeException() {
        super();
    }

    /** 构造一个具有详细信息的运行时异常。 
     * 其起因未被初始化，可在随后对{@link #initCause}调用进行初始化。
     *
     * @param   message   详细信息。详细信息被保存以供{@link #getMessage()}方法取回。
     */
    public RuntimeException(String message) {
        super(message);
    }

    /**
     * 构造一个具有详细信息和起因的运行时异常。
     * <p>注意{@code cause}的详细信息不会自动的包含在该运行时异常的详细信息中。
     *
     * @param  message 详细信息（该信息被保存以供{@link #getMessage()}方法稍后取回）。
     * @param  cause 起因（该信息被保存以供{@link #getCause()}方法稍后取回）。
     * 		        （允许为<tt>null</tt>值，表明起因不存在或为止）
     * @since  1.4
     */
    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /** 构造一个具有指定起因和<tt>(cause==null ? null : cause.toString())</tt>的详细
     * 信息（一般包含类信息和<tt>cause</tt>的详细信息）。
     * 该构造器对于运行时异常的用处仅在于作为其他throwable类的封装器。
     *
     * @param  cause 起因 （该信息被保存以供{@link #getCause()}方法稍后取回）。
     * 		        （允许为<tt>null</tt>值，表明起因不存在或为止）
     * @since  1.4
     */
    public RuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造一个具有指定详细信息，起因，是否挂起异常，是否写入堆栈参数的运行时异常。
     *
     * @param  message 详细信息。
     * @param cause 起因。  （允许为<tt>null</tt>值，表明起因不存在或为止）
     * @param enableSuppression 是否挂起异常。
     * @param writableStackTrace 是否写入堆栈。
     * 
     * @since 1.7
     */
    protected RuntimeException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
