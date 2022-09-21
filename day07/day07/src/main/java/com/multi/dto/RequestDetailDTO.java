package com.multi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestDetailDTO {
	private String rdno;
	private int rqid;
	private int itemid;
	private int total;
	private float coupon;
	private int rdcnt;

}
