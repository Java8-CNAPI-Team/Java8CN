/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

/**
 * 一个程序单元注解&#64;Deprecated标注的程序元素不鼓励使用，
 * 通常是由于有风险,
 * 或者有一个更好的替代者。  
 * 编译器在使用或重写弃用程序单元时发出警告。
 * @author  Neal Gafter
 * @since 1.5
 * @jls 9.6.3.6 @Deprecated
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
