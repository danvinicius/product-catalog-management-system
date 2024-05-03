package com.danvinicius.productcatalogmanagementsystem.domain.category;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryDTO categoryData) {
        this.title = categoryData.title();
        this.description = categoryData.description();
        this.ownerId = categoryData.ownerId();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("title", this.title);
        json.put("description", this.description);
        json.put("ownerId", this.ownerId);
        json.put("type", "category");
        return json.toString();
    }
}
