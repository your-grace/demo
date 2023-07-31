package com.liqiubo.example.demo.domain.thread;

public class Penguin {
    private static volatile Penguin m_penguin = null;
    // 避免通过new初始化对象
    private void penguin() {}
    public void beating() {
        System.out.println("打豆豆");
    };
    public static Penguin getInstance() {      //1
        if (null == m_penguin) {               //2
            synchronized(Penguin.class) {      //3
                if (null == m_penguin) {       //4
                    m_penguin = new Penguin(); //5
                }
            }
        }
        return m_penguin;                      //6
    }

    public static void main(String[] args) {
        Penguin penguin = Penguin.getInstance();
        System.out.println("penguin = " + penguin.toString());
    }
}
//单例模式的双重锁要加volatile