package com.homolangma.structural.composite.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 36732
 * @date 2019/4/24 0:06
 * 课程目录类
 */
public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> items = new ArrayList<>();

    private String name;

    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void delete(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : items) {
            // 还可以使用功能instanceOf 来判断是目录还是课程
            if (this.level != null) {
                for(int i=0;i<this.level;i++){
                    System.out.print("  ");
                }
            }
            catalogComponent.print();
        }
    }

    @Override
    public String toString() {
        return "CourseCatalog{" +
                "items=" + items +
                ", name='" + name + '\'' +
                '}';
    }
}
