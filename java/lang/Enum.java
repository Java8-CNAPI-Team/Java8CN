/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

/**
 * 该类是所有Java语言枚举类型的共同基类。
 *
 * 关于枚举的更多信息，包括由编译器合成的隐式声明方法的描述，
 * 可以在<cite>The Java&trade; Language Specification</cite>
 * 的8.9章节找到。
 *
 * <p>注意当使用枚举类型作为一个集合的类型或者作为map中键的类型时，
 * 现成类{@linkplain java.util.EnumSet set} 和 {@linkplain
 * java.util.EnumMap map}的实现都是专业和高效的。
 *
 * @param <E> 枚举类型子类
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Class#getEnumConstants()
 * @see     java.util.EnumSet
 * @see     java.util.EnumMap
 * @since   1.5
 */
public abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable {

    /**
     * 枚举常量的名称，在枚举声明中进行声明。
     * 大多数程序员应使用{@link #toString}方法而不是访问该域。
     */
    private final String name;

    /**
     * 
     * 返回枚举常量的名称，在其枚举声明中进行声明。
     *
     * <b>大多数程序员应使用{@link #toString}方法而不是该方法，因为toString方法
     * 能返回对用户更友好的名称 </b>此方法主要设计用于特殊情形，其正确性依赖于获取到的确切名称，
     * 其名称不会随版本的改变而改变。
     *
     * @return 枚举常量的名称
     */
    public final String name() {
        return name;
    }

    /**
     * 枚举常量的序数（其在枚举声明中的位置，首个常量的序数指定为0）。
     *
     * 大多数程序要不需要使用此域。
     * 其被设计用于基于枚举的负责数据结构，
     * 比如{@link java.util.EnumSet} 和 {@link java.util.EnumMap}。

     */
    private final int ordinal;

    /**
     * 返回枚举常量的序数（其在枚举声明中的位置，首个常量的序数指定为0）。
     *
     * 大多数程序要不需要使用此方法。
     * 其被设计用于基于枚举的负责数据结构，
     * 比如{@link java.util.EnumSet} 和 {@link java.util.EnumMap}。
     *
     * @return 枚举常量的序数
     */
    public final int ordinal() {
        return ordinal;
    }

    /**
     * 单独的类构造方法。程序员无法调用该构造方法。
     * 用于编译器代码生成，以响应枚举类型声明。
     *
     * @param name - 枚举常量的名称，该名称是用于声明该常量的标识符。
     * @param ordinal - 枚举常量的序数 （枚举常量中所处的位置，首个常量的序数是0）。
     */
    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    /**
     * 返回枚举常量的名称，它（已）包含在了声明中。
     * 该方法可能被重写，尽管通常不需要这么做。
     * 当出现一个更为“程序员友好”的字符串格式，应该重写这个方法。
     *
     * @return 枚举类型的名称
     */
    public String toString() {
        return name;
    }

    /**
     * 指定的对象等于枚举常量则返回真。
     *
     * @param other 与之进行等同性比较的对象。
     * @return  指定的对象等于枚举常量则返回真。
     */
    public final boolean equals(Object other) {
        return this==other;
    }

    /**
     * 为枚举常量返回哈希码
     *
     * @return 枚举常量的哈希码
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * 抛出 CloneNotSupportedException。
     * 以确保枚举对象们不会被克隆，这对他们保持“单例”状态是必要的。
     *
     * @return (永不返回)
     */
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * 比较该对象与指定对象的序数。
     * 从序数上，根据该对象小于、等于或者大于指定对象，分别返回相应的负数，0，或者正数。
     *
     * 枚举常量只与相同枚举类型的常量进行比较。
     * 该方法实现的自然顺序就是常量声明时的顺序。
     */
    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>)o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
            self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }

    /**
     * 返回与枚举常量对应的枚举类型的Class对象。
     * 当且仅当e1和e2满足条件：e1.getDeclaringClass() == e2.getDeclaringClass()，
     * 枚举常量e1和e2的枚举类型才相同。
	 * （该方法返回的值不同于{@link Object#getClass}方法返回值，
	 * {@link Object#getClass}方法用于带有特定常量的类主题的枚举常量）
     *
     * @return 与枚举常量对应的枚举类型的Class对象。
     *     
     */
    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> clazz = getClass();
        Class<?> zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? (Class<E>)clazz : (Class<E>)zuper;
    }

    /**
     * 返回指定枚举类型、指定名称的枚举常量。
     * 名称必须与在此类型中声明枚举常量所用的标识符完全匹配。（不允许使用额外的空白字符。）
     *
     * <p>注意对于确切的枚举类型{@code T}，隐式声明的{@code public static T valueOf(String)}
     * 方法常被使用来映射名称到对一个枚举常量的关系，而不是使用该方法。
     * 要获取所有的枚举类型常量，可以通过调用隐式的{@code public static T[] values()}
     * 方法来实现。
     *
     * @param <T> 要从中返回常量的枚举类型的 Class对象
     * @param enumType 枚举类型的{@code Class}对象，据此返回一个常量
     * @param name 待返回的常量名
     * @return 具有指定枚举类型、指定名称的枚举常量
     * @throws IllegalArgumentException 若指定的枚举类型不具有指定名称的常量，
     * 		        或者指定的类对象不代表枚举类型。
     * @throws NullPointerException 若{@code enumType} 或 {@code name}
     *         为null
     * @since 1.5
     */
    public static <T extends Enum<T>> T valueOf(Class<T> enumType,
                                                String name) {
        T result = enumType.enumConstantDirectory().get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
            "No enum constant " + enumType.getCanonicalName() + "." + name);
    }

    /**
     * enum类不能拥有finalize方法。
     */
    protected final void finalize() { }

    /**
     * 阻止缺省的反序列化
     */
    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}
