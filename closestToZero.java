package com.r3d.dashboard.r3ddashboard.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class closestToZero {

  private int closest;

  @Test
  public void test_closestToZero() {
    int[] array = {-1, 1, 2, 4, 1, 1000, -1, 1, -2, -3};
    when_closestToZero(array);
    then_closest_is(1);
  }

  private void when_closestToZero(int[] array) {
    int closestIndex = 0;
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
    this.closest = array[closestIndex];
  }

  private void then_closest_is(int expectedNumber) {
    assertEquals(expectedNumber, this.closest);
  }
}
