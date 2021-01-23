import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/23-15:20
 * @Since:jdk1.8
 * @Description:抽奖系统升级版
 */
public class LuckyNumPro {
    static  Scanner sc = new Scanner(System.in);    //扫描仪
    static String account[] = {};       //账号
    static String password[] = {};      //密码
    static int cardNum[] = {};          //卡号
    static int luckyCount[] = {};       //中奖次数
    static boolean isRegister = false;  //是否注册标记
    static boolean isLogin = false;     //是否登录标记
    static int indexLogin = 0;          //当前参与抽奖用户的索引

    /**
     * 界面初始化
     */
    public static void initial(){
        while (true) {
            System.out.println("欢迎使用抽奖系统！");
            System.out.println("1、*****注册*****");
            System.out.println("2、*****登录*****");
            System.out.println("3、*****抽奖*****");
            System.out.println("4、***显示数据***");
            System.out.println("请输入你要进行的操作1/2/3/4");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("抽奖系统-->注册");
                    register(); //注册
                    break;
                case 2:
                    System.out.println("抽奖系统-->登录");
                    indexLogin = login();   //登录
                    break;
                case 3:
                    System.out.println("抽奖系统-->抽奖");
                    lottery(indexLogin); //抽奖
                    break;
                case 4:
                    System.out.println("抽奖系统-->显示数据");
                    show();
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
     * 展示所有用户的数据
     */
    public static void show(){
        System.out.println("序列\t账号\t密码\t中奖次数\t\t幸运程度");
        //遍历数组以显示所有用户信息
        for (int i = 0; i < account.length; i++) {
            System.out.println((i+1)+"\t"+account[i]+ "\t\t"+password[i]+"\t\t"+luckyCount[i]+"\t\t"+luckyCount[i]+"颗星");
        }
    }

    /**
     * 四位数卡号的随机生成
     */
    public static int randomCardNum(){
        int randowNum = 0;
        randowNum = (int) (Math.random() * 9000) + 1000; //生成四位数的随机数
        return randowNum;
    }

    /**
     * 注册
     */
    public static void register(){
        while (true){
            System.out.println("请输入要注册的账号");
            String act = sc.next();
            boolean isRegFlag = false;  //用来标记账号是否被注册
            for (int i = 0; i < account.length; i++) {
                if(act.equals(account[i])){
                    System.out.println("该账号已被注册请重新");
                    isRegFlag = true;
                    break;
                }
            }
            if(!isRegFlag){             //如果该用户账号未被注册
                //把新账号添加到数组的最后一位
                account = Arrays.copyOf(account,account.length+1);
                account[account.length - 1] = act;
                System.out.println("请输入注册该用户的密码：");
                String pwd = sc.next();
                //判断密码的位数
                if(pwd.length() < 6){
                    System.out.println("密码长度小于6位！请重新设定！");
                }else { //密码设定合理的情况
                    System.out.println("密码设定成功！正在随机生成卡号...");
                    password = Arrays.copyOf(password,password.length+1);
                    password[password.length-1] = pwd;
                    //判断卡号是否重复
                    while (true){
                        int cardNo = randomCardNum(); //生成随机的卡号
                        boolean flag = false; //是否重复标记
                        for (int i = 0; i < cardNum.length; i++) {
                            if(cardNo == cardNum[i]){
                                System.out.println("该卡号已被注册请重新生成卡号");
                                flag = true;
                                break;
                            }
                        }
                        if(flag == false){
                            System.out.println("卡号生成成功，您的卡号为："+cardNo);
                            cardNum = Arrays.copyOf(cardNum,cardNum.length+1);
                            cardNum[password.length-1] = cardNo;
                            //中奖次数默认为0
                            luckyCount = Arrays.copyOf(luckyCount,luckyCount.length+1);
                            luckyCount[luckyCount.length-1] = 0;
                            break;
                        }else
                            System.out.println("正在重新生成卡号....");
                    }
                }
                isRegister = true; //注册成功标识
                break;
            }else
                System.out.println("该账号名已被占用！");
        }
    }

    /**
     * 登录
     */
    public static int login(){
        int index = 0;          // 判断该用户的索引
        if(account.length == 0){
            System.out.println("用户列表为空，请注册后登录！！！");
            return 0;
        }
        while (true){
            System.out.println("请输入用户名:");
            boolean ishaveFlag = false;
            String act = sc.next();
            //判断存不存在该用户
            for (int i = 0; i < account.length; i++) {
                if (act.equals(account[i])){
                    System.out.println("找到了该用户！");
                    ishaveFlag = true;
                    index = i;
                    break;
                }
            }
            if(ishaveFlag){  //用户名密码输入正确
                System.out.println("请输入你的密码：");
                String pwd = sc.next();
                if(account[index].equals(act) && pwd.equals(password[index])){
                    System.out.println("密码正确，登录成功！");
                    isLogin = true; //登录成功，就可参与抽奖
                    return index;
                }else {
                    System.out.println("用户名或密码错误请重新输入！");
                    continue;
                }
            }else
                System.out.println("未找到该用户，请重新输入正确的用户名：");
        }
    }

    /**
     * 抽奖
     */

    public static void lottery(int index){
        //幸运日抽奖
        if(isLogin == false){
            System.out.println("您未登录，请注册/登录后参与抽奖！");
        }else {
            System.out.println("您正在参与（1）幸运数字抽奖");
            int num[] = new int[5];
            boolean isPride = false; //是否幸运数字中奖
            for (int i = 0; i < 5; i++) {
                num[i] = randomCardNum();
                if(cardNum[index] == num[i]){
                    isPride = true;
                }
            }
            if(isPride == true){
                System.out.println("恭喜您幸运数字抽奖中奖了！");
                luckyCount[index]++; //中奖次数+1
            }else {
                System.out.println("很遗憾您未中奖，但是你还可以参与幸运日抽奖和幸运色抽奖！");
            }
            System.out.println("你正在参与（2）幸运日抽奖");
            System.out.println("当前用户的卡号为"+cardNum[index]);
            System.out.println("请输入今天的日期：");
            int date = sc.nextInt();
            if(cardNum[index]%date == 0){
                System.out.println("恭喜您幸运日期中奖了");
                luckyCount[index]++; //中奖次数+1
            }else {
                System.out.println("很遗憾您未中奖，但是你还可以参与幸运色抽奖！");
            }
            System.out.println("您正在参与幸运色抽奖！");
            System.out.println("当前用户的卡号为"+cardNum[index]);
            String color[] = {"红","橙","黄","绿","青","蓝","紫","粉","棕","黑"};
            int colorIndex = (int)(Math.random()*10); //随机生成颜色
            if(colorIndex != (cardNum[index] % 10)){
                System.out.println("您的幸运色为："+color[cardNum[index] % 10]);
                System.out.println("系统随机生成的颜色为："+color[colorIndex]);
                System.out.println("很抱歉您未中奖");
            }else {
                System.out.println("恭喜您幸运颜色中奖了");
                luckyCount[index]++;
            }
        }
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
       initial();      //程序初始化，开始执行
    }
}