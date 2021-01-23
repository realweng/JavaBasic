import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/23-11:50
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LuckyNumber {
    static Scanner sc = new Scanner(System.in); //扫描仪
    static String userNumber, userPwd;      //用户名、密码
    static int userCard;                    //会员卡卡号
    static boolean isRegister = false;      //是否注册的标记位
    static boolean isLogin = false;         //是否登录的标记位

    /**
     * 界面展示及用户操作
     */
    public static void show() {
        while (true) {
            System.out.println("欢迎使用抽奖系统！");
            System.out.println("1、*****注册*****");
            System.out.println("2、*****登录*****");
            System.out.println("3、*****抽奖*****");
            System.out.println("请输入你要进行的操作1/2/3");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("抽奖系统-->注册");
                    register(); //注册
                    break;
                case 2:
                    System.out.println("抽奖系统-->登录");
                    login();   //登录
                    break;
                case 3:
                    System.out.println("抽奖系统-->抽奖");
                    lottery(); //抽奖
                    break;
                default:
                    System.out.println("您输入的信息有误！");
                    break;
            }
            System.out.println("请问是否继续！（y/n）");
            String confirm = sc.next();
            if (confirm.equals("n")) {
                System.out.println("抽奖程序运行结束");
                break;
            }
        }
    }

    /**
     * 随机数生成
     */
    public static int randomNumber() {
        int randowNum = 0;
        randowNum = (int) (Math.random() * 9000) + 1000; //生成四位数的随机数
        return randowNum;
    }

    /**
     * 用户注册
     */
    public static void register() {
        System.out.println("请输入您要注册的用户名：");
        userNumber = sc.next();
        System.out.println("请设置账号的密码");
        userPwd = sc.next();
        userCard = randomNumber();
        System.out.println("注册成功，请记住您的会员卡号:"+userCard);
        isRegister = true; //注册成功
    }

    /**
     * 用户登录
     */
    public static void login() {
        if(!isRegister){
            System.out.println("用户未注册，请注册后再登录！");
            register();
            return;
        }
        int count = 0;
        System.out.println("请输入用户名：");
        String name = sc.next();
        while (true){
            if (userNumber.equals(name)) {
                System.out.println("查找到该用户，请继续输入密码：");
                String pwd = sc.next();
                if (userNumber.equals(name) == userPwd.equals(pwd)) {
                    System.out.println("登录成功");
                    isLogin = true;
                    break;
                } else{
                    count++;
                    System.out.println("密码输入错误，你还有"+(3-count)+"次输入机会！");
                    if(count == 3){
                        System.out.println("密码输入错误超过三次！");
                        break;
                    }
                    continue;
                }
            } else{
                System.out.println("用户名不存在！请重新操作");
                break;
            }
        }
    }

    /**
     * 用户抽奖
     */
    public static void lottery() {
        if(!isRegister){
            System.out.println("用户未注册，请注册登录抽奖！");
            return;
        }
        if(!isLogin){
            System.out.println("用户未登录，请登录后再抽奖！");
            return;
        }
        int num[] = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = randomNumber();
            if(userCard == num[i]){
                System.out.println("恭喜中奖");
                //System.out.println(num[i]);
                return;
            }
        }
        System.out.println("抱歉,未中奖！");
        return;
    }

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {
        show(); //程序开始执行
    }
}