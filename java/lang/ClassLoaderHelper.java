/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.File;

class ClassLoaderHelper {

    private ClassLoaderHelper() {}

    /**
     * 为所给文件返回一条替代的路径名，
     * 这样，如果原始的路径名不存在, 那么
     * 文件将会被定位到另一个位置。
     * 对大多数平台而言，该行为不被支持并且返回null。
     */
    static File mapAlternativeName(File lib) {
        return null;
    }
}
