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

package com.ckkloverdos.platform

import com.ckkloverdos.sys.SysProp

/**
 * 
 * @author Christos KK Loverdos <loverdos@gmail.com>.
 */
object PlatformHelpers {
  private[this] final val osName = SysProp.OsName.rawValue
  private[this] final val osNameLower = osName.toLowerCase
  private[this] final val osArch = SysProp.OsArch.rawValue
  private[this] final val osArchLower = osArch.toLowerCase

  lazy val isWindows = osName.indexOf("Windows") != -1
  lazy val isWindowsNT = isWindows && osNameLower.indexOf("nt") != -1
  lazy val isWindowsXP = isWindows && osNameLower.indexOf("xp") != -1
  lazy val isWindows2000 = isWindows && osNameLower.indexOf("2000") != -1
  lazy val isWindowsVista = isWindows && osNameLower.indexOf("vista") != -1

  lazy val isSolaris = osName.indexOf("Solaris") != -1 || osName.indexOf("SunOS") != -1

  lazy val isLinux = osName.indexOf("Linux") != -1

  lazy val isUnixLike = !isWindows// isSolaris || isLinux || isMac

  lazy val isMac = osName.indexOf("Mac OS") != -1

  lazy val isMacOSX = isMac && osName.endsWith("X")

  lazy val isX86   = osArchLower.indexOf("x86") != -1
  lazy val isSparc = osArchLower.indexOf("sparc") != -1
}