package com.elastic.serach.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//@Document和@Field用于为某个实体建立索引，@Field用于注解实体类的属性，更多参考http://www.tianshouzhi.com/api/tutorials/elasticsearch/159
//如果只用@Document,会默认为每一个属性都建立索引。如果@Document和@Field同时使用，只会为@Field注解的属性建立索引
//查询该实体类对应的索引的方法为在浏览器中输入http://127.0.0.1:9200/iengchen/_mapping，url中的iengchen对应@Document注解中的indexName值
@Document(indexName="iengchen",type="product")
public class Product {
	@Id
	private Long id;

	
	//商品名称
	private String prodName;
	
	//商品品牌,eg:松下，华为
	private String prodBrand;
	
	//商品分类，eg:服装，电子，软件
	private String prodCategory;
	
	//必须有无参构造器，否则会导致Jackson解析错误
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id,String prodName,String brand,String prodCategory) {
		this.id = id;
		this.prodName = prodName;
		this.prodBrand = brand;
		this.prodCategory = prodCategory;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}


	public String getProdBrand() {
		return prodBrand;
	}


	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

}
