package model.dto;


public class ItemDTO {
    private String itemCode;
    private String itemDes;
    private String itemCate;
    private String itemQty;
    private Double itemPrice;

    public ItemDTO(String itemCode, String itemDes, String itemCate, String itemQty, Double itemPrice) {
        this.itemCode = itemCode;
        this.itemDes = itemDes;
        this.itemCate = itemCate;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemDes() {
        return itemDes;
    }

    public String getItemCate() {
        return itemCate;
    }

    public String getItemQty() {
        return itemQty;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }

    public void setItemCate(String itemCate) {
        this.itemCate = itemCate;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemDes='" + itemDes + '\'' +
                ", itemCate='" + itemCate + '\'' +
                ", itemQty='" + itemQty + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
