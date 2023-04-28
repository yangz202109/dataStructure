/**
 * @author yangz
 * @date 2022/12/2 - 9:41
 */
public class Student {
    private Long id;
    private String name;
    @Length(min = 11,max = 11,errorMsg = "手机号必须为11位")
    private String phone;

    public Student(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
