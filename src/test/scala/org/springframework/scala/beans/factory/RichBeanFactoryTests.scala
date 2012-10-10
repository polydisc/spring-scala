/*
 * Copyright 2011-2012 the original author or authors.
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

package org.springframework.scala.beans.factory

import org.scalatest.FunSuite
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * @author Arjen Poutsma
 */
@RunWith(classOf[JUnitRunner])
class RichBeanFactoryTests extends FunSuite {

	test("getBean") {
		val beanFactory = new DefaultListableBeanFactory()
		beanFactory.registerSingleton("foo", "Foo")
		val richBeanFactory = RichBeanFactory(beanFactory)

		val result = richBeanFactory.getBean[String]
		assert("Foo" == result)
	}

	test("getBean(String)") {
		val beanFactory = new DefaultListableBeanFactory()
		beanFactory.registerSingleton("foo", "Foo")
		val richBeanFactory = RichBeanFactory(beanFactory)

		val result = richBeanFactory.getBean[String]("foo")
		assert("Foo" == result)
	}

}