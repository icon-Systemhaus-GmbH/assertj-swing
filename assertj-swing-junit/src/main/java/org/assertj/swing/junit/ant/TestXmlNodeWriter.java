/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.junit.ant;

import static java.lang.System.currentTimeMillis;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_CLASSNAME;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_MESSAGE;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_NAME;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_TIME;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_TYPE;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.TESTCASE;
import static org.assertj.core.util.Strings.isEmpty;
import static org.assertj.swing.junit.ant.CommonConstants.UNKNOWN;
import static org.assertj.swing.junit.ant.Tests.testClassNameFrom;
import static org.assertj.swing.junit.ant.Tests.testMethodNameFrom;
import static org.assertj.swing.junit.xml.XmlAttribute.name;
import static org.assertj.swing.junit.xml.XmlAttributes.attributes;
import junit.framework.Test;

import org.assertj.swing.junit.xml.XmlNode;

/**
 * Understands how to write information about a test to a XML node.
 * 
 * @author Alex Ruiz
 */
class TestXmlNodeWriter {

  private final StackTraceFilter stackTraceFilter;

  TestXmlNodeWriter() {
    this(new StackTraceFilter());
  }

  TestXmlNodeWriter(StackTraceFilter stackTraceFilter) {
    this.stackTraceFilter = stackTraceFilter;
  }

  XmlNode addNewTestXmlNode(XmlNode target, Test test) {
    String methodName = testMethodNameFrom(test);
    if (methodName == null)
      methodName = UNKNOWN;
    return target.addNewNode(TESTCASE,
        attributes(name(ATTR_NAME).value(methodName), name(ATTR_CLASSNAME).value(testClassNameFrom(test))));
  }

  TestXmlNodeWriter writeTestExecutionTime(XmlNode target, long startTime) {
    double executionTime = (currentTimeMillis() - startTime) / 1000.0;
    target.addAttribute(name(ATTR_TIME).value(executionTime));
    return this;
  }

  TestXmlNodeWriter writeErrorAndStackTrace(XmlNode target, Throwable error) {
    return writeError(target, error).writeStackTrace(target, error);
  }

  TestXmlNodeWriter writeError(XmlNode target, Throwable error) {
    String message = error.getMessage();
    if (!isEmpty(message))
      target.addAttribute(name(ATTR_MESSAGE).value(message));
    target.addAttribute(name(ATTR_TYPE).value(error.getClass().getName()));
    return this;
  }

  TestXmlNodeWriter writeStackTrace(XmlNode target, Throwable error) {
    String stackTrace = stackTraceFilter.filter(error);
    target.addText(stackTrace);
    return this;
  }
}
