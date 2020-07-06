package com.Thread;

/**
 * @author jiejie
 * @date 2020/6/15 21:29
 */

//模拟龟兔赛跑
public class Race implements Runnable {
    public static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛是否结束
            boolean flag = gameOver(i);
            //如果结束,就停止
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
        }
    }

    //判断是否完成比赛
    public boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            return true;
        }
        {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
