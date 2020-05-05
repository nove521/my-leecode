package com.cx.leecode.In202005;

import junit.framework.TestCase;

public class MaxAreaTest extends TestCase {

    public void testMaxArea() {
        int []arr = new int [] {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        assertEquals( "最大面积不正确",49,maxArea.maxArea(arr));
    }
}