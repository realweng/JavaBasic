package com.java.wxg.action;

import com.java.wxg.bean.ProductType;
import com.java.wxg.constants.MarketConstants;
import com.java.wxg.service.ProductTypeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-16:32
 * @Since:jdk1.8
 * @Description:商品类型操作
 */
public class ProductTypeAction {
    private Scanner scanner;//扫描仪
    private ProductTypeService productTypeService;//业务处理层对象
    private ProductType productType;//商品类型对象

    /**
     * 构造方法 数据初始化
     *
     * @param scanner
     */
    public ProductTypeAction(Scanner scanner) {
        this.scanner = scanner;
        productTypeService = new ProductTypeService();
        productType = new ProductType();
    }

    /**
     * 商品类型管理目录
     */
    public void typeMenu() {
        boolean flag = true;
        while (flag){
            System.out.println("1.添加商品类型信息");
            System.out.println("2.修改商品类型信息");
            System.out.println("3.查询商品类型信息");
            System.out.println("4.删除商品类型信息");
            System.out.println("0.退出商品类型管理菜单");
            System.out.println("请选择：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("您选择添加商品类型信息-->");
                    addProductType();
                    break;
                case 2:
                    System.out.println("您选择修改商品类型信息-->");
                    updateProductType();
                    break;
                case 3:
                    System.out.println("您选择查询商品类型信息-->");
                    queryProductType();
                    break;
                case 4:
                    System.out.println("您选择删除商品类型信息-->");
                    deleteProductType();
                    break;
                case 0:
                    System.out.println("退出当前菜单...");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 添加商品类型信息
     */
    public void addProductType() {
        System.out.println("请输入商品类型名：");
        productType.setTypeName(scanner.next());
        System.out.println("是否为父级：(是/否？)");
        int flagParent = 0;//默认不是父级
        if(scanner.next().equals(MarketConstants.FLAG_PARENT_ONE)){
            flagParent = 1;
        }
        List<Integer> integerList = queryParent();//查询所有父级商品
        System.out.println("请从以上商品类型中的id作为父级id(输入0表示没有父级)：");
        int parentId = scanner.nextInt();
        int index = integerList.indexOf(parentId);//查询输入是否正确
        //如果输入0 表示没有父级
        if(parentId == 0){
            productType.setParentId(parentId);
        }else if(index >= 0) {
            productType.setParentId(parentId);
        } else {
            System.out.println("父级编号选择错误");
            return;
        }
        productType.setFlagParent(flagParent);
        productType.setCreateTime(new Date());
        int i = productTypeService.addProductType(productType);
        if (i > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    /**
     * 查询商品类型所有信息
     */
    public void queryProductType() {
        List<ProductType> list = productTypeService.queryProductType();
        if (list.size() != 0) {
            System.out.println("-----------------------------------------------------------------");
            for (ProductType type : list) {
                System.out.println(type.toString());
            }
            System.out.println("-----------------------------------------------------------------");
//            System.out.println("编号\t父级id\t\t类型名\t\t\t\t父级标记\t\t创建时间\t\t\t更新时间\t\t\t");
//            //处理是否是父级的标记，使查询后结果更加友好
//            for (ProductType type : list) {
//                String flagParent = new String();
//                if(type.getFlagParent()==1){
//                    flagParent=MarketConstants.FLAG_PARENT_ONE;
//                }else if(type.getFlagParent()==0){
//                    flagParent=MarketConstants.FLAG_PARENT_ZERO;
//                }else{
//                    flagParent = "未知";
//                }
//                //显示查询结果
//                System.out.println(type.getId() + "\t\t\t" + type.getParentId() +
//                        "\t\t" + type.getTypeName() + "\t\t\t\t" + flagParent +
//                        "\t\t\t" + type.getCreateTime() + "\t\t\t" + type.getUpdateTime());
//            }
        }
    }

    /**
     * 查询商品类型的id和名字
     * @return 返回商品类型编号的list
     */
    public List<Integer> queryProductTypeIdAndName() {
        List<ProductType> list = productTypeService.queryProductType();
        List<Integer> integerList = new ArrayList<>(10);
        if (list.size() != 0) {
            System.out.println("-----------------------------");
            System.out.println("编号\t\t\t类型名");
            for (ProductType type : list) {
                System.out.println(type.getId() + "\t\t\t" + type.getTypeName());
                integerList.add(type.getId());
            }
            System.out.println("-----------------------------");
        }
        return integerList;
    }

    /**
     * 查询是父级的id及商品类型
     *
     * @return 返回所有是父级的商品类型id
     */
    public List<Integer> queryParent() {
        List<ProductType> list = productTypeService.queryProductType();
        List<Integer> integerList = new ArrayList<>(10);
        if (list.size() != 0) {
            System.out.println("----------------------------");
            System.out.println("编号\t\t类型名");
            for (ProductType type : list) {
                if (type.getFlagParent() == 1) {
                    System.out.println(type.getId() + "\t\t\t" + type.getTypeName());
                    integerList.add(type.getId());
                }
            }
            System.out.println("----------------------------");
        }
        return integerList;
    }

    /**
     * 删除商品类型
     */
    public void deleteProductType() {
        System.out.println("请输入要删除商品类型的id:");
        int id = scanner.nextInt();
        int i = productTypeService.deleteProductType(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("该id不存在，删除失败！");
        }
    }

    /**
     * 修改商品类型信息
     */
    public void updateProductType() {
        System.out.println("请输入要修改的商品类型id");
        int id = scanner.nextInt();
        productType = productTypeService.findProductTypeById(id);//获取查询到的要修改商品种类的对象
        if (productType!= null) {
            System.out.println(productType.toString());
            System.out.println("是否修改父级id:(y/n)");
            if (scanner.next().equals("y")) {
                List<Integer> integerList = queryParent(); //查询所有父级商品类型
                System.out.println("请从以上商品类型中的id作为父级id:(输入0表示当前类型改为没有父级)");
                int parentId = scanner.nextInt();
                int index = integerList.indexOf(parentId);//查询输入是否正确
                if (index >= 0 || parentId ==0 ) {
                    productType.setParentId(parentId);
                } else {
                    System.out.println("父级编号选择错误");
                    return;
                }
            }
            System.out.println("是否修改商品类型名字：(y/n)");
            if(scanner.next().equals("y")){
                System.out.println("请输入修改后商品类型名字：");
                productType.setTypeName(scanner.next());
            }
            System.out.println("是否修改商品父类标记：(y/n)");
            if(scanner.next().equals("y")){
                // 0 - 1 = -1 Math.abs(-1) = 1
                // 1 - 1 = 0 Math.abs(0) = 0
                //这样是否是父类的标记就改变了
                int flagParent = Math.abs(productType.getId() - 1);//取绝对值，状态翻转
                productType.setFlagParent(flagParent);
                System.out.println("父类标记自动修改完成！");
            }
            productType.setUpdateTime(new Date());
            //执行修改
            int i = productTypeService.updateProductType(productType);
            if(i > 0){
                System.out.println("修改成功！");
            }else
                System.out.println("修改失败！");
        } else {
            System.out.println("不存在该商品类型！");
        }
    }

}