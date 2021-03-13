package com.java.wxg.action;

import com.java.wxg.bean.Product;
import com.java.wxg.constants.MarketConstants;
import com.java.wxg.service.ProductService;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-16:32
 * @Since:jdk1.8
 * @Description:商品操作
 */
public class ProductAction {
    private Scanner scanner;
    private ProductService productService;
    private ProductTypeAction productTypeAction;
    private Product product;

    /**
     * 构造方法 初始化
     *
     * @param scanner
     */
    public ProductAction(Scanner scanner) {
        this.scanner = scanner;
        productService = new ProductService();
        product = new Product();
        productTypeAction = new ProductTypeAction(scanner);
    }

    /**
     * 商品菜单
     */
    public void productMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("1.添加商品信息");
            System.out.println("2.修改商品信息");
            System.out.println("3.查询商品信息");
            System.out.println("4.删除商品信息");
            System.out.println("0.退出当前菜单");
            System.out.println("请选择：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("您选择添加商品信息-->");
                    addProduct();
                    break;
                case 2:
                    System.out.println("您选择修改商品信息-->");
                    updateProduct();
                    break;
                case 3:
                    System.out.println("您选择查询商品信息-->");
                    limitPages();
                    break;
                case 4:
                    System.out.println("您选择删除商品信息-->");
                    deleteProduct();
                    break;
                case 0:
                    System.out.println("退出当前菜单中...");
                    flag = false;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 添加商品
     */
    public void addProduct() {
        System.out.println("请输入商品名：");
        product.setPname(scanner.next());
        System.out.println("请输入商品价格：");
        product.setPrice(scanner.nextDouble());
        System.out.println("请输入商品库存：");
        product.setNum(scanner.nextInt());
        System.out.println("请输入商品折扣（1-10）");
        product.setDiscount(scanner.nextInt());
        System.out.println("商品类型：");
        //显示已有商品类型列表
        List<Integer> integerList = productTypeAction.queryProductTypeIdAndName();
        System.out.println("请选择商品类型的id");
        int typeId = scanner.nextInt();
        int index = integerList.indexOf(typeId);
        if (index >= 0) {
            product.setTypeId(typeId);
        } else {
            System.out.println("商品类型选择错误！");
            return;
        }
//        System.out.println("请设置商品状态：1为上架，2为下架，3为删除");
        product.setState(1);//默认添加是即上架
        int i = productService.addProduct(product);
        if (i > 0) {
            System.out.println("添加成功！");
        } else
            System.out.println("添加失败！");
    }

    /**
     * 更新商品
     */
    public void updateProduct() {
        System.out.println("请输入要修改商品的商品编号：");
        int id = scanner.nextInt();
        product = productService.findProductById(id);
        if (product != null) {
            System.out.println(product.toString());
            System.out.println("是否修改商品名字：(y/n)");
            if (scanner.next().equals("y")) {
                System.out.println("请输入修改后的商品名：");
                product.setPname(scanner.next());
            }
            System.out.println("是否修改商品价格：(y/n)");
            if (scanner.next().equals("y")) {
                System.out.println("请输入修改后的商品价格：");
                product.setPrice(scanner.nextDouble());
            }
            System.out.println("是否修改商品库存：(y/n)");
            if (scanner.next().equals("y")) {
                System.out.println("请输入修改后的库存：");
                product.setNum(scanner.nextInt());
            }
            System.out.println("是否修改商品类型：(y/n)");
            if (scanner.next().equals("y")) {
                List<Integer> integerList = productTypeAction.queryProductTypeIdAndName();
                System.out.println("请选择商品类型的id");
                int typeId = scanner.nextInt();
                int index = integerList.indexOf(typeId);
                if (index > 0) {
                    product.setTypeId(typeId);
                } else {
                    product.setTypeId(product.getTypeId());
                    System.out.println("商品类型选择错误！");
                    return;
                }
            }
            System.out.println("是否修改商品的状态：(y/n)");
            if (scanner.next().equals("y")) {
                System.out.println("请选择商品状态：1.上架，2下架，3.删除");
                int select = scanner.nextInt();
                switch (select) {
                    case 1:
                        product.setState(select);
                        break;
                    case 2:
                        product.setState(select);
                        break;
                    case 3:
                        product.setState(select);
                        break;
                    default:
                        break;
                }
            }
            int i = productService.updateProduct(product);
            if (i > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
        } else {
            System.out.println("不存在该用户，无法执行修改操作！");
        }
    }

    /**
     * 查询所有商品
     */
    public void queryProduct() {
        List<Product> list = productService.queryProduct();
        System.out.println("编号\t商品名\t\t\t\t商品价格\t\t商品库存\t\t商品折扣\t\t商品种类\t\t商品状态");
        for (Product p : list) {
            //处理商品状态的显示
            String state = new String();
            switch (p.getState()) {
                case 1:
                    state = MarketConstants.STATE_ONE;
                    break;
                case 2:
                    state = MarketConstants.STATE_TWO;
                    break;
                case 3:
                    state = MarketConstants.STATE_THREE;
                    break;
                default:
                    break;
            }
            System.out.println(p.getId() + "\t" + p.getPname() + "\t\t\t\t\t" + p.getPrice() + "\t\t\t"
                    + p.getNum() + "\t\t" + p.getDiscount() + "\t\t" + p.getTypeId() + "\t\t" + state);
        }
    }

    /**
     * 删除商品
     */
    public void deleteProduct() {
        System.out.println("请输入要删除商品的id：");
        int id = scanner.nextInt();
        int i = productService.deleteProduct(id);
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("该商品id不存在，删除失败！");
        }
    }

    /**
     * 分页显示商品信息
     */
    public void limitPages() {
        List<Product> countList = productService.countRows();
        int rows = 0;
        if (countList.size() > 0) {
            rows = countList.get(0).getCountRows();
        } else {
            System.out.println("查询结果为空！");
            return;
        }
        if (rows != 0) {
            int every = 10;//每页显示10条数据
            if (every >= rows) {//如果输入条数大于数据总条数
                System.out.println("--------------------------第1页/共1页-----------------------------");
                queryProduct();
                return;
            }
            int pages = 0;
            if (rows % every == 0) {
                pages = rows / every;//可分成的页数
                for (int i = 0; i < pages; i++) {
                    List<Product> list = productService.limitPage(i * every, every);
                    System.out.println("----------------------------第" + (i + 1) + "页/共" + pages + "页------------------------------------");
                    for (Product product1 : list) {
                        System.out.println(product1.toString());
                    }
                }
            } else if (rows % every != 0 && every != 0) {
                pages = rows / every + 1;//可分成的页数
                for (int i = 0; i < pages - 1; i++) {
                    List<Product> list = productService.limitPage(i * every, every);
                    System.out.println("----------------------------第" + (i + 1) + "页/共" + pages + "页------------------------------------");
                    for (Product product1 : list) {
                        System.out.println(product1.toString());
                    }
                    if (i == pages - 2) {
                        List<Product> list1 = productService.limitPage((i + 1) * every, rows % every);
                        System.out.println("----------------------------第" + (i + 2) + "页/共" + pages + "页------------------------------------");
                        for (Product product1 : list1) {
                            System.out.println(product1.toString());
                        }
                    }
                }
            }
        }
    }
}