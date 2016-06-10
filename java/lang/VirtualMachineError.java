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
 * 抛出该错误，以指示JVM已损坏或者继续运行所需的资源已耗尽。
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */
abstract public class VirtualMachineError extends Error {
    private static final long serialVersionUID = 4161983926571568670L;

    /**
     * 构造一个没有详细说明信息的<code>VirtualMachineError</code>。
     */
    public VirtualMachineError() {
        super();
    }

    /**
     * 构造一个具有详细说明信息的<code>VirtualMachineError</code>。
     *
     * @param   message   详细信息。
     */
    public VirtualMachineError(String message) {
        super(message);
    }

    /**
     * 构造一个具有详细说明信息和起因的<code>VirtualMachineError</code>。
     * <p>注意与{@code cause}关联的详细信息不会自动包含在该错误的详细信息中。
     *
     * @param  message 纤细信息（保存后用于{@link #getMessage()}方法取回使用）
     * @param  cause 起因（保存后用于{@link #getCause()}方法取回使用）。
     * 		         （允许{@code null}值，表示该起因不存在或未知 ）。
     * @since  1.8
     */
    public VirtualMachineError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造一个具有详细起因和{@code (cause==null ? null : cause.toString())}
     * 详细信息的{@code VirtualMachineError}。
     * （通常包含类和{@code cause}的详细信息）。
     *
     * @param  cause 起因 （保存后用于{@link #getCause()}方法取回使用）。
     * 		         （允许{@code null}值，表示该起因不存在或未知 ）。
     * @since  1.8
     */
    public VirtualMachineError(Throwable cause) {
        super(cause);
    }
}
