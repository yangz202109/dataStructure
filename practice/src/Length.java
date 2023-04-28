import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangz
 * @date 2022/12/2 - 9:14
 * 成员变量只能使用基本数据类型,String和enum枚举 不可使用包装类
 *
 */
@Target(ElementType.FIELD)//用于说明该自定义注解可以使用在什么位置 ElementType.FIELD：说明自定义的注解可以用于类的变量
@Retention(RetentionPolicy.RUNTIME)//用于说明自定义注解的生命周期 RetentionPolicy.RUNTIME:表示注解可以一直保留到运行时,因此可以通过反射获取注解信息
public @interface Length {
    int min(); //允许字符串的最小值

    int max(); //允许字符串的最大值

    String errorMsg(); //错误提示语
}
