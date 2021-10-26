package com.ion.jewelry.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.ion.jewelry.model.enums.OrderProductState;

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
@ToString(exclude = {"orderGroup", "item"})
@Builder
@Accessors(chain = true)
@Entity
public class OrderDetail extends AABaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderDetailSequenceGenerator")
	@SequenceGenerator(name = "OrderDetailSequenceGenerator", sequenceName = "OrderDetailSequence", initialValue = 1, allocationSize = 1)
	private Long id; //주문상세번호
	
	private Integer orderCount; //상품 구매수량
	
	private BigDecimal orderPrice; //상품 구매가격
	
	@Enumerated(EnumType.STRING)
	private OrderProductState orderProductState; //상품 주문상태
	
	@ManyToOne
	private OrderGroup orderGroup; //OrderGroup 테이블 연관관계 설정(N:1, fk)
	
	@ManyToOne
	private Item item; //Item 테이블 연관관계 설정(N:1, fk)
}
