package com.r3d.dashboard.r3ddashboard.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class closestToZeroTest {

  private int closest;
  private Exception exception;

  @Before
  public void setUp() {
    this.exception = null;
  }

  @Test
  public void closestToZero_withValidArray() {
    when_closestToZero(new int[] {-1, 1, 2, 4, 1, 1000, -1, 1, -2, -3});
    then_closest_is(1);
  }

  @Test
  public void closestToZero_withEmptyArray() {
    when_closestToZero(new int[] {});
    then_closest_is(0);
  }

  @Test
  public void closestToZero_withNullArray() {
    when_closestToZero(null);
    then_closest_is(0);
  }

  private int closestToZero(int[] array) {
    int closestIndex = 0;
    if (array == null || array.length == 0) {
      return 0;
    }
    int distance = Integer.MAX_VALUE;
    Arrays.sort(array);
    for (int index = 0; index < array.length; ++index) {
      int absolute = Math.abs(array[index]);
      if (absolute < distance) {
        closestIndex = index;
        distance = absolute;
      } else if (absolute == distance && array[index] > 0 && array[closestIndex] < 0) {
        closestIndex = index;
      }
    }
    return array[closestIndex];
  }

  private void when_closestToZero(int[] array) {
    try {
      this.closest = this.closestToZero(array);
    } catch (Exception e) {
      this.exception = e;
    }
  }

  private void then_closest_is(int expectedNumber) {
    assertEquals(expectedNumber, this.closest);
  }
}
