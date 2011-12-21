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

import com.ckkloverdos.convert.Converters

/**
 * Abstraction for environment variables.
 * 
 * @author Christos KK Loverdos <loverdos@gmail.com>.
 */

final class SysEnv(val name: String) extends SysVar[SysEnv](System.getenv(_)) {
  override def toString: String = "SysEnv(%s, %s)".format(name, value)

  override def equals(any: Any) = any match {
    case other: SysEnv => other.name == name
    case _ => false
  }
}

object SysEnv {
  lazy val PS1   = this("PS1")
  lazy val PS2   = this("PS2")

  lazy val SHELL   = this("SHELL")
  lazy val TERM   = this("TERM")

  lazy val PATH   = this("PATH")
  lazy val MANPATH   = this("MANPATH")

  lazy val USER   = this("USER")
  lazy val HOME   = this("HOME")

  lazy val EDITOR = this("EDITOR")

  lazy val SCALA_HOME = this("SCALA_HOME")
  lazy val JAVA_HOME = this("JAVA_HOME")
  lazy val JDK_HOME = this("JDK_HOME")

  lazy val LC_CTYPE = this("LC_CTYPE")

  def apply(name: String): SysEnv = new SysEnv(name)

  def isSysEnvTrue(name: String)(implicit converters: Converters = Converters.DefaultConverters): Boolean = {
    val maybeValue = for {
      propValue    <- SysEnv(name)
      booleanValue <- converters.convertToBoolean(propValue)
    } yield {
      booleanValue
    }

    maybeValue.getOr(false)
  }
}
