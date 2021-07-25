package io.study.ehcache.employee;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Builder
@Getter @Setter
public class Employee implements Serializable {
	private String name;
	private Double salary;
}
