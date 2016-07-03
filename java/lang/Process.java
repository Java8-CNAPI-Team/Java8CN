/*
 * Copyright (c) 1995, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 * {@link ProcessBuilder#start()}和
 * {@link Runtime#exec(String[],String[],File) Runtime.exec}方法
 * 创建一个本地进程并返回{@code Process}的一个实例，
 * （该实例）用于控制进程并获取其信息。
 * {@code Process}类提供的方法用于获取进程的输入流，进程的输出流，
 * 等待进程执行完毕，检查进程的执行状态，以及销毁（杀死）进程。
 *
 * <p>在固定的本地平台上，创建进程的方法对特定进程的支持可能不好，比如本地窗口进程，守护进程，
 * 微软Windows中的Win16/DOS进程，或者是shell脚本。
 *
 * <p>默认的，创建的子进程没有自己的终端或控制台。其所有的标准I/O（比如stdin, stdout, stderr）
 * 操作将会重定向到其父进程中，父进程中可以通过使用方法
 * {@link #getOutputStream()},
 * {@link #getInputStream()}, 和
 * {@link #getErrorStream()}来获取的流来访问。
 * 
 * 父进程依靠这些流来从子进程获取输入和输出。
 * 由于一些本地平台只为输入输出流提供有限的缓存大小，
 * 迅速向子进程写输入流或读输出流的错误可能会引起子进程阻塞，甚至是死锁。
 *
 * <p>同时，<a href="ProcessBuilder.html#redirect-input">
 * 子进程I/O也可以使用</a>{@link ProcessBuilder}类的方法来重定向。
 *
 * <p>当不具有{@code Process}对象的引用时，
 * 子进程不会被杀死，相反子进程会继续异步执行。
 *
 * <p>进程没有必要异步运行。
 *
 * 
 * <p>1.5版本中，{@link ProcessBuilder#start()}是创建{@code Process}的首选方式。
 *
 * @since   JDK1.0
 */
public abstract class Process {
    /**
     * 获取子进程的输出流，该子进程连接标准输入。通过管道从进程的标准输入获取标准输出数据。
     *
     * <p>如果子进程的标准输入被使用{@link ProcessBuilder#redirectInput(Redirect)
     * ProcessBuilder.redirectInput}重定向过，
     * 那么该方法将返回<a href="ProcessBuilder.html#redirect-input">null输出流</a>。
     *
     * <p>实现注意事项：将被返回的输出流进行缓存并不是好主意。
     *
     * @return 连接到子进程标准输入的输出流。
     */
    public abstract OutputStream getOutputStream();

    /**
     * 返回连接到标准输出的输入流。通过管道从进程的标准输出获取标准输入数据。
     * 
     * <p>如果子进程的标准输出被使用{@link ProcessBuilder#redirectOutput(Redirect)
     * ProcessBuilder.redirectOutput}重定向过，
     * 那么该方法将返回<a href="ProcessBuilder.html#redirect-output">null输入流</a>。
     *
     *
     * <p>否则，如果子进程的标准错误被使用{@link ProcessBuilder#redirectErrorStream(boolean)
     * ProcessBuilder.redirectErrorStream}重定向，
     * 那么该方法返回的输入流将会接收到子进程合并后的标准输出及标准错误。
     *
     * <p>实现注意事项：将返回的输入流进行缓存是一个好主意。 
     *
     * @return 连接到子进程正常输出的输入流。
     */
    public abstract InputStream getInputStream();

    /**
     * 返回子进程中连接到错误输出的输入流。通过管道从进程的错误输出获取数据。
     * <p>如果子进程的标准错误被使用{@link ProcessBuilder#redirectError(Redirect)
     * ProcessBuilder.redirectError}或者
     * {@link ProcessBuilder#redirectErrorStream(boolean)
     * ProcessBuilder.redirectErrorStream}进行了重定向，
     * 那么该方法将会返回一个
     *
     * <p>实现注意事项：将返回的输入流进行缓存是一个好主意。 
     *
     * @return 子进程中，连接到错误输出的输入流
     */
    public abstract InputStream getErrorStream();

    /**
     * 使得当前的线程挂起等待，如有需要，直到{@code Process}对象代表的子进程终止。
     * 如果{@code Process}对象终止，该方法立即返回。
     * 如果子进程未终止，调用线程将会被阻塞，直到子进程退出。
     *
     * @return {@code Process}对象表示的子进程的退出值。
     * 			按照惯例，{@code 0}值表示正常终止。
     * @throws InterruptedException 如果当前线程在等待的时候
     * 		          被其他线程打断，那么等待终止，并且抛出{@link InterruptedException}。
     */
    public abstract int waitFor() throws InterruptedException;

    /**
     * 使得当前线程挂起等待，如有需要，直到{@code Process}对象代表的子进程终止，
     * 或者超过了指定的等待时间。
     *
     * <p>如果子进程已终止，那么该方法立刻返回{@code true}值。
     * 如果子进程没有终止且timeout值小于或等于设定值，0值，那么该方法立即返回{@code false}值。
     * <p>该方法的默认实现通过检测{@code exitValue}来核实进程是否终止。强烈建议在具体编码的时候
     * 使用一个更有效的实现进行重写。
     * 
     *
     * @param timeout 最大的等待时间
     * @param {@code timeout}参数的时间单位
     * @return 如果子进程已退出返回{@code true}，如果等待时间在子进程退出前超时则返回{@code false}。
     * @throws InterruptedException 如果在等待的时候当前线程被打断。
     * @throws NullPointerException 如果单位是null
     * @since 1.8
     */
    public boolean waitFor(long timeout, TimeUnit unit)
        throws InterruptedException
    {
        long startTime = System.nanoTime();
        long rem = unit.toNanos(timeout);

        do {
            try {
                exitValue();
                return true;
            } catch(IllegalThreadStateException ex) {
                if (rem > 0)
                    Thread.sleep(
                        Math.min(TimeUnit.NANOSECONDS.toMillis(rem) + 1, 100));
            }
            rem = unit.toNanos(timeout) - (System.nanoTime() - startTime);
        } while (rem > 0);
        return false;
    }

    /**
     * 返回子进程的退出值
     *
     * @return 该进程的退出值。按照惯例，{@code 0}值代表正常退出。
     * @throws IllegalThreadStateException 如果子进程还没有终止
     */
    public abstract int exitValue();

    /**
     * 杀死子进程。无论子进程被强制终止或者具有实现依赖。
     */
    public abstract void destroy();

    /**
     * 杀死子进程。该{@code Process}对象代表的子进程被强制终止。
     *
     * <p>该方法的默认实现调用了{@link #destroy}方法，故可能无法强制终止当前进程。
     * 具体的实现措施中，强烈建议使用有效的实现来重写该方法。
     * 调用该方法来强制终止进程（由 {@link ProcessBuilder#start}和
     * {@link Runtime#exec}获得的对象）。
     *
     * <p>注意：子进程不会立刻终止。
     * 比如：{@code isAlive()}可能在{@code destroyForcibly()}
     * 调用后的短时间内返回true。如有需要，该方法应和{@code waitFor()}方法结合使用。
     *
     * @return 被强制终止的 {@code Process}对象代表的子进程。
     * @since 1.8
     */
    public Process destroyForcibly() {
        destroy();
        return this;
    }

    /**
     * 测试该{@code Process}对象代表的子进程是否存活。
     *
     * @return {@code true} 如果该子进程未被终止。
     * @since 1.8
     */
    public boolean isAlive() {
        try {
            exitValue();
            return false;
        } catch(IllegalThreadStateException e) {
            return true;
        }
    }
}
