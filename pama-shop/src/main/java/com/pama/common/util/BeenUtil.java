package com.pama.common.util;

import java.lang.reflect.Method;

public class BeenUtil {

    @SuppressWarnings("unchecked")
	public static <T> Class<T> loadClass(String className) throws ClassNotFoundException {
    	return (Class<T>) Class.forName(className);

    }

    public static Object load(String inBeen, Object outBeen) throws ClassNotFoundException, Exception {
        return load(loadClass(inBeen), outBeen);
    }

    public static Object load(Object inBeen, Object outBeen) throws ClassNotFoundException, Exception {
        return load(inBeen.getClass(), outBeen);
    }

    public static <T> Object load(Class<T> inBeen, Object outBeen) throws Exception {

    	Method method[] = outBeen.getClass().getMethods();

    	Object result = inBeen.newInstance();
        Method method1[] = inBeen.getMethods();

    	for (int i=0; i<method.length; i++) {
    		String name = method[i].getName();
    		if(name.startsWith("get") && name.length() >= 4) {
    			for(int j = 0; j < method1.length; j++) {
    				String name1 = method1[j].getName();
    				if(name1.startsWith("set") && name1.length() >= 4 && name1.substring(3).equals(name.substring(3)))
                    {
    					if (method[i].getReturnType().getName() == method1[j].getParameterTypes()[0].getName()) {
    						method1[j].invoke(result, method[i].invoke(outBeen, null));
    					} else {
    						System.out.println("j:"+method1[j].getParameterTypes()[0].getName());
    						System.out.println("i"+method[i].getReturnType().getName());
    						//if ("Integer".equals(method1[j].getReturnType().getName())) {
    							//method1[j].invoke(result, (Integer)method[i].invoke(outBeen, null));
    						//}
    					}
                    }
    			}
    		}
    	}

    	return result;
    }

}
