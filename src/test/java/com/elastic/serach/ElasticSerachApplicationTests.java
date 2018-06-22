package com.elastic.serach;

import com.elastic.serach.entity.Product;
import com.elastic.serach.repo.ProductRepository;
import com.elastic.serach.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSerachApplicationTests {

    @Autowired
    private ProductService productService;

    private ObjectMapper mapper = new ObjectMapper();

    private ProductRepository productRepository;

    //向ES中插入全部所需商品数据
    @Test
    public void insertAllData() {
        productService.save(new Product(1L, "电吹风","飞利浦", "小家电"));
        productService.save(new Product(2L, "电吹风","美的", "小家电"));
        productService.save(new Product(3L, "电吹风","松下", "小家电"));
        productService.save(new Product(4L, "电吹风","索尼", "小家电"));
        productService.save(new Product(5L, "电吹风","华为", "小家电"));
        productService.save(new Product(6L, "电吹风","海尔", "小家电"));
        productService.save(new Product(7L, "电吹风","戴森", "小家电"));
        productService.save(new Product(8L, "电吹风","九阳", "小家电"));
        productService.save(new Product(9L, "洗衣机","海尔", "小家电"));
        productService.save(new Product(10L, "洗衣机","美的", "小家电"));
        productService.save(new Product(11L, "电视机", "飞利浦","小家电"));
        productService.save(new Product(12L, "电视机", "索尼","小家电"));
        productService.save(new Product(13L, "电视机", "夏普","小家电"));
        productService.save(new Product(14L, "电视机", "微鲸","小家电"));
        productService.save(new Product(15L, "电视机", "小米","小家电"));
        productService.save(new Product(16L, "电视机", "长虹","小家电"));
        productService.save(new Product(17L, "电视机", "海尔","小家电"));
        productService.save(new Product(18L, "电视机", "乐视","小家电"));;
        productService.save(new Product(19L, "冰箱","飞利浦", "小家电"));
        productService.save(new Product(20L, "音箱", "飞利浦","小家电"));
        productService.save(new Product(21L, "手电筒","飞利浦", "小家电"));
        productService.save(new Product(22L, "节能灯", "飞利浦","小家电"));
        productService.save(new Product(23L, "手机", "华为","数码电子"));
        productService.save(new Product(24L, "手机", "vivo","数码电子"));
        productService.save(new Product(25L, "手机", "oppo","数码电子"));
        productService.save(new Product(26L, "手机", "魅族","数码电子"));
        productService.save(new Product(27L, "手机", "小米","数码电子"));
        productService.save(new Product(28L, "手机", "摩托罗拉","数码电子"));
        productService.save(new Product(29L, "手机", "金立","数码电子"));
        productService.save(new Product(30L, "手机", "酷派","数码电子"));
        productService.save(new Product(31L, "手机", "格力","数码电子"));
        productService.save(new Product(32L, "摄像机", "飞利浦","数码电子"));
        productService.save(new Product(33L, "照相机","飞利浦", "数码电子"));
        productService.save(new Product(34L, "mp3", "飞利浦","数码电子"));
        productService.save(new Product(35L, "手环", "飞利浦","数码电子"));
        productService.save(new Product(36L, "iwatch","飞利浦", "数码电子"));
        productService.save(new Product(37L, "床", "飞利浦","家具"));

    //    productRepository.
    }

    //删除ES中存储的全部商品数据
    @Test
    public void deleteAllData() {
        productService.deleteAll();
    }

    //根据商品id删除ES中指定产品数据
    @Test
    public void testDeleteByProdId() {
        productService.deleteByProductId(1L);
    }

    //查询全部商品数据
    @Test
    public void testFindAll() {
        ArrayList<Product> products = new ArrayList<>();
        Iterator<Product> pIterator = productService.findAll().iterator();
        while (pIterator.hasNext()) {
            products.add(pIterator.next());
        }
        System.out.println("全部数据总数为: " + products.size()+"，最初插入总数为37");




    }
    //根据商品id查询
    @Test
    public void testFindByProdId() {
        Product product = productService.findByProductId(2L);
        try {
            System.out.println("商品id查询数据: " + mapper.writeValueAsString(product));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //根据商品名称查询，并分页
    @Test
    public void testFindByProdName() {
        //ES中共有8条电吹风数据
        Page<Product> prodPage = productService.findByProductName("电吹风", new PageRequest(0, 10));

        //无论分页数设置为5还是10，输出的“数据条目总数：”都是8.只不过设置为5时后面打印“prod page:”时只会输出5条数据
        System.out.println("商品名查询数据条目总数：" + prodPage.getTotalElements());


        try {
            System.out.println("商品名查询数据: " + mapper.writeValueAsString(prodPage.getContent()));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //根据商品大类查询
    @Test
    public void testFindByProdCategory() {
        List<Product> products = productService.findByProductCategory("数码电子");
        try {
            System.out.println("商品分类查询数据: " + mapper.writeValueAsString(products));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

