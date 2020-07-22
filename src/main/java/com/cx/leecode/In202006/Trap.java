package com.cx.leecode.In202006;

public class Trap {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0)
            return 0;
        int[] leftH = new int[len];
        int[] rightH = new int[len];
        leftH[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftH[i] = Math.max(height[i], leftH[i - 1]);
        }
        rightH[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightH[i] = Math.max(rightH[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int h = Math.min(leftH[i], rightH[i]) - height[i];
            sum = sum + h;
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int []h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap1 = trap.trap(h);
        System.out.println(trap1);
    }
}
