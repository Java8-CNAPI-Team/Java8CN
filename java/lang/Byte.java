/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * {@code Byte}将一个基本类型{@code byte}的值包装在了对象中。
 * 类型{@code Byte}的一个对象只包含一个类型为{@code byte}的域。
 *
 * <p>此外，该类还提供了{@code byte}和{@code String}之间互转的方法
 * 以及在处理{@code byte}时一些有用的常量和方法。
 *
 * @author  Nakul Saraiya
 * @author  Joseph D. Darcy
 * @see     java.lang.Number
 * @since   JDK1.1
 */
public final class Byte extends Number implements Comparable<Byte> {

    /**
     *  该常量保存了{@code byte}基本类型的最小值，-2<sup>7</sup>。
     */
    public static final byte   MIN_VALUE = -128;

    /**
	 *该常量保存了{@code byte}基本类型的最小值，2<sup>7</sup>-1。
     */
    public static final byte   MAX_VALUE = 127;

    /**
     * {@code Class} 实例表示{@code byte}的基本类型。
     */
    @SuppressWarnings("unchecked")
    public static final Class<Byte>     TYPE = (Class<Byte>) Class.getPrimitiveClass("byte");

    /**
     * 返回信的{@code String}对象，代表指定的
     * {@code byte}。基数默认为10。
     *
     * @param b 待转换的{@code byte}
     * @return 指定{@code byte}的字符串表示
     * @see java.lang.Integer#toString(int)
     */
    public static String toString(byte b) {
        return Integer.toString((int)b, 10);
    }

    private static class ByteCache {
        private ByteCache(){}

        static final Byte cache[] = new Byte[-(-128) + 127 + 1];

        static {
            for(int i = 0; i < cache.length; i++)
                cache[i] = new Byte((byte)(i - 128));
        }
    }

    /**
     * 返回一个{@code Byte}实例，表示指定的
     * {@code byte}值。
     * 如果不需要新生成{@code Byte}实例，一般使用该方法
     * 而不是构造器{@link #Byte(byte)}，
     * 因为在此方法中，所有byte值被缓存以显著提高程序的时间及空间效率。
     *
     * @param  b 一个byte值。
     * @return 代表{@code b}的{@code Byte}实例。
     * @since  1.5
     */
    public static Byte valueOf(byte b) {
        final int offset = 128;
        return ByteCache.cache[(int)b + offset];
    }

    /**
     * 根据参数二指定的基数（进制），将String类型参数一解析为有符号的{@code byte}。
     * 除了第一个字符可能是一个表示负值的ASCII码负号{@code '-'}({@code '\u005Cu002D'})
     * 或者表示正值的ASCII码正号{@code '+'} ({@code '\u005Cu002B'})，
     * 字符串中所有的字符都必须是指定基数（取决于{@link java.lang.Character#digit(char,int)}是否返回正值）的数字, 
	 * 该方法返回得到{@code byte}值。
     *
     * <p>如发生下列情况，则抛出{@code NumberFormatException}：
     * <ul>
     * <li> 首个参数为 {@code null}或为长度为零的字符串
     *
     * <li> 基数小于 {@link java.lang.Character#MIN_RADIX} 
     * 或大于 {@link java.lang.Character#MAX_RADIX}。
     *
     * <li> 字符串的任一字符不是指定基数的数字，
     * 第一个字符是负号 {@code '-'} ({@code '\u005Cu002D'})，
     * 或者正号{@code '+'} ({@code '\u005Cu002B'})
     * 的情况除外（但条件是字符串长度超过 1）。
     * 
     * <li> 字符串代表的值不是类型{@code byte}的值。 

     * </ul>
     *
     * @param s         包含{@code byte}表示的待解析的{@code String}
     * 
     * @param radix     解析{@code s}时使用的基数
     * @return          以指定基数表示的字符串参数表示的{@code byte}值。
     *                  
     * @throws          NumberFormatException 如果字符串不包含可解析的{@code byte}。
     */
    public static byte parseByte(String s, int radix)
        throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new NumberFormatException(
                "Value out of range. Value:\"" + s + "\" Radix:" + radix);
        return (byte)i;
    }

    /**
     * 将字符串参数转化为有符号的 十进制{@code byte}。
     * 除了首个字符是表示负值的ASCII负号{@code '-'}({@code '\u005Cu002D'})，
     * 或者是表示正值的ASCII正号{@code '+'}({@code '\u005Cu002B'})之外，
     * 字符串中的所遇字符都必须是十进制数字。
     * 该方法返回得到的{@code byte}值，与调用{@link parseByte(java.lang.String, int)}方法
     * 时，（第二个参数）基数为10得到的结果相同。
     *
     * @param s         包含{@code byte}表示的待解析的{@code String}
     * @return          以十进制表示的字符串参数表示的{@code byte}值。
     * @throws          NumberFormatException 若字符串不包含可解析的{@code byte}。
     */
    public static byte parseByte(String s) throws NumberFormatException {
        return parseByte(s, 10);
    }

    /**
     * 返回一个{@code Byte}对象，该对象保存从指定{@code String}对象中提取的值，
     * 该值由第二个参数给定的基数对指定字符串进行解析时提取。
     * 第一个参数使用第二个参数所指定的基数来解释表示一个有符号的 {@code byte}。
	 *结果是一个由字符串表示的{@code byte}值的{@code Byte}对象。
     *
     * <p> 换言之，该方法返回的{@code Byte}对象等于下面方法的返回值：
     *
     * <blockquote>
     * {@code new Byte(Byte.parseByte(s, radix))}
     * </blockquote>
     *
     * @param s         待解析的字符串
     * @param radix     解释{@code s}时使用的基数
     * @return          代表字符串参数的{@code Byte}对象
     * @throws          若{@code String}不包含可解析的{@code byte}。
     */
    public static Byte valueOf(String s, int radix)
        throws NumberFormatException {
        return valueOf(parseByte(s, radix));
    }

    /**
     * 返回指定的{@code String}表示的值的{@code Byte}对象。
     * 参数被解释为一个有符号的十进制{@code byte}，与将参数传递给
     * {@link #parseByte(java.lang.String)}方法得到的结果一样。
     * 结果是一个由字符串表示的{@code byte}值的{@code Byte}对象。
     *
     * <p> 换言之，该方法返回的{@code Byte}对象等于下面方法的返回值：
     *
     * <blockquote>
     * {@code new Byte(Byte.parseByte(s))}
     * </blockquote>
     *
     * @param s         待解析的字符串
     * @return          代表字符串参数的{@code Byte}对象
     * @throws          若{@code String}不包含可解析的{@code byte}。
     */
    public static Byte valueOf(String s) throws NumberFormatException {
        return valueOf(s, 10);
    }

    /**
     * 将{@code String}解码为 {@code Byte}。
     * 以下面的语法，接受十进制、十六进制，八进制数字：
     *
     * <blockquote>
     * <dl>
     * <dt><i>可解码的字符串：</i>
     * <dd><i>Sign<sub>opt</sub> DecimalNumeral</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0x} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0X} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code #} <i>HexDigits</i>
     * <dd><i>Sign<sub>opt</sub></i> {@code 0} <i>OctalDigits</i>
     *
     * <dt><i>Sign:</i>
     * <dd>{@code -}
     * <dd>{@code +}
     * </dl>
     * </blockquote>
     *
     * <cite>The Java&trade; Language Specification</cite>
     * 的3.10.1章节给出了<i>DecimalNumeral</i>, <i>HexDigits</i>和 <i>OctalDigits</i>
     * 的定义。不承认数字之间的下划线。
     *
     * 对可选符号和/或基数说明符（“{@code 0x}”、“{@code 0X}”、“{@code #}” 或前导零）后面的字符序列进行解析，与使用带指定基数（10、16 或 8）的 {@code Byte.parseByte}方法结果一样。
     * 该字符序列必须表示一个正值，否则将抛出 {@link NumberFormatException}。
     * 如果指定 {@code String}的第一个字符是负号，则结果将被求反。
     * {@code String}中不允许出现空格字符。
     *
     * @param   nm 待解码的{@code String}。
     * @return  由 {@code nm}表示的 {@code byte}值的 {@code Byte}对象
     * @throws  NumberFormatException  若{@code String}不包含可解析的{@code byte}。
     * @see java.lang.Byte#parseByte(java.lang.String, int)
     */
    public static Byte decode(String nm) throws NumberFormatException {
        int i = Integer.decode(nm);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new NumberFormatException(
                    "Value " + i + " out of range from input " + nm);
        return valueOf((byte)i);
    }

    /**
     * {@code Byte}的值。
     *
     * @serial
     */
    private final byte value;

    /**
     * 构造一个新生成的{@code Byte}对象，
     * 表示指定的{@code byte}值。
     *
     * @param value     代表{@code Byte}的值。
     *                  
     */
    public Byte(byte value) {
        this.value = value;
    }

    /**
     * 构造一个新生成的{@code Byte}对象，该对象代表由{@code String}参数
     * 转换而来的{@code byte}值。该字符串被转化为一个{@code byte}值，
     * 该值由基数为10的{@code parseByte}方法调用得到。
     *
     * @param s         待转换为{@code Byte}的{@code String}。
     * @throws          如{@code String}不包含可可转换的{@code byte}，则
     * 					抛出NumberFormatException。
     * @see        		java.lang.Byte#parseByte(java.lang.String, int)
     */
    public Byte(String s) throws NumberFormatException {
        this.value = parseByte(s, 10);
    }

    /**
     * 以{@code byte}形式返回此{@code Byte}的值。
     */
    public byte byteValue() {
        return value;
    }

    /**
     * 经过基本类型的扩容转换，以{@code short}形式返回此{@code Byte}的值。
     * @jls 5.1.2 基本类型扩容转换
     */
    public short shortValue() {
        return (short)value;
    }

    /**
     * 经过基本类型的扩容转换，以{@code int}形式返回此{@code Byte}的值。
     * @jls 5.1.2 基本类型扩容转换
     */
    public int intValue() {
        return (int)value;
    }

    /**
     * 经过基本类型的扩容转换，以{@code long}形式返回此{@code Byte}的值。
     * @jls 5.1.2 基本类型扩容转换
     */
    public long longValue() {
        return (long)value;
    }

    /**
     * 经过基本类型的扩容转换，以{@code float}形式返回此{@code Byte}的值。
     * @jls 5.1.2 基本类型扩容转换
     */
    public float floatValue() {
        return (float)value;
    }

    /**
     * 经过基本类型的扩容转换，以{@code double}形式返回此{@code Byte}的值。
     * @jls 5.1.2 基本类型扩容转换
     */
    public double doubleValue() {
        return (double)value;
    }

    /**
     * 返回一个{@code String}对象，代表{@code Byte}的值。
     * 此值被转换为有符号的十进制数表示，并作为字符串返回。
     * 正如{@code byte}值作为方法{@link java.lang.Byte#toString(byte)}
     * 的参数传入后得到的结果一样。
     *
     * @return  表示该对象的十进制形式的字符串
     */
    public String toString() {
        return Integer.toString((int)value);
    }

    /**
     * 为此{@code Byte}返回一个哈希码；与调用{@code intValue()}的结果equal to the result
     * 相同.
     *
     * @return 为此{@code Byte}的一个哈希码
     */
    @Override
    public int hashCode() {
        return Byte.hashCode(value);
    }

    /**
     * 为{@code byte}值返回哈希码；
     * 与{@code Byte.hashCode()}兼容。
     *
     * @param value 待哈希的值
     * @return 为{@code byte}值返回哈希码。
     * @since 1.8
     */
    public static int hashCode(byte value) {
        return (int)value;
    }

    /**
     * 比较该对象与指定的对象。
     * 当且仅当参数不为{@code null}
     * 同时参数必须是与该对象有相同的{@code byte}值的{@code Byte}对象
     * 时返回{@code true}。
     *
     * @param obj       与之比较的对象
     * @return          若两对象相同则返回{@code true}；
     *                  否则{@code false}。
     */
    public boolean equals(Object obj) {
        if (obj instanceof Byte) {
            return value == ((Byte)obj).byteValue();
        }
        return false;
    }

    /**
     * 比较两个{@code Byte}对象的数字形式。
     *
     * @param   该{@code Byte}比较的另一Byte对象。
     * @return  该{@code Byte}与参数{@code Byte}相等，则返回{@code 0}；
     * 			该{@code Byte}小于参数{@code Byte}，则返回数小于{@code 0}；
     * 			该{@code Byte}大于参数{@code Byte}，则返回数大于{@code 0}
     * 			（有符号比较）。
     * @since   1.2
     */
    public int compareTo(Byte anotherByte) {
        return compare(this.value, anotherByte.value);
    }

    /**
     * 比较两个{@code byte}值的数字形式。
     * 返回值与方法
     * <pre>
     *    Byte.valueOf(x).compareTo(Byte.valueOf(y))
     * </pre>
     * 的返回值相等。
     * @param  x 比较的第一个{@code byte}
     * @param  y 比较的第二个{@code byte}
     * @return 若{@code x == y}返回{@code 0}；
     *         若{@code x < y}返回值小于{@code 0}；
     *         若{@code x > y}返回值大于{@code 0}。
     * @since 1.7
     */
    public static int compare(byte x, byte y) {
        return x - y;
    }

    /**
     * 通过无符号转换，将参数转换为一个{@code int}。
     * 在无符号转换为一个{@code int}时，{@code int}的高24位为0，剩下的低8位
     * 同{@code byte}参数的二进制位相同。
     *
     * 因此，0和正数的{@code byte}值被映射成与相等的{@code int}数字，
     * 而负数的{@code byte}值被映射成一个由输入值加上2<sup>8</sup>所得到的{@code int}数。
     *
     * @param  x 待转换为无符号{@code int}的值
     * @return 将参数通过无符号转换变为{@code int}后的值。
     * @since 1.8
     */
    public static int toUnsignedInt(byte x) {
        return ((int) x) & 0xff;
    }

    /**
     *
     * 通过无符号转换，将参数转换为一个{@code long}。
     * 在无符号转换为一个{@code long}时，{@code long}的高56位为0，剩下的低8位
     * 同{@code byte}参数的二进制位相同。
     * 
     * 因此，0和正数的{@code byte}值被映射成与相等的{@code long}数字，
     * 而负数的{@code byte}值被映射成一个由输入值加上2<sup>8</sup>所得到的{@code long}数。
     *
     * @param  x 待转换为无符号{@code long}的值
     * @return 将参数通过无符号转换变为{@code long}后的值。
     *         
     * @since 1.8
     */
    public static long toUnsignedLong(byte x) {
        return ((long) x) & 0xffL;
    }


    /**
     * 以二进制补码形式表示{@code byte}值的位数。
     *
     * @since 1.5
     */
    public static final int SIZE = 8;

    /**
     * 以二进制补码形式表示{@code byte}值的字节数。
     *
     * @since 1.8
     */
    public static final int BYTES = SIZE / Byte.SIZE;

    /** use serialVersionUID from JDK 1.1. for interoperability */
    private static final long serialVersionUID = -7183698231559129828L;
}
