package ru.sysoev.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Order {
	
	private String orderID;
	private String description;

}
