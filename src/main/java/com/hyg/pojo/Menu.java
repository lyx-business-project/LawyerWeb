package com.hyg.pojo;

import lombok.Data;

import java.util.List;

/**
 * ่ๅ่กจ
 */
@Data
public class Menu
{
	private Integer menuId;
	private String menuName;
	private Integer parentId;
	private String router;
	private List<Menu> children;
}