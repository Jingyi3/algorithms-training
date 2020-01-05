
package com.olivia.designPattern;

public class Singleton {

    //https://www.cnblogs.com/happyone/p/11221157.html

    /**
     * 为什么要有单例模式
     * 实际编程应用场景中，有一些对象其实我们只需要一个，比如线程池对象、缓存、系统全局配置对象等。
     * 这样可以就保证一个在全局使用的类不被频繁地创建与销毁，节省系统资源。
     *
     * 实现单例模式的几个要点
     * 1. 首先要确保全局只有一个类的实例。
     * 要保证这一点，至少类的 ***构造器要私有化***。
     * 2. 单例的类只能**自己创建自己的实例**。
     * 因为，构造器私有了，但是还要有一个实例，只能自己创建咯！
     * 3. 单例类必须能够提供自己的唯一实例给其他类
     * 就是要有一个**公共的方法**能返回该单例类的**唯一实例**。
     */
}

/**
 * public class HurgrySingleton {
 * private static HurgrySingleton hurgry=new HurgrySingleton();
 * private HurgrySingleton(){};
 *      public static HurgrySingleton getSinletonHurgry(){
 *          return hurgry;
 *         }
 * }
 */
class HungrySingleton { // thread safe

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}

/**
 * public class LarzySingleton {
 *    private static LarzySingleton larzy=null;
 *    private LarzySingleton(){};
 *    public static synchronized Larzy getSinletonLarzy(){
 *         if(larzy==null){
 *               larzy=new LarzySingleton();
 *         }
 *         return larzy;
 *     }
 * }
 */

class LazySingleton{ //use synchronized to keep thread safe
    private static LazySingleton lazySingleton;
    private LazySingleton() {}
    public static synchronized  LazySingleton getLazySingleton(){
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

class DLockSingleton {
    private static volatile DLockSingleton dLockSingleton;
    //volatile关键字的使用，保证了各线程对singleton静态实例域修改的可见性。
    private DLockSingleton() {

    }
    public static DLockSingleton getdLockSingleton() {
        if (dLockSingleton == null) {
            synchronized (DLockSingleton.class) {
                if (dLockSingleton == null) {
                    dLockSingleton = new DLockSingleton();
                }
            }
        }
        return dLockSingleton;
    }
}

//静态内部类实现单例（线程安全、效率高）

/**
 * 这种方式下 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
 * 注意内部类SingletonHolder要用static修饰且其中的静态变量INSTANCE必须是final的。
 */
class StaticInnerClassSingleton{
    private static class InnerClassSingleton {
        private static final StaticInnerClassSingleton SINGLETON_INSTANCE = new StaticInnerClassSingleton();
    }
    private StaticInnerClassSingleton() {

    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClassSingleton.SINGLETON_INSTANCE;
    }

}
