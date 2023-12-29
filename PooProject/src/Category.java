import java.util.Objects;

public class Category {
    private String categoryName;
    private String description;

    // Constructors
    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    // Getter and Setter methods
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category :'" + categoryName + '\'' +
                ", description :'" + description ;
    }

    // Custom equalsIgnoreCase method for comparing categories
    public boolean equalsIgnoreCase(String otherCategoryName) {
        return categoryName.equalsIgnoreCase(otherCategoryName);
    }
}
