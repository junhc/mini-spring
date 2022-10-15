package org.springframework.aop;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

/**
 * Name: ProxyUtils
 * Function:
 *
 * @Author: K.K
 * Create Time: 2022/10/15
 * Modified By:
 * Modified Time:
 * Description:
 * Version:
 */
public abstract class ProxyUtils {

    public static void generateClassFile(Class clazz, String proxyName) {
        // 根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String paths = clazz.getResource(".").getPath();
        FileOutputStream out = null;
        try {
            // 写入硬盘中
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
    }
}
