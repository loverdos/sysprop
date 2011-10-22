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

import com.ckkloverdos.maybe.{Maybe}

/**
 * Abstraction for system properties.
 *
 * @author Christos KK Loverdos <loverdos@gmail.com>.
 */

private[sys] abstract class SysVar[T <: SysVar[T]](valueMaker: (String) => String) extends Ordered[T] {
  def value = Maybe(valueMaker(name))

  def rawValue = valueMaker(name)
  
  def name: String

  def apply(): Maybe[String] = value

  def isDefined: Boolean = value.isJust

  def map[U](f: String => U): Maybe[U] = value.map(f)

  def flatMap[U](f: String => Maybe[U]): Maybe[U] = value.flatMap(f)

  override def hashCode = name.##

  def compare(other: T) = name.compareTo(other.name)
}