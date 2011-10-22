/*
 * Copyright 2011-2011 Christos KK Loverdos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ckkloverdos.sys

import collection.immutable.SortedSet

/**
 * Abstraction for jvm system properties.
 * 
 * @author Christos KK Loverdos <loverdos@gmail.com>.
 */

final class SysProp(val name: String) extends SysVar[SysProp](System.getProperty(_)) {
  @throws(classOf[NullPointerException])
  def update(newValue: String) = {
    // Will throw NPE if null
    System.setProperty(name, newValue)
  }

  override def toString: String = "SysProp(%s, %s)".format(name, value)

  override def equals(any: Any) = any match {
    case other: SysProp => other.name == name
    case _ => false
  }
}

object SysProp {
  lazy val JavaVersion    = this("java.version")
  lazy val JavaVendor     = this("java.vendor")
  lazy val JavaVendorURL  = this("java.vendor.url")
  lazy val JavaHome       = this("java.home")

  lazy val JavaVMSpecificationVersion = this("java.vm.specification.version")
  lazy val JavaVMSpecificationVendor  = this("java.vm.specification.vendor")
  lazy val JavaVMSpecificationName    = this("java.vm.specification.name")

  lazy val JavaVMVersion = this("java.vm.version")
  lazy val JavaVMVendor  = this("java.vm.vendor")
  lazy val JavaVMName    = this("java.vm.name")

  lazy val JavaSpecificationVersion = this("java.specification.version")
  lazy val JavaSpecificationVendor  = this("java.specification.vendor")
  lazy val JavaSpecificationName    = this("java.specification.name")

  lazy val JavaClassVersion = this("java.class.version")

  lazy val UserName  = this("user.name")
  lazy val UserHome  = this("user.home")
  lazy val UserDir   = this("user.dir")

  lazy val JavaClassPath   = this("java.class.path")
  lazy val JavaLibraryPath = this("java.library.path")
  lazy val JavaIOTmpDir    = this("java.io.tmpdir")

  lazy val OsName    = this("os.name")
  lazy val OsVersion = this("os.version")
  lazy val OsArch    = this("os.arch")

  lazy val LineSeparator = this("line.separator")
  lazy val FileSeparator = this("file.separator")
  lazy val PathSeparator = this("path.separator")

  lazy val JavaCompiler = this("java.compiler")
  lazy val JavaExtDirs  = this("java.ext.dirs")

  lazy val StandardsProps = SortedSet(
    JavaVersion, JavaVendor, JavaVendorURL, JavaHome,
    JavaVMSpecificationVersion, JavaVMSpecificationVendor, JavaVMSpecificationName,
    JavaVMVersion, JavaVMVendor, JavaVMName,
    JavaSpecificationVersion, JavaSpecificationVendor, JavaSpecificationName,
    JavaClassVersion,
    UserName, UserHome, UserDir,
    JavaClassPath, JavaLibraryPath, JavaIOTmpDir,
    OsName, OsVersion, OsArch,
    LineSeparator, FileSeparator, PathSeparator,
    JavaCompiler, JavaCompiler
  )

  def apply(name: String): SysProp = new SysProp(name)
}
