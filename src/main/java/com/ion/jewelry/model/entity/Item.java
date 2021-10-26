package com.ion.jewelry.model.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailList", "category", "cartList", "imageFileList"})
@Builder
@Accessors(chain = true)
@Entity
public class Item extends AABaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ItemSequenceGenerator")
	@SequenceGenerator(name="ItemSequenceGenerator", sequenceName = "ItemSequence", initialValue = 1, allocationSize = 1)
	private Long id; //상품번호
	
	private String name; //상품명
	
	private BigDecimal price; //상품가격
	
	private Integer stock; //상품재고
	
	@ManyToOne
	private Category category; // category 테이블 연관관계 설정(N:1, fk)
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<OrderDetail> orderDetailList; // OrderDetail 테이블 연관관계 설정(1:N)
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<Cart> cartList; // Cart 테이블 연관관계 설정(1:N)
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<ImageFile> imageFileList; // ImageFile 테이블 연관관계 설정(1:N)
}
