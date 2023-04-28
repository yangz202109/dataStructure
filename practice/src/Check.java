import java.lang.reflect.Field;

/**
 * @author yangz
 * @date 2022/12/2 - 9:25
 */
public class Check {
    public static void validate(Object object) throws IllegalAccessException {
        //首先通过反射获取传入object对象的全部字段
        Field[] fields = object.getClass().getDeclaredFields();

        //循环检测每个字段,看哪个字段上加了注解
        for (Field field : fields) {
            if (field.isAnnotationPresent(Length.class)) {
                //通过反射获取到该字段上标注的@Length注解的详细信息
                Length length = field.getAnnotation(Length.class);
                //反射爆破,使可以访问私有变量
                field.setAccessible(true);
                // 用过反射获取字段的实际值
                int value = ((String) field.get(object)).length();
                if (value < length.min() || value > length.max()) {
                    System.out.println(length.errorMsg());
                }
            }
        }
    }
}
