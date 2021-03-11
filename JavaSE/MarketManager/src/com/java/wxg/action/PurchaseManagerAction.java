package com.java.wxg.action;

import com.java.wxg.bean.OrderDetails;
import com.java.wxg.bean.OrderInfo;
import com.java.wxg.bean.Product;
import com.java.wxg.bean.VIP;
import com.java.wxg.service.ProductService;
import com.java.wxg.service.PurchaseManagerService;
import com.java.wxg.service.VIPService;
import com.java.wxg.util.MD5Util;

import java.util.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:49
 * @Since:jdk1.8
 * @Description:购买管理表示层
 */
public class PurchaseManagerAction {
    private Scanner scanner;//扫描仪
    private PurchaseManagerService purchaseManagerService;//购买管理业务处理的对象
    private VIPService vipService;//会员管理业务处理的对象
    private ProductService productService;//商品管理业务处理的对象
    private VIP vip;//会员实例
    private Product product;//商品实例
    private OrderInfo orderInfo;//订单实例
    private List<OrderDetails> orderDetailsList;//订单详情实例
    private OrderDetails orderDetails;
    private Map<Integer, Integer> shopList;//购物车，存放商品id及其对应的购物数量
    private Double price;//订单总金额

    /**
     * 构造器 数据初始化
     *
     * @param scanner
     */
    public PurchaseManagerAction(Scanner scanner) {
        this.scanner = scanner;
        purchaseManagerService = new PurchaseManagerService();
        vipService = new VIPService();
        productService = new ProductService();
        vip = new VIP();
        product = new Product();
        orderInfo = new OrderInfo();
        orderDetailsList = new ArrayList<>(10);
        price = 0.0;
        shopList = new HashMap<>(16);
    }

    /**
     * 订单管理菜单
     * 输入商品ID-->显示商品详情-->
     * 输入购买数量-->输入下一个商品ID，如此反复。
     * 直到按下“确定购买”按钮。
     */
    public void purchaseMenu() {
        System.out.println("1.购买商品");
        System.out.println("0.退出购买");
        //目录
        if (scanner.nextInt() == 1) {
            showProduct();//显示状态正常的商品
            boolean loginSuccess = vipLogin();//当前待消费会员登录
            if (loginSuccess == true) {
                System.out.println("会员卡识别成功！");
            } else {
                System.out.println("会员卡识别失败！");
                return;
            }
            boolean flag = true;
            while (flag) {
                System.out.println("1.添加商品");
                System.out.println("2.修改商品数量");
                System.out.println("3.删除购物车的商品");
                System.out.println("4.展示购物车商品列表");
                System.out.println("0.提交订单，开始结算");
                System.out.println("请选择：");
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("您选择添加商品-->");
                        addProductToList();
                        break;
                    case 2:
                        System.out.println("您选择修改商品数量-->");
                        replaceProductNums();
                        break;
                    case 3:
                        System.out.println("您选择删除购物车的商品-->");
                        deleteProductFromList();
                        break;
                    case 4:
                        System.out.println("您选择展示购物车商品列表-->");
                        showList();
                        break;
                    case 0:
                        System.out.println("您选择提交订单-->");
                        commitList();
                        flag = false;
                        break;
                    default:
                        break;
                }
            }
        } else
            return;
    }

    /**
     * 会员登录
     *
     * @return
     */
    public boolean vipLogin() {
        boolean loginSuccess = false;
        System.out.println("当前消费者是否为会员？(y/n)");
        String confirm = scanner.next().toLowerCase();
        if (confirm.equals("y")) {
            System.out.println("请输入会员卡号：");
            String cardNum = scanner.next();
            List<VIP> vipList = vipService.findVipByCardNum(cardNum);
            if(vipList.size()==0){
                System.out.println("没有找到该用户！");
                return false;
            }
            vip = vipList.get(0);
            if (vip.getId() != 1 && vip != null) {
                System.out.println(vip.toString());
                System.out.println("请输入密码：");
                String pwd = scanner.next();
                pwd = MD5Util.encryption(pwd);
                if (pwd.equals(vip.getVipPassword())) {
                    loginSuccess = true;
                } else {
                    loginSuccess = false;
                }
            } else {
                System.out.println("会员编号输入错误！");
                return false;
            }
        } else if(confirm.equals("n")){//非会员,默认不需要登录
            vip = vipService.findVipById(1);
            loginSuccess = true;
        }else {
            System.out.println("输入错误！");
            return false;
        }
        return loginSuccess;
    }

    /**
     * 只显示上架的商品详情
     */
    public void showProduct() {
        System.out.println("超市商品信息如下：");
        List<Product> list = productService.queryProduct();
        System.out.println("--------------------------------------------------");
        System.out.println("商品编号\t\t商品名称\t\t\t\t商品价格\t\t商品库存");
        for (Product p : list) {
            if (p.getState() == 1) {
                System.out.println(p.getId() + "\t\t" + p.getPname() + "\t\t\t\t" + p.getPrice() + "\t\t" + p.getNum());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * 添加商品到购物车
     */
    public void addProductToList() {
        System.out.println("请输入商品编号：");
        int id = scanner.nextInt();
        if (shopList.containsKey(id)) {
            System.out.println("该商品已经添加到购物车了，如果想修改购买该商品的数量请返回上级菜单修改！");
            return;
        }
        product = productService.findProductById(id);
        if (product != null && product.getState() == 1) {
            System.out.println(product.toString());
            System.out.println("请输入购买该商品的数量：");
            int num = scanner.nextInt();
            if (num > product.getNum()) {
                System.out.println("商品数目选择大于库存上限！");
                return;
            } else if (num <= 0) {
                System.out.println("商品数目输入不规范(>0)");
                return;
            }
            shopList.put(id, num);
            price = price + product.getPrice() * num * (product.getDiscount() / 10);
        } else {
            System.out.println("商品编号选择错误");
        }
    }

    /**
     * 修改商品数量
     */
    public void replaceProductNums() {
        showList();//显示购物车已有的商品
        if (shopList.size() != 0) {
            System.out.println("请输入你要修改数量的商品id:");
            int id = scanner.nextInt();
            if (shopList.containsKey(id)) {
                System.out.println("请输入修改后的商品数量：");
                int num = scanner.nextInt();
                if (num > product.getNum()) {
                    System.out.println("商品数目选择大于库存上限！");
                    return;
                } else if (num <= 0) {
                    System.out.println("商品数目输入不规范(>0)！");
                    return;
                }
                product = productService.findProductById(id);
                //修改前，先把之前算的钱要减了，重新算
                price = price - shopList.get(id) * product.getPrice() * (product.getDiscount() / 10);
                shopList.put(id, num);
                //重新算购物车的钱
                price = price + product.getPrice() * num * (product.getDiscount() / 10);
                System.out.println("修改完成！");
            } else {
                System.out.println("你所选择的商品不在购物车中！");
            }
        } else {
            System.out.println("购物车中还没有商品！");
        }
    }

    /**
     * 删除购物车的商品
     */
    public void deleteProductFromList() {
        showList();//显示购物车已有的商品
        if (shopList.size() != 0) {
            System.out.println("请输入你要删除购物车中的商品id:");
            int id = scanner.nextInt();
            if (shopList.containsKey(id)) {
                product = productService.findProductById(id);
                //删除前，要把之前算上的钱要扣了
                price = price - shopList.get(id) * product.getPrice() * (product.getDiscount() / 10);
                shopList.remove(id);
            } else {
                System.out.println("你所选择的商品不在购物车中！");
            }
        } else {
            System.out.println("购物车中还没有商品！");
        }
    }

    /**
     * 展示购物车商品列表
     */
    public void showList() {
        if (shopList.size() == 0) {
            System.out.println("购物车为空！");
        } else {
            System.out.println("购物车中的商品信息如下：");
            System.out.println("------------------------------------------------------");
            System.out.println("商品编号\t\t\t商品名称\t\t商品单价\t\t购买数量");
            shopList.forEach((id, num) -> {
                product = productService.findProductById(id);
                System.out.println(id + "\t\t\t" + product.getPname() + "\t\t" + product.getPrice() + "\t\t" + num);
            });
            System.out.println("-------------------------------------------------------");
            System.out.println("当前订单总价：" + price + "元！");
            System.out.println("-------------------------------------------------------");
        }
    }

    /**
     * 提交订单，开始结算
     */
    public void commitList() {
        if (shopList.size() == 0) {
            System.out.println("当前购物车为空！");
            return;
        }
        int payType = 1;
        if (vip.getId() != 1) {//判断是否是会员
            System.out.println("请选择支付方式：1：现金，2：卡内余额");
            payType = scanner.nextInt();
            if (payType == 2) {//判断消费方式
                System.out.println("正在使用卡内余额消费...");
                if (price > vip.getMoney()) {//判断卡内余额是否足够
                    System.out.println("会员卡余额不足，选用现金消费！");
                    payType = 1;
                    System.out.println("现金消费" + price + "元！");
                } else {
                    System.out.println("会员卡消费成功，消费" + price + "元！");
                    vip.setMoney(vip.getMoney() - price);//卡内余额消费扣除
                    vip.setUpdateTime(new Date());
                    //消费加积分
                    vip.setJiFen(vip.getJiFen()+(int)(price*10));
                }
            } else {
                payType = 1;
                System.out.println("现金消费" + price + "元！");
                vip.setUpdateTime(new Date());
            }
        } else {
            System.out.println("非会员使用现金消费了" + price + "元！");
            vip.setUpdateTime(new Date());
        }

        //填充订单信息
        orderInfo.setOrderDate(new Date());
        orderInfo.setPayType(payType);
        orderInfo.setVipId(vip.getId());
        orderInfo.setPrice(price);

        int orderInfoId = 1;
        //填充订单详细信息

        //先要获取上一条订单的id
        List<OrderInfo> lastOrderInfo = purchaseManagerService.findLastOrderInfo();
        if (lastOrderInfo.size() == 0) {
            //说明还没有订单信息，那当前的订单orderInfo就是第一条数据
            orderInfoId = 1;
        } else {
            orderInfoId = lastOrderInfo.get(0).getId() + 1;//当前订单orderInfo的编号
        }
        int finalOrderInfoId = orderInfoId;
        shopList.forEach((id, num) -> {
            orderDetails = new OrderDetails();//注意：在构造中初始化不重新new每次都是加的最后一个数据
            orderDetails.setOrderId(finalOrderInfoId);//获得订单id
            orderDetails.setNum(num);//获得当前订购商品是数目
            orderDetails.setProductId(id);//获得当前商品的id
            product = productService.findProductById(id);
            double money = product.getPrice() * (product.getDiscount() / 10);//获取当前商品去除折扣的单价
            orderDetails.setMoney(money);
            orderDetailsList.add(orderDetails);
        });

        //提交订单信息
        purchaseManagerService.updateOrder(shopList, orderInfo, orderDetailsList, vip);
    }
}