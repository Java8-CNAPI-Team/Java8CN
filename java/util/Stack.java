/*
 * Copyright (c) 1994, 2010, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

/**
 * The <code>Stack</code> class represents a last-in-first-out
 * (LIFO) stack of objects. It extends class <tt>Vector</tt> with five
 * operations that allow a vector to be treated as a stack. The usual
 * <tt>push</tt> and <tt>pop</tt> operations are provided, as well as a
 * method to <tt>peek</tt> at the top item on the stack, a method to test
 * for whether the stack is <tt>empty</tt>, and a method to <tt>search</tt>
 * the stack for an item and discover how far it is from the top.
 * <p>
 * When a stack is first created, it contains no items.
 *
 * <p>A more complete and consistent set of LIFO stack operations is
 * provided by the {@link Deque} interface and its implementations, which
 * should be used in preference to this class.  For example:
 * <pre>   {@code
 *   Deque<Integer> stack = new ArrayDeque<Integer>();}</pre>
 *
 * @author  Jonathan Payne
 * @since   JDK1.0
 */
/**
 * <code>Stack</code> 类表示后进先出的对象堆栈结构。
 * 继承了<tt>Vector</tt>类，同时实现了五个操作以创建
 * 堆栈的数据结构。它们包括：
 * 普通的<tt>push</tt> and <tt>pop</tt> 操作, <tt>peek</tt> 以查找栈顶元素，
 * <tt>empty</tt>以判断堆栈是否为空，以及<tt>search</tt>以查找item离栈顶有多远。
 * <p>
 * 当stack结构建立的时候，默认是不包含item的。
 *
 * <p>更完善的后进先出堆栈结构是{@link Deque} 接口以及它的实现类，
 * 应该优先使用它们而不是本类。
 * 比如：
 * <pre>   {@code
 *   Deque<Integer> stack = new ArrayDeque<Integer>();}</pre>
 *
 * @author  Jonathan Payne
 * @since   JDK1.0
 */
public
class Stack<E> extends Vector<E> {
    /**
     * Creates an empty Stack.
     * 新建一个空Stack
     */
    public Stack() {
    }

    /**
     * Pushes an item onto the top of this stack. This has exactly
     * the same effect as:
     * <blockquote><pre>
     * addElement(item)</pre></blockquote>
     * 将item放在satck顶部。
     * 和<blockquote><pre>addElement(item)</pre></blockquote>
     * 的作用相同
     * @param   item   the item to be pushed onto this stack.放入stack顶部的item
     * @return  the <code>item</code> 参数.
     * @see     java.util.Vector#addElement
     */
    public E push(E item) {
        addElement(item);

        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     *
     * 删除在stack顶部的对象并返回该对象的值
     *
     * @return  stack顶部的对象 (<tt>Vector</tt> 对象的最后一项)
     * @throws  EmptyStackException  如果该stack为空.
     */
    public synchronized E pop() {
        E       obj;
        int     len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack. 找出但不删除该stack顶部的对象
     *
     * @return  the object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).该stack顶部的对象（即<tt>Vector</tt>对象的最后一项）
     * @throws  EmptyStackException  if this stack is empty.EmptyStackException  如果该stack为空
     */
    public synchronized E peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     *
     * 测试该stack是否为空
     *
     * @return  如果该stack包含Items则返回<code>true</code> ; 否则<code>false</code>.
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object <tt>o</tt> occurs as an item in this stack, this
     * method returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack; the topmost item on the
     * stack is considered to be at distance <tt>1</tt>. The <tt>equals</tt>
     * method is used to compare <tt>o</tt> to the
     * items in this stack.
     *
     * @param   o   the desired object.
     * @return  the 1-based position from the top of the stack where
     *          the object is located; the return value <code>-1</code>
     *          indicates that the object is not on the stack.
     *
     * 返回该stack中对象所处的第一个位置。
     * 如果对象<tt>o</tt>是stack中的一员，该方法返回从栈顶到最近的命中对象的步长。
     * 栈顶的item步长为<tt>1</tt>。
     * 使用<tt>equals</tt>方法来比较<tt>o</tt>和stack中的items。
     *
     * @param   o   期望比较的对象
     * @return  从栈顶到该对象的第一次顺位位置；
     *           <code>-1</code>
     *          表示对象未在栈中.
     */
    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = 1224463164541339165L;
}
