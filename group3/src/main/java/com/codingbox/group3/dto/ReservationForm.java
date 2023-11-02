package com.codingbox.group3.dto;

import com.codingbox.group3.domain.Member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservationForm {
    private Long id;
    private String day; // String 타입으로 변경
    private String count; // String 타입으로 변경
    private String store_name;
    private String addr;
    private String year;
    private String month;
    private Member member;
    private String time;
    private String store_phone;
   
    
    @Override
   public String toString() {
      return "ReservationForm [id=" + id + ", day=" + day + ", count=" + count + ", store_name=" + store_name
            + ",addr=" + addr + ", year=" + year + ", month=" + month + ", member="
            + member + ", time=" + time + ", store_phone=" + store_phone + "]";
   }
   
   
    
}