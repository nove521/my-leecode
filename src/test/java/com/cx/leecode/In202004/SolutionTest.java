package com.cx.leecode.In202004;

import com.cx.leecode.utils.TestTimeHolder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Before
    public void setUp() throws Exception {
        TestTimeHolder.newInstance();
    }

    @After
    public void tearDown() throws Exception {
        TestTimeHolder.end();
    }

    @Test
    public void twoSum() {
        int [] nums = new int[]{1,2,3,4,5,6,7};
        int target = 3;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(ints,new int[]{0,1});
    }

    @Test
    public void testTwoSumVersionMap() {
        int [] nums = new int[]{-1,2,3,4,5,6,7};
        int target = 6;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(ints,new int[]{0,6});
    }
}