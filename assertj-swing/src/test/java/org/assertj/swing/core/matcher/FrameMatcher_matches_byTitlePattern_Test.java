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
package org.assertj.swing.core.matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.test.builder.JFrames.frame;

import java.util.regex.Pattern;

import javax.swing.JFrame;

import org.assertj.swing.test.core.EDTSafeTestCase;
import org.junit.Test;

/**
 * Tests for {@link FrameMatcher#matches(java.awt.Component)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class FrameMatcher_matches_byTitlePattern_Test extends EDTSafeTestCase {
  @Test
  public void should_Return_True_If_Title_Matches_Pattern() {
    FrameMatcher matcher = FrameMatcher.withTitle(Pattern.compile("He.*"));
    JFrame frame = frame().withTitle("Hello").createNew();
    assertThat(matcher.matches(frame)).isTrue();
  }

  @Test
  public void should_Return_False_If_Title_Does_Not_Match_Pattern() {
    FrameMatcher matcher = FrameMatcher.withTitle(Pattern.compile("Hello"));
    JFrame frame = frame().withTitle("Bye").createNew();
    assertThat(matcher.matches(frame)).isFalse();
  }
}
