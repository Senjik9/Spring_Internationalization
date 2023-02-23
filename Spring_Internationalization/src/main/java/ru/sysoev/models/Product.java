package ru.sysoev.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Product {

	private String name;
	private String lastUpdated;
	private String price;
	private String summary;

}
